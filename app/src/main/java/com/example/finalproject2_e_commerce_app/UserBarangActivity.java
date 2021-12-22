package com.example.finalproject2_e_commerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class UserBarangActivity extends AppCompatActivity {
    TextView tv_testing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_barang);
        tv_testing = findViewById(R.id.tv_testing);

        Intent intent = getIntent();
        String ms = intent.getStringExtra("men_tshirt");
        String mf = intent.getStringExtra("men_formal");
        String wf = intent.getStringExtra("women_formal");

        if(ms != null){
            tv_testing.setText(ms);
        }
        if(mf != null){

            tv_testing.setText(mf);
        }
        if(wf != null){

            tv_testing.setText(wf);
        }

    }
}