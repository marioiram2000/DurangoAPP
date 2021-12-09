package BBDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS grupos (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT NOT NULL" +
                ")");
        sqLiteDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS actividades (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT NOT NULL" +
                ")"
        );
        sqLiteDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS gruact (" +
                "id_grupo INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "id_actividad INTEGER PRIMARY KEY AUTOINCREMENT" +
                ")"
        );

        ContentValues values = new ContentValues();
        values.put("nombre", "zona0");
        values.put("nombre", "zona1");
        values.put("nombre", "zona2");
        values.put("nombre", "zona3");
        values.put("nombre", "zona4");
        values.put("nombre", "zona5");
        values.put("nombre", "zona6");
        values.put("nombre", "zona7");
        values.put("nombre", "zona8");

        sqLiteDatabase.insert("actividades", null, values);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
