package com.example.durangoapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class zona0_1 extends AppCompatActivity {

    private ImageView imgZona0_1_Principal, imgZona0_1_Txorimalo,imgZona0_1_Sobre;
    private TextView txtZona0_1_Txorimalo, txtZona0_1_Narrador;
    private Button btnZona0_1_Start, btnZona0_1_Skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zona0_1);

        imgZona0_1_Principal = (ImageView) findViewById(R.id.imgZona0_1_Principal);
        imgZona0_1_Txorimalo = findViewById(R.id.imgZona0_1_Txorimalo);
        imgZona0_1_Sobre = findViewById(R.id.imgZona0_1_Sobre);
        txtZona0_1_Narrador = findViewById(R.id.txtZona0_1_Narrador);
        txtZona0_1_Txorimalo = findViewById(R.id.txtZona0_1_Txorimalo);
        btnZona0_1_Start = findViewById(R.id.btnZona0_1_Start);
        btnZona0_1_Skip = findViewById(R.id.btnZona0_1_Skip);

        //txtZona0_1_Narrador.setSelected(true);
        txtZona0_1_Narrador.setMovementMethod(new ScrollingMovementMethod());

        btnZona0_1_Skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgZona0_1_Principal.setVisibility(View.INVISIBLE);
                imgZona0_1_Sobre.setVisibility(View.VISIBLE);
                txtZona0_1_Narrador.setVisibility(View.INVISIBLE);
                btnZona0_1_Skip.setVisibility(View.INVISIBLE);
                txtZona0_1_Txorimalo.setVisibility(View.VISIBLE);
                imgZona0_1_Txorimalo.setVisibility(View.VISIBLE);
                imgZona0_1_Txorimalo.setImageDrawable(getResources().getDrawable(R.drawable.txorimalo));
                btnZona0_1_Start.setVisibility(View.VISIBLE);
                txtZona0_1_Txorimalo.setMovementMethod(new ScrollingMovementMethod());

            }
        });

    }
}