package com.example.durangoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Zona2_1 extends AppCompatActivity {

    private ImageView imgZona2_2_Cruz;
    private TextView txtZona2_1_Txorimalo;
    private Button btnZona2_5_Juego;
    private MediaPlayer audio_Txorimalo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zona2_1);

        imgZona2_2_Cruz = findViewById(R.id.imgZona2_2_Cruz);
        txtZona2_1_Txorimalo = findViewById(R.id.txtZona2_1_Txorimalo);
        btnZona2_5_Juego = findViewById(R.id.btnZona2_5_Sopa);

        //Texto 1 Txorimalo
        txtZona2_1_Txorimalo.setMovementMethod(new ScrollingMovementMethod());
        setText(getString(R.string.txtZona2_1_Txorimalo), txtZona2_1_Txorimalo,60);
        final ScrollView scroller01 = (ScrollView) findViewById(R.id.scrollerZona2_1);
        scroller01.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    scroller01.fullScroll(View.FOCUS_DOWN);
                }
            }
        });

        //Audio inicio Txorimalo
        audio_Txorimalo = MediaPlayer.create(Zona2_1.this,R.raw.zona2_1_txorimalo);
        audio_Txorimalo.start();
        //Cuando termina el audio aparece la foto
        audio_Txorimalo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                imgZona2_2_Cruz.setVisibility(View.VISIBLE);

                //Texto 2 Txorimalo
                txtZona2_1_Txorimalo.setMovementMethod(new ScrollingMovementMethod());
                txtZona2_1_Txorimalo.setText("");
                setText(getString(R.string.txtZona2_3_Txorimalo), txtZona2_1_Txorimalo,80);
                final ScrollView scroller01 = (ScrollView) findViewById(R.id.scrollerZona2_1);
                scroller01.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (hasFocus) {
                            scroller01.fullScroll(View.FOCUS_DOWN);
                        }
                    }
                });
                //Audio explicacion cruz
                audio_Txorimalo = MediaPlayer.create(Zona2_1.this,R.raw.zona2_3_txorimalo);
                audio_Txorimalo.start();

                //Cuando termine la explicacion, empezara el audio donde te propone hacer una sopa de letras
                audio_Txorimalo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        btnZona2_5_Juego.setVisibility(View.VISIBLE);

                        //Texto 4 Txorimalo
                        txtZona2_1_Txorimalo.setMovementMethod(new ScrollingMovementMethod());
                        txtZona2_1_Txorimalo.setText("");
                        setText(getString(R.string.txtZona2_4_Txorimalo), txtZona2_1_Txorimalo,70);
                        final ScrollView scroller01 = (ScrollView) findViewById(R.id.scrollerZona2_1);
                        scroller01.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                            @Override
                            public void onFocusChange(View v, boolean hasFocus) {
                                if (hasFocus) {
                                    scroller01.fullScroll(View.FOCUS_DOWN);
                                }
                            }
                        });
                        //Audio  segunda parte explicacion iglesia tras el video
                        audio_Txorimalo = MediaPlayer.create(Zona2_1.this,R.raw.zona2_4_txorimalo);
                        audio_Txorimalo.start();

                    }
                });


            }
        });
    }



    //Parar el audio cuando se pulsa el boton back
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        audio_Txorimalo.stop();
    }

    //Se visualiza el texto palabra por palabra
    public void setText(final String s, TextView txt, int velocidad)
    {
        final int[] i = new int[1];
        i[0] = 0;
        final int length = s.length();
        @SuppressLint("HandlerLeak") final Handler handler = new Handler()
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