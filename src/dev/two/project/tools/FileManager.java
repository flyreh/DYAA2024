package dev.two.project.tools;

import dev.two.project.controller.gestor.gestorDerma;
import dev.two.project.controller.gestor.gestorOfta;
import dev.two.project.controller.gestor.gestorPatient;
import dev.two.project.controller.gestor.gestorTrauma;
import dev.two.project.model.AVLDerma;
import dev.two.project.model.AVLOfta;
import dev.two.project.model.AVLTrauma;
import dev.two.project.model.AVLpatients;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class FileManager {
    private static final String ruta = "src\\dev\\two\\project\\files\\";

    public static void crearArchivo(String nombreArchivo) throws FileNotFoundException {
        String nombreFullArchivo = ruta + nombreArchivo;
        File archivo = new File(nombreFullArchivo);
        PrintWriter salida = new PrintWriter(archivo);
        salida.close();
    }

    public static void escribirArchivo(String nombreArchivo, String mensaje, boolean aniadir) throws IOException {
        String nombreFullArchivo = ruta + nombreArchivo;
        File archivo = new File(nombreFullArchivo);
        PrintWriter salida = new PrintWriter(new FileWriter(archivo, aniadir));
        salida.println(mensaje);
        salida.close();
    }

    public static void leerArchivo(String nombreArchivo, ArrayList<String> almacen) throws FileNotFoundException, IOException {
        String nombreFullArchivo = ruta + nombreArchivo;
        File archivo = new File(nombreFullArchivo);
        String entrada;
        BufferedReader buffer = new BufferedReader(new FileReader(archivo));
        do {
            entrada = buffer.readLine();
            if (entrada != null) {
                almacen.add(entrada);
            }
        } while (entrada != null);
    }

    public static void leerArchivo(String nombreArchivo, ArrayList<String> almacen, int lineas) {
        String nombreFullArchivo = ruta + nombreArchivo;
        File archivo = new File(nombreFullArchivo);
        String entrada;
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(archivo));
            for (int i = 0; i < lineas; i++) {
                entrada = buffer.readLine();
                if (entrada == null) {
                    break;
                } else {
                    almacen.add(entrada);
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void  escribirArchivo(String nombre, Object obj1, Object obj2, Object obj3, Object obj4) throws FileNotFoundException, IOException {
        FileOutputStream ostream = new FileOutputStream(ruta + nombre);
        ObjectOutputStream p = new ObjectOutputStream(ostream);
        p.writeObject(obj1);
        p.writeObject(obj2);
        p.writeObject(obj3);
        p.writeObject(obj4);
        p.close();
        //p.flush();
        ostream.close();
    }

    public static void leerArchivo(String nombreArchivo) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream istream = new FileInputStream(ruta + nombreArchivo);
        ObjectInputStream p = new ObjectInputStream(istream);

        gestorPatient.patients = (AVLpatients) p.readObject();
        gestorDerma.DoctorsDerma = (AVLDerma) p.readObject();
        gestorOfta.DoctorsOfta = (AVLOfta) p.readObject();
        gestorTrauma.DoctorsTrauma = (AVLTrauma) p.readObject();

        p.close();
        istream.close();

    }
    public static int leerArchivoTxt(String nombreArchivo) throws FileNotFoundException {
        File archivo = new File(ruta + nombreArchivo);
        Scanner scanner = new Scanner(archivo);
        int numero = 0;
        if (scanner.hasNextInt()) {
            numero = scanner.nextInt();
        }
        scanner.close();
        return numero;
    }

    public static void eliminarArchivo(String nombreArchivo) {
        File archivo = new File(ruta + nombreArchivo);
        if (archivo.exists()) {
            archivo.delete();
        }
        System.out.println("Se elimino" + ruta + nombreArchivo);
    }
}
