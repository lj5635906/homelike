package com.homelike.customer.server.repository;

import com.homelike.customer.server.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户仓库
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-04-08 14:52
 **/
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    /**
     * 根据电话号码获取客户
     * @param mobile 电话号码
     * @return Customer
     */
    Customer findCustomerByCustomerMobile(String mobile);
}
