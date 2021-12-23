package com.example.finalproject2_e_commerce_app.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.finalproject2_e_commerce_app.R;
import com.example.finalproject2_e_commerce_app.list.Product;

import java.util.List;

public class UserProductAdapter extends ArrayAdapter<Product> {

    Context context;
    List<Product> arrayGridProduct;
    public UserProductAdapter(@NonNull Context context, List<Product> arrayGridProduct) {
        super(context, R.layout.grid_product, arrayGridProduct);
        this.context = context;
        this.arrayGridProduct = arrayGridProduct;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_product, null, true);

        TextView product_nama = view.findViewById(R.id.tv_nama_grid);
        TextView product_id =   view.findViewById(R.id.tv_id_grid);
        TextView product_harga = view.findViewById(R.id.tv_harga_grid);
        ImageView product_gambar = view.findViewById(R.id.img_product_grid);

        product_id.setText(arrayGridProduct.get(position).getIdProduct());
        product_nama.setText(arrayGridProduct.get(position).getNamaProduct());
        product_harga.setText(arrayGridProduct.get(position).getHarga());
        Glide.with(context).load(arrayGridProduct.get(position).getGambarProduct()).into(product_gambar);



        return view;
    }
}
