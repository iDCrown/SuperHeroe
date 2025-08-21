package com.juego.controller;

import com.juego.model.Personaje;
import com.juego.model.Bando;
import com.juego.service.PersonajeService;
import com.juego.model.EnemigosPredefinidos;

import java.util.List;
import java.util.Scanner;


public class juegoController{

    private Scanner scanner = new Scanner(System.in);
    private EnemigosPredefinidos enemigosPredefinidos = new EnemigosPredefinidos();
    private PersonajeService personajeService = new PersonajeService();
    private CombateController combateController = new CombateController();

    private Personaje jugador;


    public void ejecutarJuego(){
        System.out.println("=== BIENVENIDO AL JUEGO === \n");
        
        // 1. Creación del personaje
        System.out.println("=== CREACION DE PERSONAJE === \n");
        System.out.println("Elige tu bando: 1 = HEROE, 2 = VILLANO (cualquier otra entrada -> HEROE por defecto)");
        System.out.print("> ");
        String sel = scanner.nextLine().trim(); // Valor por defecto

        System.out.print("Nombre real: ");
        String nombre = scanner.nextLine().trim();

        System.out.print("Alias: ");
        String alias = scanner.nextLine().trim();

        // Crear personaje con los datos proporcionados
        crearPersonajeSimple(nombre, alias, sel);

        // 2. Iniciar combate
        System.out.println("=== INICIO DEL COMBATE === \n");
        iniciarCombate();

    }


    private void crearPersonajeSimple(String nombre, String alias, String sel) {
        Bando elegido = Bando.fromInput(sel);

        // Lista de enemigos contrarios para la validación de alias
        List<Personaje> enemigosSeleccionados = (elegido == Bando.HEROE)
                ? enemigosPredefinidos.getVillanos()
                : enemigosPredefinidos.getHeroes();


        try {       
            this.jugador = personajeService.crearPersonaje(nombre, alias, elegido, enemigosSeleccionados);

            System.out.println("\n");
            System.out.println("=== PERSONAJE CREADO ===");
            System.out.println("\n");

        } catch (IllegalArgumentException ex) {
            System.out.println("Advertencia: datos inválidos.");
        }
    }


     public void iniciarCombate() {
        List<Personaje> rivales = jugador.getBando() == Bando.HEROE 
            ? enemigosPredefinidos.getVillanos() 
            : enemigosPredefinidos.getHeroes();
        if (rivales.isEmpty()) {
            System.out.println("No hay enemigos disponibles para combatir.");
            return;
        }

        this.combateController.emparejar(jugador, rivales);
    }
} 