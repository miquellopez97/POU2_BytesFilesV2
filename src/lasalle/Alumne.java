package lasalle;

import java.io.Serializable;
import java.util.ArrayList;

public class Alumne implements Serializable {
    private final String nom;
    private ArrayList<Integer> notes;
    private float notaMitja;

    public Alumne(String nom, ArrayList<Integer> notes) {
        this.nom = nom;
        this.notes = notes;
    }

    public void setNotes(int x1 ,int x2 ,int x3 ,int x4) {
        ArrayList<Integer> arrayNotes = new ArrayList<>();
        arrayNotes.add(x1);
        arrayNotes.add(x2);
        arrayNotes.add(x3);
        arrayNotes.add(x4);
        this.notes = arrayNotes;
    }

    public ArrayList<Integer> getNotes() {
        return notes;
    }

    public void setNotaMitja(float notaMitja) {
        this.notaMitja = notaMitja;
    }

    @Override
    public String toString() {
        return "Alumne{" +
                "nom='" + nom + '\'' +
                ", notes=" + notes +
                ", notaMitja=" + notaMitja +
                '}';
    }
}
