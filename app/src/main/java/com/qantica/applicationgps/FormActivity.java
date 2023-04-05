package com.qantica.applicationgps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FormActivity extends AppCompatActivity {

    ImageView evidenceCamera2;
    ImageView fotoForm;
    ImageView firmaForm;
    Bitmap signatureBitmap;

    ImageView firmarButton;

    private static final int REQUEST_CODE_SIGNATURE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        evidenceCamera2 = findViewById(R.id.evidenceCamera2);
        fotoForm = findViewById(R.id.fotoForm);
        firmaForm = findViewById(R.id.firmaForm);
        firmarButton = findViewById(R.id.firmar_button);
        // Habilita la flecha de retroceso
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Habilita la cámara
        evidenceCamera2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCamera();
            }
        });

        // Abre la actividad de firma al presionar el botón correspondiente
        firmarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormActivity.this, SignatureActivity.class);
                startActivityForResult(intent, REQUEST_CODE_SIGNATURE);
            }
        });

    }

    // Habilita la flecha de retroceso en la barra de herramientas
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Abre la cámara para tomar una foto
    private void openCamera(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 1);
    }

    // Obtiene la imagen de la firma como un Bitmap
    private Bitmap getSignatureBitmap() {
        return signatureBitmap;
    }

    // Obtiene la imagen de la firma de la actividad de firma
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imgBitmap = (Bitmap) extras.get("data");
            fotoForm.setImageBitmap(imgBitmap);
        } else if (requestCode == REQUEST_CODE_SIGNATURE && resultCode == RESULT_OK) {
            signatureBitmap = data.getParcelableExtra("signature_bitmap");
            firmaForm.setImageBitmap(signatureBitmap);
        }
    }
}
