package com.bnuz.ocean.VO;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultVO<T> implements Serializable {
    private static final long serialVersionUID = 3979327950126221921L;
    private Integer code;
    private String msg;
    private T data;
}
