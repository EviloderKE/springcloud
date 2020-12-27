package example.order.controller;

import com.example.common.entities.User;
import example.order.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("order")
@RestController
public class OrderController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("get")
    public User get(){
        return paymentFeignService.test();
    }

}