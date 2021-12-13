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

public class signup extends AppCompatActivity {

    private EditText signup_username,signup_fullname,signup_number,signup_password;
    private Button bt_signup;

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

                //Sign up data ke database nanti disini

                Intent signup = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(signup);
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

//            if(!signupusernamestr.isEmpty()){
//                if(!signupfullnamestr.isEmpty()){
//                    if(!signupnumberstr.isEmpty()){
//                        if(!signuppasswordstr.isEmpty()){
//                            int duration = Toast.LENGTH_SHORT;
//                            Toast toast = Toast.makeText(getApplicationContext(),"bisa",duration);
//                            toast.show();
////                            bt_signup.setEnabled(true);
//                        }
//                    }
//                }
//            }
//            int duration = Toast.LENGTH_SHORT;
//            Toast toaster = Toast.makeText(getApplicationContext(),"ganti",duration);
//            toaster.show();
//
//            Boolean compare1 = !signupusernamestr.isEmpty() && !signupfullnamestr.isEmpty();
//            Boolean compare2 = !signupnumberstr.isEmpty() && !signuppasswordstr.isEmpty();
//            if(compare1 && compare2){
//
//                Toast toast = Toast.makeText(getApplicationContext(),"bisa",duration);
//                toast.show();
//            }
//            bt_signup.setEnabled(compare1 && compare2);

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}
