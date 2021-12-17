package com.example.finalproject2_e_commerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

public class signup extends AppCompatActivity {

    private EditText signup_username,signup_fullname,signup_number,signup_password;
    private Button bt_signup;
    private String username,fullname,number,password;
    private String url = "https://vacillating-feedbac.000webhostapp.com/user/register.php";

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signup_username = findViewById(R.id.editText_signup_username);
        signup_fullname = findViewById(R.id.editText_signup_fullname);
        signup_number = findViewById(R.id.editText_signup_mobilenumber);
        signup_password = findViewById(R.id.editText_signup_password);


        bt_signup = findViewById(R.id.button_signup);
        bt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup();
            }
        });

        signup_username.addTextChangedListener(signupTextWatcher);
        signup_fullname.addTextChangedListener(signupTextWatcher);
        signup_number.addTextChangedListener(signupTextWatcher);
        signup_password.addTextChangedListener(signupTextWatcher);

    }

    private TextWatcher signupTextWatcher = new TextWatcher(){
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String signupusernamestr = signup_username.getText().toString().trim();
            String signupfullnamestr = signup_fullname.getText().toString().trim();
            String signupnumberstr = signup_number.getText().toString().trim();
            String signuppasswordstr = signup_password.getText().toString().trim();

            bt_signup.setEnabled(!signupusernamestr.isEmpty() && (!signupfullnamestr.isEmpty() && (!signupnumberstr.isEmpty() && !signuppasswordstr.isEmpty())));

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public void signup() {
        username = signup_username.getText().toString().trim();
        fullname = signup_fullname.getText().toString().trim();
        password = signup_password.getText().toString().trim();
        number = signup_number.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("success")) {
                    Toast.makeText(getApplicationContext(), "Successfully registered.", Toast.LENGTH_SHORT).show();
                    Intent signup = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(signup);
                } else if (response.equals("failure")) {
                    Toast.makeText(getApplicationContext(), "Something Went Wrong.", Toast.LENGTH_SHORT).show();                  }
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
                data.put("username", username);
                data.put("fullname", fullname);
                data.put("number", number);
                data.put("password", password);
                return data;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }
}
