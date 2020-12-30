package example.order.controller;

import com.example.common.entities.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import example.order.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("order")
@RestController
@DefaultProperties(defaultFallback = "globalFallBack")
public class OrderController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("get")
    public User get(){
        return paymentFeignService.test();
    }

    @GetMapping("timeout")
    /*@HystrixCommand(fallbackMethod = "myFallBack", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000" )
    })*/
    @HystrixCommand
    public String timeout(){
        return paymentFeignService.timeout();
    }

    public String myFallBack(){
        return "order client Hystrix";
    }

    public String globalFallBack(){
        return "order client global Hystrix";
    }

}
