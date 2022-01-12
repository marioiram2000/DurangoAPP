package com.example.durangoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class Zona1_7 extends AppCompatActivity {


    private Integer[] preguntas = new Integer[] {R.string.zona1_7_Pregunta1,
            R.string.zona1_7_Pregunta2,
            R.string.zona1_7_Pregunta3,
            R.string.zona1_7_Pregunta4,
            R.string.zona1_7_Pregunta5};

    private Integer[] respuestas_a = new Integer[]{R.string.zona1_7_Respuesta_1a,
            R.string.zona1_7_Respuesta_2a,
            R.string.zona1_7_Respuesta_3a,
            R.string.zona1_7_Respuesta_4a,
            R.string.zona1_7_Respuesta_5a};

    private Integer[] respuestas_b = new Integer[]{R.string.zona1_7_Respuesta_1b,
            R.string.zona1_7_Respuesta_2b,
            R.string.zona1_7_Respuesta_3b,
            R.string.zona1_7_Respuesta_4b,
            R.string.zona1_7_Respuesta_5b};

    private Integer[] respuestas_c = new Integer[]{R.string.zona1_7_Respuesta_1c,
            R.string.zona1_7_Respuesta_2c,
            null,
            R.string.zona1_7_Respuesta_4c,
            R.string.zona1_7_Respuesta_5c};

    private Integer [] correctas = new Integer[]{R.id.zona1_7_rdA,
            R.id.zona1_7_rdB,
            R.id.zona1_7_rdA,
            R.id.zona1_7_rdA,
            R.id.zona1_7_rdB};

    private static int i=0;
    MediaPlayer audioFallo, audioCompletado;
    private ImageView txorimalo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zona1_7);

        TextView pregunta = (TextView) findViewById(R.id.txtZona1_7_Pregunta);
        TextView txtTxorimalo = findViewById(R.id.zona1_7_txtTxorimalo);
        RadioGroup rg = (RadioGroup) findViewById(R.id.zona1_7_rdGroup);

        RadioButton a = (RadioButton) findViewById(R.id.zona1_7_rdA);
        RadioButton b = (RadioButton) findViewById(R.id.zona1_7_rdB);
        RadioButton c = (RadioButton) findViewById(R.id.zona1_7_rdC);
        txorimalo = findViewById(R.id.zona1_7_txorimalo);
        FloatingActionButton btnVideo = (FloatingActionButton) findViewById(R.id.zona1_7_fbtnVideo);

        FloatingActionButton btn= findViewById(R.id.zona1_7_fbtn);
        audioFallo= MediaPlayer.create(Zona1_7.this,R.raw.zona1_7_txorimalo_fallo);
            pregunta.setText(getString(preguntas[i]));
            a.setText(getString(respuestas_a[i]));
            b.setText(getString(respuestas_b[i]));
            if (respuestas_c[i] == null){
                c.setVisibility(View.INVISIBLE);
            }else{
                c.setVisibility(View.VISIBLE);
                c.setText(getString(respuestas_c[i]));
            }

            btnVideo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });


            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (rg.getCheckedRadioButtonId() == correctas[i]) {
                        if (i!=4){
                            i++;
                            recreate();
                            rg.clearCheck();
                        }else{
                            audioCompletado = MediaPlayer.create(Zona1_7.this, R.raw.zona1_7_txorimalo_acierto);
                            audioCompletado.start();
                            audioCompletado.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {
                                    finish();
                                    //Aqui falta dar la letra
                                }
                            });
                        }
                    }else{
                        audioFallo.start();
                        btn.setEnabled(false);
                        txorimalo.setVisibility(View.VISIBLE);

                        setText(getString(R.string.zona1_7_TxorimaloFallo),txtTxorimalo , 65);
                        audioFallo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                btn.setEnabled(true);
                                rg.clearCheck();
                                txorimalo.setVisibility(View.INVISIBLE);
                                txtTxorimalo.setText("");
                            }
                        });
                    }
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