package com.chinasofti.cloudpan.domain;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * @author William D X Zheng
 * @date 2018/8/7 0:57
 */
public class Result {
    private String message;
    private Boolean status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
