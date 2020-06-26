package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class loginpage extends AppCompatActivity {
    Button loginbtn;
    EditText usernameET;
    EditText pswrdET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        loginbtn=(Button)findViewById(R.id.loginbtn);
        usernameET=(EditText)findViewById(R.id.usernameET);
        pswrdET=(EditText)findViewById(R.id.passwordET);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login=new Intent(loginpage.this,MainActivity.class);
                startActivity(login);
            }
        });
    }
}