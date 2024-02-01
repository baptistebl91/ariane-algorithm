import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class BoutonSauvegarderGrilleListener implements ActionListener {
    /**
     * Cette méthode ouvre l'explorateur de fichier pour permettre à l'utilisateur
     * de choisir où sauvegarder la grille,
     * puis elle enregistre la grille à l'emplacement voulu par celui-ci.
     * 
     * @param actionEvent
     */
    public void actionPerformed(ActionEvent actionEvent) {

        JFrame parentFrame = new JFrame();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Sauvegarder la grille");

        int userSelection = fileChooser.showSaveDialog(parentFrame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            new EnregistrerFichier(fileToSave.getAbsolutePath());
        }
    }

}
