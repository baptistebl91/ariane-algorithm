import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class BoutonChargerGrilleListener implements ActionListener {
    /**
     * Cette méthode permet d'ouvrir l'explorateur de fichier pour charger la grille
     * sauvegardée
     * 
     * @param actionEvent
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // Ouverture de l'explorateur de fichier pour charger la grille
        JFileChooser choose = new JFileChooser(
                FileSystemView
                        .getFileSystemView()
                        .getHomeDirectory());

        int res = choose.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            File file = choose.getSelectedFile();
            new LireFichier(file.getAbsolutePath());
        }
    }
}
