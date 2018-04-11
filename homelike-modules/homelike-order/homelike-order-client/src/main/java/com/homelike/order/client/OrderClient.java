package com.homelike.order.client;

import com.homelike.common.web.vo.ResultVo;
import com.homelike.order.common.request.CreateOrderRequest;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 订单客户端
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-22 16:47
 **/
@FeignClient(
        name = "order",
        fallback = OrderClient.OrderClientFallback.class
)
public interface OrderClient {

    @PostMapping
    ResultVo createOrder(@RequestBody CreateOrderRequest request);

    @Component
    class OrderClientFallback implements OrderClient{
        @Override
        public ResultVo createOrder(CreateOrderRequest request) {
            return ResultVo.hystrix();
        }
    }
}
