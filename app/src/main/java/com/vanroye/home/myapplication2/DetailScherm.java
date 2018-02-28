package com.vanroye.home.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by vangu02 on 2/28/2018.
 */

public class DetailScherm extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_detail);
        Intent intent = getIntent();
        String room = intent.getStringExtra("room"); //if it's a string you stored.

        TextView whosRoom = (TextView)findViewById(R.id.RoomName);

        whosRoom.setText(room);

    }
}
