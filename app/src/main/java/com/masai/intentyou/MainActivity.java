package com.masai.intentyou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mEtUsername;
    private EditText mEtEmail;
    private EditText mEtPassword;
    private Button mBtnLogin;
    private String emailValidation ="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isEmail()&&isPassword()&&isUserName()){
                    Intent intent = new Intent(MainActivity.this,HomeScreen.class);
                    intent.putExtra("Username",mEtUsername.getText().toString());
                    startActivity(intent);
                }

            }
        });
    }

    private void initView() {
        mEtEmail =findViewById(R.id.etEmail);
        mEtPassword=findViewById(R.id.etPassword);
        mEtUsername = findViewById(R.id.etUsername);
        mBtnLogin = findViewById(R.id.btnLogIn);
    }


    private boolean isEmail(){
        if(mEtEmail.getText().toString().matches(emailValidation)&&mEtEmail.getText().toString().length()>1){
            return true;
        }
        else{
            mEtEmail.setError("Email is invalid");
            return false;
        }
    }
    private boolean isPassword(){
        if(mEtPassword.getText().toString().length()>=6){
            return  true;
        }
        else{
            mEtPassword.setError("Password should be atleast 6 characters");
            return false;
        }
    }
    private  boolean isUserName(){
        if(mEtUsername.getText().toString().trim().length()>=4){
            return  true;

        }
        else{
            mEtUsername.setError("Invalid Username");
            return false;
        }
    }


}