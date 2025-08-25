package com.juego.service;

// import com.juego.model.EnemigosPredefinidos;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class HistoricoService {
    //Variable de tipo String para poder crear una estructura de datos interna que guarde los eventos.
    private final List<String> eventos;

    //Se inicializa el constructor con una instancia
    public HistoricoService(){
        this.eventos = new ArrayList<>();
     }

     /**
      * Se valida primero que el parámetro "evento" no este vacío y con esa condición cumplida, se borran los espacios que pueda tener ese  evento en algún momento, tanto en el inicio como en el final. Luego, se almacena en la variable t.
      
      Posteriormente, se valida si la cadena quedó vacía para ignorarla y no guardarla. si no es así, entonces añade la cadena t al final de la lista.
      * @param evento
      */
    public void agregarEvento(String evento){
        if(evento == null) return;
        String t = evento.trim();

        if(t.isEmpty()) return;
        this.eventos.add(t);
    }


    public String obtenerResumen(){

        //El método inicia con una validación de la lista de eventos, si esta vacía, entonces imprimirá un mensaje diciendo que no hay eventos registrados. Por el contrario, si no esta vacía, entonces con la clase StringJoiner construye la cadena a partir de todos los eventos de cada ronda con un separador el cual es el salto de línea.
        if(eventos.isEmpty()){
            return "Es hora de escríbir una nueva historia";
        }
        StringJoiner sj = new StringJoiner("\n");
        

        //Finalmente, el método recorre la lista en orden y se va añadiendo cada evento al StringJoiner, colocando automaticamente el salto de línea que es el separador y devuelve el string construido.
        for (String e : eventos) {
            sj.add(e);
        }

        String resultado = sj.toString();
        eventos.clear();
        return resultado;
    }
}
