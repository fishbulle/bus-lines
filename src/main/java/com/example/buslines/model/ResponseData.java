package com.example.buslines.model;

import lombok.Data;

import java.util.Collection;

@Data
public class ResponseData<T> {
//    private String version;
//    private String type;
    private Collection<T> result;
}
