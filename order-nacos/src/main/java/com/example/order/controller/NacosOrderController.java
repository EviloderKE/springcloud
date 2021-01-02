package com.example.order.controller;

import com.example.common.entities.User;
import com.example.order.service.FeignNacosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("order")
@RestController
public class NacosOrderController {

    @Autowired
    private FeignNacosService feignService;

    @GetMapping("get")
    public User get(){
        return feignService.test();
    }

}
