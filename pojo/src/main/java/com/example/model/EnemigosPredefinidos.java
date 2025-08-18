package com.example.model;
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
        heroes.add(new Personaje("Red Riot", "Rikiya Yotsubashi", Bando.HEROE, 3));
        heroes.add(new Personaje("Mirio Togata", "Lemillion", Bando.HEROE, 4));
        heroes.add(new Personaje("Enji Todoroki", "Endeavor", Bando.HEROE, 5));
    }

    public void crearVillanos() {
        villanos.add(new Personaje("Himiko Toga", "Himiko Toga", Bando.VILLANO, 3));
        villanos.add(new Personaje("Dabi", "Touya Todoroki", Bando.VILLANO, 4));
        villanos.add(new Personaje("Tomura Shigaraki", "Tenko Shimura", Bando.VILLANO, 5));

    }


    public List<Personaje> getHeroes() {
        return heroes;
    }
    public List<Personaje> getVillanos() {
        return villanos;
    }
}
