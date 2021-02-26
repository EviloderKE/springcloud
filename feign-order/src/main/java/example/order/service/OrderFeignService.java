package example.order.service;

import com.example.common.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient(value = "ORDER", fallbackFactory = OrderHystrixServiceFactory.class)
public interface OrderFeignService {

    @GetMapping("order/aa")
    User test();


}
