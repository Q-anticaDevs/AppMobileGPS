package com.qantica.applicationgps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
public class LocationActivity extends AppCompatActivity {

    View view;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_locationc);
   }

    public void form(View view){
        this.view = view;
        Intent enterForm = new Intent(this, FormActivity.class);
        startActivity(enterForm);
    }
    public void info(View view){
        this.view = view;
        Intent enterInfo = new Intent(this, InfoActivity.class);
        startActivity(enterInfo);
    }
    public void evidence(View view){
        this.view = view;
        Intent enterEvidence = new Intent(this, EvidenceActivity.class);
        startActivity(enterEvidence);
    }


}