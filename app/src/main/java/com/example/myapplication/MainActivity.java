package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    LinearLayout LabsLinearLayout;
    FloatingActionButton AddFAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LabsLinearLayout=(LinearLayout)findViewById(R.id.LabsLinearLayout);
        AddFAB=(FloatingActionButton)findViewById(R.id.AddFAB);



        AddFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add("Lab","status","status","status","status","status");
                //LinearLayout eachlab=new LinearLayout(this);
                //eachlab.setOrientation(LinearLayout.VERTICAL);




            }
        });



    }
    public void add(String labname,String st1,String st2,String st3,String st4,String st5){
        LinearLayout eachlab= new LinearLayout(this);
        eachlab.setOrientation(LinearLayout.VERTICAL);
        eachlab.setBackgroundColor(Color.GRAY);
        TextView Labs=new TextView(this);
        Labs.setTextSize(20);
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
        eachlab.addView(Labs);
        eachlab.addView(hr1);
        eachlab.addView(hr2);
        eachlab.addView(hr3);
        eachlab.addView(hr4);
        eachlab.addView(hr5);
        LabsLinearLayout.addView(eachlab);





    }

}