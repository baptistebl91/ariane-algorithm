import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * La classe CaseListener gère l'évènement d'un clic sur la grille par la souris
 * de l'utilisateur.
 */
public class CaseListener implements MouseListener {

    GrilleInterface grilleInterface;

    public CaseListener(GrilleInterface grilleInterface) {
        this.grilleInterface = grilleInterface;
    }

    /**
     * Cette méthode gère le clic sur une case de la grille dans le panneau.
     * Si la case est sélectionnée et que la checkbox cocher "Thésée" aussi,
     * l'image de Thésée est ajoutée sur la case si elle est blanche.
     * Si la checkbox "Sortie" est active, l'image de la sortie est ajoutée sur la
     * case si elle est blanche.
     * Si aucune checkbox n'est active,
     * la couleur de la case est modifiée en noir ou blanc en fonction de la couleur
     * actuelle.
     * 
     * @param mouseEvent
     */
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        Case caseGrille = (Case) mouseEvent.getSource();

        if (grilleInterface.checkBoxThesee.isSelected()) {

            // Si la case est noire, on ne peut pas ajouter Thésée.
            if (GrilleInterface.grille[caseGrille.coordCase.x][caseGrille.coordCase.y] == 1) {
                return;
            }

            // Si la case est la sortie, on ne peut ajouter Thésée.
            if (grilleInterface.sortiePlacee() && caseGrille.coordCase.equals(GrilleInterface.coordSortie)) {
                return;
            }

            if (grilleInterface.theseePlacee()) {
                // Suppression de l'image de la case à l'ancienne position de Thésée.
                Case ancienneCaseThesee = this.grilleInterface.grilleCases[GrilleInterface.coordThesee.x][GrilleInterface.coordThesee.y];
                ancienneCaseThesee.ajouterCouleurBlanche();
            }

            // Ajout de l'image de Thésée sur la nouvelle case et modification de ses
            // coordonnées.
            caseGrille.ajouterThesee();
            GrilleInterface.coordThesee = caseGrille.coordCase;

        } else if (grilleInterface.checkBoxSortie.isSelected()) {

            // Si la case est noire, on ne peut pas ajouter la sortie.
            if (GrilleInterface.grille[caseGrille.coordCase.x][caseGrille.coordCase.y] == 1) {
                return;
            }

            // Si la case est Thésée, on ne peut ajouter la sortie.
            if (grilleInterface.theseePlacee() && caseGrille.coordCase.equals(GrilleInterface.coordThesee)) {
                return;
            }

            if (grilleInterface.sortiePlacee()) {
                // Suppression de l'image de la case à l'ancienne position de la sortie.
                Case ancienneCaseSortie = this.grilleInterface.grilleCases[GrilleInterface.coordSortie.x][GrilleInterface.coordSortie.y];
                ancienneCaseSortie.ajouterCouleurBlanche();
            }

            // Ajout de l'image de la sortie sur la nouvelle case et modification de ses
            // coordonnées.
            caseGrille.ajouterSortie();
            GrilleInterface.coordSortie = caseGrille.coordCase;

        } else {
            // Si la case cliquée correspond à la case de Thésée, on ne peut pas changer la
            // couleur de la case.
            if (caseGrille.coordCase.equals(GrilleInterface.coordThesee)) {
                return;
            }

            // Si la case cliquée correspond à la case de la sortie, on ne peut pas changer
            // la couleur de la case.
            if (caseGrille.coordCase.equals(GrilleInterface.coordSortie)) {
                return;
            }
            int statut = GrilleInterface.grille[caseGrille.coordCase.x][caseGrille.coordCase.y];
            if (statut == 0) {
                GrilleInterface.grille[caseGrille.coordCase.x][caseGrille.coordCase.y] = 1;
                caseGrille.setBackground(Color.BLACK);
            } else if (statut == 1) {
                GrilleInterface.grille[caseGrille.coordCase.x][caseGrille.coordCase.y] = 0;
                caseGrille.setBackground(Color.WHITE);
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
