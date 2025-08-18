package com.example.util;

public class Validaciones {
    /**
     * Valida que el nombre del personaje cumpla con las reglas:
     * - No puede ser nulo
     * - Debe contener solo letras y espacios
     * - Debe tener una longitud entre 2 y 20 caracteres
     * 
     * @param nombre El nombre a validar
     * @return true si es válido, false en caso contrario
     */
    public static boolean validarNombre(String nombre) {
        return nombre != null && 
        nombre.trim().matches("[a-zA-Z1-9À-ÖØ-öø-ÿ]+.?(( |-)[a-zA-Z1-9À-ÖØ-öø-ÿ]+.?)*") && 
        nombre.length() >= 2 &&
        nombre.length() <= 20;
    }
    /**
     * Valida que el alias del personaje cumpla con las reglas:
     * - No puede ser nulo
     * - Debe contener solo letras y espacios
     * - Debe tener una longitud entre 1 y 20 caracteres
     * 
     * @param alias El alias a validar
     * @return true si es válido, false en caso contrario
     */
    public static boolean validarAlias(String alias) {
        return alias != null && 
        alias.trim().matches("[a-zA-Z1-9À-ÖØ-öø-ÿ]+.?(( |-)[a-zA-Z1-9À-ÖØ-öø-ÿ]+.?)*") && 
        alias.isEmpty() && 
        alias.length() >= 1 &&
        alias.length() <= 20;
    }

    /**
     * valida que el número de vidas del personaje sea válido:
     * - Debe ser un número entero positivo
     * - Debe estar entre 1 y 5
     * @param vidas El numero de vidas a validar
     * @return true si es válido, false en caso contrario
     */
    public static boolean validarVida(int vidas) {
        return vidas > 0 && vidas <= 5;
    }
        

}
