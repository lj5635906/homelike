package com.homelike.common.web.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Long类型参数校验注解
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-26 14:43
 **/
// 方法和字段上
@Target({ElementType.METHOD, ElementType.FIELD})
// 运行时注解
@Retention(RetentionPolicy.RUNTIME)
// 指定类来执行校验逻辑
@Constraint(validatedBy = LongValidConstraint.class)
public @interface LongValid {
    /**
     * @return 校验不过的信息
     */
    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
