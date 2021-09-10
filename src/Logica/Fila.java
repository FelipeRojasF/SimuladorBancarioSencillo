package Logica;

import java.util.ArrayList;

/**
 *
 * @author Felipe
 */
public class Fila {

    private Nodo inicio;
    private Nodo termino;
    private int numeroFila;

    public Fila() {
        inicio = null;
        termino = null;
        numeroFila = 1;

    }

    public void insertar(Persona dato) {
        Nodo i = new Nodo(dato);
        i.setNext(null);
        if (inicio == null && termino == null) {
            inicio = i;
            termino = i;
        }
        termino.setNext(i);
        termino = termino.getNext();
    }

    public Persona extraer() {
        Persona dato = inicio.getPersona();
        if (inicio != termino) {
            inicio = inicio.getNext();
        } else {
            inicio = null;
            termino = null;
        }
        return dato;
    }

    public Persona ver() {
        
        return this.inicio.getPersona();
    }

    public void remove() {
        if (inicio != termino) {
            inicio = inicio.getNext();
        } else {
            inicio = null;
            termino = null;
        }
    }

    public boolean estaVacia() {
        boolean cola = false;
        if (inicio == null & termino == null) {
            cola = true;
        } else {
            cola = false;
        }
        return cola;
    }

    public int contar() {
        int contador = 0;
        Nodo c = this.inicio;
        while (c != null) {
            contador++;
            if (c == c.getNext()) {
                break;
            } else {
                c = c.getNext();
            }
        }
        return contador;
    }

    public String toString() {
        Nodo c = this.inicio;
        String s = "";
        while (c != null) {
            s = s + c.toString();
            c = c.getNext();
        }
        return s;
    }

    public ArrayList<Persona> toArray() {
        ArrayList<Persona> respuesta = new ArrayList<>();
        Fila copia = this;
        Nodo c = copia.inicio;

        while (c != null) {
            respuesta.add(c.getPersona());
            if (c == c.getNext()) {
                break;
            } else {
                c = c.getNext();
            }
        }
        return respuesta;
    }
    
    public Persona verUltimo() {
        Persona p;
        Nodo c = this.termino;
        p = c.getPersona();
        return p;
    }

}
