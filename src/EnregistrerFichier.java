import java.io.*;
import java.nio.ByteBuffer;

public class EnregistrerFichier {
    /**
     * Ce constructeur enregistre une grille sous format binaire dans un fichier.
     * Elle récupère la grille et les positions des éléments de la grille et les
     * convertit en tableaux d'octets,
     * puis les écrit dans un fichier de sortie.
     * 
     * @param nomFichier
     */
    public EnregistrerFichier(String nomFichier) {

        int[][] grille = GrilleInterface.grille;

        int nombreTotalElements = grille.length * grille.length;

        ByteBuffer buffer = ByteBuffer.allocate(nombreTotalElements * 4);

        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille.length; j++) {
                buffer.putInt(grille[i][j]);
            }
        }

        byte[] grilleBinaire = buffer.array();

        // Convertir grilleTaille en tableau d'octets
        byte[] grilleTailleBinaire = ByteBuffer.allocate(4).putInt(grille.length).array();
        byte[] posTheseeX = ByteBuffer.allocate(4).putInt(GrilleInterface.coordThesee.x).array();
        byte[] posTheseeY = ByteBuffer.allocate(4).putInt(GrilleInterface.coordThesee.y).array();
        byte[] posSortieX = ByteBuffer.allocate(4).putInt(GrilleInterface.coordSortie.x).array();
        byte[] posSortieY = ByteBuffer.allocate(4).putInt(GrilleInterface.coordSortie.y).array();

        ByteArrayOutputStream fluxSortie = new ByteArrayOutputStream();

        try {
            fluxSortie.write(grilleTailleBinaire);
            fluxSortie.write(posTheseeX);
            fluxSortie.write(posTheseeY);
            fluxSortie.write(posSortieX);
            fluxSortie.write(posSortieY);
            fluxSortie.write(grilleBinaire);
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] donneesBinaires = fluxSortie.toByteArray();

        try (OutputStream sortie = new FileOutputStream(nomFichier)) {
            sortie.write(donneesBinaires);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
