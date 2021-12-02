package com.example.durangoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    public void newGame(View view){
        crearGrupo();
    }

    public void resumeGame(View view){
        elegirGrupo();
    }

    private void crearGrupo(){
        Dialog dialogCrearGrupo = new Dialog(this);
        dialogCrearGrupo.setContentView(R.layout.dialog_crear_grupo);

        Button startBtn = (Button) dialogCrearGrupo.findViewById(R.id.dialogCrearGrupoButtonStart);
        EditText etGroup = dialogCrearGrupo.findViewById(R.id.dialogCrearGrupoEditTextGroup);

        dialogCrearGrupo.show();


        startBtn.setOnClickListener(view -> {
            String group = etGroup.getText().toString();
            if(group.equals("")){
                etGroup.setError(getString(R.string.new_group_error));
            }else{
                etGroup.setError(null );
            }
        });
    }

    private void elegirGrupo(){
        Dialog dialogElegirGrupo = new Dialog(this);
        dialogElegirGrupo.setContentView(R.layout.dialog_elegir_grupo);

        //Button startBtn = (Button) dialogElegirGrupo.findViewById(R.id.dialogCrearGrupoButtonStart);
        //EditText etGroup = dialogElegirGrupo.findViewById(R.id.dialogCrearGrupoEditTextGroup);

        dialogElegirGrupo.show();

    }
}