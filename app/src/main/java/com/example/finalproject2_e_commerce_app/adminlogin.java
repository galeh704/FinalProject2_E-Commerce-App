package com.example.finalproject2_e_commerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class adminlogin extends AppCompatActivity {

    private EditText admin_username,admin_password;
    private Button bt_adminlogin;
    private String username,password;
    private final String url = "https://vacillating-feedbac.000webhostapp.com/user/adminlogin.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        admin_username = findViewById(R.id.editText_admin_username);
        admin_password = findViewById(R.id.editText_admin_password);

        bt_adminlogin = findViewById(R.id.button_adminlogin);
        bt_adminlogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                adminloginfunc();
            }
        });

        admin_username.addTextChangedListener(adminTextWatcher);
        admin_password.addTextChangedListener(adminTextWatcher);
    }

    private TextWatcher adminTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String adminusernamestr = admin_username.getText().toString().trim();
            String adminpasswordstr = admin_password.getText().toString().trim();

            bt_adminlogin.setEnabled(!adminusernamestr.isEmpty() && !adminpasswordstr.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public void adminloginfunc(){
        username = admin_username.getText().toString().trim();
        password = admin_password.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("res", response);
                if (response.equals("success")) {
                    Intent intent = new Intent(getApplicationContext(), MenuAdminActivity.class);
                    startActivity(intent);
                    finish();
                } else if (response.equals("failure")) {
                    Toast.makeText(getApplicationContext(), "Invalid Login Id/Password", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> data = new HashMap<>();
                data.put("email", username);
                data.put("password", password);
                return data;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);

    }
}