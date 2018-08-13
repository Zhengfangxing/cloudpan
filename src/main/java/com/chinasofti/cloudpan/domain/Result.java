package com.chinasofti.cloudpan.domain;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * @author Charles C Wang
 * @date 2018/8/13 21:35
 */
public class Result {
    private Integer code;
    private String msg;
    private Object data;

    public static Result success(){
        return new Result(200,"成功",null);
    }

    public static Result error(){
        return new Result(300,"失败",null);
    }


    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
