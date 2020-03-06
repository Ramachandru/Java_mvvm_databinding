package com.example.handson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.handson.Listeners.DataListeners;
import com.example.handson.models.Results;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter{
    private List<String> listData;
    DataListeners dataListeners;
    MainAdapter(Context context){
        dataListeners = (DataListeners)context;
    }
    public void setData(List<String> list){
        listData = list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View videw= LayoutInflater.from(parent.getContext()).inflate(R.layout.mainadapter,parent,false);
        return new DataViewHolder(videw);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final String result=listData.get(position);
        DataViewHolder dataViewHolder= (DataViewHolder) holder;
        dataViewHolder.nameTx.setText(result);
        dataViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataListeners.onData(result);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
    static class DataViewHolder extends RecyclerView.ViewHolder {
        TextView nameTx;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTx = (TextView)itemView.findViewById(R.id.name);
        }
    }
}
