package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.example.myapplication.loginpage.access_tkn;

public class labs_booking extends AppCompatActivity {
    EditText et2;
    EditText et3;
    EditText et4;
    EditText et1;
    RequestQueue queue;
    JsonObjectRequest DetailsRequest;
    Button buttonn;
    TextView output;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        queue= Volley.newRequestQueue(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labs_booking);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
        et4=(EditText)findViewById(R.id.et4);
        et1=(EditText)findViewById(R.id.et1);
        buttonn=(Button)findViewById(R.id.buttonn) ;
        output=(TextView)findViewById(R.id.output);
        buttonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String URL2 = "https://team2api.herokuapp.com/lab";
                final String user_id = et2.getText().toString();
                final String room_id=et3.getText().toString();
                final String purpose=et4.getText().toString();
               // final String club_name=et1.getText().toString();

                JSONObject labdetails = new JSONObject();
                try {
                  //  labdetails.put("club_name",club_name);
                    labdetails.put("user_id", user_id);
                    labdetails.put("room_id",room_id);
                    labdetails.put("purpose",purpose);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                DetailsRequest = new JsonObjectRequest(Request.Method.POST,
                        URL2,
                        labdetails,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast toast = Toast.makeText(getApplicationContext(), "Request Sent!", Toast.LENGTH_LONG);
                                toast.show();


                            }

                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast toast = Toast.makeText(getApplicationContext(), "Invalid Details", Toast.LENGTH_LONG);
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
                      //  params.put("club_name",club_name);
                        params.put("user_id", user_id);
                        params.put("room_id",room_id);
                        params.put("purpose",purpose);
                        return params;
                    }

                };
                queue.add(DetailsRequest);



            }
        });
    }
}

