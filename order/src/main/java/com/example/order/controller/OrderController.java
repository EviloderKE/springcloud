package com.example.order.controller;

import com.example.common.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("order")
@RestController
@RefreshScope
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${version}")
    private String version;

    @GetMapping("get")
    public User get(){
        String url = "http://PAYMENT/payment/test";
        return restTemplate.getForObject(url, User.class);
    }

    @GetMapping("test")
    public String test(){
        return version;
    }

}
