package example.order.service;

import com.example.common.entities.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient("PAYMENT")
public interface PaymentFeignService {

    @GetMapping("payment/test")
    User test();

    @GetMapping("payment/timeout")
    String timeout();

}
