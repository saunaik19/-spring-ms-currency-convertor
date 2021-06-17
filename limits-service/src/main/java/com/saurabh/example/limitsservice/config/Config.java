package com.saurabh.example.limitsservice.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties("limits-service")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Config {
    private int minimum;
    private int maximum;
}
