package com.example.payment.controller;

import com.example.common.entities.User;
import com.example.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${version}")
    private String version;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/test")
    public User test(){
        return new User("zk", 1);
    }

    @GetMapping("timeout")
    public String timeOut(){
        return paymentService.timeOut();
    }

    @GetMapping("break/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") int id){
        return paymentService.paymentCircuitBreaker(id);
    }

    @GetMapping("version")
    public String version(){
        return version;
    }

}
