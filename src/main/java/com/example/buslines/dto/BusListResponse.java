package com.example.buslines.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BusListResponse {
    public Integer busLine;
    public List<String> stops;
}
