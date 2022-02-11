package com.example.durangoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
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

public class Zona7_1 extends AppCompatActivity {

    private MediaPlayer audio_Txorimalo;
    private ImageView imgZona7_2;
    private Button btnZona7_5_Juego;
    private TextView txtZona7_1_Txorimalo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zona7_1);

        imgZona7_2 = findViewById(R.id.imgZona7_2_Teatro);
        btnZona7_5_Juego = findViewById(R.id.btnZona7_5_Juego);
        txtZona7_1_Txorimalo = findViewById(R.id.txtZona7_1_Txorimalo);
        final ScrollView scroller = findViewById(R.id.scrollerZona7_1);

        //Texto 1 Txorimalo
        txtZona7_1_Txorimalo.setMovementMethod(new ScrollingMovementMethod());
        setText(getString(R.string.txtZona7_1_Txorimalo), txtZona7_1_Txorimalo, 60 );
        scroller.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    scroller.fullScroll(View.FOCUS_DOWN);
                }
            }
        });
        //Audio Txorimalo
        audio_Txorimalo = MediaPlayer.create(Zona7_1.this, R.raw.zona7_1_txorimalo);
        audio_Txorimalo.start();

        //Cuando termina aparece la foto
        audio_Txorimalo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                imgZona7_2.setImageDrawable(getDrawable(R.drawable.zona7_2_1));
                imgZona7_2.setVisibility(View.VISIBLE);

                //Texto 2 Txorimalo

                txtZona7_1_Txorimalo.setText("");
                setText(getString(R.string.txtZona7_3_Txorimalo), txtZona7_1_Txorimalo, 70);

                //Audio explicacion 2
                audio_Txorimalo = MediaPlayer.create(Zona7_1.this,R.raw.zona7_3_txorimalo);
                audio_Txorimalo.start();

                audio_Txorimalo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        btnZona7_5_Juego.setVisibility(View.VISIBLE);
                        imgZona7_2.setImageDrawable(getDrawable(R.drawable.zona7_2_2));
                        //texto 3 txorimalo
                        txtZona7_1_Txorimalo.setText("");
                        setText(getString(R.string.txtZona7_4_Txorimalo), txtZona7_1_Txorimalo, 70);

                        audio_Txorimalo = MediaPlayer.create(Zona7_1.this,R.raw.zona7_4_txorimalo);
                        audio_Txorimalo.start();

                    }
                });
            }
        });

        btnZona7_5_Juego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Zona7_1.this, Zona7_5.class);
                startActivity(intent);
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