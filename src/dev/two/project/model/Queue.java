package dev.two.project.model;

public class Queue {

    private Nodo first;
    private Nodo last;
    private int size;

    public Queue() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public void add(Appointment appointment) {
        if (isEmpty()) {
            this.first = appointment;
            this.last = appointment;
        } else {
            this.last.setNext(appointment);
            this.last = appointment;
        }
        this.last.setNext(this.first);
        this.size++;
    }

    public void remove() {
        if (isEmpty()) {
            return;
        }
        if (first == last) {
            this.first = null;
            this.last = null;
            this.size = 0;
            return;
        }
        this.first = this.first.getNext();
        this.last.setNext(this.first);
        this.size--;
    }

    public Nodo getFirst() {
        if (isEmpty()) {
            return null;
        }
        return this.first;
    }

    public Nodo getLast() {
        if (isEmpty()) {
            return null;
        }
        return this.last;
    }

    public int getSize() {
        return this.size;
    }

    public void clear() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }


    public Nodo get(int index) {
        if (index < 0 || index >= this.size) {
            return null;
        }
        Nodo current = this.first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    public void moveFirstToEnd() {
        if (isEmpty() || first == last) {
            return;
        }
        this.last.setNext(this.first);
        this.first = this.first.getNext();
        this.last = this.last.getNext();
        this.last.setNext(this.first);
    }

    public void removeById(int id) {
        if (isEmpty()) {
            return;
        }

        // Si el primer nodo tiene el ID buscado
        if (((Appointment)first).getId() == id) {
            if (first == last) {
                this.first = null;
                this.last = null;
                this.size = 0;
            } else {
                this.first = this.first.getNext();
                this.last.setNext(this.first); // El último nodo apunta al nuevo primer nodo
                this.size--;
            }
            return;
        }

        // Buscar el nodo con el ID en el resto de la cola
        Nodo current = first;
        while (current.getNext() != first && ((Appointment)current.getNext()).getId() != id) {
            current = current.getNext();
        }

        // Si se encontró el nodo con el ID
        if (current.getNext() != first) {
            current.setNext(current.getNext().getNext());
            if (current.getNext() == first) {
                last = current;
            }
            size--;
        }
    }

}
