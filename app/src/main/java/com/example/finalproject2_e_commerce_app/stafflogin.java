package com.example.finalproject2_e_commerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class stafflogin extends AppCompatActivity {

    private EditText staff_username,staff_password;
    private Button bt_stafflogin;

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
                //Cek data staff ke database nanti disini

                Intent stafflogint = new Intent(getApplicationContext(),successfullogin.class);
                startActivity(stafflogint);
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
}