package com.example.admin.services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button play,pause,stope;

    String order = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        play = findViewById(R.id.play);
        stope = findViewById(R.id.stop);
        pause = findViewById(R.id.puse);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,myservices.class);
                order="play";
                intent.putExtra("order",order);
                play.setText("Resume");
                startService (intent);

            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,myservices.class);
                order="pause";
                intent.putExtra("order",order);
                play.setText("Resume");
                startService (intent);
            }
        });

        stope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(MainActivity.this, myservices.class));
            }});
    }
}
