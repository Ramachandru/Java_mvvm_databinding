package com.example.handson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.handson.Listeners.DataListeners;
import com.example.handson.models.Results;
import com.example.handson.viewmodel.RaceViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DataListeners {
    MainAdapter mainAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recylceView=findViewById(R.id.main_recycle);
        RaceViewModel raceViewModel = ViewModelProviders.of(this).get(RaceViewModel.class);
        raceViewModel.getRaceModelMaps().observe(this, new Observer<HashMap<String, List<Results>>>() {
            @Override
            public void onChanged(HashMap<String, List<Results>> stringListHashMap) {
                RaceTon.getInstance().setResultsList(stringListHashMap);
                List<String> mains=new ArrayList<>(stringListHashMap.keySet());
                Log.v("","<<<<<<<<<<<<<<<Data : "+mains);
                mainAdapter.setData(mains);
                mainAdapter.notifyDataSetChanged();
            }
        });
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recylceView.setLayoutManager(linearLayoutManager);
        mainAdapter=new MainAdapter(this);
        mainAdapter.setData(new ArrayList<String>());
        recylceView.setAdapter(mainAdapter);
    }

    @Override
    public void onData(String data) {
        Intent intent=new Intent(MainActivity
                .this,ResultActivity.class);
        intent.putExtra("pass",data);
        startActivity(intent);
    }
}
