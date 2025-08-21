package com.juego;
import java.util.Arrays;
import java.util.List;

import com.juego.model.Bando;
import com.juego.model.EnemigosPredefinidos;
import com.juego.model.Personaje;
import com.juego.service.HistoricoService;
import com.juego.service.PersonajeService;

public class main{
    public static void main(String[] args) {
        HistoricoService historico = new HistoricoService();

        // 1) Añadir eventos uno a uno (simulan rondas)
        historico.agregarEvento("Ronda 1 - [Tomura] - J:4 vs E:3 -> Enemigo pierde 1 vida (J=3 / E=2)");
        historico.agregarEvento("Ronda 2 - [Tomura] - J:2 vs E:2 -> Empate; Jugador recupera 1 (J=3 / E=2)");

        // 2) Añadir varios eventos simulando sub-eventos (añadiéndolos con un loop)
        List<String> batch = Arrays.asList(
            "Subevento A: efecto pasivo activado",
            "Subevento B: daño residual",
            "Fin de la ronda 2"
        );
        for (String e : batch) {
            historico.agregarEvento(e);
        }

        // 3) Imprimir resumen (esto además limpia la lista internamente)
        System.out.println("=== RESUMEN (PRIMER COMBATE) ===");
        System.out.println(historico.obtenerResumen());

        // 4) Comprobación: si pedimos el resumen otra vez, debe decir que no hay eventos
        String resumen = historico.obtenerResumen();
            if (!resumen.isEmpty()) {
    System.out.println("=== RESUMEN DEL COMBATE ===");
    System.out.println(resumen);
    // si querés, pedís al usuario que presione Enter para continuar
}

        // 5) Añadimos eventos del segundo combate y probamos de nuevo
        historico.agregarEvento("Ronda 1 (combate 2) - [Dabi] - J:6 vs E:1 -> Enemigo pierde 1 vida (J=3 / E=2)");
        System.out.println("\n=== RESUMEN (SEGUNDO COMBATE) ===");
        System.out.println(historico.obtenerResumen());
    }
}
