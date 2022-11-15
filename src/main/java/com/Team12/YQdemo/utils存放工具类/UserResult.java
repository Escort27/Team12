package com.Team12.YQdemo.utils存放工具类;

public class UserResult<T> {
    private String code;
    private String msg;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public UserResult() {
    }

    public UserResult(T data) {
        this.data = data;
    }

    public static UserResult success() {
        UserResult userResult = new UserResult<>();
        userResult.setCode("0");
        userResult.setMsg("成功");
        return userResult;
    }

    public static <T> UserResult<T> success(T data) {
        UserResult<T> userResult = new UserResult<>(data);
        userResult.setCode("0");
        userResult.setMsg("成功");
        return userResult;
    }

    public static <T> UserResult<T> success(T data, String msg) {
        UserResult<T> userResult = new UserResult<>(data);
        userResult.setCode("0");
        userResult.setMsg(msg);
        return userResult;
    }

    public static UserResult error(String code, String msg) {
        UserResult userResult = new UserResult();
        userResult.setCode(code);
        userResult.setMsg(msg);
        return userResult;
    }
}