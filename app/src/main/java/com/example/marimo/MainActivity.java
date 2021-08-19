package com.example.marimo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;



public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

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


        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();

                        String msg = token;
                        //Log.d(TAG, msg);
                        //Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });

    }
}