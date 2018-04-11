package com.homelike.customer.server.repository;

import com.homelike.customer.server.entity.CustomerShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户配送地址仓库
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-04-08 14:52
 **/
public interface CustomerShippingAddressRepository extends JpaRepository<CustomerShippingAddress, Long> {
}
