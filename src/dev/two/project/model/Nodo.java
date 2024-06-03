package dev.two.project.model;

import java.io.Serializable;

public class Nodo implements Serializable {

    public Nodo next;

    public Nodo() {
        this.next = null;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

}
