package com.example.handson.api;

import com.example.handson.models.RaceModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RacesApi {
    String BaseUrl ="http://ergast.com/api/f1/2004/1/";

    @GET("results.json")
    Call<RaceModel> getRaceSApis();
}
