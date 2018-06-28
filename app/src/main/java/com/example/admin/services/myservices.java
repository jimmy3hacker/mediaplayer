package com.example.admin.services;

   //  1

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;

public class myservices extends Service {

    MediaPlayer mediaPlayer;
    int cur_position = 0;

    @Override
    public void onCreate() {
        super.onCreate();

        mediaPlayer = MediaPlayer.create(this,R.raw.faded);
        mediaPlayer.setLooping(true);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if(intent.getStringExtra("order").equalsIgnoreCase("play")) {
            mediaPlayer.start();
            mediaPlayer.setLooping(true);

        }
        else if(intent.getStringExtra("order").equals("pause")){
            cur_position=mediaPlayer.getCurrentPosition();
            mediaPlayer.pause();
        }
        else if(intent.getStringExtra("order").equalsIgnoreCase("resume")){
            mediaPlayer.seekTo(cur_position);
            mediaPlayer.start();
        }


        return START_STICKY;

    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        mediaPlayer.stop();



    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

    return null;
    }
}
