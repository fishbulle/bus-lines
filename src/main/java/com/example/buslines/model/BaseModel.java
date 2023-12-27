package com.example.buslines.model;

import lombok.Data;

@Data
public class BaseModel<T> {
    private int statusCode;
//    private String message;
//    private int ExecutionTime;
    private ResponseData<T> responseData;
}
