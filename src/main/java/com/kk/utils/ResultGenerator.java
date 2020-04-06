package com.kk.utils;

/*
@author kzj
@date 2020/4/6 - 15:01
*/

import com.kk.constants.HttpStatusConstants;
import com.kk.dto.Result;
import org.springframework.util.StringUtils;

/**
 * 请求的返回值生成器
 */
public class ResultGenerator {

    public static Result genSuccessResult(){
        Result result = new Result();
        result.setResultCode(HttpStatusConstants.SUCCESS.getStatus());
        result.setMessage(HttpStatusConstants.SUCCESS.getContent());
        return result; 
    }

    public static Result genSuccessResult(String message){
        Result result = new Result();
        result.setResultCode(HttpStatusConstants.SUCCESS.getStatus());
        result.setMessage(message);
        return result;
    }

    public static Result genSuccessResult(Object data){
        Result result = new Result();
        result.setResultCode(HttpStatusConstants.SUCCESS.getStatus());
        result.setMessage(HttpStatusConstants.SUCCESS.getContent());
        result.setData(data);
        return result;
    }

    /**
     * 500错误
     * @param message
     * @return
     */
    public static Result genFailResult(String message){
        Result result = new Result();
        result.setResultCode(HttpStatusConstants.INTERNAL_SERVER_ERROR.getStatus());
        if(StringUtils.isEmpty(message)){
            result.setMessage(HttpStatusConstants.INTERNAL_SERVER_ERROR.getContent());
        }else {
            result.setMessage(message);
        }
        return result;
    }

    public static Result getErrorResult(int code, String message){
        Result result = new Result();
        result.setResultCode(code);
        result.setMessage(message);
        return result;
    }

    public static Result genResultByHttp(HttpStatusConstants constants, Object data){
        Result result = new Result();
        result.setResultCode(constants.getStatus());
        result.setMessage(constants.getContent());
        result.setData(data);
        return result;
    }

    public static Result genResultByHttp(HttpStatusConstants constants){
        Result result = new Result();
        result.setResultCode(constants.getStatus());
        result.setMessage(constants.getContent());
        return result;
    }

}
