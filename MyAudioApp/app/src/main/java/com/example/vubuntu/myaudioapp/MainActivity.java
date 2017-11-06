package com.example.vubuntu.myaudioapp;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    AudioManager audioManager;  // to get value from audio service regarding audio properties for various devices provided like for music, notification,etc

    public void playTapped(View view){
        mediaPlayer.start();
    }

    public void pauseTapped(View view){
        mediaPlayer.pause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this,R.raw.song);


        //getting context fom audio service
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int myMaxVol = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int myCurrentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);


        //setting context volume on seekbar
        SeekBar volumeBar = (SeekBar) findViewById(R.id.seekBar);
        volumeBar.setMax(myMaxVol);
        volumeBar.setProgress(myCurrentVolume);

        //set on change listner
        volumeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,i ,0);   //first arg- to set that property on music streaming, sec arg- progress value(a param of seekbar on design),third arg-from user
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //setting player timeline

        final SeekBar timeline = (SeekBar) findViewById(R.id.seekBar2);
        timeline.setMax(mediaPlayer.getDuration());

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timeline.setProgress(mediaPlayer.getCurrentPosition());
            }
        },0,1000);

        timeline.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mediaPlayer.seekTo(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
