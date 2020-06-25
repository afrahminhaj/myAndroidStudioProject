package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Seminar_hall extends AppCompatActivity {
    Button SHnxtbtn;
    Button SHprevbtn;
    private Spinner spinner;
    private EditText seminar;
    private EditText purpose;
    Button buttonConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seminar_hall);

        seminar = (EditText) findViewById(R.id.Semname);
        purpose = (EditText) findViewById(R.id.purpose);
        buttonConfirm = (Button) findViewById(R.id.submit);

        seminar.addTextChangedListener(loginTextWatcher);
        purpose.addTextChangedListener(loginTextWatcher);

        spinner =findViewById(R.id.spinner);

        List<String> clubs = new ArrayList<>();
        clubs.add(0,"CHOOSE THE CLUB");
        clubs.add("COSC");
        clubs.add("IEEE");
        clubs.add("Chaitanya Smruthi");
        clubs.add("Sports");
        clubs.add("Street Cause");
        clubs.add("Litratri");

        //style and populate the spinner
        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, clubs);

        //dropdown layout style
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getItemAtPosition(position).equals("CHOOSE THE CLUB"))
                {
                    //do nothing
                }
                else
                {
                    //on selecting a spinner item
                    String item = parent.getItemAtPosition(position).toString();
                    //show selected spinner item
                    Toast.makeText(parent.getContext(),"Selected: "+item, Toast.LENGTH_SHORT).show();


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //todo Auto-generated method stub

            }
        });


        SHnxtbtn=(Button)findViewById(R.id.SHnextButton);
        SHprevbtn=(Button)findViewById(R.id.SHprevbutton);

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendrequest=new Intent(Seminar_hall.this,Seminar_hallpg2.class);
                startActivity(sendrequest);
            }
        });

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
    
     private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String hallinput = seminar.getText().toString();
            String purposeinput = purpose.getText().toString();

            buttonConfirm.setEnabled(!hallinput.isEmpty() && !purposeinput.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
