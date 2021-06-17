package com.saurabh.example.currencyconversionservice.config;

import feign.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class FiegnClientConfig {
    @Bean
    public Logger.Level configureLogLevel(){
        return  Logger.Level.FULL;
    }
}
