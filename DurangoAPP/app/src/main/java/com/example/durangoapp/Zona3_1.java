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

public class Zona3_1 extends AppCompatActivity {

    private MediaPlayer audio_Txorimalo;
    private ImageView img_Txorimalo, imgZona3_2_arkua;
    private Button btnZona3_5_Juego;
    private TextView txtZona3_1_Txorimalo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zona3_1);

        img_Txorimalo = findViewById(R.id.imgZona3_1_Txorimalo);
        imgZona3_2_arkua = findViewById(R.id.imgZona3_2_Arkua);
        btnZona3_5_Juego = findViewById(R.id.btnZona3_5_Juego);
        txtZona3_1_Txorimalo = findViewById(R.id.txtZona3_1_Txorimalo);
        final ScrollView scroller = findViewById(R.id.scrollerZona3_1);

        //Texto 1 Txorimalo
        txtZona3_1_Txorimalo.setMovementMethod(new ScrollingMovementMethod());
        setText(getString(R.string.txtZona3_1_Txorimalo), txtZona3_1_Txorimalo, 60 );
        scroller.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    scroller.fullScroll(View.FOCUS_DOWN);
                }
            }
        });
        //Audio Txorimalo
        audio_Txorimalo = MediaPlayer.create(Zona3_1.this, R.raw.zona3_1_txorimalo);
        audio_Txorimalo.start();

        //Cuando termina aparece la foto
        audio_Txorimalo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                imgZona3_2_arkua.setVisibility(View.VISIBLE);

                //Texto 2 Txorimalo

                txtZona3_1_Txorimalo.setText("");
                setText(getString(R.string.txtZona3_3_Txorimalo), txtZona3_1_Txorimalo, 60);

                //Audio explicacion 2
                audio_Txorimalo = MediaPlayer.create(Zona3_1.this,R.raw.zona3_3_txorimalo);
                audio_Txorimalo.start();

                audio_Txorimalo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        btnZona3_5_Juego.setVisibility(View.VISIBLE);

                        //texto 3 txorimalo
                        txtZona3_1_Txorimalo.setText("");
                        setText(getString(R.string.txtZona3_4_Txorimalo), txtZona3_1_Txorimalo, 70);

                        audio_Txorimalo = MediaPlayer.create(Zona3_1.this,R.raw.zona3_3_txorimalo);
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