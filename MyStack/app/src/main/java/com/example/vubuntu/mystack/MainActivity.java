package com.example.vubuntu.mystack;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    public class SetupFetch extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {

            URL url;
            HttpURLConnection urlConnection=null;
            String page="";

            try{
                url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream input = urlConnection.getInputStream();
                InputStreamReader read = new InputStreamReader(input);

                int data = read.read();

                while (data!=-1){
                    char storeData = (char) data;
                    page+=storeData;
                    data=read.read();
                }
                return page;

            }
            catch (Exception e){
                e.printStackTrace();
                return "Cannot fetch data";
            }



        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SetupFetch request = new SetupFetch();
        String page =null;

        try {
            page = request.execute("http://www.HiteshChoudhary.com/").get();
            Log.i("Msg","DONE!");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        Log.i("WebPage",page);
        Log.i("Msg","DONE!");
    }
}
