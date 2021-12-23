package com.example.finalproject2_e_commerce_app;

import androidx.appcompat.app.AppCompatActivity;



public class HomeActivity extends AppCompatActivity {
   

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.FrameLayout;
  
public class HomeActivity extends AppCompatActivity {
   FrameLayout kategori_fashion,kategori_books,kategori_gadget,kategori_others,kategori_furniture,kategori_toys;
    ImageView fashion,gadget,book,other;


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

  /*
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
        */

    }
}