package com.example.test;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignIn extends AppCompatActivity {

    EditText log_email, log_pass;
    Button log_button;
    TextView log_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        log_email = findViewById(R.id.log_email);
        log_pass = findViewById(R.id.log_pass);
        log_button = findViewById(R.id.log_button);
        log_reg = findViewById(R.id.log_reg);

     log_reg.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(SignIn.this, SignUp.class);
             startActivity(intent);
         }
     });
    }
}