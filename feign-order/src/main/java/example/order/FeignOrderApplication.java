package example.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeignOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignOrderApplication.class, args);
    }

}
