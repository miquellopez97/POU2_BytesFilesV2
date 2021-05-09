package lasalle;

import java.io.Serializable;
import java.util.ArrayList;

public class Alumne implements Serializable {
    private String nom;
    private ArrayList<Integer> notes;
    private float notaMitja;

    public Alumne(String nom, ArrayList<Integer> notes) {
        this.nom = nom;
        this.notes = notes;
    }

    public void setNotes(ArrayList<Integer> notes) {
        this.notes = notes;
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
