import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Cette classe est un KeyListener (prend en compte lorsque l'utilisateur appuie
 * sur le clavier)
 * pour la grille de jeu et elle est liée à une instance de la classe
 * GrilleInterface.
 */
public class KeyListenerGrille implements KeyListener {

    private GrilleInterface grilleInterface;
    private boolean algoTermine = false;

    public KeyListenerGrille(GrilleInterface grilleInterface) {
        this.grilleInterface = grilleInterface;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    /**
     * La méthode permet de lancer le prochain mouvement de Thésée lorsqu'on appuie
     * sur la touche espace,
     * met à jour sa position et change la couleur de la case correspondante.
     * Si l'algorithme est terminé, un message s'affiche.
     * 
     * @param keyEvent
     */
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        System.out.println("Algo terminé ?" + algoTermine);
        if (algoTermine) {
            System.out.println("Algorithme terminé");
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE && !algoTermine) {
            System.out.println("touche espace appuyée");
            // Sauvegarde des coordonnées de Thésée
            Coord coordThesee = GrilleInterface.coordThesee;
            // Lancement du prochain mouvement
            StatutAlgo statutAlgo = AlgoAleatoire.prochainMouvement();
            this.algoTermine = statutAlgo.fini;
            // Mise à jour des coordonnées de Thésée
            GrilleInterface.coordThesee = statutAlgo.nouvellesCoord;
            // Si le mouvement n'a pas été refusé, on déplace la couleur rouge de Thésée.
            if (!statutAlgo.fini || !statutAlgo.mouvementRefuse) {
                // On supprime la couleur rouge de l'ancienne position de Thésée.
                grilleInterface.grilleCases[coordThesee.x][coordThesee.y].ajouterCouleurBlanche();
                // On ajoute la couleur rouge à sa nouvelle position.
                grilleInterface.grilleCases[statutAlgo.nouvellesCoord.x][statutAlgo.nouvellesCoord.y].ajouterThesee();
            }

            if (this.algoTermine) {
                System.out.println("Algorithme terminé");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }
}
