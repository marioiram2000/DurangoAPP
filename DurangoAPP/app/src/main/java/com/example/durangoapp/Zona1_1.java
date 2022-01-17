package com.example.durangoapp;

import androidx.annotation.Nullable;
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
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;

public class Zona1_1 extends AppCompatActivity {

    private ImageView imgZona1_1_Txorimalo, imgZona1_1_Iglesia;
    private TextView txtZona1_1_Txorimalo;
    private Button btnZona1_1_Video, btnZona1_7_Test;
    private MediaPlayer audio_Txorimalo;
    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zona1_1);

        imgZona1_1_Iglesia = findViewById(R.id.imgZona1_2_Iglesia);
        txtZona1_1_Txorimalo = findViewById(R.id.txtZona1_1_Txorimalo);
        btnZona1_1_Video = findViewById(R.id.btnZona1_2_Video);
        btnZona1_7_Test = findViewById(R.id.btnZona1_7_Test);


        //Texto 1 Txorimalo
        txtZona1_1_Txorimalo.setMovementMethod(new ScrollingMovementMethod());
        setText(getString(R.string.txtZona1_1_Txorimalo_1), txtZona1_1_Txorimalo,60);
        final ScrollView scroller01 = (ScrollView) findViewById(R.id.scrollerZona1_1);
        scroller01.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    scroller01.fullScroll(View.FOCUS_DOWN);
                }
            }
        });

        //Audio inicio Txorimalo
        audio_Txorimalo = MediaPlayer.create(Zona1_1.this,R.raw.zona1_1_txorimalo);
        audio_Txorimalo.start();
        //Cuando termina el audio aparece la foto
        audio_Txorimalo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                imgZona1_1_Iglesia.setVisibility(View.VISIBLE);

                //Texto 2 Txorimalo
                //txtZona1_1_Txorimalo.setMovementMethod(new ScrollingMovementMethod());
                txtZona1_1_Txorimalo.setText("");
                setText(getString(R.string.txtZona1_3_Txorimalo_1), txtZona1_1_Txorimalo,80);
                //final ScrollView scroller01 = (ScrollView) findViewById(R.id.scrollerZona1_1);
                scroller01.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (hasFocus) {
                            scroller01.fullScroll(View.FOCUS_DOWN);
                        }
                    }
                });
                //Audio explicacion iglesia
                audio_Txorimalo = MediaPlayer.create(Zona1_1.this,R.raw.zona1_3_txorimalo);
                audio_Txorimalo.start();

                audio_Txorimalo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        btnZona1_1_Video.setVisibility(View.VISIBLE);
                        btnZona1_7_Test.setVisibility(View.VISIBLE);
                    }
                });


            }
        });

        btnZona1_1_Video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verVideo();
            }
        });

        btnZona1_7_Test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Zona1_1.this, Zona1_7.class);
                startActivity(intent);
                audio_Txorimalo.stop();
            }
        });


    }

    //Video en Dialogo
    private void verVideo(){
//        Dialog dialogVerVideo = new Dialog(this);
//        dialogVerVideo.setContentView(R.layout.dialog_zona1_4_video);
//        dialogVerVideo.show();

        Intent intent = new Intent(Zona1_1.this, Zona1_4_video.class);
        startActivityForResult(intent,1244);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        btnZona1_1_Video.setVisibility(View.INVISIBLE);

        //Texto 3 Txorimalo
        //txtZona1_1_Txorimalo.setMovementMethod(new ScrollingMovementMethod());
        txtZona1_1_Txorimalo.setText("");
        setText(getString(R.string.txtZona1_5_Txorimalo_1), txtZona1_1_Txorimalo,65);
        final ScrollView scroller01 = (ScrollView) findViewById(R.id.scrollerZona1_1);
        scroller01.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    scroller01.fullScroll(View.FOCUS_DOWN);
                }
            }
        });

        //Audio  segunda parte explicacion iglesia tras el video
        audio_Txorimalo = MediaPlayer.create(Zona1_1.this,R.raw.zona1_5_txorimalo);
        audio_Txorimalo.start();

        //Cuando termine la segunda explicacion, empezara el audio donde te propone hacer un test
        audio_Txorimalo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                //Texto 4 Txorimalo
                //txtZona1_1_Txorimalo.setMovementMethod(new ScrollingMovementMethod());
                txtZona1_1_Txorimalo.setText("");
                setText(getString(R.string.txtZona1_6_Txorimalo_1), txtZona1_1_Txorimalo,70);
                final ScrollView scroller01 = (ScrollView) findViewById(R.id.scrollerZona1_1);
                scroller01.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (hasFocus) {
                            scroller01.fullScroll(View.FOCUS_DOWN);
                        }
                    }
                });
                //Audio  segunda parte explicacion iglesia tras el video
                audio_Txorimalo = MediaPlayer.create(Zona1_1.this,R.raw.zona1_6_txorimalo);
                audio_Txorimalo.start();
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