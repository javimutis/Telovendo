package com.example.telovendo.model;

public class Flores {
    private String nombre;
    private int foto;

    public Flores(){

    }
    public Flores(String nombre, int foto){
        this.nombre = nombre;
        this.foto = foto;
    }
    public String getNombre(){ return nombre;}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getFoto() { return foto;}

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
