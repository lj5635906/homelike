package com.homelike.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 删除标志
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-29 15:49
 **/
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum DeleteFlag {

    No(1,"未删除"),
    Yes(2,"未删除"),
    ;
    private Integer code;
    private String message;
}
