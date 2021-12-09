package com.example.durangoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import BBDD.DBHelper;


public class MainActivity extends AppCompatActivity {

    private Button pruebas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);




        pruebas = (Button) findViewById(R.id.btnPruebas);

        pruebas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, zona0_1.class);
                startActivity(intent);
            }
        });
    }



    public void newGame(View view) {
        crearGrupo();
    }

    public void resumeGame(View view) {
        elegirGrupo();
    }

    private void crearGrupo() {
        Dialog dialogCrearGrupo = new Dialog(this);
        dialogCrearGrupo.setContentView(R.layout.dialog_crear_grupo);

        Button startBtn = (Button) dialogCrearGrupo.findViewById(R.id.dialogCrearGrupoButtonStart);
        EditText etGroup = dialogCrearGrupo.findViewById(R.id.dialogCrearGrupoEditTextGroup);

        dialogCrearGrupo.show();

        startBtn.setOnClickListener(view -> {
            String group = etGroup.getText().toString();
            if (group.equals("")) {
                etGroup.setError(getString(R.string.new_group_error));
            } else {
                etGroup.setError(null);
                //crearConfigGrupo(group);
            }
        });
    }

    private void elegirGrupo() {
        Dialog dialogElegirGrupo = new Dialog(this);
        dialogElegirGrupo.setContentView(R.layout.dialog_elegir_grupo);

        //Button startBtn = (Button) dialogElegirGrupo.findViewById(R.id.dialogCrearGrupoButtonStart);
        //EditText etGroup = dialogElegirGrupo.findViewById(R.id.dialogCrearGrupoEditTextGroup);

        dialogElegirGrupo.show();
    }

    private void crearConfigGrupo(String grupo) {
        try {
            FileOutputStream fos = null;
            File f = new File("../assets/" + grupo + ".properties");
            if(f.createNewFile()) {
                fos = new FileOutputStream(f);

                ArrayList<String> properties = readMainProperties();
                if (properties != null) {
                    for (String property : properties) {
                        fos.write(property.getBytes(StandardCharsets.UTF_8));
                    }
                    fos.flush();
                    fos.close();
                }
            }else{
                Log.d("crearConfigGrupo: ", "El fichero ya existe");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private ArrayList<String> readMainProperties() {
        try {

            File fp = new File("DurangoAPP/app/src/main/assets/mainProperties.properties");
            FileReader fr = null;
            fr = new FileReader(fp);
            BufferedReader br = new BufferedReader(fr);
            ArrayList<String> lines = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            fr.close();
            return lines;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}