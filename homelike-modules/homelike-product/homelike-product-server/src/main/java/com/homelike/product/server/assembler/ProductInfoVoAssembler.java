package com.homelike.product.server.assembler;

import com.homelike.product.common.vo.ProductInfoVo;
import com.homelike.product.server.entity.ProductInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 创建订单装配
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-23 16:56
 **/
public class ProductInfoVoAssembler {

    public static List<ProductInfoVo> toProductInfoVo(List<ProductInfo> list) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        } else {
            List<ProductInfoVo> productInfoVoList = list.stream()
                    .map(productInfo -> {
                        ProductInfoVo productInfoVo = new ProductInfoVo();
                        BeanUtils.copyProperties(productInfo, productInfoVo);
                        return productInfoVo;
                    }).collect(Collectors.toList());
            return productInfoVoList;
        }
    }

}
