package com.example.vubuntu.mydice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {


    int[] myDiceArray = {
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.six
    };

    public void rollTapped(View view){
        Log.i("roll it","Tapped roll it");
        Random ran = new Random();
        int randomNum=ran.nextInt(6);
        Log.i("Random Number is"," "+randomNum);
        ImageView display_dice = (ImageView) findViewById(R.id.dice);
        display_dice.setImageResource(myDiceArray[randomNum]);
        TextView head = (TextView) findViewById(R.id.numHead);
        head.setText("Your number is "+(randomNum+1));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
