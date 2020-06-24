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
        firstrow();

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

                add("Lab","NA","NA","BOOK","BOOK","BOOK");
                //LinearLayout eachlab=new LinearLayout(this);
                //eachlab.setOrientation(LinearLayout.VERTICAL);




            }
        });



    }
    public void firstrow(){
        LinearLayout first_row=new LinearLayout(this);
        TextView col1=new TextView(this);
        TextView col2=new TextView(this);
        TextView col3=new TextView(this);
        TextView col4=new TextView(this);
        TextView col5=new TextView(this);
        TextView col6=new TextView(this);
        col1.setText("LAB");
        col2.setText("I");
        col3.setText("II");
        col4.setText("III");
        col5.setText("IV");
        col6.setText("V");
        col1.setPadding(50,5,50,5);
        col2.setPadding(50,5,50,5);
        col3.setPadding(50,5,50,5);
        col4.setPadding(50,5,50,5);
        col5.setPadding(50,5,50,5);
        col6.setPadding(50,5,50,5);
        first_row.addView(col1);
        first_row.addView(col2);
        first_row.addView(col3);
        first_row.addView(col4);
        first_row.addView(col5);
        first_row.addView(col6);
        LabsLinearLayout.addView(first_row);




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
        hr1.setBackground(getResources().getDrawable(R.drawable.redbtn));
        TextView hr2=new TextView(this);
        hr2.setBackground(getResources().getDrawable(R.drawable.redbtn));
        TextView hr3=new TextView(this);
        hr3.setBackground(getResources().getDrawable(R.drawable.greenbtn));
        TextView hr4=new TextView(this);
        hr4.setBackground(getResources().getDrawable(R.drawable.greenbtn));
        TextView hr5=new TextView(this);
        hr5.setBackground(getResources().getDrawable(R.drawable.greenbtn));
        Labs.setText(labname);
        hr1.setText(st1);
        hr2.setText(st2);
        hr3.setText(st3);
        hr4.setText(st4);
        hr5.setText(st5);
        Labs.setPadding(30,5,30,8);
        hr1.setPadding(30,5,30,8);
        hr2.setPadding(30,5,30,8);
        hr3.setPadding(30,5,30,8);
        hr4.setPadding(30,5,30,8);
        hr5.setPadding(30,5,30,8);
        //Labs.setBackground(getResources().getDrawable(R.drawable.cutom_layout));
        //Labs.setBackground(getResources().getDrawable(R.drawable.cutom_layout));
        //hr1.setBackground(getResources().getDrawable(R.drawable.cutom_layout));
        //hr2.setBackground(getResources().getDrawable(R.drawable.cutom_layout));
        //hr3.setBackground(getResources().getDrawable(R.drawable.cutom_layout));
        //hr4.setBackground(getResources().getDrawable(R.drawable.cutom_layout));
        //hr5.setBackground(getResources().getDrawable(R.drawable.cutom_layout));

        eachlab.addView(Labs);
        eachlab.addView(hr1);
        eachlab.addView(hr2);
        eachlab.addView(hr3);
        eachlab.addView(hr4);
        eachlab.addView(hr5);
        LabsLinearLayout.addView(eachlab,layoutParams);





    }

}