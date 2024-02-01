import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonValiderTailleGrilleListener implements ActionListener {

    private FenetreBoutons fenetreBoutons;

    public BoutonValiderTailleGrilleListener(FenetreBoutons fenetreBoutons) {
        this.fenetreBoutons = fenetreBoutons;
    }

    /**
     * Cette méthode récupère la saisie de l'utilisateur concernant la taille de la
     * grille,
     * valide l'action et crée une nouvelle grille si elle est valide (entiers
     * positifs seulement).
     * Sinon, elle affiche un message d'erreur.
     * 
     * @param actionEvent
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String saisieTaille = this.fenetreBoutons.champTaille.getText();
        boolean grilleVide = this.fenetreBoutons.checkBoxGrilleVide.isSelected();

        try {
            int tailleGrille = Integer.parseInt(saisieTaille);
            if (tailleGrille < 2) {
                this.fenetreBoutons.texteErreurChoixTaille.setText("Erreur : entrez un entier > 1.");
                return;
            }

            new GrilleInterface(tailleGrille, grilleVide, false);
        } catch (NumberFormatException ex) {
            this.fenetreBoutons.texteErreurChoixTaille.setText("Erreur : entrez un entier > 1.");
        }
    }
}
