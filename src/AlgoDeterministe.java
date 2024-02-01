import java.util.*;

/**
 * La classe AlgoDeterministe contient une constante INFINI et une matrice
 * DIRECTIONS
 * qui correspondent les directions de déplacement de Thésée.
 */
public class AlgoDeterministe {
    private static final int INFINI = Integer.MAX_VALUE;
    private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // droite, bas, gauche, haut

    /**
     * Méthode qui calcule le plus court chemin entre Thésée et la sortie de la
     * grille
     * en utilisant l'algorithme déterministe.
     *
     * @param grille
     * @param depart
     * @param arrivee
     * @return Retourne le nombre de cases à parcourir pour arriver à destination.
     */
    public static int commencer(int[][] grille, Coord depart, Coord arrivee) {
        int tailleGrille = grille.length;

        int pas = 0;

        int[][] distances = new int[tailleGrille][tailleGrille];
        for (int i = 0; i < tailleGrille; i++) {
            for (int j = 0; j < tailleGrille; j++) {
                distances[i][j] = INFINI;
            }
        }
        distances[depart.x][depart.y] = 0;

        List<Coord> noeuds = new ArrayList<>();
        noeuds.add(depart);

        while (!noeuds.isEmpty()) {
            Coord actuel = noeuds.remove(0);
            int x = actuel.x;
            int y = actuel.y;

            if (x == arrivee.x && y == arrivee.y) {
                return distances[x][y];
            }

            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (newX >= 0 && newX < tailleGrille && newY >= 0 && newY < tailleGrille && grille[newX][newY] != 1) {
                    int nouvelleDistance = distances[x][y] + 1;
                    pas++;
                    if (nouvelleDistance < distances[newX][newY]) {
                        distances[newX][newY] = nouvelleDistance;
                        noeuds.add(new Coord(newX, newY));
                    }
                }
            }
        }
        return pas;
    }
}