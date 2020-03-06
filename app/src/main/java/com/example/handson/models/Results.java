package com.example.handson.models;

public class Results {
    private String number;
    private String points;
    private Driver Driver;
    private Constructor Constructor;
    public void setNumber(String number){
        this.number = number;
    }
    public String getNumber(){
        return number;
    }
    public void setPoints(String points){
        this.points = points;
    }
    public String getPoints(){
        return points;
    }
    public void setDriver(Driver driver){
        this.Driver = driver;
    }
    public Driver getDriver(){
        return Driver;
    }
    public void setConstructor(Constructor constructor){
        this.Constructor =constructor;
    }
    public Constructor getConstructor(){
        return Constructor;
    }
}
