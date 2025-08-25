package com.juego.service;

import java.util.List;
import java.util.Locale;
// import java.util.Objects;

import com.juego.model.Bando;
import com.juego.model.Personaje;
import com.juego.util.Validaciones;

public class PersonajeService {
    private static final int VIDAS_JUGADOR = 3; // Constante: jugador siempre inicia con 3 vidas

    /**
     * Crea y valida un Personaje.
     *
     * @param nombre                nombre real (input del usuario)
     * @param alias                 alias/ambientación del personaje
     * @param bando                 enum Bando (HEROE o VILLANO)
     * @param enemigosPredefinidos  lista de enemigos para verificar alias duplicados
     * @return Personaje válido listo para jugar
     * @throws IllegalArgumentException si cualquier validación falla
     */
    public Personaje crearPersonaje(String nombre, String alias, Bando bando, List<Personaje> enemigosPredefinidos) {
           
        // 1) Checkeo de varios Null
        if (nombre == null || alias == null || bando == null) {
            throw new IllegalArgumentException("Nombre, alias y bando son obligatorios.");
        }

       if (!Validaciones.validarNombre(nombre)) {
            throw new IllegalArgumentException("El nombre no cumple con las reglas.");
        }

        if (!Validaciones.validarAlias(alias)) {
            throw new IllegalArgumentException("El alias no cumple con las reglas.");
        }
    

        // 5) Comprobar alias no repetido con enemigos predefinidos 
        if (aliasRepetidoConEnemigos(alias, enemigosPredefinidos)) {
            throw new IllegalArgumentException("No te copies, se original. Escoge otro alias.");
        }

        // 6) Si todo está OK, construir y devolver el Personaje con vidas iniciales
        return new Personaje(nombre, alias, bando, VIDAS_JUGADOR); 
    }

    // Comprueba duplicados de alias en la lista de enemigos
    private boolean aliasRepetidoConEnemigos(String alias, List<Personaje> enemigos) {
        if (enemigos == null) return false;
        String aLower = alias.toLowerCase(Locale.ROOT);
        for (Personaje e : enemigos) {
            if (e.getAlias() != null && e.getAlias().toLowerCase(Locale.ROOT).equals(aLower)) {
                return true;
            }
        }
        return false;
    }
}
