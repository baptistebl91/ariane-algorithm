import java.awt.*;
import javax.swing.*;

/**
 * Cette classe est une fenêtre qui contient plusieurs boutons, un champ de
 * texte, une case à cocher et une étiquette.
 * Les différents éléments sont accessibles publiquement.
 */
public class FenetreBoutons extends JFrame {

    private JFrame fenetre = new JFrame("Algorithme d'Arianne");
    private JPanel panneau = new JPanel();
    public JButton boutonChargerGrille = new JButton("Charger une grille");
    public JButton boutonConstruireNouvelleGrille = new JButton("Construire une nouvelle grille");
    public JButton boutonValiderTailleGrille = new JButton("Valider");
    public JTextField champTaille = new JTextField(16);
    public JLabel texteErreurChoixTaille = new JLabel("Aucune taille insérée");
    public JCheckBox checkBoxGrilleVide = new JCheckBox("Obtenir une grille vide ?");

    /**
     * Ce constructeur crée une fenêtre avec plusieurs boutons et zones de texte, et
     * les affiche à la fenêtre.
     * La méthode ajoute ensuite les boutons et zones de texte à la fenêtre et
     * affiche la fenêtre à l'écran.
     */
    public FenetreBoutons() {
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boutonChargerGrille.addActionListener(new BoutonChargerGrilleListener());
        boutonConstruireNouvelleGrille.addActionListener(new BoutonConstruireNouvelleGrilleListener(this));
        boutonValiderTailleGrille.addActionListener(new BoutonValiderTailleGrilleListener(this));
        // On cache les boutons qui ne doivent pas encore apparaître à l'écran
        boutonValiderTailleGrille.setVisible(false);
        champTaille.setVisible(false);
        texteErreurChoixTaille.setVisible(false);
        checkBoxGrilleVide.setVisible(false);

        fenetre.setPreferredSize(new Dimension(800, 500));
        fenetre.pack();
        fenetre.setLocationRelativeTo(null);
        panneau.add(boutonChargerGrille);
        panneau.add(boutonConstruireNouvelleGrille);
        panneau.add(texteErreurChoixTaille);
        panneau.add(champTaille);
        panneau.add(checkBoxGrilleVide);
        panneau.add(boutonValiderTailleGrille);
        fenetre.setLayout(new FlowLayout());
        fenetre.add(panneau);
        fenetre.pack();
        fenetre.setVisible(true);
    }
}
