package com.example.durangoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class zona0_1 extends AppCompatActivity {

    private ImageView imgZona0_1_Principal, imgZona0_1_Txorimalo, imgZona0_1_Sobre;
    private TextView txtZona0_1_Txorimalo, txtZona0_1_Narrador;
    private Button btnZona0_1_Start, btnZona0_1_Skip;
    private MediaPlayer audio_narrador, audio_txorimalo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zona0_1);

        imgZona0_1_Principal = (ImageView) findViewById(R.id.imgZona0_1_Principal);
        imgZona0_1_Txorimalo = findViewById(R.id.imgZona0_1_Txorimalo);
        imgZona0_1_Sobre = findViewById(R.id.imgZona0_1_Sobre);
        txtZona0_1_Narrador = findViewById(R.id.txtZona0_1_Narrador);
        txtZona0_1_Txorimalo = findViewById(R.id.txtZona0_1_Txorimalo);
        btnZona0_1_Start = findViewById(R.id.btnZona0_2_Start);
        btnZona0_1_Skip = findViewById(R.id.btnZona0_1_Skip);

        setText(getString(R.string.zona0_1Text_1), txtZona0_1_Narrador, 80);

        txtZona0_1_Narrador.setMovementMethod(new ScrollingMovementMethod());
        final ScrollView scroller01 = (ScrollView) findViewById(R.id.scrollerZona0_1);
        scroller01.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    scroller01.fullScroll(View.FOCUS_DOWN);
                }
            }
        });
        

        //Audio del narrador cuando llegas al albergue
        audio_narrador = MediaPlayer.create(zona0_1.this,R.raw.zona0_1_narrador);
        audio_narrador.start();


        btnZona0_1_Skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                audio_narrador.stop();
                imgZona0_1_Principal.setVisibility(View.INVISIBLE);
                imgZona0_1_Sobre.setVisibility(View.VISIBLE);
                txtZona0_1_Narrador.setVisibility(View.INVISIBLE);
                btnZona0_1_Skip.setVisibility(View.INVISIBLE);
                txtZona0_1_Txorimalo.setVisibility(View.VISIBLE);
                imgZona0_1_Txorimalo.setVisibility(View.VISIBLE);
                imgZona0_1_Txorimalo.setImageDrawable(getResources().getDrawable(R.drawable.txorimalo));
                btnZona0_1_Start.setVisibility(View.VISIBLE);
                txtZona0_1_Txorimalo.setMovementMethod(new ScrollingMovementMethod());

                //audio del txorimalo
                audio_txorimalo = MediaPlayer.create(zona0_1.this,R.raw.zona0_2_txorimalo);
                audio_txorimalo.start();

                //texto del audio letra por letra
                setText(getString(R.string.zona0_1Text_2), txtZona0_1_Txorimalo, 65);
                final ScrollView scroller02 = (ScrollView) findViewById(R.id.scrollerZona0_2);
                scroller01.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (hasFocus) {
                            scroller02.fullScroll(View.FOCUS_DOWN);
                        }
                    }
                });

            }
        });

        //ESTO ES PROVISIONAL PARA HACER PRUEBAS. ESTE BOTON DEBERIA LLEVARTE AL MAPA
        btnZona0_1_Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(zona0_1.this, zona1_1.class);
                startActivity(intent);
            }
        });

    }

    //Parar el audio cuando se pulsa el boton back
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        audio_narrador.stop();
        if (audio_txorimalo!=null){
            audio_txorimalo.stop();
        }

    }

    //Se visualizar el texto palabra por palabra
    public void setText(final String s, TextView txt, int velocidad)
    {
        final int[] i = new int[1];
        i[0] = 0;
        final int length = s.length();
        final Handler handler = new Handler(Looper.myLooper())
        {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                char c= s.charAt(i[0]);
                //Log.d("Strange",""+c);
                txt.append(String.valueOf(c));
                i[0]++;
            }
        };

        final Timer timer = new Timer();
        TimerTask taskEverySplitSecond = new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
                if (i[0] == length - 1) {
                    timer.cancel();
                }
            }
        };
        timer.schedule(taskEverySplitSecond, 1, velocidad);
    }
}