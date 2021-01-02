package com.example.order.service;

import com.example.common.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient("nacos-payment-provider")
public interface FeignNacosService {

    @GetMapping("payment/test")
    User test();

}
