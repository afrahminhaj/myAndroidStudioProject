package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Seminar_hallpg2 extends AppCompatActivity {
    Button SHBbtn;
    FloatingActionButton Add3FAB;
    LinearLayout SHBlinearlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seminar_hallpg2);
        SHBbtn=(Button)findViewById(R.id.SHBbtn) ;
        Add3FAB=(FloatingActionButton)findViewById(R.id.Add3FAB);
        SHBlinearlayout=(LinearLayout)findViewById(R.id.SHBlinearlayout);

        Add3FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SHadd("HALL_NAME","NA","NA","BOOK","BOOK","BOOK");
            }
        });
        SHBbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SHBback=new Intent(Seminar_hallpg2.this,Seminar_hall.class);
                startActivity(SHBback);
            }
        });
    }

    public void SHadd(String Hallname,String fst,String scnd,String thrd,String fourth,String fifth){
        Space space2= new Space(this);
        Space space3=new Space(this);
        Space space4=new Space(this);
        Space space5=new Space(this);
        Space space6=new Space(this);
        Space space7=new Space(this);

        LinearLayout eachhall= new LinearLayout(this);
        //eachlab.setBackgroundColor(Color.GRAY);
        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0,0,0,37);
        TextView hall=new TextView(this);
        hall.setTextSize(15);
        hall.setPadding(10,0,10,0);
        TextView hr1=new TextView(this);
        hr1.setBackground(getResources().getDrawable(R.drawable.redbtn));
        TextView hr2=new TextView(this);
        hr2.setBackground(getResources().getDrawable(R.drawable.redbtn));
        TextView hr3=new TextView(this);
        hr3.setBackground(getResources().getDrawable(R.drawable.greenbtn));
        TextView hr4=new TextView(this);
        hr4.setBackground(getResources().getDrawable(R.drawable.greenbtn));
        TextView hr5=new TextView(this);
        hr5.setBackground(getResources().getDrawable(R.drawable.greenbtn));
        hall.setText(Hallname);
        hr1.setText(fst);
        hr2.setText(scnd);
        hr3.setText(thrd);
        hr4.setText(fourth);
        hr5.setText(fifth);
        hall.setPadding(10,5,5,10);
        hr1.setPadding(25,5,25,8);
        hr2.setPadding(25,5,25,8);
        hr3.setPadding(25,5,25,8);
        hr4.setPadding(25,5,25,8);
        hr5.setPadding(25,5,25,8);

        eachhall.addView(hall);
        eachhall.addView(space2,3,2);
        eachhall.addView(hr1);
        eachhall.addView(space3,11,2);
        eachhall.addView(hr2);
        eachhall.addView(space4,11,2);
        eachhall.addView(hr3);
        eachhall.addView(space5,11,2);
        eachhall.addView(hr4);
        eachhall.addView(space6,11,2);
        eachhall.addView(hr5);
        SHBlinearlayout.addView(eachhall,layoutParams);}

    }