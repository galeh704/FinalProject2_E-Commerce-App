package com.example.finalproject2_e_commerce_app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class AddBarangActivity extends AppCompatActivity {
    EditText et_nama,et_kategori,et_harga,et_stock,et_deskripsi;
    Button btn_save,btn_select;
    ImageView img_barang;
    Bitmap bitmap;
    String encodedImage;

    AutoCompleteTextView autoCompleteTextView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_barang);
        et_nama = findViewById(R.id.et_namaP);
        et_deskripsi = findViewById(R.id.et_deskripsi);
        et_harga = findViewById(R.id.et_hargaP);
        et_stock = findViewById(R.id.et_stockP);
        et_kategori = findViewById(R.id.et_kategoriP);
        btn_save = findViewById(R.id.btn_save);
        btn_select = findViewById(R.id.btn_select);
        img_barang = findViewById(R.id.img_barang);







        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
                startActivity(new Intent(AddBarangActivity.this, ProductActivity.class));
            }
        });
        btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dexter.withActivity(AddBarangActivity.this)
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {

                                Intent intent = new Intent(Intent.ACTION_PICK);
                                intent.setType("image/*");
                                startActivityForResult(Intent.createChooser(intent, "Select Image"), 1);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                permissionToken.continuePermissionRequest();
                            }
                        }).check();
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Uri filePath = data.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(filePath);
                bitmap = BitmapFactory.decodeStream(inputStream);
                img_barang.setImageBitmap(bitmap);

                imageStore(bitmap);

            } catch (FileNotFoundException e) {

                e.printStackTrace();
            }


        }


        super.onActivityResult(requestCode, resultCode, data);
    }
    private void imageStore(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);

        byte[] imageBytes = stream.toByteArray();

        encodedImage = android.util.Base64.encodeToString(imageBytes, Base64.DEFAULT);


    }
    private void insertData(){
        String namaP = et_nama.getText().toString().trim();
        String kategori = et_kategori.getText().toString().trim();
        String harga = et_harga.getText().toString().trim();
        String stock = et_stock.getText().toString().trim();
        String deskripsi = et_deskripsi.getText().toString().trim();


        img_barang.setImageBitmap(bitmap);



            StringRequest request = new StringRequest(Request.Method.POST, "https://vacillating-feedbac.000webhostapp.com/insertProduct.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if(response.equalsIgnoreCase("data masuk")){
                                Toast.makeText(AddBarangActivity.this, "data masuk", Toast.LENGTH_SHORT).show();
                            } else{
                                Toast.makeText(AddBarangActivity.this, response, Toast.LENGTH_SHORT).show();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(AddBarangActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("namaProduct", namaP);
                    params.put("harga", harga);
                    params.put("stock", stock);
                    params.put("deskripsi", deskripsi);
                    params.put("kategori", kategori);
                    params.put("gambarProduct", encodedImage);



                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(AddBarangActivity.this);
            requestQueue.add(request);
        }
    }
