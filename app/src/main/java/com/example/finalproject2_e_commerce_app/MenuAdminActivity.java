package com.example.finalproject2_e_commerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.finalproject2_e_commerce_app.list.Staff;
import com.example.finalproject2_e_commerce_app.utils.StaffAdapter;

import java.util.ArrayList;

public class MenuAdminActivity extends AppCompatActivity {

    LinearLayout menu_staff, menu_barang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin);
        menu_barang = findViewById(R.id.menu_barang);
        menu_staff = findViewById(R.id.menu_staff);

        menu_staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoStaff = new Intent(MenuAdminActivity.this, StaffActivity.class);
                startActivity(gotoStaff);
            }
        });
        menu_barang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoBarang = new Intent(MenuAdminActivity.this, BarangActivity.class);
                startActivity(gotoBarang);
            }
        });
    }
}