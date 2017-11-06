package com.example.vubuntu.my_mybulbanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void blueTapped(View view) {
        ImageView blue = (ImageView) findViewById(R.id.bluebulb);
        ImageView green = (ImageView) findViewById(R.id.greenbulb);
        green.animate().alpha(0).setDuration(1000);
        blue.animate().alpha(1).setDuration(1000);
    }

    public void greenTapped(View view) {
        ImageView blue = (ImageView) findViewById(R.id.bluebulb);
        ImageView green = (ImageView) findViewById(R.id.greenbulb);
        green.animate().alpha(1).setDuration(1000);
        blue.animate().alpha(0).setDuration(1000);
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
