package com.juego.controller;


public class CombateController {
   
    public int valorTirada() {
        return (int)(Math.random() * 6) + 1; // Simula un dado de 6 caras
    }

}


/* /* *
 * /**
     * Muestra la ficha técnica del enemigo (simple wrapper).
     * Si preferís que CombateController imprima la ficha, podés eliminar este método
     * y la llamada en iniciarPartida().
     */
    /* private void mostrarFicha(Personaje enemigo) {
        System.out.println("\n=== FICHA DEL ENEMIGO ===");
        System.out.println(enemigo.toStringFicha());
    } */

    // Mostrar ficha (puede delegarse al CombateController si prefieres)
            /* mostrarFicha(enemigo); */ 

            
 

 /**
     * Espera a que el usuario presione ENTER.
     */
    /* private void esperarEnter() {
        try {
            scanner.nextLine();
        } catch (Exception ignored) {
        }
    }
 */
    // Esperar que el usuario presione ENTER para comenzar el combate
            /* System.out.println("Presiona ENTER para comenzar el combate...");
            esperarEnter(); */
    