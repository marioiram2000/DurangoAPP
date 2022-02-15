package com.example.durangoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class Zona3_5 extends AppCompatActivity {

    private EditText ed1;
    private EditText ed2;
    private EditText ed3;
    private EditText ed4;
    boolean correcto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zona3_5);

        ed1 = findViewById(R.id.editText3_5_1);
        ed2 = findViewById(R.id.editText3_5_2);
        ed3 = findViewById(R.id.editText3_5_3);
        ed4 = findViewById(R.id.editText3_5_4);

        Button btn = findViewById(R.id.btn_zona3_5_zuzendu);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                corregir(view);
            }
        });
    }

    private void corregir(View view) {
        correcto = true;
        String resp1 = ed1.getText().toString();
        String resp2 = ed2.getText().toString();
        String resp3 = ed3.getText().toString();
        String resp4 = ed4.getText().toString();

        String resu1 = "GAUR EGUN";
        String resu2 = "HIRIA";
        String resu3 = "ANTZINEAN";
        String resu4 = "PLAZA";

        if (!resu1.equals(resp1.trim().toUpperCase(Locale.ROOT))) {
            correcto = false;
        }else if (!resu2.equals(resp2.trim().toUpperCase(Locale.ROOT))) {
            correcto = false;
        }else if (!resu3.equals(resp3.trim().toUpperCase(Locale.ROOT))) {
            correcto = false;
        }else if (!resu4.equals(resp4.trim().toUpperCase(Locale.ROOT))) {
            correcto = false;
        }

        if(correcto){
            bien();
        }else{
            mal();

        }
    }

    private void mal(){
        MediaPlayer audioFallo = MediaPlayer.create(this, R.raw.zona1_7_txorimalo_fallo);
        audioFallo.start();
        ed1.setText("");
        ed2.setText("");
        ed3.setText("");
        ed4.setText("");
    }

    private void bien(){
        Intent intent = new Intent(this, Zona3_6.class);
        startActivity(intent);
    }
}