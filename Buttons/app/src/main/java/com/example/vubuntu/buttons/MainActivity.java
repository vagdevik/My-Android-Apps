package com.example.vubuntu.buttons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void Up(View view){
        Log.i("signup","Sign Up tapped");
    }

    public void In(View view){
        Log.i("signin","sign in tapped!");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
