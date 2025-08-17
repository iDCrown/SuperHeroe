package com.example;
public class main {
    public static void main(String[] args) {
        Superheroe superheroe = new Superheroe();
        superheroe.setNombre("Clark Kent");
        superheroe.setAlias("Superman");
        superheroe.setPoder("Super fuerza y vuelo");
        superheroe.setCiudad("Metropolis");
        superheroe.setRanking("1");

        superheroe.presentarse();
        superheroe.salvarElMundo();
    }
}
