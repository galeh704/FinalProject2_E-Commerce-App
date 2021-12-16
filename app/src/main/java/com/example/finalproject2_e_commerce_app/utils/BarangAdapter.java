package com.example.finalproject2_e_commerce_app.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.finalproject2_e_commerce_app.R;
import com.example.finalproject2_e_commerce_app.list.Barang;

import java.util.List;

public class BarangAdapter extends ArrayAdapter<Barang> {
    Context context;
    List<Barang> arrayListBarang;

    public BarangAdapter(@NonNull Context context, List<Barang> arrayListBarang) {
        super(context, R.layout.list_barang1);
        this.context = context;
        this.arrayListBarang = arrayListBarang;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_barang1, null, true);



        return view;
    }
}
