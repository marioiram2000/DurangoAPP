package com.example.durangoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Timer;
import java.util.TimerTask;

public class Zona8_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zona8_1);

        MediaPlayer audioCompletado;
        TextView txtTxorimalo = findViewById(R.id.txtZona8_1_Txorimalo);

        audioCompletado = MediaPlayer.create(Zona8_1.this, R.raw.zona8_1_txorimalo);
        audioCompletado.start();
        setText(getString(R.string.txtZona8_1_Txorimalo),txtTxorimalo , 65);
        audioCompletado.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                finish();
                //Aqui falta dar la letra
            }
        });

        //Pulsando el boton se revela la llave del albergue
        ImageView imgZona8_1_Llave = findViewById(R.id.imgZona8_1_Llave);
        Button llave = findViewById(R.id.btnZona8_1_Llave);
        llave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgZona8_1_Llave.setVisibility(View.VISIBLE);
            }
        });

        //Boton para salir
        FloatingActionButton btn= findViewById(R.id.zona8_1_fbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Zona8_1.this, MapaActivity.class);
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