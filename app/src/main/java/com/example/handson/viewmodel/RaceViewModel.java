package com.example.handson.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.handson.api.RacesApi;
import com.example.handson.models.RaceModel;
import com.example.handson.models.Races;
import com.example.handson.models.Results;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RaceViewModel extends ViewModel
{
    private MutableLiveData<HashMap<String, List<Results>>> raceModelMaps;
    public MutableLiveData<HashMap<String, List<Results>>> getRaceModelMaps(){
        if(raceModelMaps == null){
            raceModelMaps = new MutableLiveData<>();
            loadRaceDatas();
        }
        return raceModelMaps;
    }
    private void loadRaceDatas(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(RacesApi.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RacesApi racesApi=retrofit.create(RacesApi.class);
        Call<RaceModel> call=racesApi.getRaceSApis();
        call.enqueue(new Callback<RaceModel>() {
            @Override
            public void onResponse(Call<RaceModel> call, Response<RaceModel> response) {
                raceModelMaps.setValue(seggergateRacesDatas(response.body()));
            }

            @Override
            public void onFailure(Call<RaceModel> call, Throwable t) {
                Log.v("","ERROR : "+t.getMessage());
            }
        });
    }
    private HashMap<String,List<Results>> seggergateRacesDatas(RaceModel raceModel){
        HashMap<String,List<Results>> raceDatas=new HashMap<>();
        List<Results> races=raceModel.getMRData().getRaceTable().getRaces().get(0).getResults();
        for(Results result: races){
            setValue(raceDatas,result);
        }
        return raceDatas;
    }
    private void setValue(HashMap<String,List<Results>> raceData,Results result){
        if(raceData.containsKey(result.getConstructor().getConstructorId())){
            List<Results> list = raceData.get(result.getConstructor().getConstructorId());
            list.add(result);
            raceData.put(result.getConstructor().getConstructorId(),list);
        }
        else{
            List<Results> list=new ArrayList<>();
            list.add(result);
            raceData.put(result.getConstructor().getConstructorId(),list);
        }
    }
}
