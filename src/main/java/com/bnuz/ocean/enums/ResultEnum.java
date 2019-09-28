package com.bnuz.ocean.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    SUCCESS(200, "成功"),
    UNKNOW_ERROR(201,"未知错误");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
