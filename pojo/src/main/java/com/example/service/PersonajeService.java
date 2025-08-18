package com.example.service;

import com.example.model.Personaje;
import com.example.model.Bando;
import com.example.util.Validaciones;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class PersonajeService {
    private static final int VIDAS_JUGADOR = 3; // Constante: jugador siempre inicia con 3 vidas

    public PersonajeService() { }

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

        // 2) Normalizar entradas (quitar espacios al inicio/fin)
        String nombreTrim = nombre.trim();
        String aliasTrim = alias.trim();

        // 3) Validar nombre con la util Validaciones (regex + longitud)
        if (!nombreValido(nombreTrim)) {
            throw new IllegalArgumentException("Nombre inválido. Debe tener entre 3 y 15 letras y solo contener letras, espacios o guiones.");
        }

        // 4) Validar alias: longitud mínima/máxima sencilla
        if (aliasTrim.length() < 2 || aliasTrim.length() > 20) {
            throw new IllegalArgumentException("Alias inválido. Debe tener entre 2 y 20 caracteres.");
        }

        // 5) Comprobar alias no repetido con enemigos predefinidos 
        if (aliasRepetidoConEnemigos(aliasTrim, enemigosPredefinidos)) {
            throw new IllegalArgumentException("No te copies, se original. Escoge otro alias.");
        }

        // 6) Si todo está OK, construir y devolver el Personaje con vidas iniciales
        return new Personaje(nombreTrim, aliasTrim, bando, VIDAS_JUGADOR);
    }

    // Método público que delega a la util de Validaciones
    public boolean nombreValido(String nombre) {
        return Validaciones.validarNombre(nombre);
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
