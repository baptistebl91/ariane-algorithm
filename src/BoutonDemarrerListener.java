import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La classe BoutonDemarrerListener est un ActionListener pour le bouton
 * "Démarrer"
 * dans l'interface de la grille.
 */
public class BoutonDemarrerListener implements ActionListener {
    GrilleInterface grilleInterface;

    public BoutonDemarrerListener(GrilleInterface grilleInterface) {
        this.grilleInterface = grilleInterface;
    }

    /**
     * La méthode vérifie si la position de Thésée et de la sortie sont définies,
     * puis exécute un des algorithmes en fonction du mode sélectionné (automatique
     * ou manuel).
     * Si le mode automatique est sélectionné, l'algorithme est exécuté
     * automatiquement,
     * sinon, le KeyListener se charge du mode manuel.
     * 
     * @param actionEvent
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (!(grilleInterface.theseePlacee() && grilleInterface.sortiePlacee())) {
            grilleInterface.msgErreur.setText("Erreur : Thésée / la sortie n'a pas été placée");
        } else {
            grilleInterface.msgErreur.setText("");

            boolean modeAuto = this.grilleInterface.radioButtonModeAutomatique.isSelected();
            boolean algoAleatoire = this.grilleInterface.radioButtonAlgoAleatoire.isSelected();
            boolean algoDeterministe = this.grilleInterface.radioButtonAlgoDeterministe.isSelected();

            grilleInterface.setFocusable(true);
            grilleInterface.requestFocus();

            if (algoAleatoire) {
                System.out.println("Mode aléatoire sélectionné.");
                System.out.println("Mode automatique activé ? " + modeAuto);

                if (modeAuto) {
                    int nbEssais = AlgoAleatoire.commencer();
                    System.out.println("Nombre d'essais = " + nbEssais);
                } else {
                    grilleInterface.addKeyListener(new KeyListenerGrille(grilleInterface));
                }

            } else if (algoDeterministe) {
                System.out.println("Mode déterministe sélectionné.");
                System.out.println("Mode deterministe activé ? " + modeAuto);

                if (modeAuto) {
                    int nbEssais = AlgoDeterministe.commencer(GrilleInterface.grille, GrilleInterface.coordThesee,
                            GrilleInterface.coordSortie);
                    System.out.println("Nombre d'essais = " + nbEssais);
                } else {
                    grilleInterface.addKeyListener(new KeyListenerGrille(grilleInterface));
                }
            } else {
                System.out.println("Mode manuel sélectionné.");
                System.out.println("Mode automatique activé ? " + modeAuto);
                // A faire
            }
        }
    }
}
