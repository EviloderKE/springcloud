package com.example.payment.controller;

import com.example.common.entities.User;
import com.example.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

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

}
