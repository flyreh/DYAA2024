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
}
