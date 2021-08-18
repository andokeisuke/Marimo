package com.example.marimo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //stausへ遷移
        Button status_Button = findViewById(R.id.status_button);

        // lambda式
        status_Button.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), StatusActivity.class);
            startActivity(intent);
        });

        //logへ遷移
        Button log_Button = findViewById(R.id.log_button);

        // lambda式
        log_Button.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), LogActivity.class);
            startActivity(intent);
        });

        //missionへ遷移
        Button mission_Button = findViewById(R.id.mission_button);

        // lambda式
        mission_Button.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), MissionActivity.class);
            startActivity(intent);
        });
    }
}