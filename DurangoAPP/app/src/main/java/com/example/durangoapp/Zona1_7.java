package com.example.durangoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.HashMap;

public class Zona1_7 extends AppCompatActivity {


    private HashMap <String, String []> preguntas = new HashMap<String, String[]>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zona1_7);

        cargarPreguntas();
        TextView pregunta = (TextView) findViewById(R.id.txtZona1_7_Pregunta);
        RadioGroup rg = (RadioGroup) findViewById(R.id.zona1_7_rdGroup);

        RadioButton a = (RadioButton) findViewById(R.id.zona1_7_rdA);
        RadioButton b = (RadioButton) findViewById(R.id.zona1_7_rdB);
        RadioButton c = (RadioButton) findViewById(R.id.zona1_7_rdC);


    }

    private void cargarPreguntas (){
        preguntas.put(getString(R.string.zona1_7_Pregunta1),
                new String[]{getString(R.string.zona1_7_Respuesta_1a), getString(R.string.zona1_7_Respuesta_1b), getString(R.string.zona1_7_Respuesta_1c)});

        preguntas.put(getString(R.string.zona1_7_Pregunta2),
                new String[]{getString(R.string.zona1_7_Respuesta_2a), getString(R.string.zona1_7_Respuesta_2b), getString(R.string.zona1_7_Respuesta_2c)});

        preguntas.put(getString(R.string.zona1_7_Pregunta3),
                new String[]{getString(R.string.zona1_7_Respuesta_3a), getString(R.string.zona1_7_Respuesta_3b)});

        preguntas.put(getString(R.string.zona1_7_Pregunta4),
                new String[]{getString(R.string.zona1_7_Respuesta_4a), getString(R.string.zona1_7_Respuesta_4b), getString(R.string.zona1_7_Respuesta_4c)});

        preguntas.put(getString(R.string.zona1_7_Pregunta5),
                new String[]{getString(R.string.zona1_7_Respuesta_5a), getString(R.string.zona1_7_Respuesta_5b), getString(R.string.zona1_7_Respuesta_5c)});
    }
}