package com.example.buslines.controller;

import com.example.buslines.service.BusService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/bus")
public class BusController {

    private BusService busService;


}
