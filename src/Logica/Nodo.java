package Logica;

/**
 *
 * @author Felipe
 */
public class Nodo {

    private Persona persona;
    private Nodo next;

    public Nodo(Persona persona) {
        this.persona = persona;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
    
    public String toString() {
        String s = " " + persona + " ";
        return s;
    }
}
