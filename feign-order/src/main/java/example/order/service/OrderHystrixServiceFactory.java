package example.order.service;

import com.example.common.entities.User;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderHystrixServiceFactory implements FallbackFactory<OrderFeignService>{

    @Override
    public OrderFeignService create(Throwable throwable) {
        return new OrderFeignService() {
            @Override
            public User test() {
                log.info("熔断代码~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                log.info(throwable.getMessage());
                User u = new User();
                u.setName("熔断");
                u.setAge(1);
                return u;
            }
        };
    }
}
