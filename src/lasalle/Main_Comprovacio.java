package lasalle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.SQLOutput;

/**
 * Classe que permet comprovar la correcta generació del fitxer d'objectes Alumne objectesAlumne.data dins el directori Data
 * Resultat esperat per consola:
 * Alumne{nom='Enric', notes=[5, 6, 8, 8], notaMitja=6.75}
 * Alumne{nom='Frida', notes=[10, 9, 9, 5], notaMitja=8.25}
 * Alumne{nom='Daniel', notes=[6, 7, 8, 3], notaMitja=6.0}
 * Alumne{nom='Ramon', notes=[8, 10, 5, 5], notaMitja=7.0}
 * Alumne{nom='Lucia', notes=[5, 5, 3, 7], notaMitja=5.0}
 * Alumne{nom='Anna', notes=[3, 4, 5, 6], notaMitja=4.5}
 * Alumne{nom='Elisenda', notes=[4, 4, 7, 8], notaMitja=5.75}
 * Alumne{nom='Julian', notes=[8, 9, 3, 6], notaMitja=6.5}
 * Fi dela lectura del fitxer: Data/objectesAlumne.data
 */
public class Main_Comprovacio {

    public static void main(String[] args) {
        read("Data/objectesAlumne.data");
    }

    public static void read(String path){
        FileInputStream fileIn =null;
        ObjectInputStream input = null;
        try {
            fileIn = new FileInputStream(path);
            input = new ObjectInputStream(fileIn);
            while (true) {
                Alumne alumne = (Alumne) input.readObject();
                System.out.println(alumne.toString());
            }
        }catch(Exception e){
            System.out.println("Fi dela lectura del fitxer: " + path.toString());
        }finally{
            if (input!=null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileIn!=null) {
                try {
                    fileIn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
