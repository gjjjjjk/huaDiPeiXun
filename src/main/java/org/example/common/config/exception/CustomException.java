package org.example.common.config.exception;

public class CustomException extends Throwable {
    private String msg;


    public CustomException(String msg) {
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
