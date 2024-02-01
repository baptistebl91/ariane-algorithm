import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Cette classe est un ActionListener pour le bouton "construire une nouvelle
 * grille".
 * Elle prend une instance de FenetreBoutons en paramètre.
 */
public class BoutonConstruireNouvelleGrilleListener implements ActionListener {

    private FenetreBoutons fenetreBoutons;

    public BoutonConstruireNouvelleGrilleListener(FenetreBoutons fenetreBoutons) {
        this.fenetreBoutons = fenetreBoutons;
    }

    /**
     * Cette méthode permet de changer l'état des boutons de la fenêtre si
     * l'utilisateur clique
     * sur le bouton "Construire une nouvelle grille" grâce au ActionListener.
     * 
     * @param actionEvent
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.fenetreBoutons.boutonConstruireNouvelleGrille.setVisible(false);
        this.fenetreBoutons.boutonChargerGrille.setVisible(false);
        // on active les boutons pour choisir la taille de la grille
        this.fenetreBoutons.boutonValiderTailleGrille.setVisible(true);
        this.fenetreBoutons.champTaille.setVisible(true);
        this.fenetreBoutons.texteErreurChoixTaille.setVisible(true);
        this.fenetreBoutons.checkBoxGrilleVide.setVisible(true);
    }
}
