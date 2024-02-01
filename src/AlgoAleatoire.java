import java.util.Random;

/**
 * La classe AlgoAleatoire contient des constantes et une méthode pour récupérer
 * l'état
 * d'une case à partir de ses coordonnées.
 */
public class AlgoAleatoire {

    private final static int HAUT = 1;
    private final static int BAS = 2;
    private final static int GAUCHE = 3;
    private final static int DROITE = 4;

    private final static Random rand = new Random();

    private static int recupEtatCase(Coord coordCase) {
        return GrilleInterface.grille[coordCase.x][coordCase.y];
    }

    /**
     * Crée un prochain mouvement aléatoire pour Thésée dans la grille et vérifie si
     * le déplacement est valide.
     * 
     * @return
     *         Les nouvelles coordonnées de Thésée, indique si le déplacement a été
     *         refusé ou si Thésée a atteint la sortie.
     */
    public static StatutAlgo prochainMouvement() {
        boolean finish = false;
        boolean mouvementRefuse = false;
        int nbrAle = rand.nextInt(4) + 1;
        int caseEtat;
        Coord coordTest;
        Coord prochainesCoord = GrilleInterface.coordThesee;

        switch (nbrAle) {
            case HAUT:
                if (GrilleInterface.coordThesee.y == 0) {
                    System.out.println("HAUT (REFUSE): MUR"); // DEBUGING PRINTLN
                    mouvementRefuse = true;
                    break;
                }

                coordTest = Deplacement.deplacementHaut(GrilleInterface.coordThesee);

                caseEtat = recupEtatCase(coordTest);
                if (caseEtat == 1) {
                    System.out.println("HAUT (REFUSE)"); // DEBUGING PRINTLN
                    mouvementRefuse = true;
                    break;
                }

                System.out.println("HAUT (VALIDE)"); // DEBUGING PRINTLN
                prochainesCoord = coordTest;

                if (GrilleInterface.coordThesee.equals(GrilleInterface.coordSortie)) {
                    System.out.println("sortie trouvée"); // DEBUGING PRINTLN
                    finish = true;
                    break;
                }

            case BAS:
                if (GrilleInterface.coordThesee.y == (GrilleInterface.taille - 1)) {
                    System.out.println("BAS (REFUSE): MUR"); // DEBUGING PRINTLN
                    mouvementRefuse = true;
                    break;
                }
                coordTest = Deplacement.deplacementBas(GrilleInterface.coordThesee);

                caseEtat = recupEtatCase(coordTest);
                if (caseEtat == 1) {
                    System.out.println("BAS (REFUSE)"); // DEBUGING PRINTLN
                    mouvementRefuse = true;
                    break;
                }

                System.out.println("BAS (VALIDE)"); // DEBUGING PRINTLN
                prochainesCoord = coordTest;

                if (GrilleInterface.coordThesee.equals(GrilleInterface.coordSortie)) {
                    System.out.println("sortie trouvée"); // DEBUGING PRINTLN
                    finish = true;
                    break;
                }

            case GAUCHE:
                if (GrilleInterface.coordThesee.x == 0) {
                    System.out.println("GAUCHE (REFUSE): MUR"); // DEBUGING PRINTLN
                    mouvementRefuse = true;
                    break;
                }
                coordTest = Deplacement.deplacementGauche(GrilleInterface.coordThesee);

                caseEtat = recupEtatCase(coordTest);
                if (caseEtat == 1) {
                    System.out.println("GAUCHE (REFUSE)"); // DEBUGING PRINTLN
                    mouvementRefuse = true;
                    break;
                }

                System.out.println("GAUCHE (VALIDE)"); // DEBUGING PRINTLN
                prochainesCoord = coordTest;

                if (GrilleInterface.coordThesee.equals(GrilleInterface.coordSortie)) {
                    System.out.println("sortie trouvée"); // DEBUGING PRINTLN
                    finish = true;
                    break;
                }

            case DROITE:
                if (GrilleInterface.coordThesee.x == (GrilleInterface.taille - 1)) {
                    System.out.println("DROITE (REFUSE): MUR"); // DEBUGING PRINTLN
                    mouvementRefuse = true;
                    break;
                }
                coordTest = Deplacement.deplacementDroite(GrilleInterface.coordThesee);

                caseEtat = recupEtatCase(coordTest);
                if (caseEtat == 1) {
                    System.out.println("DROITE (REFUSE)"); // DEBUGING PRINTLN
                    mouvementRefuse = true;
                    break;
                }

                System.out.println("DROITE (VALIDE)"); // DEBUGING PRINTLN
                prochainesCoord = coordTest;

                if (GrilleInterface.coordThesee.equals(GrilleInterface.coordSortie)) {
                    System.out.println("sortie trouvée"); // DEBUGING PRINTLN
                    finish = true;
                    break;
                }

        }

        return new StatutAlgo(finish, mouvementRefuse, prochainesCoord);
    }

    /**
     * Méthode pour trouver la sortie du labyrinthe en utilisant une boucle while.
     * 
     * @return
     *         Le nombre d'essais avant d'atteindre la sortie en un entier.
     */
    public static int commencer() {

        Coord ancienneCoordThesse = GrilleInterface.coordThesee;

        int nbrEssai = 0;
        boolean finish = false;

        while (!finish) {
            nbrEssai++;
            StatutAlgo statusAlgo = prochainMouvement();
            // On met à jour les coordonnées de Thésée avec le prochain mouvement.
            GrilleInterface.coordThesee = statusAlgo.nouvellesCoord;
            finish = statusAlgo.fini;
        }

        // À la fin, on remet les ancinnes coordonnées de Thésée.
        GrilleInterface.coordThesee = ancienneCoordThesse;

        return nbrEssai;
    }
}