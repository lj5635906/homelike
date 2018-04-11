package com.homelike.order.server.rest;

import com.homelike.common.web.vo.ResultVo;
import com.homelike.order.common.request.CreateOrderRequest;
import com.homelike.order.server.assembler.CreateOrderAssembler;
import com.homelike.order.server.dto.CreateOrderDto;
import com.homelike.order.server.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 订单相关接口
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-22 17:19
 **/
@RestController
@RequestMapping("/order")
public class OrderRest {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResultVo createOrder(@Valid @RequestBody CreateOrderRequest request) {
        // 数据转换
        CreateOrderDto orderDto = CreateOrderAssembler.toCreateOrderDto(request);

        String orderId = orderService.createOrder(orderDto);
        return ResultVo.ok(orderId);
    }
}
