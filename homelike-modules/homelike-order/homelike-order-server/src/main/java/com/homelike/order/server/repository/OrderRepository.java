package com.homelike.order.server.repository;

import com.homelike.order.server.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ${DESCRIPTION}
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-22 17:16
 **/
public interface OrderRepository extends JpaRepository<Order,String>{

}
