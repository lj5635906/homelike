package com.homelike.customer.server.repository;

import com.homelike.customer.server.entity.CustomerVerifyCode;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户验证码 仓库
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-04-08 14:52
 **/
public interface CustomerVerifyCodeRepository extends JpaRepository<CustomerVerifyCode,Long> {

    /**
     * 根据手机号和类型获取最新的一条记录
     * @param mobile 手机号码
     * @param codeType 验证码类型
     * @return CustomerVerifyCode
     */
    CustomerVerifyCode findFirstByMobileAndCodeTypeOrderByCreateTimeDesc(String mobile,Integer codeType);

}
