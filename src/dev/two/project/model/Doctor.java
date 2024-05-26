package dev.two.project.model;

public class Doctor extends NodoAVL {
    private int id;
    private String firstName;

    public Doctor() {
        super();
    }

    public int getId(){
        return id;
    }
    public String getFirstname(){
        return firstName;
    }

}
