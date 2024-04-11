package org.example.entity;

import lombok.Data;

@Data
//使用Result返回统一结构
public class Result {

    //定义静态常量/也可以定义枚举类型
    public static final String SUCCESS = "0";
    public static final String ERROR = "-1";

    private String code;
    private String msg;
    private Object data;

    //只返回成功标识
    public static Result success() {
        Result result = new Result();
        result.setCode(SUCCESS);
        return result;
    }

    //返回成功标识及数据
    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(SUCCESS);
        result.setData(data);
        return result;
    }

    //返回错误标识及错误信息
    public static Result error(String msg) {
        Result result = new Result();
        result.setCode(ERROR);
        result.setData(msg);
        return result;
    }

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

