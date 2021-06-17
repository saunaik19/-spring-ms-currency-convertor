package com.saurabh.example.currencyexchangeservice.sevice;

import com.saurabh.example.currencyexchangeservice.dto.ExchangeValue;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service("exchangeService")
public class ExchangeService {

    static List<ExchangeValue> exchangeValues=new ArrayList<>(20);
    static {
        exchangeValues.add(new ExchangeValue(1L, "USD", "INR", BigDecimal.valueOf(65)));
        exchangeValues.add(new ExchangeValue(2L, "EUR", "INR", BigDecimal.valueOf(75)));
        exchangeValues.add(new ExchangeValue(3L, "AUD", "INR", BigDecimal.valueOf(35)));
    }
    public ExchangeValue getExchangeValue(String from,String to){

        return exchangeValues
                .stream()
                .filter(currentData->currentData.getFrom().equals(from) &&
                        currentData.getTo().equals(to))
                .findFirst().get();
    }

}
