package com.kk.constants;

/**
 *
 * @author kzj
 * @date 2020-4-6 13:04:58
 */
public enum HttpStatusConstants {

    /**
     * 成功的请求
     */
    SUCCESS(200,"成功"),
    /**
     * 请求参数有误
     */
    BAD_REQUEST(400,"请求参数有误"),
    /**
     * 登录失败
     */
    UNAUTHORIZED(401,"登录失败"),
    /**
     * 服务器遇到一个未预料到的错误
     */
    INTERNAL_SERVER_ERROR(500,"服务器遇到一个未预料到的错误"),
    /**
     * 从上游服务器接收到无效的响应
     */
    BA_GATEWAY(502,"从上游服务器接收到无效的响应");


    private final int status;
    private final String content;

    HttpStatusConstants(int status, String content) {
        this.status = status;
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public String getContent() {
        return content;
    }
}
