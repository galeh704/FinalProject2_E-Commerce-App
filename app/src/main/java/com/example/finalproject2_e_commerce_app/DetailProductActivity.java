package com.example.finalproject2_e_commerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailProductActivity extends AppCompatActivity {
    TextView tv_namaDetail,tv_harga,tv_deskripsi,tv_id;
    ImageView img_barang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        tv_deskripsi = findViewById(R.id.tv_deskripsi);
        tv_harga = findViewById(R.id.tv_hargaDetail);
        tv_namaDetail = findViewById(R.id.tv_namaDetail);
        img_barang = findViewById(R.id.img_detail);
        tv_id = findViewById(R.id.tv_idD);

        Intent intent = getIntent();
        int position = intent.getExtras().getInt("position");
        tv_namaDetail.setText(UserBarangActivity.arrayGridProduct.get(position).getNamaProduct());
        tv_id.setText(UserBarangActivity.arrayGridProduct.get(position).getIdProduct());
        tv_harga.setText(UserBarangActivity.arrayGridProduct.get(position).getHarga());
        tv_deskripsi.setText(UserBarangActivity.arrayGridProduct.get(position).getDeskripsi());
        Glide.with(getApplicationContext()).load(UserBarangActivity.arrayGridProduct.get(position).getGambarProduct()).into(img_barang);

    }
}