package com.saurabh.example.currencyconversionservice.controller;

import com.saurabh.example.currencyconversionservice.dto.CurrencyConvertedBean;
import com.saurabh.example.currencyconversionservice.proxies.CurrencyExchangeServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class CurrencyConversionController {


    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

    @GetMapping("/currency-convertor/from/{from}/to/{to}/quantity/{quantity}")
    public ResponseEntity<CurrencyConvertedBean> convertCurrency(@PathVariable("from") String from,
                                                                 @PathVariable("to") String to,
                                                                 @PathVariable("quantity") BigDecimal quantity) {

        CurrencyConvertedBean currencyConvertedBean =
                new CurrencyConvertedBean(1000L, from, to, BigDecimal.valueOf(65), quantity);
     //   currencyConvertedBean.setPort(port);


        Map<String, String> uriVariables = new HashMap<>(6);
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        ResponseEntity<CurrencyConvertedBean> response = new RestTemplate()
                .getForEntity("http://localhost:7000/currency-exchange/from/{from}/to/{to}"
                        , CurrencyConvertedBean.class
                        , uriVariables);

        CurrencyConvertedBean fromMicroService = response.getBody();
        CurrencyConvertedBean result = new CurrencyConvertedBean(fromMicroService.getId()
                , fromMicroService.getFrom()
                , fromMicroService.getTo()
                , fromMicroService.getConversionMultiple()
                , quantity
                , quantity.multiply(fromMicroService.getConversionMultiple())
                , fromMicroService.getPort());
        return new ResponseEntity<CurrencyConvertedBean>(result, HttpStatus.OK);
    }
    @GetMapping("/currency-convertor-feign/from/{from}/to/{to}/quantity/{quantity}")
    public ResponseEntity<CurrencyConvertedBean> convertCurrencyFeign(@PathVariable("from") String from,
                                                                 @PathVariable("to") String to,
                                                                 @PathVariable("quantity") BigDecimal quantity) {

        CurrencyConvertedBean currencyConvertedBean=currencyExchangeServiceProxy.convertCurrencyFeign(from,to);
     //   currencyConvertedBean.setPort(port);
        currencyConvertedBean.setQuantity(quantity);
        currencyConvertedBean.setTotalCalculatedAmount(currencyConvertedBean.getConversionMultiple().multiply(quantity));


        return new ResponseEntity<>(currencyConvertedBean,HttpStatus.OK);
    }


}
