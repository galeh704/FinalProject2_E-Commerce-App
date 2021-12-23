package com.example.finalproject2_e_commerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class successfullogin extends AppCompatActivity {
    TextView logout, aboutus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successfullogin);
        logout = findViewById(R.id.tv_logout2);
        aboutus = findViewById(R.id.tv_aboutus2);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent out = new Intent(successfullogin.this,MainActivity.class);
                startActivity(out);
                finish();
            }
        });
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent about = new Intent(successfullogin.this, com.example.finalproject2_e_commerce_app.aboutus.class);
                startActivity(about);
            }
        });
    }
}