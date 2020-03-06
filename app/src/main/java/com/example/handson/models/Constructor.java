package com.example.handson.models;

public class Constructor {
    private String constructorId;
    private String url;
    private String name;
    private String nationality;
    public void setConstructorId(String constructorId){
        this.constructorId = constructorId;
    }
    public String getConstructorId(){
        return constructorId;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public String getUrl(){
        return url;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setNationality(String nationality){
        this.nationality = nationality;
    }
    public String getNationality(){
        return nationality;
    }
}
