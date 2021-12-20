package com.example.durangoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.HashMap;

public class Zona1_7 extends AppCompatActivity {


    private Integer[] preguntas = new Integer[] {R.string.zona1_7_Pregunta1,
            R.string.zona1_7_Pregunta2,
            R.string.zona1_7_Pregunta3,
            R.string.zona1_7_Pregunta4,
            R.string.zona1_7_Pregunta5};

    private Integer[] respuestas_a = new Integer[]{R.string.zona1_7_Respuesta_1a,
            R.string.zona1_7_Respuesta_2a,
            R.string.zona1_7_Respuesta_3a,
            R.string.zona1_7_Respuesta_4a,
            R.string.zona1_7_Respuesta_5a};

    private Integer[] respuestas_b = new Integer[]{R.string.zona1_7_Respuesta_1b,
            R.string.zona1_7_Respuesta_2b,
            R.string.zona1_7_Respuesta_3b,
            R.string.zona1_7_Respuesta_4b,
            R.string.zona1_7_Respuesta_5b};

    private Integer[] respuestas_c = new Integer[]{R.string.zona1_7_Respuesta_1c,
            R.string.zona1_7_Respuesta_2c,
            null,
            R.string.zona1_7_Respuesta_4c,
            R.string.zona1_7_Respuesta_5c};

    private Integer [] correctas = new Integer[]{R.id.zona1_7_rdA,
            R.id.zona1_7_rdB,
            R.id.zona1_7_rdA,
            R.id.zona1_7_rdA,
            R.id.zona1_7_rdA};

    private static int i=0;
    MediaPlayer audioFallo;
    private ImageView txorimalo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zona1_7);

        TextView pregunta = (TextView) findViewById(R.id.txtZona1_7_Pregunta);
        RadioGroup rg = (RadioGroup) findViewById(R.id.zona1_7_rdGroup);

        RadioButton a = (RadioButton) findViewById(R.id.zona1_7_rdA);
        RadioButton b = (RadioButton) findViewById(R.id.zona1_7_rdB);
        RadioButton c = (RadioButton) findViewById(R.id.zona1_7_rdC);
        txorimalo = findViewById(R.id.zona1_7_txorimalo);

        FloatingActionButton btn= findViewById(R.id.zona1_7_fbtn);
        audioFallo= MediaPlayer.create(Zona1_7.this,R.raw.zona1_7_txorimalo_fallo);
            pregunta.setText(getString(preguntas[i]));
            a.setText(getString(respuestas_a[i]));
            b.setText(getString(respuestas_b[i]));
            if (respuestas_c[i] == null){
                c.setVisibility(View.INVISIBLE);
            }else{
                c.setVisibility(View.VISIBLE);
                c.setText(getString(respuestas_c[i]));
            }



            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (rg.getCheckedRadioButtonId() == correctas[i]) {
                        i++;
                        recreate();
                    }else{
                        audioFallo.start();
                        rg.clearCheck();
                        txorimalo.setVisibility(View.VISIBLE);
                    }
                }
            });

            audioFallo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    txorimalo.setVisibility(View.INVISIBLE);
                }
            });

    }

}