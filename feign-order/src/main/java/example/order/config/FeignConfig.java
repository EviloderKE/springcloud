package example.order.config;

import com.netflix.hystrix.exception.HystrixBadRequestException;
import example.order.service.FeignBadResponseWrapper;
import feign.Logger;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public ErrorDecoder feignError() {
        return (key, response) -> {
            Exception exception = null;
            if (response.status() == 400) {

                String s = response.body().toString();

                log.error("请求xxx服务400参数错误,返回:{}", s);

                return new FeignBadResponseWrapper(response.status(), s);
            }

            if (response.status() == 409) {
                log.error("请求xxx服务409异常,返回:{}", response.body());
            }

            if (response.status() == 404) {
                log.error("请求xxx服务404异常,返回:{}", response.body());
            }

            // 其他异常交给Default去解码处理
            // 这里使用单例即可，Default不用每次都去new
            return new ErrorDecoder.Default().decode(key, response);
        };
    }
}
