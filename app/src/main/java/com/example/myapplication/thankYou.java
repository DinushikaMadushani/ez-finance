package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class thankYou extends AppCompatActivity {

    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        home = findViewById(R.id.home);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("Ez Notification", " Ez Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //notification code
                NotificationCompat.Builder builder = new NotificationCompat.Builder(thankYou.this, "Ez Notification");
                builder.setContentTitle("Ez finance");
                builder.setContentText("You have successfully organized the finances for Ez Finance.");
                builder.setSmallIcon(R.drawable.ic_baseline_notifications_24);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(thankYou.this);
                managerCompat.notify(1,builder.build());

                Intent intent = new Intent(thankYou.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}