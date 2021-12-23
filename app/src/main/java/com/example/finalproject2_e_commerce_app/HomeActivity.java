package com.example.finalproject2_e_commerce_app;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
   


import android.content.Intent;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.FrameLayout;
  
public class HomeActivity extends AppCompatActivity {
   FrameLayout kategori_fashion,kategori_books,kategori_gadget,kategori_others,kategori_furniture,kategori_toys;
    ImageView fashion,gadget,book,other;
    TextView tv_logout,tv_aboutus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        kategori_books = findViewById(R.id.kategori_books);
        kategori_fashion = findViewById(R.id.kategori_fashion);
        kategori_gadget = findViewById(R.id.kategori_gadget);
        kategori_others = findViewById(R.id.kategori_others);
        kategori_toys = findViewById(R.id.kategori_toys);
        kategori_furniture = findViewById(R.id.kategori_furniture);
        tv_aboutus = findViewById(R.id.tv_aboutus3);
        tv_logout = findViewById(R.id.tv_logout3);



        tv_logout.setOnClickListener(this::onClick);

        tv_aboutus.setOnClickListener(this::onClick);

        kategori_fashion.setOnClickListener(this::onClick);

        kategori_gadget.setOnClickListener(this::onClick);

        kategori_books.setOnClickListener(this::onClick);

        kategori_others.setOnClickListener(this::onClick);

        kategori_toys.setOnClickListener(this::onClick);

        kategori_furniture.setOnClickListener(this::onClick);

    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.kategori_fashion:
                String kategori = "fashion";
                Intent fas =  new Intent(HomeActivity.this, KategoriDetailActivity.class).putExtra("fashion",kategori);
                startActivity(fas);
                break;

            case R.id.kategori_gadget:
                String kategori3 = "gadget";
                startActivity(new Intent(HomeActivity.this, KategoriGadgetActivity.class).putExtra("gadget",kategori3));
                break;

            case R.id.kategori_books:
                String kategori2 = "books";
                startActivity( new Intent(HomeActivity.this, UserBarangActivity.class).putExtra("books",kategori2));
                break;
            case R.id.kategori_others:
                String kategori4 = "others";
                startActivity(new Intent(HomeActivity.this, UserBarangActivity.class).putExtra("others",kategori4));
                break;
            case R.id.kategori_furniture:
                String kategori5 = "furniture";
                startActivity(new Intent(HomeActivity.this, UserBarangActivity.class).putExtra("furniture",kategori5));
                break;
             case R.id.kategori_toys:
                String kategori6 = "toys";
                startActivity(new Intent(HomeActivity.this, UserBarangActivity.class).putExtra("toys",kategori6));
                break;
             case R.id.tv_logout3:
               startActivity(new Intent(HomeActivity.this,MainActivity.class));
                finish();
                break;
             case R.id.tv_aboutus3:
                startActivity(new Intent(HomeActivity.this,aboutus.class));
                finish();
                break;
        }


    }
}