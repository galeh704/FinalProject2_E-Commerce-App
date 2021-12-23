package com.example.finalproject2_e_commerce_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.finalproject2_e_commerce_app.list.Product;
import com.example.finalproject2_e_commerce_app.utils.StaffAdapter;
import com.example.finalproject2_e_commerce_app.utils.UserProductAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class UserBarangActivity extends AppCompatActivity {
    GridView grid_barang;
    UserProductAdapter adapter;
    public static ArrayList<Product> arrayGridProduct = new ArrayList<>();
    Product product;

    TextView tv_testing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_barang);
        tv_testing = findViewById(R.id.tv_testing);
        grid_barang = findViewById(R.id.grid_barang);
        adapter = new UserProductAdapter(this, arrayGridProduct);
        grid_barang.setAdapter(adapter);
        arrayGridProduct.clear();

        Intent intent = getIntent();
        String ms = intent.getStringExtra("men_tshirt");
        String mf = intent.getStringExtra("men_formal");
        String wf = intent.getStringExtra("women_formal");
        String ws = intent.getStringExtra("women_tshirt");
        String p = intent.getStringExtra("pants");
        String s = intent.getStringExtra("shoes");
        String ow = intent.getStringExtra("outwear");
        String books = intent.getStringExtra("books");
        String toys = intent.getStringExtra("toys");
        String furniture = intent.getStringExtra("furniture");
        String others = intent.getStringExtra("others");
        String laptop = intent.getStringExtra("laptop");
        String smartphone = intent.getStringExtra("smartphone");



        if(ms != null){
            tv_testing.setText(ms);

            retrieveData("https://vacillating-feedbac.000webhostapp.com/readbaranguser.php");
        }
        if(mf != null){

            tv_testing.setText(mf);
            retrieveData("https://vacillating-feedbac.000webhostapp.com/readmformal.php");
        }
        if(wf != null){

            tv_testing.setText(wf);
            retrieveData("https://vacillating-feedbac.000webhostapp.com/readwformal.php");
        }
        if(ws != null){

            tv_testing.setText(ws);
            retrieveData("https://vacillating-feedbac.000webhostapp.com/readwtshirts.php");
        }
        if(s != null){

            tv_testing.setText(s);
            retrieveData("https://vacillating-feedbac.000webhostapp.com/readshoes.php");
        }
        if(p != null){

            tv_testing.setText(p);
            retrieveData("https://vacillating-feedbac.000webhostapp.com/readpants.php");
        }
        if(ow != null){
            retrieveData("https://vacillating-feedbac.000webhostapp.com/readoutwear.php");
            tv_testing.setText(ow);
        }
        if(books != null){
            retrieveData("https://vacillating-feedbac.000webhostapp.com/readbooks.php");
            tv_testing.setText(books);
        }
        if(toys != null){
            retrieveData("https://vacillating-feedbac.000webhostapp.com/readtoys.php");
            tv_testing.setText(toys);
        }
        if(furniture != null){
            retrieveData("https://vacillating-feedbac.000webhostapp.com/readfurniture.php");
            tv_testing.setText(furniture);
        }
        if(others != null){
            retrieveData("https://vacillating-feedbac.000webhostapp.com/readothers.php");
            tv_testing.setText(others);
        }
        if(laptop !=null){
            retrieveData("https://vacillating-feedbac.000webhostapp.com/readlaptop.php");
            tv_testing.setText(laptop);
        }
        if(smartphone !=null){
            retrieveData("https://vacillating-feedbac.000webhostapp.com/readsmartphone.php");
            tv_testing.setText(smartphone);
        }
        grid_barang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                        startActivity(new Intent(getApplicationContext(),DetailProductActivity.class).putExtra("position",position));


            }
        });

    }

    private void retrieveData( String lala){

        StringRequest request = new StringRequest(Request.Method.POST, lala,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        arrayGridProduct.clear();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String sucess = jsonObject.getString("success");
                            Log.e("anyText", response);
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
                                    arrayGridProduct.add(product);
                                    adapter.notifyDataSetChanged();

                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(UserBarangActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}