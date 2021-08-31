package com.eldem.swaggerdemo.models;

public class DataModel {
    public int id;
    public String number;
    public int amount;
    public boolean isRG;
    public String location;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isIsRG() {
        return this.isRG;
    }

    public boolean getIsRG() {
        return this.isRG;
    }

    public void setIsRG(boolean isRG) {
        this.isRG = isRG;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
