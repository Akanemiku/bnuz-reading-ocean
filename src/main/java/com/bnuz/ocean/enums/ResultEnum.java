package com.bnuz.ocean.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    SUCCESS(200, "成功"),
    UNKNOW_ERROR(201,"未知错误"),

    MISSION_INSERT_ERROR(301,"任务插入错误"),
    M_S_INSERT_ERROR(302,"任务学生关系插入错误"),
    M_B_INSERT_ERROR(303,"任务图书关系插入错误"),
    EVALUATE_INSERT_ERROR(304,"评价信息插入错误"),
    ASSESS_INFO_NULL_ERROR(305,"评价信息为空");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
