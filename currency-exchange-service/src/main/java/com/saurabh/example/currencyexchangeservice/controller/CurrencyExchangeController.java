package com.saurabh.example.currencyexchangeservice.controller;

import com.saurabh.example.currencyexchangeservice.dto.ExchangeValue;
import com.saurabh.example.currencyexchangeservice.repository.ExchangeRepository;
import com.saurabh.example.currencyexchangeservice.sevice.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Objects;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeRepository exchangeRepository;
    @Autowired
    private ExchangeService exchangeService;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<ExchangeValue> retriveValue(@PathVariable("from") String from,
                                                      @PathVariable("to") String to) {
        Integer port=getPort();
        ExchangeValue exchangeValue = new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65));
        exchangeValue.setPort(port);
        ExchangeValue exchangeValue1 = exchangeService.getExchangeValue(from,to);
       System.out.println(exchangeValue1);
        exchangeValue1.setPort(port);
        return new ResponseEntity<ExchangeValue>(exchangeValue, HttpStatus.OK);
    }

    private Integer getPort() {
        if (Objects.nonNull(environment.getProperty("local.server.port")))
            return Integer.valueOf(environment.getProperty("local.server.port"));
        return 0;
    }
}
