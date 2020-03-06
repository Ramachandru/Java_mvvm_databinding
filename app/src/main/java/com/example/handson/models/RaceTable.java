package com.example.handson.models;

import java.util.List;

public class RaceTable {
    private String round;
    private List<Races> Races;
    public void setRound(String round){
        this.round = round;
    }
    public String getRound(){
        return round;
    }
    public void setRaces(List<Races> races){
        this.Races = races;
    }
    public List<Races> getRaces(){
        return Races;
    }
}
