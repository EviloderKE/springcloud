package com.example.order.controller;

import com.example.common.entities.User;
import com.example.order.service.FeignNacosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("order")
@RestController
@RefreshScope
public class NacosOrderController {

    @Autowired
    private FeignNacosService feignNacosService;

    @Value("${v}")
    private String v;

    @GetMapping("get")
    public User get(){
        return feignNacosService.test();
    }

    @GetMapping("version")
    public String version(){
        return this.v;
    }

}
