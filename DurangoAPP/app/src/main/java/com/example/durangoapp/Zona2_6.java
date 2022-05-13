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

public class Zona2_6 extends AppCompatActivity {

    //Las acciónes que queremos que se ejecuten cuando se inicia la actividad
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zona2_6);

        MediaPlayer audioCompletado;
        TextView txtTxorimalo = findViewById(R.id.txtZona2_6_Txorimalo);
        ImageView imgZona2_6_TxorimaloLetraU = findViewById(R.id.imgZona2_6_TxorimaloLetraU);
        TextView txtZona2_6_LetraU = findViewById(R.id.txtZona2_6_LetraU);
        TextView txtZona2_6_U = findViewById(R.id.txtZona2_6_U);

        audioCompletado = MediaPlayer.create(Zona2_6.this, R.raw.zona2_5_txorimalo_acierto);
        audioCompletado.start();
        setText(getString(R.string.txtZona2_6_Txorimalo_1),txtTxorimalo , 65);
        //Al terminar te aparece la letra
        audioCompletado.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                imgZona2_6_TxorimaloLetraU.setVisibility(View.VISIBLE);
                txtZona2_6_LetraU.setVisibility(View.VISIBLE);
                txtZona2_6_U.setVisibility(View.VISIBLE);
            }
        });

        //Boton para volver al mapa
        FloatingActionButton btn= findViewById(R.id.zona2_6_fbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Zona2_6.this, MapaActivity.class);
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