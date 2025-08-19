package com.juego.model;

public enum Bando {
    //Bandos disponibles para el juego
    HEROE,
    VILLANO;

    //Método estatico público con el que se puede llamar al bando sin la necesidad de crear una instancia. Esto convierte el texto a enum.
    public static Bando fromInput(String input){

        //Si lo que se paso dentro del input fue un null o un valor vacio, entonces no retorna un NullPointerException, sino efectivamente "null".
        if (input == null) return null;

        //Aquí trim() sirve para eliminar los espacios al inicio y al final en el input. Por otro lado, toUpperCase() convierte todo el texto escrito a mayuscula, que es como estan declarados los valores del enum.

        String s = input.trim().toUpperCase();

        // aceptar "1"/"2" como HEROE o VILLANO. También, si el usuario desea escribir la palabra, lo reconoce como elección. Retorna un héroe o un villano.

        if (s.equals("1") || s.equals("HEROE") || s.equals("HÉROE")) {
            return HEROE;
        }
        if (s.equals("2") || s.equals("VILLANO")) {
            return VILLANO;
        }
        //Con esto se intenta normalizar acentos como HÉROE o HEROÉ para que lo covierta al valor del enum "HÉROE -> HEROE". Sino lo hace, atrapa la excepción y retorna null.
        try {
            return Bando.valueOf(s.replace("É","E"));
        } catch (IllegalArgumentException e) {
            return null; // input inválido, se maneja en PersonajeService
        }
    }
}
