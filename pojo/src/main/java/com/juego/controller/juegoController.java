package com.juego.controller;

import com.juego.model.Personaje;
import com.juego.model.Bando;
import com.juego.service.PersonajeService;
import com.juego.model.EnemigosPredefinidos;

import java.util.List;
import java.util.Scanner;


public class juegoController{

    private final PersonajeService personajeService;
    private final EnemigosPredefinidos enemigosPredefinidos;
    private final CombateController combateController;
    private final Scanner scanner;

    private Personaje jugador;

    public juegoController(PersonajeService personajeService, EnemigosPredefinidos enemigosPredefinidos,CombateController combateController, Scanner scanner) {
        this.personajeService = personajeService;
        this.enemigosPredefinidos = enemigosPredefinidos;
        this.combateController = combateController;
        this.scanner = scanner;
    }

    /**
     * Inicio de la partida. Aquí se maneja todo el flujo del juego.
     * El método crea al personaje haciendo las respectivas validaciones ayudandose del servicio de PersonajeService. 
     */
    public void iniciarPartida() {
        // 1) Crear personaje 
        crearPersonajeSimple();
    }

    /**
     * Crea el personaje de forma sencilla: pide bando, nombre y alias por consola,
     * intenta crear con PersonajeService. Si falla la validación, crea un personaje por defecto.
     */
    private void crearPersonajeSimple() {
        System.out.println("=== CREACION DE PERSONAJE ===");
        System.out.println("Elige tu bando: 1 = HEROE, 2 = VILLANO (cualquier otra entrada -> HEROE por defecto)");
        System.out.print("> ");
        String sel = scanner.nextLine().trim();
        Bando elegido = (sel.equals("2") || sel.equalsIgnoreCase("VILLANO") || sel.equalsIgnoreCase("V"))
                ? Bando.VILLANO
                : Bando.HEROE;

        // Lista de enemigos contrarios para la validación de alias
        List<Personaje> enemigosContrarios = (elegido == Bando.HEROE)
                ? enemigosPredefinidos.getVillanos()
                : enemigosPredefinidos.getHeroes();

        System.out.print("Nombre real: ");
        String nombre = scanner.nextLine().trim();
        System.out.print("Alias: ");
        String alias = scanner.nextLine().trim();

        try {
            this.jugador = personajeService.crearPersonaje(nombre, alias, elegido, enemigosContrarios);
            System.out.println("Personaje creado:");
            System.out.println(jugador.toStringFicha());
        } catch (IllegalArgumentException ex) {
            System.out.println("Advertencia: datos inválidos, se creará un personaje por defecto.");
            // personaje por defecto simple para no romper el flujo
            this.jugador = new Personaje("Jugador", "Player", elegido, 3);
            System.out.println(jugador.toStringFicha());
        }
    }
}