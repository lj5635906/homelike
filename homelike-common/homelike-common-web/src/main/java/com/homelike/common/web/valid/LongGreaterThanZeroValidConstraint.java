package com.homelike.common.web.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Long类型参数校验逻辑（大于0）
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-26 14:42
 **/
public class LongGreaterThanZeroValidConstraint implements ConstraintValidator<LongGreaterThanZeroValid, Long> {

    @Override
    public void initialize(LongGreaterThanZeroValid longValid) {

    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext constraintValidatorContext) {
        if (null == value) {
            return false;
        }
        if (value.longValue() < Long.MAX_VALUE && value.longValue() > 0) {
            // 验证通过
            return true;
        }
        return false;
    }
}
