package BBDD.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import BBDD.modelo.Grupo;

public class GrupoDAO {

    public Grupo insert(SQLiteDatabase db, String nombre){
        ContentValues nuevoGrupo = new ContentValues();
        nuevoGrupo.put("nombre", nombre);
        long id = db.insert("grupos", null, nuevoGrupo);
        return new Grupo((int)id, nombre);
    }
    
}
