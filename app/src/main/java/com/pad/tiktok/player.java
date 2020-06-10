package com.pad.tiktok;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class player extends AppCompatActivity {
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videoplayer);

        String mURL = getIntent().getStringExtra("mURL");

        String videoUrl2 =  mURL;
        Uri uri = Uri.parse( videoUrl2 );
        videoView = (VideoView)this.findViewById(R.id.videoView );
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();


        videoView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(videoView.isPlaying()){
                    videoView.pause();
                }else{
                    videoView.start();
                }
                return false;
            }
        });



    }


    @Override
    protected void onNewIntent(Intent intent){
        super.onNewIntent(intent);
        String result;
        if(intent!=null){
            result = intent.getStringExtra("mURL");
            setIntent(intent);
        }

    }

    @Override
    protected void onResume(){
        super.onResume();

        Intent intent = getIntent();
        if(intent!=null){
            String result = intent.getStringExtra("mURL");
        }
    }


}