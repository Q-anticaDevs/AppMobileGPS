package com.qantica.applicationgps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class FormActivity extends AppCompatActivity {

    ImageView evidenceCamera2;
    ImageView fotoForm;
    View view;

    View view2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        evidenceCamera2 = findViewById(R.id.evidenceCamera2);
        fotoForm = findViewById(R.id.fotoForm);

        //Habilita la flecha de retroceso
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Habilita la cámara
        evidenceCamera2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCamera();
            }
        });


    }

    //Abrir pantalla para firma
    public void firmado(View view2){
        this.view = view2;
        Intent enter = new Intent(this, SignatureActivity.class);
        startActivity(enter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void openCamera(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imgBitmap = (Bitmap) extras.get("data");
            fotoForm.setImageBitmap(imgBitmap);
        }
    }
}