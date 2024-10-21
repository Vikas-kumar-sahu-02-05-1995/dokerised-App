package com.todo.demotodolist.exception;

import java.util.Map;

import lombok.Data;

@Data
public class ApiResponse {

    private String message;
    private boolean success;
    private Map<String, Object> data;

    public ApiResponse(String message, boolean success, Map<String, Object> data) {
        super();
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public ApiResponse(String message, boolean success,Object data) {
        this.message = message;
        this.success = success;
        this.data = Map.of("data", data);    //wrap data in map
    }

    public ApiResponse(String message, boolean success) {
        super();
        this.message = message;
        this.success = success;
    }
}

