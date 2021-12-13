package BBDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private final String sqlCreateGrupos = "CREATE TABLE IF NOT EXISTS grupos (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT NOT NULL)";
    private final String sqlCreateActividades = "CREATE TABLE IF NOT EXISTS actividades (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT NOT NULL)";
    private final String sqlCreateGruAct = "CREATE TABLE IF NOT EXISTS gruact (id_grupo INTEGER, id_actividad INTEGER, PRIMARY KEY (id_grupo, id_actividad))";

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        crearTablas(sqLiteDatabase);
        insertActividades(sqLiteDatabase);
    }

/* Si la versión de la base de datos es más nueva, borramos las tablas y las creamos de nuevo */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if(i>i1){
            borrarTablas(sqLiteDatabase);
            crearTablas(sqLiteDatabase);
            insertActividades(sqLiteDatabase);
        }
    }

    private void crearTablas(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(sqlCreateGrupos);
        sqLiteDatabase.execSQL(sqlCreateActividades);
        sqLiteDatabase.execSQL(sqlCreateGruAct);
    }

    private void borrarTablas(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS grupos");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS actividades");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS gruact");
    }

    private void insertActividades(SQLiteDatabase sqLiteDatabase){
        for (int i = 0; i<9; i++){
            String nombre = "zona"+i;
            System.out.println(nombre);
            String sql = "INSERT INTO actividades (nombre) values ('"+nombre+"')";
            sqLiteDatabase.execSQL(sql);
        }
    }
}
