package com.example.finalproject2_e_commerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class HomeActivity extends AppCompatActivity {
    FrameLayout kategori_fashion,kategori_books,kategori_gadget,kategori_others,kategori_furniture,kategori_toys;
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


        kategori_fashion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kategori = "fashion";
                Intent goFsh = new Intent(HomeActivity.this, KategoriDetailActivity.class).putExtra("fashion",kategori);
                startActivity(goFsh);

            }
        });
        kategori_books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kategori = "books";
                Intent goBooks = new Intent(HomeActivity.this, UserBarangActivity.class).putExtra("books",kategori);
                startActivity(goBooks);
            }
        });

        kategori_others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kategori = "others";
                Intent goOth = new Intent(HomeActivity.this, UserBarangActivity.class).putExtra("others",kategori);
                startActivity(goOth);
            }
        });
        kategori_gadget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kategori = "gadget";
                Intent goGdt = new Intent(HomeActivity.this, KategoriGadgetActivity.class).putExtra("gadget",kategori);
                startActivity(goGdt);
            }
        });
        kategori_furniture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kategori = "furniture";
                Intent goGdt = new Intent(HomeActivity.this, UserBarangActivity.class).putExtra("furniture",kategori);
                startActivity(goGdt);
            }
        });
        kategori_toys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kategori = "toys";
                Intent goGdt = new Intent(HomeActivity.this, UserBarangActivity.class).putExtra("toys",kategori);
                startActivity(goGdt);
            }
        });
    }
}