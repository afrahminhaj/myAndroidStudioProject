package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    LinearLayout LabsLinearLayout;
    FloatingActionButton AddFAB;
    Button Labsnextbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LabsLinearLayout=(LinearLayout)findViewById(R.id.LabsLinearLayout);
        AddFAB=(FloatingActionButton)findViewById(R.id.AddFAB);
        Labsnextbutton=(Button)findViewById(R.id.LabsnextButton) ;

        Labsnextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent labnext=new Intent(MainActivity.this,Seminar_hall.class);
                startActivity(labnext);
            }
        });



        AddFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add("Lab","s","s","s","s","s");
                //LinearLayout eachlab=new LinearLayout(this);
                //eachlab.setOrientation(LinearLayout.VERTICAL);




            }
        });



    }
    public void add(String labname,String st1,String st2,String st3,String st4,String st5){
        LinearLayout eachlab= new LinearLayout(this);
        //eachlab.setBackgroundColor(Color.GRAY);
        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0,30,0,0);
        TextView Labs=new TextView(this);
        Labs.setTextSize(20);
        Labs.setPadding(10,0,10,0);
        TextView hr1=new TextView(this);
        TextView hr2=new TextView(this);
        TextView hr3=new TextView(this);
        TextView hr4=new TextView(this);
        TextView hr5=new TextView(this);
        Labs.setText(labname);
        hr1.setText(st1);
        hr2.setText(st2);
        hr3.setText(st3);
        hr4.setText(st4);
        hr5.setText(st5);
        hr1.setPadding(30,5,30,5);
        hr2.setPadding(30,5,30,5);
        hr3.setPadding(30,5,30,5);
        hr4.setPadding(30,5,30,5);
        hr5.setPadding(30,5,30,5);
        //Labs.setBackground(getResources().getDrawable(R.drawable.cutom_layout));
        Labs.setBackground(getResources().getDrawable(R.drawable.cutom_layout));
        hr1.setBackground(getResources().getDrawable(R.drawable.cutom_layout));
        hr2.setBackground(getResources().getDrawable(R.drawable.cutom_layout));
        hr3.setBackground(getResources().getDrawable(R.drawable.cutom_layout));
        hr4.setBackground(getResources().getDrawable(R.drawable.cutom_layout));
        hr5.setBackground(getResources().getDrawable(R.drawable.cutom_layout));

        eachlab.addView(Labs);
        eachlab.addView(hr1);
        eachlab.addView(hr2);
        eachlab.addView(hr3);
        eachlab.addView(hr4);
        eachlab.addView(hr5);
        LabsLinearLayout.addView(eachlab,layoutParams);





    }

}