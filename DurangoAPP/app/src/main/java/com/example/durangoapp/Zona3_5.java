package com.example.durangoapp;

import androidx.appcompat.app.AppCompatActivity;

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

        String resu1 = "SANTA ANAKO ARKUA KOKATUTA DAGOEN PLAZA";
        String resu2 = "SANTA ANAKO ARKUA KOKATUTA GAUR EGUN";
        String resu3 = "SANTA ANAKO ARKUA ANTZINEAN";
        String resu4 = "SANTA ANAKO ARKUA KOKATUTA DAGOEN HIRIA";
        if (!resp1.toLowerCase(Locale.ROOT).equals(resu1.trim().toLowerCase(Locale.ROOT))) {
            correcto = false;
        }else if (!resp2.toLowerCase(Locale.ROOT).equals(resu2.trim().toLowerCase(Locale.ROOT))) {
            correcto = false;
        }else if (!resp3.toLowerCase(Locale.ROOT).equals(resu3.trim().toLowerCase(Locale.ROOT))) {
            correcto = false;
        }else if (!resp4.toLowerCase(Locale.ROOT).equals(resu4.trim().toLowerCase(Locale.ROOT))) {
            correcto = false;
        }

        if(correcto){
            bien();
        }else{
            mal();
            
        }
    }

    private void mal(){

    }

    private void bien(){

    }
}