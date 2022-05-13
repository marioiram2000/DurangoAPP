package com.example.durangoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

import BBDD.DBHelper;
import BBDD.dao.GrupoDAO;
import BBDD.modelo.Actividad;
import BBDD.modelo.Grupo;

//Actividad principal
public class MainActivity extends AppCompatActivity {

    public static Grupo GRUPO;
    public static Actividad ACTIVIDAD = null;
    private SQLiteDatabase db;

    //Las acciónes que queremos que se ejecuten cuando se inicia la actividad
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Abrimos la base de datos
        DBHelper dbh = new DBHelper(this, "durangoDB", null, 1);
        db = dbh.getWritableDatabase();

        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        //Boton para modo desarrollador
        Button test = (Button) findViewById(R.id.test);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Desarrollo.class);
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

    //Función que crea un nuevo grupo y lo añade a la base de datos
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
                GRUPO = new GrupoDAO().insert(db, group);
                dialogCrearGrupo.hide();
                startZona0();
            }
        });
    }

    //Función que abre un desplegable con los grupos de la base de datos para que podamos continuar con un grupo
    private void elegirGrupo() {
        Dialog dialogElegirGrupo = new Dialog(this);
        dialogElegirGrupo.setContentView(R.layout.dialog_elegir_grupo);

        int width = (int)(getResources().getDisplayMetrics().widthPixels*0.90);

        dialogElegirGrupo.getWindow().setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT);

        dialogElegirGrupo.show();

        Button startBtn = (Button) dialogElegirGrupo.findViewById(R.id.DialogElegirGrupoButton);
        EditText etGroup = dialogElegirGrupo.findViewById(R.id.dialogCrearGrupoEditTextGroup);
        Spinner spinnerGrupos = dialogElegirGrupo.findViewById(R.id.DialogElegirGrupoSpinner);

        List<Grupo> grupos = new GrupoDAO().select(db);
        ArrayAdapter<Grupo> adaptador = new ArrayAdapter<Grupo>(this, android.R.layout.simple_spinner_item, grupos);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGrupos.setAdapter(adaptador);

        startBtn.setOnClickListener(view -> {
            GRUPO = (Grupo) spinnerGrupos.getSelectedItem();
            if(GRUPO!=null){
                dialogElegirGrupo.hide();
                startZona0();
            }
        });
    }

    //Función para iniciar la actividad de la zona 0
    private void startZona0(){
        Intent intent = new Intent(MainActivity.this, Zona0_1.class);
        startActivity(intent);
        finish();
    }




}