package com.example.finalproject2_e_commerce_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.finalproject2_e_commerce_app.list.Barang;

import com.example.finalproject2_e_commerce_app.utils.BarangAdapter;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BarangActivity extends AppCompatActivity {
    ListView list_barangg;
    FloatingActionButton fl_tambah;
    ImageView back_btn;
    BarangAdapter adapter;
    public static ArrayList<Barang> barangArrayList = new ArrayList<>();
    Barang barang;
    String url = "https://vacillating-feedbac.000webhostapp.com/barang/readbarang.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang);

        fl_tambah = findViewById(R.id.flButton);
        list_barangg = findViewById(R.id.list_b);
        adapter = new BarangAdapter(this, barangArrayList);
        list_barangg.setAdapter(adapter);


        list_barangg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int ia, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                ProgressDialog progressDialog = new ProgressDialog(view.getContext());

                CharSequence[] dialogItem = {"Edit Data","Delete Data"};
                builder.setTitle(barangArrayList.get(ia).getNamaBarang());
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                        switch (i){
                            case 0:
                                startActivity(new Intent(getApplicationContext(), EditProductActivity.class).putExtra("position",ia));
                                break;
                            case 1:
                                break;

                        }

                    }
                });
                builder.create().show();


            }

        });


        fl_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goEdit = new Intent(BarangActivity.this, AddBarangActivity.class);
                startActivity(goEdit);
            }
        });



    }

    private void retrieveData() {
        StringRequest request = new StringRequest(Request.Method.POST, "https://vacillating-feedbac.000webhostapp.com/readbarang.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        barangArrayList.clear();
                        try {

                            JSONObject jsonObject = new JSONObject(response);
                            String sucess = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("barang");

                            if (sucess.equals("1")) {

                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String idBarang = object.getString("idBarang");
                                    String namaBarang = object.getString("namaBarang");
                                    String harga = object.getString("harga");
                                    String stock = object.getString("stock");
                                    String deskripsi = object.getString("deskripsi");
                                    String kategori = object.getString("kategori");
                                    String gambarBarang = object.getString("gambarBarang");

                                    barang = new Barang(idBarang, namaBarang, harga,stock,deskripsi,kategori,gambarBarang);
                                    barangArrayList.add(barang);
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
                Toast.makeText(BarangActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

}