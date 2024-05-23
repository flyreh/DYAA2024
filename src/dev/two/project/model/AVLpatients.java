package dev.two.project.model;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class AVLpatients  {

    Patient raiz;

    public AVLpatients() {
        raiz = null;
    }
    public Patient getRaiz() {
        return raiz;
    }
    private Patient rotacionII(Patient n, Patient n1) {
        n.setIzdo(n1.getDcho());
        n1.setDcho(n);
        if (n1.fe == -1) {
            n.fe = 0;
            n1.fe = 0;
        } else {
            n.fe = -1;
            n1.fe = 1;
        }
        return n1;
    }

    private Patient rotacionDD(Patient n, Patient n1) {
        n.setDcho(n1.getIzdo());
        n1.setIzdo(n);
        if (n1.fe == 1) {
            n.fe = 0;
            n1.fe = 0;
        } else {
            n.fe = 1;
            n1.fe = -1;
        }
        return n1;
    }

    private Patient rotacionID(Patient n, Patient n1) {
        Patient n2;
        n2 = (Patient) n1.getDcho();
        n.setIzdo(n2.getDcho());
        n2.setDcho(n);
        n1.setDcho(n2.getIzdo());
        n2.setIzdo(n1);
        if (n2.fe == -1) {
            n.fe = 1;
            n1.fe = 0;
        } else if (n2.fe == 0) {
            n.fe = 0;
            n1.fe = 0;
        } else if (n2.fe == 1) {
            n.fe = 0;
            n1.fe = -1;
        }
        n2.fe = 0;
        return n2;
    }

    private Patient rotacionDI(Patient n, Patient n1) {
        Patient n2;
        n2 = (Patient) n1.getIzdo();
        n.setDcho(n2.getIzdo());
        n2.setIzdo(n);
        n1.setIzdo(n2.getDcho());
        n2.setDcho(n1);
        if (n2.fe == -1) {
            n.fe = 0;
            n1.fe = 1;
        } else if (n2.fe == 0) {
            n.fe = 0;
            n1.fe = 0;
        } else if (n2.fe == 1) {
            n.fe = -1;
            n1.fe = 0;
        }
        n2.fe = 0;
        return n2;
    }
    public void insertar(Patient paciente) throws Exception {
        Patient newpatient = paciente ;
        Boolean flag = false;
        raiz = insertarAVL(raiz, newpatient, flag);
    }
    private Patient insertarAVL(Patient raiz, Patient newpatient, Boolean flag) throws Exception {
        Patient n1;
        if (raiz == null) {
            raiz = newpatient;
            flag = true;
        } else if (newpatient.getId() < raiz.getId()) {
            Patient iz;
            iz = insertarAVL((Patient) raiz.getIzdo(), newpatient, flag);
            raiz.setIzdo(iz);
            if (flag) {
                switch (raiz.fe) {
                    case 1:
                        raiz.fe = 0;
                        flag = false;
                        break;
                    case 0:
                        raiz.fe = -1;
                        break;
                    case -1:
                        n1 = (Patient) raiz.getIzdo();
                        if (n1.fe == -1) {
                            raiz = rotacionII(raiz, n1);
                        } else {
                            raiz = rotacionID(raiz, n1);
                        }
                        flag = false;
                }
            }
        } else if (newpatient.getId() > raiz.getId()) {
            Patient dr;
            dr = insertarAVL((Patient) raiz.getDcho(), newpatient, flag);
            raiz.setDcho(dr);
            if (flag) {
                switch (raiz.fe) {
                    case 1:
                        n1 = (Patient) raiz.getDcho();
                        if (n1.fe == 1) {
                            raiz = rotacionDD(raiz, n1);
                        } else {
                            raiz = rotacionDI(raiz, n1);
                        }
                        flag = false;
                        break;
                    case 0:
                        raiz.fe = 1;
                        break;
                    case -1:
                        raiz.fe = 0;
                        flag = false;
                }
            }
        } else {
            throw new Exception("Clave duplicada");
        }
        return raiz;
    }
    public void eliminar(Patient existingpatient) throws Exception {
        Patient patient = (Patient) existingpatient;
        Boolean flag = false;
        raiz = eliminarAVL(raiz, patient, flag);
    }

    private Patient eliminarAVL(Patient r, Patient patient, Boolean cambiaAltura) throws Exception {
        if (r == null) {
            throw new Exception(" Nodo no encontrado ");
        } else if (patient.getId() < r.getId()){
            Patient iz;
            iz = eliminarAVL((Patient) r.getIzdo(), patient, cambiaAltura);
            r.setIzdo(iz);
            if (cambiaAltura) {
                r = equilibrar1(r, cambiaAltura);
            }
        } else if (patient.getId() > r.getId()){
            Patient dr;
            dr = eliminarAVL((Patient) r.getDcho(), patient, cambiaAltura);
            r.setDcho(dr);
            if (cambiaAltura) {
                r = equilibrar2(r, cambiaAltura);
            }
        } else {
            Patient q;
            q = r;
            if (q.getIzdo() == null) {
                r = (Patient) q.getDcho();
                cambiaAltura = true;
            } else if (q.getDcho() == null) {
                r = (Patient) q.getIzdo();
                cambiaAltura = true;
            } else {
                Patient iz;
                iz = reemplazar(r, (Patient) r.getIzdo(), cambiaAltura);
                r.setIzdo(iz);
                if (cambiaAltura) {
                    r = equilibrar1(r, cambiaAltura);
                }
            }
            q = null;
        }
        return r;
    }

    private Patient reemplazar(Patient n, Patient act, Boolean cambiaAltura) {
        if (act.getDcho() != null) {
            Patient d;
            d = reemplazar(n, (Patient) act.getDcho(), cambiaAltura);
            act.setDcho(d);
            if (cambiaAltura)
                act = equilibrar2(act, cambiaAltura);
        } else {
           // n.setDato(act.getDato());
            n = act;
            act = (Patient) act.getIzdo();
            n = null;
            cambiaAltura = true;
        }
        return act;
    }


    private Patient equilibrar1(Patient n, Boolean cambiaAltura) {
        Patient n1;
        switch (n.fe) {
            case -1:
                n.fe = 0;
                break;
            case 0:
                n.fe = 1;
                cambiaAltura = false;
                break;
            case 1:
                n1 = (Patient) n.getDcho();
                if (n1.fe >= 0) {
                    if (n1.fe == 0) {
                        cambiaAltura = false;
                    }
                    n = this.rotacionDD(n, n1);
                } else
                    n = this.rotacionDI(n, n1);
                break;
        }
        return n;
    }

    private Patient equilibrar2(Patient n, Boolean cambiaAltura) {
        Patient n1;
        switch (n.fe) {
            case 1:
                n.fe = 0;
                break;
            case 0:
                n.fe = -1;
                cambiaAltura = false;
                break;
            case -1:
                n1 = (Patient) n.getIzdo();
                if (n1.fe <= 0) {
                    if (n1.fe == 0) cambiaAltura = false;
                    n = this.rotacionII(n, n1);
                } else
                    n = this.rotacionID(n, n1);
                break;
        }
        return n;
    }

    public  void posorden(Patient r){
        if(r!=null){
            posorden((Patient) r.getIzdo());
            posorden((Patient) r.getDcho());
            System.out.print( r.getFirstname() +", ");
        }
    }

    public  void preorden(Patient r){
        if(r!=null){
            System.out.print(r.getFirstname()+", ");
            preorden((Patient) r.getIzdo());
            preorden((Patient) r.getDcho());
        }
    }
    public  void inorden(Patient r){
        if(r!=null){
            inorden((Patient) r.getIzdo());
            System.out.print(r.getFirstname() + r.getId() + ", ");
            inorden((Patient) r.getDcho());
        }
    }
    public Patient searchPatient(int id){
        boolean encontrado=false;
        Patient raizpatient = raiz;

        while(!encontrado && raizpatient!=null){
            if(id == raizpatient.getId()) encontrado=true;
            else if(id < raizpatient.getId()) raizpatient = (Patient) raizpatient.getIzdo();
            else raizpatient = (Patient) raizpatient.getDcho();
        }
        return raizpatient;
    }


}
