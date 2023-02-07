package qantica.app.appgps.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import qantica.app.appgps.R;
import qantica.app.appgps.view.MapsActivity;

public class MainActivity extends AppCompatActivity {

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Botón provisional primera pantalla
    public void siguiente(View view){
        this.view = view;
        Intent enter = new Intent(this, MapsActivity.class);
        startActivity(enter);
    }

}