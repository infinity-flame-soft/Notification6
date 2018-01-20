package com.droidkothon.joy.notification6;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.edit_text);
        button=findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendNotification();

            }
        });

    }


    private void sendNotification(){

        Random random=new Random();
        int id=random.nextInt();

        Intent intent=new Intent(MainActivity.this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent=PendingIntent.getActivity(this,id,intent,0);

        NotificationCompat.Builder builder=new NotificationCompat.Builder(this);

        builder.setContentText(editText.getText().toString());
        builder.setContentTitle("Notification");
        builder.setSmallIcon(R.mipmap.ic_launcher_round);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);


        NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        manager.notify(id,builder.build());


    }


}



