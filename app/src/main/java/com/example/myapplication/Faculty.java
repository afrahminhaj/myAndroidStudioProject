package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.example.myapplication.loginpage.access_tkn;

public class Faculty extends AppCompatActivity {
    Button Fetchdetailsbtn;
    RequestQueue queueC;
    JsonArrayRequest FacultyDetailsRequest;
    BottomNavigationView bnv;
    LinearLayout FLL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        queueC = Volley.newRequestQueue(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        FLL=(LinearLayout)findViewById(R.id.facultylinearlayout);

        Fetchdetailsbtn = (Button) findViewById(R.id.Fetch_detailsbtn);

        bnv=(BottomNavigationView)findViewById(R.id.bnv);
        bnv.setSelectedItemId(R.id.LabsNav);

        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.LabsNav:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.SemNav:
                        startActivity(new Intent(getApplicationContext(),seminar_hall2.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.FacultyNav:
                        return true;

                }
                return false;
            }
        });
        codeAPI();






        Fetchdetailsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String URL4 = "https://internship-team-2.herokuapp.com/getroom";

                FacultyDetailsRequest = new JsonArrayRequest(Request.Method.GET,
                        URL4,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                int len=response.length();
                                for(int i=0;i<len;i++){
                                    try {
                                        add(response.getJSONObject(i).getString("fac_name"),
                                                response.getJSONObject(i).getString("faculty_id"),
                                                response.getJSONObject(i).getString("current_hour"));
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast toast = Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG);
                                toast.show();


                            }
                        }) {
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("Authorization", "Bearer " + access_tkn);
                        return params;
                    }
                   /* @Override
                    public Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<>();
                        params.put("fac_name", facname);
                        return params;
                    }*/

                };
                queueC.add(FacultyDetailsRequest);


            }
        });
    }
    public void codeAPI(){

        String URL4 = "https://internship-team-2.herokuapp.com/getroom";

        FacultyDetailsRequest = new JsonArrayRequest(Request.Method.GET,
                URL4,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        int len=response.length();
                        for(int i=0;i<len;i++){
                            try {
                                add(response.getJSONObject(i).getString("fac_name"),
                                        response.getJSONObject(i).getString("faculty_id"),
                                        response.getJSONObject(i).getString("current_hour"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast toast = Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG);
                        toast.show();


                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", "Bearer " + access_tkn);
                return params;
            }
                   /* @Override
                    public Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<>();
                        params.put("fac_name", facname);
                        return params;
                    }*/

        };
        queueC.add(FacultyDetailsRequest);

    }
    private void add(String facname,String facid,String crnt_hr) {
        Space space2= new Space(this);
        Space space3=new Space(this);
        Space space4=new Space(this);
        Space space5=new Space(this);
        LinearLayout eachdetail= new LinearLayout(this);
        TextView name=new TextView(this);
        TextView id=new TextView(this);
        TextView hour=new TextView(this);
        name.setText(facname);
        id.setText(facid);
        hour.setText(crnt_hr);
        name.setTextSize(27);
        id.setTextSize(27);
        hour.setTextSize(27);
        eachdetail.addView(name);
        eachdetail.addView(space2,32,2);
        eachdetail.addView(id);
        eachdetail.addView(space3,32,2);
        eachdetail.addView(hour);
        eachdetail.addView(space4,32,2);
        FLL.addView(eachdetail);
        FLL.addView(space5,35,35);





    }
}