package com.qantica.applicationgps;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.DrawableImageViewTarget;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 5000; // tiempo de duración del splash

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // carga la imagen GIF con Glide
        ImageView imageView = findViewById(R.id.imageViewS);
        DrawableImageViewTarget imageViewTarget = new DrawableImageViewTarget(imageView);
        Glide.with(this)
                .asGif()
                .load(R.drawable.splashmovicapp)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);

        // crea un handler para cerrar la pantalla de splash después del tiempo de duración
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // inicia la actividad principal y cierra la pantalla de splash
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
