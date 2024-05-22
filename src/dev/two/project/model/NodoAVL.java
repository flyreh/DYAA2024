package dev.two.project.model;

public class NodoAVL {

    protected NodoAVL izdo;
    protected NodoAVL dcho;
    public int fe;

    public NodoAVL() {
        izdo= null;
        dcho=null;
        fe=0;
    }

    public NodoAVL(NodoAVL izdo, NodoAVL dcho) {
        this.izdo = izdo;
        this.dcho = dcho;
    }

    public NodoAVL getIzdo() {
        return izdo;
    }
    public void setIzdo(NodoAVL izdo) {
        this.izdo = izdo;
    }
    public NodoAVL getDcho() {
        return dcho;
    }
    public void setDcho(NodoAVL dcho) {
        this.dcho = dcho;
    }

}
