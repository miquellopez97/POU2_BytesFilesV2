package lasalle;

import java.io.*;
import java.util.ArrayList;

public class LopezMiquel_solucio {
    static ArrayList<Alumne> arrayAlumnes = new ArrayList<>();
    static ArrayList<Integer> arrayNotes = new ArrayList<>();
    static String FILENAMEALUMN="Data/alumnes.dat";
    static String[] FILENAMENOTES={ "Data/notesM01.dat",
                                    "Data/notesM02.dat",
                                    "Data/notesM03.dat",
                                    "Data/notesM04.dat"};

    public static void main(String[] args){
        readBbddName();
        //readBbddNotes();
        printArray(arrayAlumnes);
    }

    public static void readBbddName(){
        FileInputStream fileInputName;
        DataInputStream dataInputName;

        try{
            fileInputName = new FileInputStream(FILENAMEALUMN);
            dataInputName = new DataInputStream(fileInputName);

            while(true){
                Alumne alumne = new Alumne(dataInputName.readUTF(), null);
                arrayAlumnes.add(alumne);
            }
        } catch (EOFException ignored) {
        } catch (FileNotFoundException e){
            System.out.println("ERROR: " + e);
        } catch (IOException e) {
            System.out.println("ERROR: " + e);
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }

    public static void readBbddNotes(String x){
        FileInputStream fileInputNote;
        DataInputStream dataInputNote = null;
        arrayNotes.clear();

        try{
            fileInputNote = new FileInputStream(x);
            dataInputNote = new DataInputStream(fileInputNote);

            while(true){
                int y = dataInputNote.readInt();
                arrayNotes.add(y);
            }
        } catch (EOFException ignored) {
        } catch (FileNotFoundException e){
            System.out.println("ERROR: " + e);
        } catch (IOException e) {
            System.out.println("ERROR: " + e);
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        for (int i = 0; i < arrayAlumnes.size(); i++) {
            //arrayAlumnes.get(i).add()
        }
    }

    public static void printArray(ArrayList array){
        for (Object a : array) {
            System.out.println(a);
        }
    }
}
