package com.example.model;

public  class Personaje {

    //Atributos principales de cada personaje (Héroe o Villano)
    private String nombre;
    private String alias;
    private Bando bando; //Enum para la selección del bando del personaje
    private int vidas;

    //Constructor
    public Personaje(){
        this.nombre = "Anonimo";
        this.alias ="Anonimo";
        this.bando = null;
        this.vidas = 3;
    }
    public Personaje(String nombre, String alias, Bando bando, int vidas){
        this.nombre = nombre;
        this.alias =alias;
        this.bando = bando;
        this.vidas = vidas;
    }

    // getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Bando getBando() {
        return bando;
    }

    public void setBando(Bando bando) {
        this.bando = bando;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    // Métodos de lógica básica
    public void perderVida() {
        if (vidas > 0) {
            vidas--;
        }
    }

    public void ganarVida() {
        vidas++;
    }

    public String toStringFicha() {
        return "=== FICHA DEL PERSONAJE ===\n" +
               "Nombre: " + nombre + "\n" +
               "Alias: " + alias + "\n" +
               "Bando: " + bando + "\n" +
               "Vidas: " + vidas + "\n";
    }

}
