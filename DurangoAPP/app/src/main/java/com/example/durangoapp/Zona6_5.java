package com.example.durangoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class Zona6_5 extends AppCompatActivity {

    //Las acciónes que queremos que se ejecuten cuando se inicia la actividad
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zona6_5);

        Button btn = findViewById(R.id.btnZona6_5zuzendu);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                corregir(view);
            }
        });
    }

    private void corregir(View view) {
        Switch s1 = findViewById(R.id.z65switch1);
        Switch s2 = findViewById(R.id.z65switch2);
        Switch s3 = findViewById(R.id.z65switch3);
        Switch s4 = findViewById(R.id.z65switch4);
        Switch s5 = findViewById(R.id.z65switch5);
        Switch s6 = findViewById(R.id.z65switch6);

        //GEZURRA           //EGIA              //GEZURRA           //GEZURRA       //GEZURRA           //EGIA
        if (!s1.isChecked() && s2.isChecked() && !s3.isChecked() && !s4.isChecked() && !s5.isChecked() && s6.isChecked()) {
            Intent intent = new Intent(Zona6_5.this, Zona6_6.class);
            startActivity(intent);
        } else {
            MediaPlayer audioFallo = MediaPlayer.create(this, R.raw.zona1_7_txorimalo_fallo);
            audioFallo.start();
        }
    }
}