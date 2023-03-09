package com.qantica.applicationgps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void entrar(View view){
        this.view = view;
        Intent enter = new Intent(this, LocationActivity.class);
        startActivity(enter);
    }


}