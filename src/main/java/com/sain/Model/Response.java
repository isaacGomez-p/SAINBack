package com.sain.Model;

import org.springframework.http.HttpStatus;


public class Response {

    private int status;
    private String message;
    private Object result;

    public Response(HttpStatus status, String message, Object result) {
        this.status = status.value();
        this.message = message;
        this.result = result;
    }

    public Response(HttpStatus status, Object result) {
        this.status = status.value();
        this.result = result;
    }

    public Response(HttpStatus status, String message) {
        this.status = status.value();
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
