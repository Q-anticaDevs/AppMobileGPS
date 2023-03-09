package com.qantica.applicationgps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SignatureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signature);


        DrawView drawView = new DrawView(this, null);
        setContentView(drawView);
    }
}