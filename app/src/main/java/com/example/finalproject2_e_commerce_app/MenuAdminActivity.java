package com.example.finalproject2_e_commerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MenuAdminActivity extends AppCompatActivity {

    LinearLayout menu_staff, menu_barang;
    TextView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin);
        menu_barang = findViewById(R.id.menu_barang);
        menu_staff = findViewById(R.id.menu_staff);
        logout = findViewById(R.id.tv_logout);

        menu_staff.setOnClickListener(view -> {
            Intent gotoStaff = new Intent(MenuAdminActivity.this, StaffActivity.class);
            startActivity(gotoStaff);
        });
        menu_barang.setOnClickListener(view -> {
            Intent gotoBarang = new Intent(MenuAdminActivity.this, ProductActivity.class);
            startActivity(gotoBarang);
        });
        logout.setOnClickListener(view -> {
            Intent out = new Intent(MenuAdminActivity.this, adminlogin.class);
            startActivity(out);
            finish();
        });
    }
}