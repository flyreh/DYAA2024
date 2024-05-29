package dev.two.project.model;

public class AVLOfta {
    Doctor raiz;

    public AVLOfta() {
        raiz = null;
    }
    public Doctor getRaiz() {
        return raiz;
    }
    private Doctor rotacionII(Doctor n, Doctor n1) {
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

    private Doctor rotacionDD(Doctor n, Doctor n1) {
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

    private Doctor rotacionID(Doctor n, Doctor n1) {
        Doctor n2;
        n2 = (Doctor) n1.getDcho();
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

    private Doctor rotacionDI(Doctor n, Doctor n1) {
        Doctor n2;
        n2 = (Doctor) n1.getIzdo();
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
    public void insertar(Doctor paciente) throws Exception {
        Doctor newpatient = paciente ;
        Boolean flag = false;
        raiz = insertarAVL(raiz, newpatient, flag);
    }
    private Doctor insertarAVL(Doctor raiz, Doctor newdoctor, Boolean flag) throws Exception {
        Doctor n1;
        if (raiz == null) {
            raiz = newdoctor;
            flag = true;
        } else if (newdoctor.getId() < raiz.getId()) {
            Doctor iz;
            iz = insertarAVL((Doctor) raiz.getIzdo(), newdoctor, flag);
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
                        n1 = (Doctor) raiz.getIzdo();
                        if (n1.fe == -1) {
                            raiz = rotacionII(raiz, n1);
                        } else {
                            raiz = rotacionID(raiz, n1);
                        }
                        flag = false;
                }
            }
        } else if (newdoctor.getId() > raiz.getId()) {
            Doctor dr;
            dr = insertarAVL((Doctor) raiz.getDcho(), newdoctor, flag);
            raiz.setDcho(dr);
            if (flag) {
                switch (raiz.fe) {
                    case 1:
                        n1 = (Doctor) raiz.getDcho();
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
    public void eliminar(Doctor existingpatient) throws Exception {
        Doctor patient = (Doctor) existingpatient;
        Boolean flag = false;
        raiz = eliminarAVL(raiz, patient, flag);
    }

    private Doctor eliminarAVL(Doctor r, Doctor patient, Boolean cambiaAltura) throws Exception {
        if (r == null) {
            throw new Exception(" Nodo no encontrado ");
        } else if (patient.getId() < r.getId()){
            Doctor iz;
            iz = eliminarAVL((Doctor) r.getIzdo(), patient, cambiaAltura);
            r.setIzdo(iz);
            if (cambiaAltura) {
                r = equilibrar1(r, cambiaAltura);
            }
        } else if (patient.getId() > r.getId()){
            Doctor dr;
            dr = eliminarAVL((Doctor) r.getDcho(), patient, cambiaAltura);
            r.setDcho(dr);
            if (cambiaAltura) {
                r = equilibrar2(r, cambiaAltura);
            }
        } else {
            Doctor q;
            q = r;
            if (q.getIzdo() == null) {
                r = (Doctor) q.getDcho();
                cambiaAltura = true;
            } else if (q.getDcho() == null) {
                r = (Doctor) q.getIzdo();
                cambiaAltura = true;
            } else {
                Doctor iz;
                iz = reemplazar(r, (Doctor) r.getIzdo(), cambiaAltura);
                r.setIzdo(iz);
                if (cambiaAltura) {
                    r = equilibrar1(r, cambiaAltura);
                }
            }
            q = null;
        }
        return r;
    }

    private Doctor reemplazar(Doctor n, Doctor act, Boolean cambiaAltura) {
        if (act.getDcho() != null) {
            Doctor d;
            d = reemplazar(n, (Doctor) act.getDcho(), cambiaAltura);
            act.setDcho(d);
            if (cambiaAltura)
                act = equilibrar2(act, cambiaAltura);
        } else {
            // n.setDato(act.getDato());
            n = act;
            act = (Doctor) act.getIzdo();
            n = null;
            cambiaAltura = true;
        }
        return act;
    }


    private Doctor equilibrar1(Doctor n, Boolean cambiaAltura) {
        Doctor n1;
        switch (n.fe) {
            case -1:
                n.fe = 0;
                break;
            case 0:
                n.fe = 1;
                cambiaAltura = false;
                break;
            case 1:
                n1 = (Doctor) n.getDcho();
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

    private Doctor equilibrar2(Doctor n, Boolean cambiaAltura) {
        Doctor n1;
        switch (n.fe) {
            case 1:
                n.fe = 0;
                break;
            case 0:
                n.fe = -1;
                cambiaAltura = false;
                break;
            case -1:
                n1 = (Doctor) n.getIzdo();
                if (n1.fe <= 0) {
                    if (n1.fe == 0) cambiaAltura = false;
                    n = this.rotacionII(n, n1);
                } else
                    n = this.rotacionID(n, n1);
                break;
        }
        return n;
    }

    public  void posorden(Doctor r){
        if(r!=null){
            posorden((Doctor) r.getIzdo());
            posorden((Doctor) r.getDcho());
            System.out.print( r.getFirstname() +", ");
        }
    }

    public  void preorden(Doctor r){
        if(r!=null){
            System.out.print(r.getFirstname()+", ");
            preorden((Doctor) r.getIzdo());
            preorden((Doctor) r.getDcho());
        }
    }
    public  void inorden(Doctor r){
        if(r!=null){
            inorden((Doctor) r.getIzdo());
            System.out.print(r.getFirstname() + r.getId() + ", ");
            inorden((Doctor) r.getDcho());
        }
    }
    public Doctor searchDoctorOftaId(int id){
        boolean encontrado=false;
        Doctor raizpatient = raiz;

        while(!encontrado && raizpatient!=null){
            if(id == raizpatient.getId()) encontrado=true;
            else if(id < raizpatient.getId()) raizpatient = (Doctor) raizpatient.getIzdo();
            else raizpatient = (Doctor) raizpatient.getDcho();
        }
        return raizpatient;
    }
}
