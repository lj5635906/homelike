package com.homelike.common.web.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Integer 类型参数校验逻辑（大于0）
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-26 14:42
 **/
public class IntegerGreaterThanZeroValidConstraint implements ConstraintValidator<IntegerGreaterThanZeroValid, Integer> {

    @Override
    public void initialize(IntegerGreaterThanZeroValid longValid) {

    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        if (null == value) {
            return false;
        }
        if (value.intValue() < Integer.MAX_VALUE && value.intValue() > 0) {
            // 验证通过
            return true;
        }
        return false;
    }
}
