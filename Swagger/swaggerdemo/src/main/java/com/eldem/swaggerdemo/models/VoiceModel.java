package com.eldem.swaggerdemo.models;

public class VoiceModel {
    private int id;
    private String numberA;
    private String numberB;
    private Long duration;
    private String location;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumberA() {
        return this.numberA;
    }

    public void setNumberA(String numberA) {
        this.numberA = numberA;
    }

    public String getNumberB() {
        return this.numberB;
    }

    public void setNumberB(String numberB) {
        this.numberB = numberB;
    }

    public Long getDuration() {
        return this.duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}