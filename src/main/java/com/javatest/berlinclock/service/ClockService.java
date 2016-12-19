package com.javatest.berlinclock.service;

import com.javatest.berlinclock.model.Clock;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class ClockService {

    public Clock calculateBerlinClockByNow(){
        return calculateBerlinClockByTime(LocalTime.now());
    }

    public Clock calculateBerlinClockByTime(LocalTime time){
        Clock clock = new Clock();
        clock.setSecond((time.getSecond() % 2) == 0);

        int hourBy1Value = time.getHour() % 5;
        int hourBy5Value =  (time.getHour() - hourBy1Value) / 5;

        clock.setHour_1(fillBooleanArrayByValue(4, hourBy1Value));
        clock.setHour_5(fillBooleanArrayByValue(4, hourBy5Value));


        int minuteBy1Value = time.getMinute() % 5;
        int minuteBy5Value = (time.getMinute() - minuteBy1Value) / 5;

        clock.setMinute_1(fillBooleanArrayByValue(4, minuteBy1Value));
        clock.setMinute_5(fillBooleanArrayByValue(11, minuteBy5Value));

        return clock;
    }

    private boolean[] fillBooleanArrayByValue(int arrayLength, int value){
        boolean[] steps = new boolean[arrayLength];
        for(int i = 0; i<arrayLength; i++) {
            steps[i] = i < value;
        }
        return steps;
    }
}
