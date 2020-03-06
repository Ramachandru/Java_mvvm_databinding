package com.example.handson.models;

import java.util.List;

public class Races {
    private String season;
    private String raceName;
    private List<Results> Results;
    public void setSeason(String season){
        this.season = season;
    }
    public String getSeason(){
        return season;
    }
    public void setRaceName(String raceName){
        this.raceName = raceName;
    }
    public String getRaceName(){
        return raceName;
    }
    public void setResults(List<Results> results){
        this.Results = results;
    }
    public List<Results> getResults(){
        return Results;
    }

}
