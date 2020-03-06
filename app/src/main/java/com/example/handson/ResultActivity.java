package com.example.handson;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.handson.models.Results;

import java.util.List;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        String key = getIntent().getStringExtra("pass");
        List<Results> resultsList =RaceTon.getInstance().getResultsList().get(key);
        RecyclerView recylceView=findViewById(R.id.result_recycle);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recylceView.setLayoutManager(linearLayoutManager);
        RaceAdapter raceAdapter=new RaceAdapter();
        raceAdapter.setData(resultsList);
        recylceView.setAdapter(raceAdapter);
    }
}
