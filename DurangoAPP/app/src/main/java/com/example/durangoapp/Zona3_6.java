package com.example.durangoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Timer;
import java.util.TimerTask;

public class Zona3_6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zona3_6);

        MediaPlayer audioCompletado;
        TextView txtTxorimalo = findViewById(R.id.txtZona3_6_Txorimalo);
        ImageView imgZona3_6_TxorimaloLetraR = findViewById(R.id.imgZona3_6_TxorimaloLetraR);
        TextView txtZona3_6_LetraR = findViewById(R.id.txtZona3_6_LetraR);
        TextView txtZona3_6_R = findViewById(R.id.txtZona3_6_R);

        audioCompletado = MediaPlayer.create(Zona3_6.this, R.raw.zona3_5_txorimalo_acierto);
        audioCompletado.start();
        setText(getString(R.string.txtZona3_6_Txorimalo_1),txtTxorimalo , 65);
        //Al terminar te aparece la letra
        audioCompletado.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                imgZona3_6_TxorimaloLetraR.setVisibility(View.VISIBLE);
                txtZona3_6_LetraR.setVisibility(View.VISIBLE);
                txtZona3_6_R.setVisibility(View.VISIBLE);
            }
        });

        //Boton para volver al mapa
        FloatingActionButton btn= findViewById(R.id.zona3_6_fbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Zona3_6.this, MapaActivity.class);
                startActivity(intent);
                finish();
            }
        });
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