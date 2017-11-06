package com.example.vubuntu.momsremainder;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText userTime = (EditText) findViewById(R.id.myeditText);
        final TextView NewHead = (TextView) findViewById(R.id.EnterHead);
        final TextView mnum = (TextView) findViewById(R.id.mnumber);
        final TextView result = (TextView) findViewById(R.id.done);
        final Button button = (Button) findViewById(R.id.button);
        final Button newButton = (Button) findViewById(R.id.newButton);
        String k1;

        newButton.setVisibility(View.INVISIBLE);





        button.setOnClickListener(new View.OnClickListener() {

            int flag=0;
            MediaPlayer mediaPlayer;
            @Override
            public void onClick(View view) {
                if(flag==0){
                    flag=1;
                    String k2 = userTime.getText().toString();
                    NewHead.setText(k2);
                    userTime.setVisibility(View.INVISIBLE);
                    button.setVisibility(View.INVISIBLE);

                    new CountDownTimer(10000,1000){
                        public void onTick(long millisecondsUntilDone){
                            mnum.setText("Time: "+String.valueOf(millisecondsUntilDone/1000));
                        }
                        public void onFinish(){
                            result.setText("Done!");
                            mnum.setText("0");
                            result.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.fade_in));
                            mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.song);
                            mediaPlayer.start();
                            button.setVisibility(View.VISIBLE);
                        }
                    }.start();
                }
                else{
                    mediaPlayer.pause();
                    flag=0;
                    newButton.setVisibility(View.VISIBLE);
                    newButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            newButton.setVisibility(View.INVISIBLE);
                            NewHead.setText("Enter Time in sec");
                            userTime.setVisibility(View.VISIBLE);
                            button.setVisibility(View.VISIBLE);

                            button.callOnClick();
                        }
                    });

                }




            }
        });



    }


}
