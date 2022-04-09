package com.novalover.controller.utils;

import lombok.Data;

@Data
public class R {
    private boolean flat;
    private Object data;
    private String msg;

    public R(boolean flat, Object data) {
        this.flat = flat;
        this.data = data;
    }

    public R(boolean flat,String msg){
        this.flat = flat;
        this.msg = msg;
    }

    public R(String msg){
        this.flat = false;
        this.msg = msg;
    }

}
