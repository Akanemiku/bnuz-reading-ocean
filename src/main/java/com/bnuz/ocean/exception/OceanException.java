package com.bnuz.ocean.exception;


import com.bnuz.ocean.enums.ResultEnum;

/**
 * Create by Akane on 2019/8/22.
 */
public class OceanException extends RuntimeException{
    private Integer code;

    public OceanException(ResultEnum resultEnum){
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public OceanException(Integer code, String message){
        super(message);
        this.code = code;
    }
}
