import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class LireFichier {

    public static int[][] grille;

    /**
     * Cette méthode lit un fichier binaire avec la taille de la grille, les
     * coordonnées de Thésée et de la sortie,
     * ainsi que les valeurs de chaque case.
     * Elle affiche les valeurs de chaque case lue et crée une instance de
     * "GrilleInterface".
     *
     * @param cheminFichier
     *
     */
    public LireFichier(String cheminFichier) {

        try (DataInputStream dis = new DataInputStream(new FileInputStream(cheminFichier))) {

            int tailleGrille = dis.readInt();
            System.out.println("Taille de la grille : " + tailleGrille);

            int caseGrille = 0;

            grille = new int[tailleGrille][tailleGrille];
            GrilleInterface.coordThesee = new Coord(dis.readInt(), dis.readInt());
            GrilleInterface.coordSortie = new Coord(dis.readInt(), dis.readInt());

            for (int i = 0; i < tailleGrille; i++) {
                for (int j = 0; j < tailleGrille; j++) {
                    caseGrille++;
                    int caseValeur = dis.readInt();
                    grille[i][j] = caseValeur;
                    System.out.println("Case " + caseGrille + " : " + grille[i][j]);
                }
            }

            new GrilleInterface(tailleGrille, false, true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
