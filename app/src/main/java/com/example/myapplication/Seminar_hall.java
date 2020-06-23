package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Seminar_hall extends AppCompatActivity {
    Button SHnxtbtn;
    Button SHprevbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seminar_hall);
        SHnxtbtn=(Button)findViewById(R.id.SHnextButton);
        SHprevbtn=(Button)findViewById(R.id.SHprevbutton);

        SHprevbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SHprev=new Intent(Seminar_hall.this,MainActivity.class);
                startActivity(SHprev);
            }
        });
        SHnxtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SHnext=new Intent(Seminar_hall.this,Faculty.class);
                startActivity(SHnext);
            }
        });
    }
}