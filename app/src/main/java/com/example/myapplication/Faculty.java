package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Faculty extends AppCompatActivity {
    Button Facultyprevbutton;
    FloatingActionButton Add2FAB;
    LinearLayout FacultyLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        Facultyprevbutton=(Button)findViewById(R.id.Facultyprevbutton);
        Add2FAB=(FloatingActionButton)findViewById(R.id.Add2FAB);
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
                add2("Faculty name","Current hour");
            }
        });

    }

    public void add2(String faculty_name, String current_hour) {
        Space space = new Space(this);
        Space s2=new Space(this);
        LinearLayout eachfaculty=new LinearLayout(this);
        TextView Fname=new TextView(this);
        TextView Av=new TextView(this);
        Fname.setText(faculty_name);
        Fname.setTextSize(20);
        Av.setText(current_hour);
        eachfaculty.addView(Fname);
        eachfaculty.addView(space,100,10);
        eachfaculty.addView(Av);
        FacultyLinearLayout.addView(eachfaculty);
        FacultyLinearLayout.addView(s2,10,50);



    }
}