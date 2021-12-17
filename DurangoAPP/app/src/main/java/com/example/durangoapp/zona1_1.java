package com.example.durangoapp;

import androidx.appcompat.app.AppCompatActivity;

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

public class zona1_1 extends AppCompatActivity {

    private ImageView imgZona1_1_Txorimalo, imgZona1_1_Iglesia;
    private TextView txtZona1_1_Txorimalo;
    private Button btnZona0_1_Video;
    private MediaPlayer audio_Txorimalo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zona1_1);

        imgZona1_1_Iglesia = findViewById(R.id.imgZona1_2_Iglesia);
        txtZona1_1_Txorimalo = findViewById(R.id.txtZona1_1_Txorimalo);

        //Texto 1 Txorimalo
        setText(getString(R.string.txtZona1_1_Txorimalo_1), txtZona1_1_Txorimalo,60);
        txtZona1_1_Txorimalo.setMovementMethod(new ScrollingMovementMethod());
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
        audio_Txorimalo = MediaPlayer.create(zona1_1.this,R.raw.zona1_1_txorimalo);
        audio_Txorimalo.start();

        audio_Txorimalo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                imgZona1_1_Iglesia.setVisibility(View.VISIBLE);
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
        final Handler handler = new Handler()
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