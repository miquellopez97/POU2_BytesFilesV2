package lasalle;

import java.io.*;
import java.util.ArrayList;

public class LopezMiquel_solucio {
    static ArrayList<Alumne> arrayAlumnes = new ArrayList<>();
    static ArrayList<Integer> arrayNotes = new ArrayList<>();
    static String FILENAMEALUMN="Data/alumnes.dat", ENDFILE="Data/objectesAlumne.data";
    static String[] FILENAMENOTES={ "Data/notesM01.dat",
                                    "Data/notesM02.dat",
                                    "Data/notesM03.dat",
                                    "Data/notesM04.dat"};

    public static void main(String[] args) {
        readBbddName();

        for (int i = 0; i < FILENAMENOTES.length; i++) {
            readBbddNotes(FILENAMENOTES[i]);
        }

        addNotes();

        addAvg();

        printArray(arrayAlumnes);

        writeData();
    }

    public static void readBbddName(){
        FileInputStream fileInputName;
        DataInputStream dataInputName;

        try{
            fileInputName = new FileInputStream(FILENAMEALUMN);
            dataInputName = new DataInputStream(fileInputName);
            ArrayList<Integer> x = new ArrayList<>();

            while(true){
                Alumne alumne = new Alumne(dataInputName.readUTF(), x);
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
        DataInputStream dataInputNote;

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
    }

    public static void printArray(ArrayList array){
        for (Object a : array) {
            System.out.println(a);
        }
    }

    public static void addNotes(){
        for (int i = 0; i < arrayAlumnes.size(); i++) {
            arrayAlumnes.get(i).setNotes(arrayNotes.get(i),arrayNotes.get(9+i),arrayNotes.get(18+i),arrayNotes.get(26+i));
        }
    }

    public static void addAvg(){
        for (int i = 0; i < arrayAlumnes.size(); i++) {
            float sum = 0f;
            for (Integer mark : arrayAlumnes.get(i).getNotes()) {
                sum += mark;
            }
            sum=sum/FILENAMENOTES.length;
            arrayAlumnes.get(i).setNotaMitja(sum);
        }
    }

    public static void writeData(){
        try {
            FileOutputStream fileOutput = new FileOutputStream(ENDFILE);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

            for (int i = 0; i < arrayAlumnes.size(); i++) {
                objectOutput.writeObject(arrayAlumnes.get(i));
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
    }
    }
}
