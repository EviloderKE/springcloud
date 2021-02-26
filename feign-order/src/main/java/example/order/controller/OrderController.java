package example.order.controller;

import com.example.common.entities.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import example.order.service.FeignBadResponseWrapper;
import example.order.service.OrderFeignService;
import example.order.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("order")
@RestController
@DefaultProperties(defaultFallback = "globalFallBack")
@Slf4j
public class OrderController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @Autowired
    private OrderFeignService orderFeignService;

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


    @GetMapping("getaa")
    public User getaa(){

        User user = new User();
        try {
            user = orderFeignService.test();
        } catch (FeignBadResponseWrapper e) {
            log.info("捕获异常~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            log.info(e.getInfo());

            user.setName("捕获异常");
            user.setAge(0);
        }

        return user;
    }


    @GetMapping("aa")
    public ResponseEntity<User> aa(){
        log.info("请求");
        User user = new User();
        user.setName("success");
        user.setAge(200);
        return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
    }

}
