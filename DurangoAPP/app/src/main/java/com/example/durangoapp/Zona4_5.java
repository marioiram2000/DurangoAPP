package com.example.durangoapp;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.slice.SliceItem;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.content.SharedPreferences;
import java.util.TimerTask;
import android.media.MediaPlayer;
import android.widget.TextView;
import java.util.Random;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;
import android.media.MediaPlayer;
import android.widget.Toast;

public class Zona3_5 extends AppCompatActivity {
//
//    //full screen 1 of 3
//    private Canvas canvas;
//    private View decorView;
//    //
//
//    SharedPreferences sp;
//    String textinput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zona3_5);

//
//
//        final TextView choice1 = (TextView) findViewById(R.id.textView);
//        final TextView choice2 = (TextView) findViewById(R.id.textView2);
//        final TextView choice3 = (TextView) findViewById(R.id.textView3);
//        final TextView choice4 = (TextView) findViewById(R.id.textView4);
//        final TextView choice5 = (TextView) findViewById(R.id.textView6);
//        final ImageView dustbin = (ImageView) findViewById(R.id.imageView23);
//
//        //Letters at boxes
//        final TextView textView7 = (TextView) findViewById(R.id.textView7);
//        final TextView textView8 = (TextView) findViewById(R.id.textView8);
//        final TextView textView9 = (TextView) findViewById(R.id.textView9);
//        final TextView textView10 = (TextView) findViewById(R.id.textView10);
//        final TextView textView11 = (TextView) findViewById(R.id.textView11);
//        final TextView textView12 = (TextView) findViewById(R.id.textView12);
//        final TextView textView13 = (TextView) findViewById(R.id.textView13);
//        final TextView textView14 = (TextView) findViewById(R.id.textView14);
//        final TextView textView15 = (TextView) findViewById(R.id.textView15);
//        final TextView textView16 = (TextView) findViewById(R.id.textView16);
//        final TextView textView17 = (TextView) findViewById(R.id.textView17);
//
//        final TextView textView18 = (TextView) findViewById(R.id.textView18);
//
//
//        final TextView input = (TextView) findViewById(R.id.textView5);
//
//        final String inputs;
//
//        sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sp.edit();
//        editor.putString("textinput", "");
//        editor.apply();
//
//        //s:sounds effects reset
//        editor.putString("soundinput", "1");
//        editor.apply();
//        //e:sounds effects reset
//
//        //s:lock score for those answered [1]
//        editor.putString("lockscore1", "");
//        editor.apply();
//
//        editor.putString("lockscore2", "");
//        editor.apply();
//
//        editor.putString("lockscore3", "");
//        editor.apply();
//
//        editor.putString("lockscore4", "");
//        editor.apply();
//
//        //e:lock score for those answered [1]
//
//
////getscore
//        String highscore = sp.getString("highscore", "0");
//        String tagnewhighscore = "Score:" + " " + highscore;
//        textView18.setText(tagnewhighscore);
//
//
//
//        //full screen 2 of 3
//        // -> hide status bar
//        decorView = getWindow().getDecorView();
//        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
//            @Override
//            public void onSystemUiVisibilityChange(int visibility) {
//                if (visibility == 0)
//                    decorView.setSystemUiVisibility(hideSystemBars());
//            }
//        });
//        //
//
//        choice1.setOnClickListener(new View.OnClickListener() {
//            String textinputsecondary;
//
//            @Override
//            //button H
//            public void onClick(View view) {
//                textinput = sp.getString("textinput", "");
//
//                //s:lock score for those answered [2]
//                String lockscore1 = sp.getString("lockscore1", "");
//                String lockscore2 = sp.getString("lockscore2", "");
//                String lockscore3 = sp.getString("lockscore3", "");
//                String lockscore4 = sp.getString("lockscore4", "");
//                //=
//
//                SharedPreferences.Editor editor = sp.edit();
//
//
//                //choice button on click
//                textinputsecondary = textinput + "H";
//                editor.putString("textinput", textinputsecondary);
//                editor.apply();
//                input.setText(textinputsecondary);
//                if (textinputsecondary.equals("HAPPY") && !lockscore1.equals("1")) {
//                    textView7.setText("H");
//                    textView8.setText("A");
//                    textView9.setText("P");
//                    textView10.setText("P");
//                    textView11.setText("Y");
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//
//                    String one = "1";
//                    //s:lock score for those answered [3]
//                    editor.putString("lockscore1", one);
//                    editor.apply();
//
//                    //====
//
//                    // get score
//                    String highscore = sp.getString("highscore", "0");
//                    int Ihighscore = parseInt(highscore) + 100;
//                    String newHighScore = new Integer(Ihighscore).toString();
//
//                    editor.putString("highscore", newHighScore);
//                    editor.apply();
//
//                    String tagnewhighscore = "Score:" + " " + newHighScore;
//
//                    textView18.setText(tagnewhighscore);
//
//
//                    //
//                }
//                else if (textinputsecondary.equals("HAPPY")) {
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                }
//
//                if (textinputsecondary.equals("HAY") && !lockscore2.equals("1")) {
//                    textView11.setText("Y");
//                    textView12.setText("A");
//                    textView13.setText("H");
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//
//                    //s:lock score for those answered [4]
//                    editor.putString("lockscore2", "1");
//                    editor.apply();
//                    //====
//
//                    // get score
//                    String highscore = sp.getString("highscore", "0");
//                    int Ihighscore = parseInt(highscore) + 100;
//                    String newHighScore = new Integer(Ihighscore).toString();
//
//                    editor.putString("highscore",newHighScore);
//                    editor.apply();
//
//                    String tagnewhighscore = "Score:" + " " + newHighScore;
//
//                    textView18.setText(tagnewhighscore);
//
//
//                    //
//
//
//                }
//                else if (textinputsecondary.equals("HAY")) {
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//
//                }
//
//
//                if (textinputsecondary.equals("PAY") && !lockscore3.equals("1")) {
//                    textView10.setText("P");
//                    textView14.setText("A");
//                    textView15.setText("Y");
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//
//                    //s:lock score for those answered [5]
//                    editor.putString("lockscore3", "1");
//                    editor.apply();
//                    //====
//
//                    // get score
//                    String highscore = sp.getString("highscore", "0");
//                    int Ihighscore = parseInt(highscore) + 100;
//                    String newHighScore = new Integer(Ihighscore).toString();
//
//                    editor.putString("highscore",newHighScore);
//                    editor.apply();
//
//                    String tagnewhighscore = "Score:" + " " + newHighScore;
//
//                    textView18.setText(tagnewhighscore);
//
//
//                    //
//
//                }
//                else if (textinputsecondary.equals("PAY")) {
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//
//                }
//
//                if (textinputsecondary.equals("APP") && !lockscore4.equals("1")) {
//                    textView17.setText("A");
//                    textView16.setText("P");
//                    textView9.setText("P");
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//
//                    //s:lock score for those answered [6]
//                    editor.putString("lockscore4", "1");
//                    editor.apply();
//                    //====
//
//                    // get score
//                    String highscore = sp.getString("highscore", "0");
//                    int Ihighscore = parseInt(highscore) + 100;
//                    String newHighScore = new Integer(Ihighscore).toString();
//
//                    editor.putString("highscore",newHighScore);
//                    editor.apply();
//
//                    String tagnewhighscore = "Score:" + " " + newHighScore;
//
//                    textView18.setText(tagnewhighscore);
//
//
//                    //
//
//
//                }
//                else if (textinputsecondary.equals("APP")) {
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//
//                }
////E:choice button on click
//
//                String soundinput;
//                int soundinputsecondary;
//
//                //S: Ascending Sounds on click
//                soundinput = sp.getString("soundinput", "1");
//                int soundinput2 = parseInt(soundinput);
//                soundinputsecondary = soundinput2 + 1;
//                String soundinputsecondary2 = new Integer(soundinputsecondary).toString();;
//
//                editor.putString("soundinput", soundinputsecondary2);
//                editor.apply();
//
//                if (soundinput2 == 1 && !textinputsecondary.equals("HAPPY") && !textinputsecondary.equals("HAY") && !textinputsecondary.equals("PAY") && !textinputsecondary.equals("APP") ) {
//                    //play music
//                    note1.start();
//                }
//                else if (soundinput2 == 1) {
//                    bingo1.start();
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                }
//
//                if (soundinput2 == 2 && !textinputsecondary.equals("HAPPY") && !textinputsecondary.equals("HAY") && !textinputsecondary.equals("PAY") && !textinputsecondary.equals("APP") ) {
//                    //play music
//                    note2.start();
//                }
//                else if (soundinput2 == 2) {
//                    bingo1.start();
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                }
//
//                if (soundinput2 == 3 && !textinputsecondary.equals("HAPPY") && !textinputsecondary.equals("HAY") && !textinputsecondary.equals("PAY") && !textinputsecondary.equals("APP") ) {
//                    //play music
//                    note3.start();
//                }
//                else if (soundinput2 == 3) {
//                    bingo1.start();
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                }
//
//                if (soundinput2 == 4 && !textinputsecondary.equals("HAPPY") && !textinputsecondary.equals("HAY") && !textinputsecondary.equals("PAY") && !textinputsecondary.equals("APP") ) {
//                    //play music
//                    note4.start();
//                }
//                else if (soundinput2 == 4) {
//                    bingo1.start();
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                }
//
//                if (soundinput2 == 5 && !textinputsecondary.equals("HAPPY") && !textinputsecondary.equals("HAY") && !textinputsecondary.equals("PAY") && !textinputsecondary.equals("APP") ) {
//                    //play music
//                    note5.start();
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                }
//                else if (soundinput2 == 5) {
//                    bingo1.start();
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//
//                }
//            }
//        });
//
//        choice2.setOnClickListener(new View.OnClickListener() {
//            String textinputsecondary;
//
//            @Override
//            //button P
//            public void onClick(View view) {
//                //s:lock score for those answered [2]
//                String lockscore1 = sp.getString("lockscore1", "");
//                String lockscore2 = sp.getString("lockscore2", "");
//                String lockscore3 = sp.getString("lockscore3", "");
//                String lockscore4 = sp.getString("lockscore4", "");
//                //=
//
//
//                textinput = sp.getString("textinput", "");
//                SharedPreferences.Editor editor = sp.edit();
//                textinputsecondary = textinput + "P";
//                editor.putString("textinput", textinputsecondary);
//                editor.apply();
//                input.setText(textinputsecondary);
//                if (textinputsecondary.equals("HAPPY") && !lockscore1.equals("1")) {
//                    textView7.setText("H");
//                    textView8.setText("A");
//                    textView9.setText("P");
//                    textView10.setText("P");
//                    textView11.setText("Y");
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//
//                    String one = "1";
//                    //s:lock score for those answered [3]
//                    editor.putString("lockscore1", one);
//                    editor.apply();
//
//                    //====
//
//                    // get score
//                    String highscore = sp.getString("highscore", "0");
//                    int Ihighscore = parseInt(highscore) + 100;
//                    String newHighScore = new Integer(Ihighscore).toString();
//
//                    editor.putString("highscore", newHighScore);
//                    editor.apply();
//
//                    String tagnewhighscore = "Score:" + " " + newHighScore;
//
//                    textView18.setText(tagnewhighscore);
//
//
//                    //
//                }
//                else if (textinputsecondary.equals("HAPPY")) {
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                }
//
//                if (textinputsecondary.equals("HAY") && !lockscore2.equals("1")) {
//                    textView11.setText("Y");
//                    textView12.setText("A");
//                    textView13.setText("H");
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//
//                    //s:lock score for those answered [4]
//                    editor.putString("lockscore2", "1");
//                    editor.apply();
//                    //====
//
//                    // get score
//                    String highscore = sp.getString("highscore", "0");
//                    int Ihighscore = parseInt(highscore) + 100;
//                    String newHighScore = new Integer(Ihighscore).toString();
//
//                    editor.putString("highscore",newHighScore);
//                    editor.apply();
//
//                    String tagnewhighscore = "Score:" + " " + newHighScore;
//
//                    textView18.setText(tagnewhighscore);
//
//
//                    //
//
//
//                }
//                else if (textinputsecondary.equals("HAY")) {
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//
//                }
//
//
//                if (textinputsecondary.equals("PAY") && !lockscore3.equals("1")) {
//                    textView10.setText("P");
//                    textView14.setText("A");
//                    textView15.setText("Y");
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//
//                    //s:lock score for those answered [5]
//                    editor.putString("lockscore3", "1");
//                    editor.apply();
//                    //====
//
//                    // get score
//                    String highscore = sp.getString("highscore", "0");
//                    int Ihighscore = parseInt(highscore) + 100;
//                    String newHighScore = new Integer(Ihighscore).toString();
//
//                    editor.putString("highscore",newHighScore);
//                    editor.apply();
//
//                    String tagnewhighscore = "Score:" + " " + newHighScore;
//
//                    textView18.setText(tagnewhighscore);
//
//
//                    //
//
//                }
//                else if (textinputsecondary.equals("PAY")) {
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//
//                }
//
//                if (textinputsecondary.equals("APP") && !lockscore4.equals("1")) {
//                    textView17.setText("A");
//                    textView16.setText("P");
//                    textView9.setText("P");
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//
//                    //s:lock score for those answered [6]
//                    editor.putString("lockscore4", "1");
//                    editor.apply();
//                    //====
//
//                    // get score
//                    String highscore = sp.getString("highscore", "0");
//                    int Ihighscore = parseInt(highscore) + 100;
//                    String newHighScore = new Integer(Ihighscore).toString();
//
//                    editor.putString("highscore",newHighScore);
//                    editor.apply();
//
//                    String tagnewhighscore = "Score:" + " " + newHighScore;
//
//                    textView18.setText(tagnewhighscore);
//
//
//                    //
//
//
//                }
//                else if (textinputsecondary.equals("APP")) {
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//
//                }
//
//
//                //E:choice button on click
//
//                String soundinput;
//                int soundinputsecondary;
//
//                //S: Ascending Sounds on click
//                soundinput = sp.getString("soundinput", "1");
//                int soundinput2 = parseInt(soundinput);
//                soundinputsecondary = soundinput2 + 1;
//                String soundinputsecondary2 = Integer.toString(soundinputsecondary);
//
//                editor.putString("soundinput", soundinputsecondary2);
//                editor.apply();
//
//                if (soundinput2 == 1 && !textinputsecondary.equals("HAPPY") && !textinputsecondary.equals("HAY") && !textinputsecondary.equals("PAY") && !textinputsecondary.equals("APP") ) {
//                    //play music
//                    note1.start();
//                }
//                else if (soundinput2 == 1) {
//                    bingo1.start();
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                }
//
//                if (soundinput2 == 2 && !textinputsecondary.equals("HAPPY") && !textinputsecondary.equals("HAY") && !textinputsecondary.equals("PAY") && !textinputsecondary.equals("APP") ) {
//                    //play music
//                    note2.start();
//                }
//                else if (soundinput2 == 2) {
//                    bingo1.start();
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                }
//
//                if (soundinput2 == 3 && !textinputsecondary.equals("HAPPY") && !textinputsecondary.equals("HAY") && !textinputsecondary.equals("PAY") && !textinputsecondary.equals("APP") ) {
//                    //play music
//                    note3.start();
//                }
//                else if (soundinput2 == 3) {
//                    bingo1.start();
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                }
//
//                if (soundinput2 == 4 && !textinputsecondary.equals("HAPPY") && !textinputsecondary.equals("HAY") && !textinputsecondary.equals("PAY") && !textinputsecondary.equals("APP") ) {
//                    //play music
//                    note4.start();
//                }
//                else if (soundinput2 == 4) {
//                    bingo1.start();
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                }
//
//                if (soundinput2 == 5 && !textinputsecondary.equals("HAPPY") && !textinputsecondary.equals("HAY") && !textinputsecondary.equals("PAY") && !textinputsecondary.equals("APP") ) {
//                    //play music
//                    note5.start();
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                }
//                else if (soundinput2 == 5) {
//                    bingo1.start();
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//
//                }
//            }
//        });
//
//        choice3.setOnClickListener(new View.OnClickListener() {
//            String textinputsecondary;
//
//            @Override
//            //button A
//            public void onClick(View view) {
//                //s:lock score for those answered [2]
//                String lockscore1 = sp.getString("lockscore1", "");
//                String lockscore2 = sp.getString("lockscore2", "");
//                String lockscore3 = sp.getString("lockscore3", "");
//                String lockscore4 = sp.getString("lockscore4", "");
//                //=
//
//                textinput = sp.getString("textinput", "");
//                SharedPreferences.Editor editor = sp.edit();
//                textinputsecondary = textinput + "A";
//                editor.putString("textinput", textinputsecondary);
//                editor.apply();
//                input.setText(textinputsecondary);
//                if (textinputsecondary.equals("HAPPY") && !lockscore1.equals("1")) {
//                    textView7.setText("H");
//                    textView8.setText("A");
//                    textView9.setText("P");
//                    textView10.setText("P");
//                    textView11.setText("Y");
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//
//                    String one = "1";
//                    //s:lock score for those answered [3]
//                    editor.putString("lockscore1", one);
//                    editor.apply();
//
//                    //====
//
//                    // get score
//                    String highscore = sp.getString("highscore", "0");
//                    int Ihighscore = parseInt(highscore) + 100;
//                    String newHighScore = new Integer(Ihighscore).toString();
//
//                    editor.putString("highscore", newHighScore);
//                    editor.apply();
//
//                    String tagnewhighscore = "Score:" + " " + newHighScore;
//
//                    textView18.setText(tagnewhighscore);
//
//
//                    //
//                }
//                else if (textinputsecondary.equals("HAPPY")) {
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                }
//
//                if (textinputsecondary.equals("HAY") && !lockscore2.equals("1")) {
//                    textView11.setText("Y");
//                    textView12.setText("A");
//                    textView13.setText("H");
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//
//                    //s:lock score for those answered [4]
//                    editor.putString("lockscore2", "1");
//                    editor.apply();
//                    //====
//
//                    // get score
//                    String highscore = sp.getString("highscore", "0");
//                    int Ihighscore = parseInt(highscore) + 100;
//                    String newHighScore = new Integer(Ihighscore).toString();
//
//                    editor.putString("highscore",newHighScore);
//                    editor.apply();
//
//                    String tagnewhighscore = "Score:" + " " + newHighScore;
//
//                    textView18.setText(tagnewhighscore);
//
//
//                    //
//
//
//                }
//                else if (textinputsecondary.equals("HAY")) {
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//
//                }
//
//
//                if (textinputsecondary.equals("PAY") && !lockscore3.equals("1")) {
//                    textView10.setText("P");
//                    textView14.setText("A");
//                    textView15.setText("Y");
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//
//                    //s:lock score for those answered [5]
//                    editor.putString("lockscore3", "1");
//                    editor.apply();
//                    //====
//
//                    // get score
//                    String highscore = sp.getString("highscore", "0");
//                    int Ihighscore = parseInt(highscore) + 100;
//                    String newHighScore = new Integer(Ihighscore).toString();
//
//                    editor.putString("highscore",newHighScore);
//                    editor.apply();
//
//                    String tagnewhighscore = "Score:" + " " + newHighScore;
//
//                    textView18.setText(tagnewhighscore);
//
//
//                    //
//
//                }
//                else if (textinputsecondary.equals("PAY")) {
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//
//                }
//
//                if (textinputsecondary.equals("APP") && !lockscore4.equals("1")) {
//                    textView17.setText("A");
//                    textView16.setText("P");
//                    textView9.setText("P");
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//
//                    //s:lock score for those answered [6]
//                    editor.putString("lockscore4", "1");
//                    editor.apply();
//                    //====
//
//                    // get score
//                    String highscore = sp.getString("highscore", "0");
//                    int Ihighscore = parseInt(highscore) + 100;
//                    String newHighScore = new Integer(Ihighscore).toString();
//
//                    editor.putString("highscore",newHighScore);
//                    editor.apply();
//
//                    String tagnewhighscore = "Score:" + " " + newHighScore;
//
//                    textView18.setText(tagnewhighscore);
//
//
//                    //
//
//
//                }
//                else if (textinputsecondary.equals("APP")) {
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//
//                }
//
//                //E:choice button on click
//
//                String soundinput;
//                int soundinputsecondary;
//
//                //S: Ascending Sounds on click
//                soundinput = sp.getString("soundinput", "1");
//                int soundinput2 = parseInt(soundinput);
//                soundinputsecondary = soundinput2 + 1;
//                String soundinputsecondary2 = Integer.valueOf(soundinputsecondary).toString();
//
//                editor.putString("soundinput", soundinputsecondary2);
//                editor.apply();
//
//                if (soundinput2 == 1 && !textinputsecondary.equals("HAPPY") && !textinputsecondary.equals("HAY") && !textinputsecondary.equals("PAY") && !textinputsecondary.equals("APP") ) {
//                    //play music
//                    note1.start();
//                }
//                else if (soundinput2 == 1) {
//                    bingo1.start();
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                }
//
//                if (soundinput2 == 2 && !textinputsecondary.equals("HAPPY") && !textinputsecondary.equals("HAY") && !textinputsecondary.equals("PAY") && !textinputsecondary.equals("APP") ) {
//                    //play music
//                    note2.start();
//                }
//                else if (soundinput2 == 2) {
//                    bingo1.start();
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                }
//
//                if (soundinput2 == 3 && !textinputsecondary.equals("HAPPY") && !textinputsecondary.equals("HAY") && !textinputsecondary.equals("PAY") && !textinputsecondary.equals("APP") ) {
//                    //play music
//                    note3.start();
//                }
//                else if (soundinput2 == 3) {
//                    bingo1.start();
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                }
//
//                if (soundinput2 == 4 && !textinputsecondary.equals("HAPPY") && !textinputsecondary.equals("HAY") && !textinputsecondary.equals("PAY") && !textinputsecondary.equals("APP") ) {
//                    //play music
//                    note4.start();
//                }
//                else if (soundinput2 == 4) {
//                    bingo1.start();
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                }
//
//                if (soundinput2 == 5 && !textinputsecondary.equals("HAPPY") && !textinputsecondary.equals("HAY") && !textinputsecondary.equals("PAY") && !textinputsecondary.equals("APP") ) {
//                    //play music
//                    note5.start();
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                }
//                else if (soundinput2 == 5) {
//                    bingo1.start();
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//                }
//            }
//        });
//
//        choice4.setOnClickListener(new View.OnClickListener() {
//            String textinputsecondary;
//
//
//            @Override
//            //button Y
//            public void onClick(View view) {
//                //s:lock score for those answered [2]
//                String lockscore1 = sp.getString("lockscore1", "");
//                String lockscore2 = sp.getString("lockscore2", "");
//                String lockscore3 = sp.getString("lockscore3", "");
//                String lockscore4 = sp.getString("lockscore4", "");
//                //=
//
//
//                textinput = sp.getString("textinput", "");
//                SharedPreferences.Editor editor = sp.edit();
//                textinputsecondary = textinput + "Y";
//                editor.putString("textinput", textinputsecondary);
//                editor.apply();
//                input.setText(textinputsecondary);
//                if (textinputsecondary.equals("HAPPY") && !lockscore1.equals("1")) {
//                    textView7.setText("H");
//                    textView8.setText("A");
//                    textView9.setText("P");
//                    textView10.setText("P");
//                    textView11.setText("Y");
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//
//                    String one = "1";
//                    //s:lock score for those answered [3]
//                    editor.putString("lockscore1", one);
//                    editor.apply();
//
//                    //====
//
//                    // get score
//                    String highscore = sp.getString("highscore", "0");
//                    int Ihighscore = parseInt(highscore) + 100;
//                    String newHighScore = new Integer(Ihighscore).toString();
//
//                    editor.putString("highscore", newHighScore);
//                    editor.apply();
//
//                    String tagnewhighscore = "Score:" + " " + newHighScore;
//
//                    textView18.setText(tagnewhighscore);
//
//
//                    //
//                }
//                else if (textinputsecondary.equals("HAPPY")) {
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                }
//
//                if (textinputsecondary.equals("HAY") && !lockscore2.equals("1")) {
//                    textView11.setText("Y");
//                    textView12.setText("A");
//                    textView13.setText("H");
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//
//                    //s:lock score for those answered [4]
//                    editor.putString("lockscore2", "1");
//                    editor.apply();
//                    //====
//
//                    // get score
//                    String highscore = sp.getString("highscore", "0");
//                    int Ihighscore = parseInt(highscore) + 100;
//                    String newHighScore = new Integer(Ihighscore).toString();
//
//                    editor.putString("highscore",newHighScore);
//                    editor.apply();
//
//                    String tagnewhighscore = "Score:" + " " + newHighScore;
//
//                    textView18.setText(tagnewhighscore);
//
//
//                    //
//
//
//                }
//                else if (textinputsecondary.equals("HAY")) {
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//
//                }
//
//
//                if (textinputsecondary.equals("PAY") && !lockscore3.equals("1")) {
//                    textView10.setText("P");
//                    textView14.setText("A");
//                    textView15.setText("Y");
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//
//                    //s:lock score for those answered [5]
//                    editor.putString("lockscore3", "1");
//                    editor.apply();
//                    //====
//
//                    // get score
//                    String highscore = sp.getString("highscore", "0");
//                    int Ihighscore = parseInt(highscore) + 100;
//                    String newHighScore = new Integer(Ihighscore).toString();
//
//                    editor.putString("highscore",newHighScore);
//                    editor.apply();
//
//                    String tagnewhighscore = "Score:" + " " + newHighScore;
//
//                    textView18.setText(tagnewhighscore);
//
//
//                    //
//
//                }
//                else if (textinputsecondary.equals("PAY")) {
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//
//                }
//
//                if (textinputsecondary.equals("APP") && !lockscore4.equals("1")) {
//                    textView17.setText("A");
//                    textView16.setText("P");
//                    textView9.setText("P");
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//
//                    //s:lock score for those answered [6]
//                    editor.putString("lockscore4", "1");
//                    editor.apply();
//                    //====
//
//                    // get score
//                    String highscore = sp.getString("highscore", "0");
//                    int Ihighscore = parseInt(highscore) + 100;
//                    String newHighScore = new Integer(Ihighscore).toString();
//
//                    editor.putString("highscore",newHighScore);
//                    editor.apply();
//
//                    String tagnewhighscore = "Score:" + " " + newHighScore;
//
//                    textView18.setText(tagnewhighscore);
//
//
//                    //
//
//
//                }
//                else if (textinputsecondary.equals("APP")) {
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//
//                }
//                //E:choice button on click
//
//                String soundinput;
//                int soundinputsecondary;
//
//                //S: Ascending Sounds on click
//                soundinput = sp.getString("soundinput", "1");
//                int soundinput2 = parseInt(soundinput);
//                soundinputsecondary = soundinput2 + 1;
//                String soundinputsecondary2 = Integer.valueOf(soundinputsecondary).toString();
//
//                editor.putString("soundinput", soundinputsecondary2);
//                editor.apply();
//
//                if (soundinput2 == 1 && !textinputsecondary.equals("HAPPY") && !textinputsecondary.equals("HAY") && !textinputsecondary.equals("PAY") && !textinputsecondary.equals("APP") ) {
//                    //play music
//                    note1.start();
//                }
//                else if (soundinput2 == 1) {
//                    bingo1.start();
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                }
//
//                if (soundinput2 == 2 && !textinputsecondary.equals("HAPPY") && !textinputsecondary.equals("HAY") && !textinputsecondary.equals("PAY") && !textinputsecondary.equals("APP") ) {
//                    //play music
//                    note2.start();
//                }
//                else if (soundinput2 == 2) {
//                    bingo1.start();
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                }
//
//                if (soundinput2 == 3 && !textinputsecondary.equals("HAPPY") && !textinputsecondary.equals("HAY") && !textinputsecondary.equals("PAY") && !textinputsecondary.equals("APP") ) {
//                    //play music
//                    note3.start();
//                }
//                else if (soundinput2 == 3) {
//                    bingo1.start();
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                }
//
//                if (soundinput2 == 4 && !textinputsecondary.equals("HAPPY") && !textinputsecondary.equals("HAY") && !textinputsecondary.equals("PAY") && !textinputsecondary.equals("APP") ) {
//                    //play music
//                    note4.start();
//                }
//                else if (soundinput2 == 4) {
//                    bingo1.start();
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                }
//
//                if (soundinput2 == 5 && !textinputsecondary.equals("HAPPY") && !textinputsecondary.equals("HAY") && !textinputsecondary.equals("PAY") && !textinputsecondary.equals("APP") ) {
//                    //play music
//                    note5.start();
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//
//
//                }
//                else if (soundinput2 == 5) {
//                    bingo1.start();
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//
//                }
//            }
//        });
//
//        choice5.setOnClickListener(new View.OnClickListener() {
//            String textinputsecondary;
//
//
//            @Override
//            //button P
//            public void onClick(View view) {
//                //s:lock score for those answered [2]
//                String lockscore1 = sp.getString("lockscore1", "");
//                String lockscore2 = sp.getString("lockscore2", "");
//                String lockscore3 = sp.getString("lockscore3", "");
//                String lockscore4 = sp.getString("lockscore4", "");
//                //=
//
//                textinput = sp.getString("textinput", "");
//                SharedPreferences.Editor editor = sp.edit();
//                textinputsecondary = textinput + "P";
//                editor.putString("textinput", textinputsecondary);
//                editor.apply();
//                input.setText(textinputsecondary);
//                if (textinputsecondary.equals("HAPPY") && !lockscore1.equals("1")) {
//                    textView7.setText("H");
//                    textView8.setText("A");
//                    textView9.setText("P");
//                    textView10.setText("P");
//                    textView11.setText("Y");
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//
//                    String one = "1";
//                    //s:lock score for those answered [3]
//                    editor.putString("lockscore1", one);
//                    editor.apply();
//
//                    //====
//
//                    // get score
//                    String highscore = sp.getString("highscore", "0");
//                    int Ihighscore = parseInt(highscore) + 100;
//                    String newHighScore = new Integer(Ihighscore).toString();
//
//                    editor.putString("highscore", newHighScore);
//                    editor.apply();
//
//                    String tagnewhighscore = "Score:" + " " + newHighScore;
//
//                    textView18.setText(tagnewhighscore);
//
//
//                    //
//                }
//                else if (textinputsecondary.equals("HAPPY")) {
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                }
//
//                if (textinputsecondary.equals("HAY") && !lockscore2.equals("1")) {
//                    textView11.setText("Y");
//                    textView12.setText("A");
//                    textView13.setText("H");
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//
//                    //s:lock score for those answered [4]
//                    editor.putString("lockscore2", "1");
//                    editor.apply();
//                    //====
//
//                    // get score
//                    String highscore = sp.getString("highscore", "0");
//                    int Ihighscore = parseInt(highscore) + 100;
//                    String newHighScore = new Integer(Ihighscore).toString();
//
//                    editor.putString("highscore",newHighScore);
//                    editor.apply();
//
//                    String tagnewhighscore = "Score:" + " " + newHighScore;
//
//                    textView18.setText(tagnewhighscore);
//
//
//                    //
//
//
//                }
//                else if (textinputsecondary.equals("HAY")) {
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//
//                }
//
//
//                if (textinputsecondary.equals("PAY") && !lockscore3.equals("1")) {
//                    textView10.setText("P");
//                    textView14.setText("A");
//                    textView15.setText("Y");
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//
//                    //s:lock score for those answered [5]
//                    editor.putString("lockscore3", "1");
//                    editor.apply();
//                    //====
//
//                    // get score
//                    String highscore = sp.getString("highscore", "0");
//                    int Ihighscore = parseInt(highscore) + 100;
//                    String newHighScore = new Integer(Ihighscore).toString();
//
//                    editor.putString("highscore",newHighScore);
//                    editor.apply();
//
//                    String tagnewhighscore = "Score:" + " " + newHighScore;
//
//                    textView18.setText(tagnewhighscore);
//
//
//                    //
//
//                }
//                else if (textinputsecondary.equals("PAY")) {
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//
//                }
//
//                if (textinputsecondary.equals("APP") && !lockscore4.equals("1")) {
//                    textView17.setText("A");
//                    textView16.setText("P");
//                    textView9.setText("P");
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//
//                    //s:lock score for those answered [6]
//                    editor.putString("lockscore4", "1");
//                    editor.apply();
//                    //====
//
//                    // get score
//                    String highscore = sp.getString("highscore", "0");
//                    int Ihighscore = parseInt(highscore) + 100;
//                    String newHighScore = new Integer(Ihighscore).toString();
//
//                    editor.putString("highscore",newHighScore);
//                    editor.apply();
//
//                    String tagnewhighscore = "Score:" + " " + newHighScore;
//
//                    textView18.setText(tagnewhighscore);
//
//
//                    //
//
//
//                }
//                else if (textinputsecondary.equals("APP")) {
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//
//                }
//
//                //E:choice button on click
//
//                String soundinput;
//                int soundinputsecondary;
//
//                //S: Ascending Sounds on click
//                soundinput = sp.getString("soundinput", "1");
//                int soundinput2 = parseInt(soundinput);
//                soundinputsecondary = soundinput2 + 1;
//                String soundinputsecondary2 = Integer.valueOf(soundinputsecondary).toString();
//
//                editor.putString("soundinput", soundinputsecondary2);
//                editor.apply();
//
//                if (soundinput2 == 1 && !textinputsecondary.equals("HAPPY") && !textinputsecondary.equals("HAY") && !textinputsecondary.equals("PAY") && !textinputsecondary.equals("APP") ) {
//                    //play music
//                    note1.start();
//                }
//                else if (soundinput2 == 1) {
//                    bingo1.start();
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                }
//
//                if (soundinput2 == 2 && !textinputsecondary.equals("HAPPY") && !textinputsecondary.equals("HAY") && !textinputsecondary.equals("PAY") && !textinputsecondary.equals("APP") ) {
//                    //play music
//                    note2.start();
//                }
//                else if (soundinput2 == 2) {
//                    bingo1.start();
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                }
//
//                if (soundinput2 == 3 && !textinputsecondary.equals("HAPPY") && !textinputsecondary.equals("HAY") && !textinputsecondary.equals("PAY") && !textinputsecondary.equals("APP") ) {
//                    //play music
//                    note3.start();
//                }
//                else if (soundinput2 == 3) {
//                    bingo1.start();
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                }
//
//                if (soundinput2 == 4 && !textinputsecondary.equals("HAPPY") && !textinputsecondary.equals("HAY") && !textinputsecondary.equals("PAY") && !textinputsecondary.equals("APP") ) {
//                    //play music
//                    note4.start();
//                }
//                else if (soundinput2 == 4) {
//                    bingo1.start();
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                }
//
//                if (soundinput2 == 5 && !textinputsecondary.equals("HAPPY") && !textinputsecondary.equals("HAY") && !textinputsecondary.equals("PAY") && !textinputsecondary.equals("APP") ) {
//                    //play music
//                    note5.start();
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                }
//                else if (soundinput2 == 5) {
//                    bingo1.start();
//                    editor.putString("soundinput", "1");
//                    editor.apply();
//                    editor.putString("textinput", "");
//                    editor.apply();
//                    input.setText("");
//
//                }
//            }
//        });
//
//
//
//
//        dustbin.setOnClickListener(new View.OnClickListener() {
//            String textinputsecondary;
//
//            @Override
//            //button Dustbin
//            public void onClick(View view) {
//                textinput = "";
//                SharedPreferences.Editor editor = sp.edit();
//                textinputsecondary = textinput;
//                editor.putString("textinput", textinputsecondary);
//                editor.apply();
//                input.setText(textinputsecondary);
//
//                //s:sounds effects reset
//                editor.putString("soundinput", "1");
//                editor.apply();
//                //e:sounds effects reset
//
//            }
//        });
//
//
//    }
//
//    //full screen 3 of 3
//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        if (hasFocus) {
//            decorView.setSystemUiVisibility(hideSystemBars());
//        }
//    }
//
//    private int hideSystemBars() {
//        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
//                |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                |View.SYSTEM_UI_FLAG_FULLSCREEN
//                |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
//    }
//    //
    }
}