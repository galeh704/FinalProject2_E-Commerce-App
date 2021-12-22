package com.example.finalproject2_e_commerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    ImageView fashion,gadget,book,other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fashion = findViewById(R.id.iv_fashion);
        fashion.setOnClickListener(this::onClick);

        gadget = findViewById(R.id.iv_gadget);
        gadget.setOnClickListener(this::onClick);

        book = findViewById(R.id.iv_book);
        book.setOnClickListener(this::onClick);

        other = findViewById(R.id.iv_other);
        other.setOnClickListener(this::onClick);

    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_fashion:
                Intent fas = new Intent(HomeActivity.this,KategoriDetailActivity.class);
                startActivity(fas);
                break;

            case R.id.iv_gadget:
                startActivity(new Intent(HomeActivity.this,UserBarangActivity.class));
                break;

            case R.id.iv_book:
                startActivity(new Intent(HomeActivity.this,ProductActivity.class));
                break;

            case R.id.iv_other:
                startActivity(new Intent(HomeActivity.this,ProductActivity.class));
                break;

//            case R.id.tv_logout2:
//                startActivity(new Intent(HomeActivity.this,MainActivity.class));
//                finish();
//                break;
//
//            case R.id.tv_aboutus2:
//                startActivity(new Intent(HomeActivity.this,aboutus.class));
//                finish();
//                break;
        }
    }
}