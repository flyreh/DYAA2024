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
        this.size++;
    }

    public void remove() {
        if (isEmpty()) {
            return;
        }
        if(first == last){
            this.first = null;
            this.last = null;
            this.size = 0;
            return;
        }
        this.first = this.first.getNext();
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

}
