package com.example.handson.models;

public class Driver {
    private String driverId;
    private String code;
    private String givenName;
    private String familyName;
    private String dateOfBirth;
    public void setDriverId(String driverId){
        this.driverId = driverId;
    }
    public String getDriverId(){
        return driverId;
    }
    public void  setCode(String code){
        this.code = code;
    }
    public String getCode(){
        return code;
    }
    public void setGivenName(String givenName){
        this.givenName = givenName;
    }
    public String getGivenName(){
        return givenName;
    }
    public void setFamilyName(String familyName){
        this.familyName = familyName;
    }
    public String getFamilyName(){
        return familyName;
    }
    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }
    public String getDateOfBirth(){
        return dateOfBirth;
    }
}
