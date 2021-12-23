package com.example.finalproject2_e_commerce_app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.finalproject2_e_commerce_app.list.Product;
import com.example.finalproject2_e_commerce_app.utils.ProductAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductActivity extends AppCompatActivity {

    ListView list_product;
    ImageView back_btn;
    FloatingActionButton fb_product;
    ProductAdapter productAdapter;
    public static ArrayList<Product> productArrayList = new ArrayList<>();
    Product product;
    String url = "https://vacillating-feedbac.000webhostapp.com/readbarang.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        back_btn = findViewById(R.id.back_btn);
        fb_product = findViewById(R.id.fb_product);
        list_product = findViewById(R.id.list_product);
        productAdapter = new ProductAdapter(this, productArrayList);
        list_product.setAdapter(productAdapter);

        list_product.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                ProgressDialog progressDialog = new ProgressDialog(view.getContext());

                CharSequence[] dialogItem = {"View Data", "Delete Data"};
                builder.setTitle(productArrayList.get(position).getNamaProduct());
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0:
                                startActivity(new Intent(getApplicationContext(),EditProductActivity.class).putExtra("position",position));
                                break;
                            case 1:
                                deleteData(productArrayList.get(position).getIdProduct());
                                break;

                        }
                    }
                });
                builder.create().show();
            }
        });
        retrieveData();
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goBack = new Intent(ProductActivity.this, MenuAdminActivity.class);
                startActivity(goBack);
                finish();
            }
        });
        fb_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goEdit = new Intent(ProductActivity.this, AddBarangActivity.class);
                startActivity(goEdit);

            }
        });
    }

    private void retrieveData() {
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        productArrayList.clear();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String sucess = jsonObject.getString("success");
                            Log.e("anyText",response);
                            JSONArray jsonArray = jsonObject.getJSONArray("product");

                            if (sucess.equals("1")) {
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String idProduct = object.getString("idProduct");
                                    String namaProduct = object.getString("namaProduct");
                                    String harga = object.getString("harga");
                                    String stock = object.getString("stock");
                                    String deskripsi = object.getString("deskripsi");
                                    String kategori = object.getString("kategori");
                                    String gambar = object.getString("gambarProduct");

                                    String url = "https://vacillating-feedbac.000webhostapp.com/Images/"+ gambar;

                                    product = new Product(idProduct,namaProduct, harga, stock, deskripsi, kategori, url);
                                    productArrayList.add(product);
                                    productAdapter.notifyDataSetChanged();
                                }
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ProductActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);

    }

    private  void deleteData(String idProduct){
        StringRequest request = new StringRequest(Request.Method.POST, "https://vacillating-feedbac.000webhostapp.com/deleteProduct.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    if(response.equalsIgnoreCase("data terhapus")){
                        Toast.makeText(ProductActivity.this, "Data suskes terhapus", Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(ProductActivity.this, "Data gagal", Toast.LENGTH_SHORT).show();
                    }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("idProduct", idProduct);

                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(ProductActivity.this);
        requestQueue.add(request);
    }

}