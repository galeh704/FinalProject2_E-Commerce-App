package com.example.finalproject2_e_commerce_app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
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
import com.example.finalproject2_e_commerce_app.list.Staff;
import com.example.finalproject2_e_commerce_app.utils.StaffAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaffActivity extends AppCompatActivity {

    ListView list_staff;
    ImageView back_btn;
    FloatingActionButton fb_staff;
    StaffAdapter adapter;
    public  static ArrayList<Staff> staffArrayList = new ArrayList<>();
    Staff staff;
    String url = "https://vacillating-feedbac.000webhostapp.com/staff/read.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);
        back_btn = findViewById(R.id.back_btn);
        fb_staff = findViewById(R.id.fb_staff);
        list_staff = findViewById(R.id.list_staff);
        adapter = new StaffAdapter(this, staffArrayList);
        list_staff.setAdapter(adapter);

        list_staff.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                ProgressDialog progressDialog = new ProgressDialog(view.getContext());

                CharSequence[] dialogItem = {"View Data","Delete Data"};
                builder.setTitle(staffArrayList.get(position).getNamaStaff());
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                        switch (i){
                            case 0:
                                startActivity(new Intent(getApplicationContext(),EditStaffActivity.class).putExtra("position",position));
                                break;
                            case 1:
                                deleteData(staffArrayList.get(position).getIdStaff());
                                
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
                Intent goBack = new Intent(StaffActivity.this, MenuAdminActivity.class);
                startActivity(goBack);
                finish();
            }
        });

        fb_staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goEdit = new Intent(StaffActivity.this, AddStaffActivity.class);
                startActivity(goEdit);

            }
        });


    }

    private void retrieveData() {

        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        staffArrayList.clear();
                        try {

                            JSONObject jsonObject = new JSONObject(response);
                            String sucess = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("staff");

                            if (sucess.equals("1")) {

                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String idStaff = object.getString("idStaff");
                                    String namaStaff = object.getString("namaStaff");
                                    String jabatan = object.getString("jabatan");
                                    String email = object.getString("email");
                                    String password = object.getString("password");
                                    String kontak = object.getString("kontak");
                                    String gambar = object.getString("gambar");


                                    String url2 = "https://vacillating-feedbac.000webhostapp.com/staff/Images/" + gambar;

                                    staff = new Staff(idStaff, namaStaff, jabatan, email, password, kontak,url2);
                                    staffArrayList.add(staff);
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
                Toast.makeText(StaffActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    private void deleteData(String id){
    StringRequest request = new StringRequest(Request.Method.POST, "https://vacillating-feedbac.000webhostapp.com/staff/delete.php",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if(response.equalsIgnoreCase("data terhapus")){
                        Toast.makeText(StaffActivity.this, "Data suskes terhapus", Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(StaffActivity.this, "Data gagal terhapus", Toast.LENGTH_SHORT).show();
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
            params.put("idStaff", id);

            return params;
        }

    };
        RequestQueue requestQueue = Volley.newRequestQueue(StaffActivity.this);
        requestQueue.add(request);

    }


}
