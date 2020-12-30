package example.order.service;

import com.example.common.entities.User;
import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixService implements PaymentFeignService{
    @Override
    public User test() {
        return new User();
    }

    @Override
    public String timeout() {
        return "feign Hystrix";
    }
}
