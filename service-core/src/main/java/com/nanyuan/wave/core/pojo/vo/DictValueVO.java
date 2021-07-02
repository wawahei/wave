package com.nanyuan.wave.core.pojo.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.Map;

public class DictValueVO {

    @ApiModelProperty(value = "字典类型编码 字典类型编码")
    private String typeCode;

    private Map<String,Object> map;
}
