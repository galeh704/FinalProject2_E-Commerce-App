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

public class ProductAdapter extends ArrayAdapter<Product> {

    Context context;
    List<Product> arrayListProduct;
    public ProductAdapter(@NonNull Context context, List<Product> arrayListProduct) {
        super(context, R.layout.list_product, arrayListProduct);
        this.context = context;
        this.arrayListProduct = arrayListProduct;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_product,null, true);

        TextView product_nama = view.findViewById(R.id.tv_nama_prd);
        TextView product_id = view.findViewById(R.id.tv_id_prd);
        TextView product_harga = view.findViewById(R.id.tv_harga);
        TextView product_stock = view.findViewById(R.id.tv_stock_product);
        ImageView img_view = view.findViewById(R.id.img_product);

        product_id.setText(arrayListProduct.get(position).getIdProduct());
        product_nama.setText(arrayListProduct.get(position).getNamaProduct());
        product_harga.setText(arrayListProduct.get(position).getHarga());
        product_stock.setText(arrayListProduct.get(position).getStock());
        Glide.with(context).load(arrayListProduct.get(position).getGambarProduct()).into(img_view);


        return view;
    }
}
