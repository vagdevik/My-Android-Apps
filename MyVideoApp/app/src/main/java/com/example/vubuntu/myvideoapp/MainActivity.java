package com.example.vubuntu.myvideoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Basics of video

        //1.get video view

        VideoView videoView = (VideoView) findViewById(R.id.videoView);

        //2.set video path

        videoView.setVideoPath("android.resource://"+ getPackageName()+"/"+R.raw.myvideo);

        //3.add media control(for things like playing it again

        MediaController mediaController = new MediaController(this);


        //also the presence of mediacontroller view and video view should be known by eachother..,as follows..

        mediaController.setAnchorView(videoView);  //mediacontroller views knows on which view to place its anchors like play button
        videoView.setMediaController(mediaController); //videoview gets to know that it is being controlled by the mediacontroller

        //4.start video

        videoView.start();

    }
}
