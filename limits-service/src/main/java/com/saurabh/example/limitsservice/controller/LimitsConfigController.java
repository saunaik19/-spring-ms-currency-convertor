package com.saurabh.example.limitsservice.controller;

import com.saurabh.example.limitsservice.config.Config;
import com.saurabh.example.limitsservice.dto.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigController {

    @Autowired
    private Config config;

    @GetMapping("/limits")
    public LimitConfiguration retriveLimitConfig(){
        return new LimitConfiguration(config.getMinimum(),config.getMaximum());
    }
}
