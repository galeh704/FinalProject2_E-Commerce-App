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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
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

public class EditStaffActivity extends AppCompatActivity {
    EditText et_nama, et_email, et_kontak,et_password,et_jabatan,et_id;
    Button btn_save,btn_select,btn_edit;
    ImageView img_staff;
    Bitmap bitmap;
    String encodedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_staff);
        et_id= findViewById(R.id.et_idS);
        et_nama = findViewById(R.id.et_namaS);
        et_email = findViewById(R.id.et_emailS);
        et_jabatan = findViewById(R.id.et_jabatanS);
        et_kontak = findViewById(R.id.et_kontakS);
        et_password = findViewById(R.id.et_passwordS);
        btn_save = findViewById(R.id.btn_save);
        btn_select = findViewById(R.id.btn_select);
        img_staff = findViewById(R.id.img_staff);
        btn_edit = findViewById(R.id.btn_edit);


        Intent intent = getIntent();

       //int  position = intent.getExtras().getInt("position");
       //et_id.setText(StaffActivity.staffArrayList.get(position).getIdStaff());
       // et_nama.setText(StaffActivity.staffArrayList.get(position).getNamaStaff());
        //et_jabatan.setText(StaffActivity.staffArrayList.get(position).getJabatan());
       // et_email.setText(StaffActivity.staffArrayList.get(position).getEmail());
       // et_password.setText(StaffActivity.staffArrayList.get(position).getPassword());
       // et_kontak.setText(StaffActivity.staffArrayList.get(position).getKontak());

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
                startActivity(new Intent(EditStaffActivity.this, StaffActivity.class));
            }
        });
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateData();
                startActivity(new Intent(EditStaffActivity.this, StaffActivity.class));
            }
        });
        btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dexter.withActivity(EditStaffActivity.this)
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
                img_staff.setImageBitmap(bitmap);

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
        String namaStaff = et_nama.getText().toString().trim();
        String jabatan = et_jabatan.getText().toString().trim();
        String email = et_email.getText().toString().trim();
        String password = et_password.getText().toString().trim();
        String kontak = et_kontak.getText().toString().trim();
        img_staff.setImageBitmap(bitmap);

        if(namaStaff.isEmpty()){
            Toast.makeText(this,"Masukkan nama", Toast.LENGTH_SHORT).show();
        }
        else if(jabatan.isEmpty()){
            Toast.makeText(this,"Masukkan nim", Toast.LENGTH_SHORT).show();
        }
        else if(email.isEmpty()){
            Toast.makeText(this,"Masukkan jurusan", Toast.LENGTH_SHORT).show();
        }
        else if(password.isEmpty()){
            Toast.makeText(this,"Masukkan alamat", Toast.LENGTH_SHORT).show();
        }
        else if(kontak.isEmpty()){
            Toast.makeText(this,"Masukkan kontak", Toast.LENGTH_SHORT).show();
        }
        else{
            StringRequest request = new StringRequest(Request.Method.POST, "https://vacillating-feedbac.000webhostapp.com/staff/insert.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if(response.equalsIgnoreCase("data masuk")){
                                Toast.makeText(EditStaffActivity.this, "data masuk", Toast.LENGTH_SHORT).show();
                            } else{
                                Toast.makeText(EditStaffActivity.this, response, Toast.LENGTH_SHORT).show();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(EditStaffActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("namaStaff", namaStaff);
                    params.put("jabatan", jabatan);
                    params.put("email", email);
                    params.put("password", password);
                    params.put("kontak", kontak);
                    params.put("gambar", encodedImage);


                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(EditStaffActivity.this);
            requestQueue.add(request);
        }
    }
    private void updateData(){
        String idStaff = et_id.getText().toString().trim();
        String namaStaff = et_nama.getText().toString().trim();
        String jabatan = et_jabatan.getText().toString().trim();
        String email = et_email.getText().toString().trim();
        String password = et_password.getText().toString().trim();
        String kontak = et_kontak.getText().toString().trim();
        img_staff.setImageBitmap(bitmap);

        StringRequest request = new StringRequest(Request.Method.POST, "https://vacillating-feedbac.000webhostapp.com/staff/update.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(EditStaffActivity.this, response, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),StaffActivity.class));
                        finish();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(EditStaffActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("idStaff", idStaff);
                params.put("namaStaff", namaStaff);
                params.put("jabatan", jabatan);
                params.put("email", email);
                params.put("password", password);
                params.put("kontak", kontak);
                params.put("gambar", encodedImage);


                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(EditStaffActivity.this);
        requestQueue.add(request);
    }

    }

