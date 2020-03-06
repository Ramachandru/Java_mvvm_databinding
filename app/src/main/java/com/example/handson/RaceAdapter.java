package com.example.handson;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.handson.models.Results;

import java.util.List;

public class RaceAdapter extends RecyclerView.Adapter{
    private List<Results> listData;
    public void setData(List<Results> list){
        listData = list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View videw= LayoutInflater.from(parent.getContext()).inflate(R.layout.raceadapter,parent,false);
        return new DataViewHolder(videw);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Results result=listData.get(position);
        DataViewHolder dataViewHolder= (DataViewHolder) holder;
        dataViewHolder.nameTx.setText(result.getDriver().getGivenName()+" ,\n"+result.getDriver().getDateOfBirth());
        dataViewHolder.capitalTxt.setText(result.getConstructor().getName()+" ,\n"+result.getConstructor().getNationality());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
    static class DataViewHolder extends RecyclerView.ViewHolder {
        TextView nameTx,capitalTxt;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTx = (TextView)itemView.findViewById(R.id.name);
            capitalTxt = (TextView)itemView.findViewById(R.id.capital);
        }
    }
}
