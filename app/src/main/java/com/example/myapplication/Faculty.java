package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Faculty extends AppCompatActivity {
    Button Facultyprevbutton;
    Button Add2FAB;
    LinearLayout FacultyLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        Facultyprevbutton=(Button)findViewById(R.id.Facultyprevbutton);
        Add2FAB=(Button)findViewById(R.id.Add2FAB);
        FacultyLinearLayout=(LinearLayout)findViewById(R.id.FacultyLinearLayout) ;

        Facultyprevbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Facultyprev=new Intent(Faculty.this,Seminar_hall.class);
                startActivity(Facultyprev);
            }
        });

        Add2FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add2("Faculty name","A/NA");
            }
        });

    }

    public void add2(String faculty_name, String av) {
        LinearLayout eachfaculty=new LinearLayout(this);
        eachfaculty.setBackgroundColor(Color.GRAY);
        TextView Fname=new TextView(this);
        TextView Av=new TextView(this);
        Fname.setText(faculty_name);
        Fname.setTextSize(20);
        Av.setText(av);
        eachfaculty.addView(Fname);
        eachfaculty.addView(Av);
        FacultyLinearLayout.addView(eachfaculty);



    }
}