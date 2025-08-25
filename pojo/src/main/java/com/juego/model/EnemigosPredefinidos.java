package com.juego.model;
import java.util.List;
import java.util.ArrayList;

public class EnemigosPredefinidos {
    
    private List<Personaje> villanos;
    private List<Personaje> heroes;

    public EnemigosPredefinidos(){
        heroes = new ArrayList<>();
        villanos = new ArrayList<>();
        crearHeroes();
        crearVillanos();
    }

    public void crearHeroes() {
        heroes.add(new Personaje("Rikiya Yotsubashi", "Red Riot", Bando.HEROE, 3));
        heroes.add(new Personaje("Mirio Togata", "Lemillion", Bando.HEROE, 4));
        heroes.add(new Personaje("Enji Todoroki", "Endeavor", Bando.HEROE, 5));
    }

    public void crearVillanos() {
        villanos.add(new Personaje("Himiko Toga", "Himiko Toga", Bando.VILLANO, 3));
        villanos.add(new Personaje("Touya Todoroki", " Dabi", Bando.VILLANO, 4));
        villanos.add(new Personaje("Tenko Shimura", " Tomura Shigaraki", Bando.VILLANO, 5));

    }


    public List<Personaje> getHeroes() {
        return heroes;
    }
    public List<Personaje> getVillanos() {
        return villanos;
    }
}
