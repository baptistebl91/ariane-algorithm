import javax.swing.*;
import java.awt.*;

/**
 * Cette classe représente une case dans une grille.
 * Elle contient les coordonnées de la case et le CaseListener permet la gestion
 * des évènements concernant
 * les clics de la souris.
 * Elle peut également changer sa couleur de fond.
 */
public class Case extends JPanel {
    public Coord coordCase;

    public Case(GrilleInterface grilleInterface, Coord coordCase) {
        this.coordCase = coordCase;

        this.addMouseListener(new CaseListener(grilleInterface));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.WHITE);
    }

    public void ajouterThesee() {
        this.setBackground(Color.RED);
    }

    public void ajouterSortie() {
        this.setBackground(Color.GREEN);
    }

    public void ajouterCouleurBlanche() {
        this.setBackground(Color.WHITE);
    }
}
