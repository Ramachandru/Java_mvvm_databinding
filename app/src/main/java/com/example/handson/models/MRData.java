package com.example.handson.models;

public class MRData {
    private String series;
    private String total;
    private RaceTable RaceTable;
    public void setSeries(String series){
        this.series = series;
    }
    public String getSeries(){
        return series;
    }
    public void setTotal(String total){
        this.total = total;
    }
    public String getTotal(){
        return total;
    }
    public void setRaceTable(RaceTable raceTable){
        this.RaceTable = raceTable;
    }
    public  RaceTable getRaceTable(){
        return RaceTable;
    }
}

