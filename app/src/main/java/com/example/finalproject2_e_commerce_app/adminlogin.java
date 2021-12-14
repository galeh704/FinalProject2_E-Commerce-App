package com.example.finalproject2_e_commerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class adminlogin extends AppCompatActivity {

    private EditText admin_username,admin_password;
    private Button bt_adminlogin;

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
                //Nanti masukin disini login cek staff terus masuk ke menu tambah barang dan edit barang
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
}