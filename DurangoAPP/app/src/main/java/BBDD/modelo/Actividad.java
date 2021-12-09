package BBDD.modelo;

import androidx.annotation.NonNull;

public class Actividad {

    private int id;
    private String nombre;

    public Actividad() {
    }

    public Actividad(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @NonNull
    @Override
    public String toString() {
        return "Actividad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
