package com.company;

import java.sql.Time;

public class Timer {
    private int hour;//a class, has some properties
    private int minute; //int = "primitive" type, like "C" type
    private int second; //int run faster than Integer

    public Timer(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        if(second > 59) {
            this.second = 59;
            int remainSeconds = second - 59;
            this.minute += remainSeconds/60;
        } else if(second < 0) {
            this.second = 0;
        } else {
            this.second = second;
        }

    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
    public void setTime(int hour, int minute, int second) {
        //this function only changes hour, minute, second of this object, NOT create a new Object !
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    @Override
    public String toString() {
        return "Timer{" +
                "hour=" + hour +
                ", minute=" + minute +
                ", second=" + second +
                '}';
    }
    public Timer nextSecond() {
        //create new Object with changed properties !
        //this.second++;//wrong !
        return new Timer(this.hour, this.minute, this.second + 1);
    }
    public Timer previousSecond() {
        //create new Object with changed properties !
        //this.second++;//wrong !
        return new Timer(this.hour, this.minute, this.second - 1);
    }
}
