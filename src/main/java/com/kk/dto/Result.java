package com.kk.dto;

/*
@author kzj
@date 2020/4/6 - 14:38
*/

import java.io.Serializable;

/**
 * @author kzj
 * @param <T>
 */
public class Result<T> implements Serializable {

    private int resultCode;
    private String message;
    private T data;

    public Result(){

    }

    public Result(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + resultCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}