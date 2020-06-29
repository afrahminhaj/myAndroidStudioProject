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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.example.myapplication.loginpage.access_tkn;

public class Faculty extends AppCompatActivity {
    Button Fetchdetailsbtn;
    String facname;
    RequestQueue queueA;
    JsonObjectRequest DetailsRequest;
    EditText facultyname;
    TextView D1;
    BottomNavigationView bnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        queueA = Volley.newRequestQueue(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);

        Fetchdetailsbtn = (Button) findViewById(R.id.Fetch_detailsbtn);
        facultyname = (EditText) findViewById(R.id.Faculty_nameET);
        D1 = (TextView) findViewById(R.id.Detail1);
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



        Fetchdetailsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t=new Intent(Faculty.this,labs_booking.class);
                startActivity(t);


                /*String URL2 = "https://team2api.herokuapp.com/getroom?fac_name="+facname;
                facname = facultyname.getText().toString();
                JSONObject facdetails = new JSONObject();
                try {
                    facdetails.put("fac_name", facname);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                DetailsRequest = new JsonObjectRequest(Request.Method.GET,
                        URL2,
                        null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    String det1 = response.getString("current_hour");
                                    D1.setText(det1);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }


                            }

                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast toast = Toast.makeText(getApplicationContext(), "Enter Valid Faculty Name", Toast.LENGTH_LONG);
                                toast.show();


                            }
                        }) {
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("Authorization", "Bearer " + access_tkn);
                        return params;
                    }
                    @Override
                    public Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<>();
                        params.put("fac_name", facname);
                        return params;
                    }

                };
                queueA.add(DetailsRequest);*/


            }
        });
    }
}