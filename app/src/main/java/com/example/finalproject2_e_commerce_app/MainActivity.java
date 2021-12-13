package com.example.finalproject2_e_commerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    private EditText et_username,et_password;
    private Button bt_login;
    private TextView createacc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_username=findViewById(R.id.editText_login_username);
        et_password=findViewById(R.id.editText_login_password);

        createacc=findViewById(R.id.textView_createaccount);
        createacc.setOnClickListener(this);

        bt_login=findViewById(R.id.button_login);
        bt_login.setOnClickListener(this);

        et_username.addTextChangedListener(loginTextWatcher);
        et_password.addTextChangedListener(loginTextWatcher);
    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String usernameInput = et_username.getText().toString().trim();
            String passwordInput = et_password.getText().toString().trim();

            bt_login.setEnabled(!usernameInput.isEmpty() && !passwordInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_login:
                //Masukin cek username id ke database nanti disini
                //Ganti jadi intent ke class home page
                Intent login = new Intent(getApplicationContext(),signup.class);
                startActivity(login);

                break;
            case R.id.textView_createaccount:
                Intent createacc = new Intent(getApplicationContext(),signup.class);
                startActivity(createacc);

                break;
        }

    }
}