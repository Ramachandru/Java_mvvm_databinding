package com.example.handson;

import com.example.handson.models.Results;

import java.util.HashMap;
import java.util.List;

public class RaceTon {
    private HashMap<String, List<Results>> mCountryList;
    private static RaceTon mCountryTon;
    private RaceTon(){

    }
    public static RaceTon getInstance(){
        if(mCountryTon == null) {
            synchronized (RaceTon.class) {
                if (mCountryTon == null) {
                    mCountryTon = new RaceTon();
                }
            }
        }
        return mCountryTon;
    }
    public void setResultsList(HashMap<String, List<Results>> countryList){
        mCountryList = countryList;
    }

    public HashMap<String, List<Results>>  getResultsList() {
        return mCountryList;
    }
}
