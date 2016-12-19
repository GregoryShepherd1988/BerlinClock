package com.javatest.berlinclock.controller;

import com.javatest.berlinclock.model.Clock;
import com.javatest.berlinclock.service.ClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClockController {

    @Autowired
    private ClockService clockService;

    @RequestMapping(value = "/clock", method = RequestMethod.GET)
    public Clock getClockByNow() {
        return clockService.calculateBerlinClockByNow();
    }
}
