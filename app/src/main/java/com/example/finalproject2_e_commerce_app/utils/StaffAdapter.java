package com.example.finalproject2_e_commerce_app.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.finalproject2_e_commerce_app.R;
import com.example.finalproject2_e_commerce_app.list.Staff;

import java.util.List;

public class StaffAdapter extends ArrayAdapter<Staff> {
    Context context;
    List<Staff> arrayListStaff;

    public StaffAdapter(@NonNull Context context, List<Staff> arrayListStaff) {
        super(context, R.layout.list_staff, arrayListStaff);
        this.context = context;
        this.arrayListStaff = arrayListStaff;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_staff, null, true);

        TextView staff_nama = view.findViewById(R.id.tv_namaS);
        TextView staff_id = view.findViewById(R.id.tv_id);
        TextView staff_jabatan = view.findViewById(R.id.tv_jabatan);

        staff_id.setText(arrayListStaff.get(position).getIdStaff());
        staff_nama.setText(arrayListStaff.get(position).getNamaStaff());
        staff_jabatan.setText(arrayListStaff.get(position).getJabatan());



        return view;
    }
}
