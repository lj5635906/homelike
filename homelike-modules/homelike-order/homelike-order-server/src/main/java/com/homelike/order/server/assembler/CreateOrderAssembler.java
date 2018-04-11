package com.homelike.order.server.assembler;

import com.homelike.order.common.request.CreateOrderRequest;
import com.homelike.order.server.dto.CreateOrderCartDto;
import com.homelike.order.server.dto.CreateOrderDto;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 创建订单装配
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-23 16:56
 **/
public class CreateOrderAssembler {

    public static CreateOrderDto toCreateOrderDto(CreateOrderRequest request) {
        CreateOrderDto dto = new CreateOrderDto();
        dto.setCustomerId(request.getCustomerId());
        dto.setCustomerShoppingAddressId(request.getCustomerShoppingAddressId());

        List<CreateOrderCartDto> list = request.getCars().stream()
                .map(cars -> {
                    CreateOrderCartDto cartDto = new CreateOrderCartDto();
                    cartDto.setProductQuantity(cars.getProductQuantity());
                    cartDto.setProductId(cars.getProductId());
                    return cartDto;
                }).collect(Collectors.toList());
        dto.setCars(list);
        return dto;
    }

}
