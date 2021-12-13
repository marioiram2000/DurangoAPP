package com.example.durangoapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
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
        btnZona0_1_Start = findViewById(R.id.btnZona0_2_Start);
        btnZona0_1_Skip = findViewById(R.id.btnZona0_1_Skip);

        setText(getString(R.string.zona0_1Text_1), txtZona0_1_Narrador);

        //txtZona0_1_Narrador.setSelected(true);
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
                setText(getString(R.string.zona0_1Text_2), txtZona0_1_Txorimalo);
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

    }

    public void setText(final String s, TextView txt)
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
                Log.d("Strange",""+c);
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
        timer.schedule(taskEverySplitSecond, 1, 50);
    }
}