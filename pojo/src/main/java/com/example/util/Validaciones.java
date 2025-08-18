package com.example.util;

import java.util.regex.Pattern;

public class Validaciones {

    // Nombre: solo letras (unicode), espacios y guion. Longitud 3..20
    private static final Pattern NOMBRE_PATTERN = Pattern.compile("^[\\p{L}\\s\\-]{3,20}$");

    // Alias: letras (unicode), dígitos, espacios, guion y underscore. Longitud 1..20
    private static final Pattern ALIAS_PATTERN  = Pattern.compile("^[\\p{L}0-9\\s\\-_]{1,20}$");



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
        if (nombre == null) return false;
        String t = nombre.trim();
        if (t.length() < 3 || t.length() > 20) return false;
        return NOMBRE_PATTERN.matcher(t).matches();
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
        if (alias == null) return false;
        String t = alias.trim();
        if (t.isEmpty()) return false;
        if (t.length() < 1 || t.length() > 20) return false;
        return ALIAS_PATTERN.matcher(t).matches();
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
