package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp extends AppCompatActivity {
EditText reg_email, reg_pass,reg_firstName,reg_lastName;
TextView reg_logg;
Button reg_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        reg_email = findViewById(R.id.reg_email);
        reg_pass = findViewById(R.id.reg_pass);
        reg_button = findViewById(R.id.reg_button);
        reg_firstName = findViewById(R.id.reg_firstName);
        reg_lastName = findViewById(R.id.reg_lastName);
        reg_logg = findViewById(R.id.reg_logg);

        reg_logg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, SignIn.class);
                startActivity(intent);
            }
        });

        reg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(reg_email.getText().toString())
                        ||TextUtils.isEmpty(reg_pass.getText().toString())
                        ||TextUtils.isEmpty(reg_firstName.getText().toString())
                        ||TextUtils.isEmpty(reg_lastName.getText().toString())){
                    String message = "Заполните все поля";
                    Toast.makeText(SignUp.this, message,Toast.LENGTH_LONG).show();
                }
                else {


                }

            }
        });
        public void registerUser(){
            RegisterRequest registerRequest = new RegisterRequest();
            registerRequest.setEmail(reg_email.getText().toString());
            registerRequest.setPassword(reg_pass.getText().toString());
            registerRequest.setFirstName(reg_firstName.getText().toString());
            registerRequest.setLastName(reg_lastName.getText().toString());
            Call<RegisterResponse> registerResponseCall = ApiClient.getRegister().registerUser(registerRequest);
            registerResponseCall.enqueue(new Callback<RegisterResponse>() {
                @Override
                public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                    if (response.isSuccessful()){
                        String message = "Все ок...";
                        Toast.makeText(SignUp.this, message, Toast.LENGTH_LONG).show();

                        finish();
                    }else {

                        String message = "Что-то пошло не так";
                        Toast.makeText(SignUp.this, response.errorBody().toString(), Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<RegisterResponse> call, Throwable t) {
                    String message = "Регистрация прошла умпешно";
                    Toast.makeText(SignUp.this, message, Toast.LENGTH_LONG).show();
                    startActivity(new Intent(SignUp.this,SignIn.class));

                }
            });

    }

}