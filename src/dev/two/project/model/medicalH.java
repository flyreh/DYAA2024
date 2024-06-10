package dev.two.project.model;

import java.io.Serializable;

public class medicalH implements Serializable {
    private Appointment cabeza;


    public medicalH(){
        this.cabeza = null;
    }
    public Appointment getCabeza() {
        return cabeza;
    }
    public void eliminarInicio(){
        if(cabeza == null){
            System.out.println("la lista está vacía, paciente : " + cabeza.getPatient().getFirstname());
            return ;
        }
        cabeza = (Appointment) cabeza.next;

    }
    public void eliminarFinal(){
        if(cabeza == null){
            System.out.println("La lista se encuentra vacía");
            return;
        }
        Appointment nodoActual = cabeza;
        while(nodoActual.next.next != null){
            nodoActual = (Appointment) nodoActual.next;
        }
        nodoActual.next = null;
    }
    public void eliminarPorPosicion(int posicion){
        int tamaño = TamañoLista();
        if(posicion>=0 && posicion< tamaño){
            if(cabeza ==null){
                System.out.println("La lista está vacía");
                return;
            }else{
                if (posicion == 0) {
                    cabeza =  (Appointment) cabeza.next;
                } else {
                    Nodo actual = cabeza;
                    for (int i = 0; i < posicion - 1 && actual.next != null; i++) {
                        actual = actual.next;
                    }
                    if (actual.next != null) {
                        actual.next = actual.next.next;
                    }
                }

            }
        }else{
            System.out.println("Posicion ingresada fuera de los límites de la lista");
        }
    }

    public int TamañoLista(){
        int tamaño = 0;
        Appointment nodoConteo = cabeza;
        while(nodoConteo != null){
            nodoConteo = (Appointment) nodoConteo.next;
            tamaño++;
        }
        return tamaño;
    }

    public void InsertarInicio(Appointment cita){
        cita.next = cabeza;
        cabeza = cita;
    }

    public void insertadespues(Appointment nodoprevio, Appointment nuevodato){
        if(nodoprevio==null) {
            System.out.println("nodo previo no puede ser null");
            return;
        }
        Appointment nuevonodo= nuevodato;
        nuevonodo.next = nodoprevio.next;
        nodoprevio.next=nuevonodo;
    }

    public void InsertarFinal(Appointment nuevodato){
        Appointment nuevonodo= nuevodato;
        if(cabeza==null){
            cabeza = nuevonodo;
            return ;
        }
        Appointment ultimo = cabeza;
        while (ultimo.next!=null){
            ultimo = (Appointment) ultimo.next;
        }
        ultimo.next = nuevonodo;
    }
    public void imprime(){
        Appointment n=cabeza;
        while(n!=null){
            System.out.print(n.getDoctor().getFirstname()+" ");
            n= (Appointment) n.next;
        }
        System.out.println();
    }

    public medicalH copy() {
        medicalH copy = new medicalH();
        Appointment current = this.cabeza;
        while (current != null) {
            Appointment newNode = new Appointment(current.getId(), current.getInitialdescription(), current.getCreationTimeDay(), current.getCreationTime(), current.getDoctor(), current.getPatient());
            newNode.setDoctordescription(current.getDoctordescription());
            newNode.setCreationAttention(current.getCreationAttention());
            newNode.setCreationAttentionDay(current.getCreationAttentionDay());
            copy.InsertarFinal(newNode);
            current = (Appointment) current.next;
        }
        return copy;
    }
    // Método para ordenar la lista enlazada con merge sort
    public Appointment mergeSort(Appointment head) {
        if (head == null || head.next == null) {
            return head;
        }

        Appointment middle = getMiddle(head);
        Appointment nextOfMiddle = (Appointment) middle.next;

        middle.next = null;

        Appointment left = mergeSort(head);
        Appointment right = mergeSort(nextOfMiddle);

        Appointment sortedList = sortedMerge(left, right);
        return sortedList;
    }
    // Método para obtener el nodo medio de la lista enlazada
    public Appointment getMiddle(Appointment head) {
        if (head == null) {
            return head;
        }

        Appointment slow = head, fast = (Appointment) head.next;

        while (fast != null) {
            fast = (Appointment) fast.next;
            if (fast != null) {
                slow = (Appointment) slow.next;
                fast = (Appointment) fast.next;
            }
        }
        return slow;
    }
    // Método para fusionar dos listas enlazadas ordenadas
    public Appointment sortedMerge(Appointment a, Appointment b) {
        Appointment result = null;
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        // Aquí debes cambiar la condición de comparación según tu criterio de ordenamiento
        if (a.getDoctor().getLastName().compareTo(b.getDoctor().getLastName()) <= 0) {
            result = a;
            result.next = sortedMerge((Appointment) a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, (Appointment) b.next);
        }
        return result;
    }
}
