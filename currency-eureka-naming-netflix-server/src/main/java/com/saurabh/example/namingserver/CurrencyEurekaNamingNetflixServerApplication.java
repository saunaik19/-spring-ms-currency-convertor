package com.saurabh.example.namingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CurrencyEurekaNamingNetflixServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyEurekaNamingNetflixServerApplication.class, args);
	}

}
