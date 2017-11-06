package com.example.vubuntu.myvolleyfour;

import android.app.VoiceInteractor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String myURL = "http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.buttonapi);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Butoon","Tapped");

                final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, myURL, null,
                        new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                Log.i("Json","Json"+response);

                                try {
                                    String info = response.getString("weather");
                                    Log.i("info","info"+info);

                                    JSONArray arr = new JSONArray(info);

                                    for(int i=0;i<arr.length();i++){
                                        JSONObject parObj = arr.getJSONObject(i);
                                        Log.i("ID","ID"+parObj.getString("id"));
                                        Log.i("Main","Main"+parObj.getString("main"));
                                        
                                    }


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }


//                                try {
//                                    String coor = response.getString("coord");
//                                    Log.i("COOR", "COOR: " + coor);
//                                    JSONObject co = new JSONObject(coor);
//
//                                    String lon = co.getString("lon");
//                                    String lat = co.getString("lat");
//
//                                    Log.i("LON", "LON: " + lon);
//                                    Log.i("LAT", "LAT: " + lat);
//
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                }

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("Error","Something went wrong"+error);
                    }
                });
                MySingleton.getInstance(MainActivity.this).addToRequestQue(jsonObjectRequest);

            }
        });

    }
}
