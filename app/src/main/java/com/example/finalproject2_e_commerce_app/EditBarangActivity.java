package com.example.finalproject2_e_commerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class EditBarangActivity extends AppCompatActivity {
    EditText et_nama,et_kategori,et_harga,et_stock,et_deskripsi;
    Button btn_save,btn_select;
    ImageView img_barang;
    Bitmap bitmap;
    String encodedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_barang);
        et_nama = findViewById(R.id.et_namaP);
        et_deskripsi = findViewById(R.id.et_deskripsi);
        et_harga = findViewById(R.id.et_hargaP);
        et_stock = findViewById(R.id.et_stockP);
        et_kategori = findViewById(R.id.et_kategoriP);
        btn_save = findViewById(R.id.btn_save);
        btn_select = findViewById(R.id.btn_select);
        img_barang = findViewById(R.id.img_barang);
    }
}