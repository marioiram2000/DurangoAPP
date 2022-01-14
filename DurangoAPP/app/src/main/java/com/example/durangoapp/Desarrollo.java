package com.example.durangoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Desarrollo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desarrollo);


        Button irZona0 = (Button) findViewById(R.id.btn_Desa_Zona_0);
        irZona0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Desarrollo.this, Zona0_1.class);
                startActivity(intent);
            }
        });

        Button irZona1 = (Button) findViewById(R.id.btn_Desa_Zona_1);
        irZona1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Desarrollo.this, Zona1_1.class);
                startActivity(intent);
            }
        });

        Button irJuego1 = (Button) findViewById(R.id.btn_Desa_Zona_1_Test);
        irJuego1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Desarrollo.this, Zona1_7.class);
                startActivity(intent);
            }
        });

        Button btnVideo = (Button) findViewById(R.id.btnVideo_desa);
        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Desarrollo.this, Zona1_4_video.class);
                startActivity(intent);
            }
        });

        Button btnMapa = (Button) findViewById(R.id.btn_Desa_mapa);
        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Desarrollo.this, MapaActivity.class);
                startActivity(intent);
            }
        });


    }
}