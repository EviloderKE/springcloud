package example.order.service;

import com.netflix.hystrix.exception.HystrixBadRequestException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeignBadResponseWrapper extends HystrixBadRequestException {

    private int status;
    private String info;

    public FeignBadResponseWrapper(int status, String body) {
        super("bad");

        this.status = status;
        this.info = body;
    }
}
