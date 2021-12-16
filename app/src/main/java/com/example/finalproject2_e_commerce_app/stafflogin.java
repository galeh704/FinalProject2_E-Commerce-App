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

public class stafflogin extends AppCompatActivity {

    private EditText staff_username,staff_password;
    private Button bt_stafflogin;
    private String username,password;
    private String url = "https://vacillating-feedbac.000webhostapp.com/staff/stafflogin.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stafflogin);

        staff_username = findViewById(R.id.editText_staff_username);
        staff_password = findViewById(R.id.editText_staff_password);

        bt_stafflogin = findViewById(R.id.button_stafflogin);
        bt_stafflogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                staffloginfunc();
            }
        });

        staff_username.addTextChangedListener(staffTextWatcher);
        staff_password.addTextChangedListener(staffTextWatcher);

    }

    private TextWatcher staffTextWatcher = new TextWatcher(){

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            String staffusernamestr = staff_username.getText().toString().trim();
            String staffpasswordstr = staff_password.getText().toString().trim();

            bt_stafflogin.setEnabled(!staffusernamestr.isEmpty() && !staffpasswordstr.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public void staffloginfunc(){
        username = staff_username.getText().toString().trim();
        password = staff_password.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("res", response);
                if (response.equals("success")) {
                    Intent intent = new Intent(getApplicationContext(), successfullogin.class); //ganti ke activity home nanti disini
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