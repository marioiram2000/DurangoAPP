package BBDD.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import BBDD.modelo.Grupo;

public class GrupoDAO {

    public Grupo insert(SQLiteDatabase db, String nombre){
        ContentValues nuevoGrupo = new ContentValues();
        nuevoGrupo.put("nombre", nombre);
        long id = db.insert("grupos", null, nuevoGrupo);
        return new Grupo((int)id, nombre);
    }

    public ArrayList<Grupo> select(SQLiteDatabase db){
        ArrayList<Grupo> grupos = new ArrayList<>();
        Cursor c = db.query("grupos", null, null, null, null, null, null);
        c.moveToFirst();
        while(!c.isAfterLast()) {
            Grupo g = new Grupo(c.getInt(0), c.getString(1));
            grupos.add(g);
            c.moveToNext();
        }
        return grupos;
    }
    
}
