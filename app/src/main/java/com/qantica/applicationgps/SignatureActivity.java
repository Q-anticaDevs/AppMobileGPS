package com.qantica.applicationgps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.ByteArrayOutputStream;

public class SignatureActivity extends AppCompatActivity {

    private DrawView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signature);

        ConstraintLayout signatureContainer = findViewById(R.id.signature_container);

        drawView = new DrawView(this, null);

        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.MATCH_PARENT);

        signatureContainer.addView(drawView, params);

        Button clearButton = findViewById(R.id.clear_button);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawView.clear();
            }
        });

        // Obtener referencia a botón de guardar
        Button guardarButton = findViewById(R.id.save_button);

        // Agregar OnClickListener al botón de guardar
        guardarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un bitmap a partir de DrawView
                Bitmap bitmap = Bitmap.createBitmap(
                        drawView.getWidth(),
                        drawView.getHeight(),
                        Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                drawView.draw(canvas);

                // Convertir el bitmap a bytes
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                // Pasar el bitmap a FormActivity
                Intent intent = new Intent();
                intent.putExtra("signature_bitmap", byteArray);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}

