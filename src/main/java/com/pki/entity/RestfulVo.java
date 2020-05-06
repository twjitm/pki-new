package com.pki.entity;

import java.util.HashMap;
import java.util.Map;

public class RestfulVo {
    private int code;
    private boolean successful;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    public RestfulVo() {
        //data = new HashMap<>();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public Object getData(String key) {
        return data.get(key);
    }

    public void addData(String key, Object d) {
        data.put(key, d);
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
