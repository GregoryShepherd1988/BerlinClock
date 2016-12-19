package com.javatest.berlinclock.model;

public class Clock {

    private boolean second;
    private boolean[] hour_5;
    private boolean[] hour_1;
    private boolean[] minute_5;
    private boolean[] minute_1;

    public boolean isSecond() {
        return second;
    }

    public void setSecond(boolean second) {
        this.second = second;
    }

    public boolean[] getHour_5() {
        return hour_5;
    }

    public void setHour_5(boolean[] hour_5) {
        this.hour_5 = hour_5;
    }

    public boolean[] getHour_1() {
        return hour_1;
    }

    public void setHour_1(boolean[] hour_1) {
        this.hour_1 = hour_1;
    }

    public boolean[] getMinute_5() {
        return minute_5;
    }

    public void setMinute_5(boolean[] minute_5) {
        this.minute_5 = minute_5;
    }

    public boolean[] getMinute_1() {
        return minute_1;
    }

    public void setMinute_1(boolean[] minute_1) {
        this.minute_1 = minute_1;
    }
}
