package com.nanyuan.wave.core.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @description:
 * @author: yanghailang
 * @create: 2021-05-25 14:44
 **/
@Getter
@AllArgsConstructor
@ToString
public enum ResponseEnum {

    SUCCESS(20000, "成功"),
    ERROR(500, "服务器内部错误"),

    //-1xx 服务器错误
    BAD_SQL_GRAMMAR_ERROR(-101, "sql语法错误"),
    SERVLET_ERROR(-102, "servlet请求异常"), //-2xx 参数校验
    UPLOAD_ERROR(-103, "文件上传错误"),
    EXPORT_DATA_ERROR(104, "数据导出失败"),

    LOGIN_AUTH_ERROR(999,"登录校验失败"),

    //-3xx 参数校验
    PARAM_NOT_EMPTY(301,"参数不能为空"),
    ;


    //响应状态码
    private Integer code;
    //响应信息
    private String message;
}
