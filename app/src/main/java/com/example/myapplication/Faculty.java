package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Faculty extends AppCompatActivity {
    Button Facultyprevbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        Facultyprevbutton=(Button)findViewById(R.id.Facultyprevbutton);

        Facultyprevbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Facultyprev=new Intent(Faculty.this,Seminar_hall.class);
                startActivity(Facultyprev);
            }
        });



    }
}