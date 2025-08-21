package com.juego.controller;

import com.juego.model.Personaje;
import com.juego.util.Validaciones;
import java.util.List;
import com.juego.service.HistoricoService;

import java.util.Scanner;
public class CombateController {

    Scanner scanner = new Scanner(System.in);
    HistoricoService HistoricoService = new HistoricoService();
   
    public int valorTirada() {
        return (int)(Math.random() * 6) + 1; // Simula un dado de 6 caras
    }

    private void esperarEnter() {
    try {
            scanner.nextLine();
        } catch (Exception ignored) {
            System.out.println("Error al esperar entrada. Asegúrate de que la entrada sea válida.");
        }
    }

    public void emparejar(Personaje personaje, List<Personaje> enemigoPredefinido){
        
        int puntosPersonaje = 0;
        int puntosEnemigo = 0;

        for(int i = 0; i < Math.min(3, enemigoPredefinido.size()); i++) { //numero de combates 
            Personaje enemigoVill = enemigoPredefinido.get(i);

            System.out.println("=== COMBATE # " + (i + 1) + " CON " + enemigoVill.getAlias().toUpperCase() + " === \n");

            System.out.println("== FICHA DEL ENEMIGO A COMBATIR ==");
            System.out.println(enemigoVill.toStringFicha());

            System.out.println("== FICHA DE TU PERSONAJE ==");
            System.out.println(personaje.toStringFicha());
   

            // variables escensiales para el combate
            int vidaEnemigo = enemigoVill.getVidas();
            int vidaPersonaje = personaje.getVidas();
            
            int[] resultadoCombate = combate(vidaPersonaje, vidaEnemigo, personaje.getAlias(), enemigoVill.getAlias());

            vidaPersonaje = resultadoCombate[0];
            vidaEnemigo = resultadoCombate[1];
            
            if(vidaEnemigo <= 0){
                puntosPersonaje += 1;
                System.out.println("El villano " + enemigoVill.getAlias() + " ha sido derrotado.");
                System.out.println("Héroe gano" + puntosPersonaje + " /3 combates \n");
                
            }else {
                puntosEnemigo += 1;
                System.out.println("El héroe " + personaje.getAlias() + " ha sido derrotado.");
                System.out.println("Villano gano " + puntosEnemigo + " /3 combates \n");
            }
            //registrar resultado del combate en el historial 

            HistoricoService.obtenerResumen();

            System.out.println("Presiona ENTER para comenzar el siguiente combate...");
            esperarEnter();
        }
    }


    public int[] combate(int vidaPersonaje, int vidaEnemigo, String alias, String aliasEnemigo ){

        if (!Validaciones.validarVida(vidaEnemigo)) {
            throw new IllegalArgumentException("El nombre no cumple con las reglas.");
        }

         if (!Validaciones.validarVida(vidaPersonaje)) {
            throw new IllegalArgumentException("El nombre no cumple con las reglas.");
        }
       

        int numeroRonda = 1;

        while(vidaPersonaje > 0 && vidaEnemigo > 0){

            int tiradaPersonaje = valorTirada();
            int tiradaEnemigo = valorTirada();

            System.out.println("=== COMIENZA EL ENFRENTAMIENTO #" + numeroRonda + " === \n");

            System.out.println("EL TURNO ES PARA " + alias.toUpperCase());
            System.out.println("TIRADA DEL " + alias.toUpperCase() + " ES: " + tiradaPersonaje + "\n");
            System.out.println("EL TURNO ES PARA " + aliasEnemigo.toUpperCase());
            System.out.println("TIRADA DEL " + aliasEnemigo.toUpperCase() + " ES: " + tiradaEnemigo + "\n");

            if(tiradaPersonaje == tiradaEnemigo){ //empate
                if(vidaEnemigo < vidaPersonaje && vidaEnemigo != 5){ // suma vida enemigo
                    System.out.println("un empate, se les sumará una vida al personajes con menos vidas");
                    vidaEnemigo++;
                }else if (vidaPersonaje < vidaEnemigo && vidaPersonaje != 5) { // suma vida personaje
                    System.out.println("un empate, se les sumará una vida al personajes con menos vidas");
                    vidaPersonaje++;
                }else {
                    System.out.println("Las vidas son iguales, no se les va a sumar vidas");
                }
            } else if(tiradaPersonaje > tiradaEnemigo){ //gana un punto el heroe
                vidaEnemigo --;
            }else { //gana un punto el villano
                vidaPersonaje--;
            }

            numeroRonda += 1;
            System.out.println("=== RESULTADO DE LA RONDA ===");


            if(tiradaPersonaje > tiradaEnemigo){
                System.out.println("GANADOR DE ESTA RONDA: " + alias.toUpperCase() + "\n");
            } else if(tiradaEnemigo > tiradaPersonaje){
                System.out.println("GANADOR DE ESTA RONDA: " + aliasEnemigo.toUpperCase() + "\n");
            } else {
                System.out.println("EMPATE EN ESTA RONDA \n");
            }


            System.out.println(alias.toUpperCase() + " tiene " + vidaPersonaje + " vidas restantes.\n");
            System.out.println(aliasEnemigo.toUpperCase() + " tiene " + vidaEnemigo + " vidas restantes.\n");
            HistoricoService.agregarEvento(alias + " tiró " + tiradaPersonaje + ", " + aliasEnemigo + " tiró " + tiradaEnemigo + "historico");

            System.out.println("=== FINALIZA ENCUENTRO === \n");
            
            if(vidaPersonaje != 0 && vidaEnemigo != 0){
                 System.out.println("Presiona ENTER para comenzar el combate...");
                esperarEnter();
            } else {
                System.out.println("=== COMBATE CON " + aliasEnemigo.toUpperCase() + " FINALIZADO ===");
            }

        }
       
        return new int[]{vidaPersonaje, vidaEnemigo};
    }
}
