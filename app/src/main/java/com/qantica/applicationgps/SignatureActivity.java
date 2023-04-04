package com.qantica.applicationgps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignatureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signature);

        ConstraintLayout signatureContainer = findViewById(R.id.signature_container);

        // Crea la instancia de la vista personalizada DrawView
        DrawView drawView = new DrawView(this, null);

        // Crea los parametros de layout para la vista personalizada
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.MATCH_PARENT);

        // Agrega la vista personalizada al contenedor
        signatureContainer.addView(drawView, params);

        //Limpiar espacio para firma
        Button clearButton = findViewById(R.id.clear_button);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawView.clear();
            }
        });
    }





}