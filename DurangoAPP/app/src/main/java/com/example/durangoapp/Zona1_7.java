package com.example.durangoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.HashMap;

public class Zona1_7 extends AppCompatActivity {


    private String[] preguntas = new String[] {getString(R.string.zona1_7_Pregunta1),
            getString(R.string.zona1_7_Pregunta2),
            getString(R.string.zona1_7_Pregunta3),
            getString(R.string.zona1_7_Pregunta4),
            getString(R.string.zona1_7_Pregunta5)};

    private Integer [] correctas = new Integer[]{R.id.zona1_7_rdA,
            R.id.zona1_7_rdB,
            R.id.zona1_7_rdA,
            R.id.zona1_7_rdA,
            R.id.zona1_7_rdA};

    private int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zona1_7);

        TextView pregunta = (TextView) findViewById(R.id.txtZona1_7_Pregunta);
        RadioGroup rg = (RadioGroup) findViewById(R.id.zona1_7_rdGroup);

        RadioButton a = (RadioButton) findViewById(R.id.zona1_7_rdA);
        RadioButton b = (RadioButton) findViewById(R.id.zona1_7_rdB);
        RadioButton c = (RadioButton) findViewById(R.id.zona1_7_rdC);

        FloatingActionButton btn= findViewById(R.id.zona1_7_fbtn);

        pregunta.setText(preguntas[i]);
        a.setText(getString(R.string.zona1_7_Respuesta_1a));
        b.setText(getString(R.string.zona1_7_Respuesta_1b));
        c.setText(getString(R.string.zona1_7_Respuesta_1c));

        if (rg.getCheckedRadioButtonId() == correctas[i]){
            i++;
        }





//        switch (i){
//            case 0:
//                pregunta.setText(preguntas[i]);
//                a.setText();
//        }




    }

}