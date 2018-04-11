package com.homelike.common.web.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * List 类型参数校验逻辑
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-26 15:19
 **/
public class ListValidConstraint implements ConstraintValidator<ListValid, List> {


    @Override
    public void initialize(ListValid listValid) {

    }

    @Override
    public boolean isValid(List value, ConstraintValidatorContext constraintValidatorContext) {
        if (null == value || value.size() == 0){
            return false;
        }
        return true;
    }
}
