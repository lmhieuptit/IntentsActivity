package com.example.intentsactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView activity2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        activity2 = (TextView)findViewById(R.id.tvActivity2);

        Intent intent=getIntent();

        String name =intent.getStringExtra("toActivity2");
        activity2.setText(name+"........");

    }
}