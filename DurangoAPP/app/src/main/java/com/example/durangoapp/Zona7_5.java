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

public class Zona7_5 extends AppCompatActivity {

    private int cont= 0;
    MediaPlayer audioFallo;
    
    //Las acciónes que queremos que se ejecuten cuando se inicia la actividad
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zona7_5);

        Button btnCorregir = findViewById(R.id.btnZona7_5_Corregir);

        TextView palabra1 = findViewById(R.id.txtZona7_5_palabra1);
        TextView palabra2 = findViewById(R.id.txtZona7_5_palabra2);
        TextView palabra3 = findViewById(R.id.txtZona7_5_palabra3);
        TextView palabra4 = findViewById(R.id.txtZona7_5_palabra4);
        TextView palabra5 = findViewById(R.id.txtZona7_5_palabra5);

        EditText hueco1 = findViewById(R.id.txtZona7_5_hueco1);
        EditText hueco2 = findViewById(R.id.txtZona7_5_hueco2);
        EditText hueco3 = findViewById(R.id.txtZona7_5_hueco3);
        EditText hueco4 = findViewById(R.id.txtZona7_5_hueco4);
        EditText hueco5 = findViewById(R.id.txtZona7_5_hueco5);

        btnCorregir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                corregir()
            }
        });
    }

    private void corregir(){
        if (palabra1.getText().toString().equals(hueco1.getText().toString().toLowerCase())){
            hueco1.setTextColor(getColor(R.color.verde));
            hueco1.setEnabled(false);
            palabra1.setText("");
            cont++;
        }else{
            hueco1.setText("");
        }
        if (palabra2.getText().toString().equals(hueco2.getText().toString().toLowerCase())){
            hueco2.setTextColor(getColor(R.color.verde));
            hueco2.setEnabled(false);
            palabra2.setText("");
            cont++;
        }else{
            hueco2.setText("");
        }
        if (palabra3.getText().toString().equals(hueco3.getText().toString().toLowerCase())){
            hueco3.setTextColor(getColor(R.color.verde));
            hueco3.setEnabled(false);
            palabra3.setText("");;
            cont++;
        }else{
            hueco3.setText("");
        }
        if (palabra4.getText().toString().equals(hueco4.getText().toString().toLowerCase())){
            hueco4.setTextColor(getColor(R.color.verde));
            hueco4.setEnabled(false);
            palabra4.setText("");
            cont++;
        }else{
            hueco4.setText("");
        }
        if (palabra5.getText().toString().equals(hueco5.getText().toString().toLowerCase())){
            hueco5.setTextColor(getColor(R.color.verde));
            hueco5.setEnabled(false);
            palabra5.setText("");
            cont++;
        }else{
            hueco5.setText("");
        }

        if (cont == 5){
            Intent intent = new Intent(Zona7_5.this, Zona7_6.class);
            startActivity(intent);
            finish();
        }else{
            audioFallo= MediaPlayer.create(Zona7_5.this,R.raw.zona1_7_txorimalo_fallo);
            audioFallo.start();
        }
    }
}