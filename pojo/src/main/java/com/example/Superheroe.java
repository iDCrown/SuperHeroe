package com.example;
public class Superheroe {
    private String nombre;
    private String poder;
    private String alias;
    private String ciudad;
    private String ranking;

// getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPoder() {
        return poder;
    }
    public void setPoder(String poder) {
        this.poder = poder;
    }

    public String getAlias() {
        return alias;
    }
    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRanking() {
        return ranking;
    }
    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

// métodos
    public void presentarse() {
        System.out.println("PRESENTACIÓN DEL SUPERHÉROE");
        System.out.println("Hola, soy " + nombre + ", también conocido como " + alias + ". Mi poder es " + poder + 
                           " y protejo la ciudad de " + ciudad + ". Y soy el numero " + ranking + " de mi ciudad.");
    }

    public void salvarElMundo() {
        System.out.println("SALUDO DEL SUPERHÉROE");
        System.out.println("¡Salvando el mundo con " + poder + "!");
    }

}
