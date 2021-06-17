package com.saurabh.example.currencyconversionservice.proxies;


import com.saurabh.example.currencyconversionservice.dto.CurrencyConvertedBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-service",url="http://localhost:7000")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConvertedBean convertCurrencyFeign(@PathVariable("from") String from,
                                                                      @PathVariable("to") String to);
}
