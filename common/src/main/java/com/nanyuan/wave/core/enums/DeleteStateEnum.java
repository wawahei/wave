package com.nanyuan.wave.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description:
 * @author: yanghailang
 * @create: 2021-05-25 16:28
 **/
@AllArgsConstructor
@Getter
public enum  DeleteStateEnum {
    NORMAL(0, "正常"),
    DELETE(1, "已删除"),
            ;

    private Integer status;
    private String msg;
}