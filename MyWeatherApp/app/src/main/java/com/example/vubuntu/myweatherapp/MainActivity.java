package com.example.vubuntu.myweatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText city;
    TextView result;

    //http://api.openweathermap.org/data/2.5/weather?q=satyavedu&appid=e7b10965d6df9be93ba58f6385e82e28

    String myBaseUrl ="http://api.openweathermap.org/data/2.5/weather?q=";
    String myAPIkey = "&appid=e7b10965d6df9be93ba58f6385e82e28";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        city = (EditText) findViewById(R.id.getCity);
        result = (TextView) findViewById(R.id.result);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myUrl = myBaseUrl+city.getText().toString()+myAPIkey;
//                Log.i("URL","URL: "+myUrl);



                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, myUrl, null,
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

                                        String myWeatherDetail = parObj.getString("main");
                                        result.setText(myWeatherDetail);
                                        String str = myWeatherDetail.toLowerCase();
                                        if(str=="mist"){

                                        }
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
