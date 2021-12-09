package com.example.durangoapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class zona0_1 extends AppCompatActivity {

    private ImageView imgZona0_1_Principal, imgZona0_1_Txorimalo;
    private TextView txtZona0_1_Txorimalo, txtZona0_1_Narrador;
    private Button btnZona0_1_Start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zona0_1);

        imgZona0_1_Principal = findViewById(R.id.imgZona0_1_Principal);
        imgZona0_1_Txorimalo = findViewById(R.id.imgZona0_1_Txorimalo);
        txtZona0_1_Narrador = findViewById(R.id.txtZona0_1_Narrador);
        txtZona0_1_Txorimalo = findViewById(R.id.txtZona0_1_Txorimalo);
        btnZona0_1_Start = findViewById(R.id.btnZona0_1_Start);



    }
}