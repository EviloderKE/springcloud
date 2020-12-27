package com.example.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
// hystrix
@EnableCircuitBreaker
public class PaymentOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentOneApplication.class, args);
    }

}
