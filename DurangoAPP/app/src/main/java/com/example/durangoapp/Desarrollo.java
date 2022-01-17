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

        Button irZona2 = (Button) findViewById(R.id.btn_Desa_Zona_2);
        irZona2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Desarrollo.this, Zona2_1.class);
                startActivity(intent);
            }
        });

//        Button irJuego2 = (Button) findViewById(R.id.btn_Desa_Zona_2_Juego);
//        irJuego2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Desarrollo.this, Zona2_5.class);
//                startActivity(intent);
//            }
//        });

        Button btnZona3 = findViewById(R.id.btn_Zona3);
        btnZona3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Desarrollo.this, Zona3_1.class);
                startActivity(intent);
            }
        });

//        Button irJuego3 = (Button) findViewById(R.id.btn_Desa_Zona_3_Juego);
//        irJuego3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Desarrollo.this, Zona3_5.class);
//                startActivity(intent);
//            }
//        });

        Button btnZona4 = findViewById(R.id.btn_Zona4);
        btnZona4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Desarrollo.this, Zona4_1.class);
                startActivity(intent);
            }
        });

//        Button irJuego4 = (Button) findViewById(R.id.btn_Desa_Zona_4_Juego);
//        irJuego4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Desarrollo.this, Zona4_5.class);
//                startActivity(intent);
//            }
//        });

        Button btnZona5 = findViewById(R.id.btn_Zona5);
        btnZona5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Desarrollo.this, Zona5_1.class);
                startActivity(intent);
            }
        });

//        Button irJuego5 = (Button) findViewById(R.id.btn_Desa_Zona_5_Juego);
//        irJuego5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Desarrollo.this, Zona5_5.class);
//                startActivity(intent);
//            }
//        });

        Button btnZona6 = findViewById(R.id.btn_Zona6);
        btnZona6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Desarrollo.this, Zona6_1.class);
                startActivity(intent);
            }
        });

//        Button irJuego6 = (Button) findViewById(R.id.btn_Desa_Zona_6_Juego);
//        irJuego6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Desarrollo.this, Zona6_5.class);
//                startActivity(intent);
//            }
//        });

//        Button btnZona7 = findViewById(R.id.btn_Zona7);
//        btnZona7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Desarrollo.this, Zona7_1.class);
//                startActivity(intent);
//            }
//        });

//        Button irJuego7 = (Button) findViewById(R.id.btn_Desa_Zona_7_Juego);
//        irJuego7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Desarrollo.this, Zona7_5.class);
//                startActivity(intent);
//            }
//        });


//        Button btnZona8 = findViewById(R.id.btn_Zona8);
//        btnZona8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Desarrollo.this, Zona8_1.class);
//                startActivity(intent);
//            }
//        });
    }
}