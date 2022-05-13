package com.example.durangoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;


public class Zona4_5 extends AppCompatActivity {

    private boolean l1 = false;
    private boolean l2 = false;
    private boolean l3 = false;
    private boolean l4 = false;

    //Las acciónes que queremos que se ejecuten cuando se inicia la actividad
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zona4_5);

        Button btn = findViewById(R.id.zona4_5_zuzendu);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                corregir(view);
            }
        });
    }

    //Comprobamos los resultados
    public void corregir(View view) {
        EditText ed = findViewById(R.id.editTextZona4_5_resul);
        String resul = ed.getText().toString();

        //Respuestas
        String r1 = "FATXADA";
        String r2 = "ARKUA";
        String r3 = "BALKOIA";
        String r4 = "BONBARDAKETA";

        //Si la palabra introducida por el usuario es una de las respuestas, mostramos la palabra en el crucigrama
        if (resul.trim().toUpperCase(Locale.ROOT).equals(r1)) {
            findViewById(R.id.txtZona3_5_Box_23).setVisibility(View.VISIBLE);
            findViewById(R.id.txtZona3_5_Box_24).setVisibility(View.VISIBLE);
            findViewById(R.id.txtZona3_5_Box_25).setVisibility(View.VISIBLE);
            findViewById(R.id.txtZona3_5_Box_26).setVisibility(View.VISIBLE);
            findViewById(R.id.txtZona3_5_Box_27).setVisibility(View.VISIBLE);
            findViewById(R.id.txtZona3_5_Box_28).setVisibility(View.VISIBLE);
            findViewById(R.id.txtZona3_5_Box_16).setVisibility(View.VISIBLE);
            l1 = true;
        } else if (resul.trim().toUpperCase(Locale.ROOT).equals(r2)) {
            findViewById(R.id.txtZona3_5_Box_5).setVisibility(View.VISIBLE);
            findViewById(R.id.txtZona3_5_Box_13).setVisibility(View.VISIBLE);
            findViewById(R.id.txtZona3_5_Box_14).setVisibility(View.VISIBLE);
            findViewById(R.id.txtZona3_5_Box_15).setVisibility(View.VISIBLE);
            findViewById(R.id.txtZona3_5_Box_16).setVisibility(View.VISIBLE);
            l2 = true;
        } else if (resul.trim().toUpperCase(Locale.ROOT).equals(r3)) {
            findViewById(R.id.txtZona3_5_Box_17).setVisibility(View.VISIBLE);
            findViewById(R.id.txtZona3_5_Box_18).setVisibility(View.VISIBLE);
            findViewById(R.id.txtZona3_5_Box_19).setVisibility(View.VISIBLE);
            findViewById(R.id.txtZona3_5_Box_14).setVisibility(View.VISIBLE);
            findViewById(R.id.txtZona3_5_Box_20).setVisibility(View.VISIBLE);
            findViewById(R.id.txtZona3_5_Box_21).setVisibility(View.VISIBLE);
            findViewById(R.id.txtZona3_5_Box_22).setVisibility(View.VISIBLE);
            l3 = true;
        } else if (resul.trim().toUpperCase(Locale.ROOT).equals(r4)) {
            findViewById(R.id.txtZona3_5_Box_1).setVisibility(View.VISIBLE);
            findViewById(R.id.txtZona3_5_Box_2).setVisibility(View.VISIBLE);
            findViewById(R.id.txtZona3_5_Box_3).setVisibility(View.VISIBLE);
            findViewById(R.id.txtZona3_5_Box_4).setVisibility(View.VISIBLE);
            findViewById(R.id.txtZona3_5_Box_5).setVisibility(View.VISIBLE);
            findViewById(R.id.txtZona3_5_Box_6).setVisibility(View.VISIBLE);
            findViewById(R.id.txtZona3_5_Box_7).setVisibility(View.VISIBLE);
            findViewById(R.id.txtZona3_5_Box_8).setVisibility(View.VISIBLE);
            findViewById(R.id.txtZona3_5_Box_9).setVisibility(View.VISIBLE);
            findViewById(R.id.txtZona3_5_Box_10).setVisibility(View.VISIBLE);
            findViewById(R.id.txtZona3_5_Box_11).setVisibility(View.VISIBLE);
            findViewById(R.id.txtZona3_5_Box_12).setVisibility(View.VISIBLE);
            l4 = true;
        } else {
            MediaPlayer audioFallo = MediaPlayer.create(this, R.raw.zona1_7_txorimalo_fallo);
            audioFallo.start();
        }
        ed.setText("");

        if (l1 && l2 && l3 && l4) {
            Intent intent = new Intent(Zona4_5.this, Zona4_6.class);
            startActivity(intent);
        }
    }
}