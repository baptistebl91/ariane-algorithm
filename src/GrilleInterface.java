import java.awt.*;
import javax.swing.*;

/**
 * Classe représentant l'interface graphique de la grille, avec des boutons qui
 * effectuent différentes actions.
 * Elle contient également des informations sur la taille de la grille
 * ainsi que sur les coordonnées de Thésée et de la sortie.
 */
public class GrilleInterface extends JFrame {

    public static int[][] grille;
    public Case[][] grilleCases;
    public static Coord coordThesee = new Coord(-1, -1);
    public static Coord coordSortie = new Coord(-1, -1);
    private JPanel grillePanel;
    private JPanel boutonPanel;
    public JButton boutonSauvegarde = new JButton("Sauvegarder");

    public JCheckBox checkBoxThesee = new JCheckBox("Placer Thésée");

    public JCheckBox checkBoxSortie = new JCheckBox("Placer la sortie");

    public JRadioButton radioButtonModeManuel = new JRadioButton("Mode manuel");
    public JRadioButton radioButtonModeAutomatique = new JRadioButton("Mode automatique");

    public JRadioButton radioButtonAlgoAleatoire = new JRadioButton("Algorithme aléatoire");
    public JRadioButton radioButtonAlgoDeterministe = new JRadioButton("Algorithme déterministe");

    public JButton boutonDemarrer = new JButton("Démarrer");

    public JLabel msgErreur = new JLabel();

    public static int taille;

    /**
     * Constructeur qui initialise une instance de la classe GrilleInterface
     * avec une certaine taille et une certaine configuration de la grille.
     * Il crée des éléments pour l'utilisateur (boutons, cases à cocher, boîtes de
     * dialogue, etc.)
     * et définit des EventListener pour répondre aux interactions de l'utilisateur.
     * Enfin, il initialise la grille avec des valeurs vides, aléatoires ou chargées
     * à partir d'un fichier
     * en fonction des paramètres donnés.
     * 
     * @param taille
     * @param grilleVide
     * @param grilleCharger
     */
    public GrilleInterface(int taille, boolean grilleVide, boolean grilleCharger) {

        GrilleInterface.taille = taille;
        this.grilleCases = new Case[GrilleInterface.taille][GrilleInterface.taille];

        if (grilleCharger) {
            GrilleInterface.grille = LireFichier.grille;
        } else {
            GrilleInterface.grille = new int[taille][taille];
        }

        this.boutonPanel = new JPanel();
        this.grillePanel = new JPanel();

        this.setLayout(new BorderLayout());
        this.add(grillePanel, BorderLayout.CENTER);

        boutonSauvegarde.addActionListener(new BoutonSauvegarderGrilleListener());
        checkBoxThesee.addItemListener(new CheckBoxTheseeListener(checkBoxSortie));
        checkBoxSortie.addItemListener(new CheckBoxSortieListener(checkBoxThesee));
        boutonDemarrer.addActionListener(new BoutonDemarrerListener(this));

        ButtonGroup groupeAlgo = new ButtonGroup();
        groupeAlgo.add(radioButtonAlgoDeterministe);
        groupeAlgo.add(radioButtonAlgoAleatoire);
        radioButtonAlgoDeterministe.setSelected(true);

        ButtonGroup groupeMode = new ButtonGroup();
        groupeMode.add(radioButtonModeAutomatique);
        groupeMode.add(radioButtonModeManuel);
        radioButtonModeAutomatique.setSelected(true);

        Box box = Box.createVerticalBox();
        box.add(boutonSauvegarde);
        box.add(new JLabel("Edition de la grille :"));
        box.add(checkBoxThesee);
        box.add(checkBoxSortie);
        box.add(new JLabel("Choix de l'algorithme"));
        box.add(radioButtonAlgoDeterministe);
        box.add(radioButtonAlgoAleatoire);
        box.add(new JLabel("Choix du mode"));
        box.add(radioButtonModeAutomatique);
        box.add(radioButtonModeManuel);
        box.add(boutonDemarrer);
        box.add(msgErreur);
        boutonPanel.add(box);

        this.add(boutonPanel, BorderLayout.WEST);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        if (grilleVide) {
            initialiserGrilleVide();
        } else if (grilleCharger) {
            this.initialiserGrilleCharger();
        } else {
            this.initialiserGrilleAleatoire();
        }
    }

    /**
     * Cette méthode initialise une grille vide de cases en utilisant la classe
     * "Case"
     * ainsi que "GridLayout", en itérant sur chaque case pour l'ajouter à la grille
     * et au panneau.
     */
    public void initialiserGrilleVide() {
        grillePanel.setLayout(new GridLayout(taille, taille));
        for (int y = 0; y < taille; y++) {
            for (int x = 0; x < taille; x++) {
                Case caseGrille = new Case(this, new Coord(x, y));
                grilleCases[x][y] = caseGrille;
                grille[x][y] = 0;
                grillePanel.add(caseGrille);
            }
        }
    }

    /**
     * Cette méthode initialise une grille aléatoire en utilisant la classe "Case"
     * ainsi que "GridLayout". Pour chaque case, elle définit soit la couleur noire
     * soit
     * la couleur blanche et l'ajoute à la grille et au panneau.
     */
    public void initialiserGrilleAleatoire() {

        grillePanel.setLayout(new GridLayout(taille, taille));
        // Génére les coordonnées pour Thésée et la sortie.
        // Va de 0 à taille (taille est exclue).

        for (int y = 0; y < taille; y++) {
            for (int x = 0; x < taille; x++) {
                Coord posActuelle = new Coord(x, y);
                Case caseGrille = new Case(this, posActuelle);
                grilleCases[x][y] = caseGrille;

                double caseColor = Math.random();
                Color color = caseColor > 0.5 ? Color.BLACK : Color.WHITE;
                grille[x][y] = color == Color.BLACK ? 1 : 0;

                caseGrille.setBackground(color);
                grillePanel.add(caseGrille);
            }
        }
    }

    /**
     * Cette méthode initialise une grille en chargeant une configuration
     * prédéfinie.
     * Elle utilise la classe "Case" ainsi que "GridLayout".
     * Pour chaque case, elle vérifie si elle doit ajouter Thésée, la sortie ou une
     * case normale.
     * Elle définit ensuite la couleur appropriée et ajoute la case au panneau de la
     * grille.
     */
    public void initialiserGrilleCharger() {

        grillePanel.setLayout(new GridLayout(taille, taille));
        // Génére les coordonnées pour Thésée et la sortie.
        // Va de 0 à taille (taille est exclue).

        for (int y = 0; y < taille; y++) {
            for (int x = 0; x < taille; x++) {
                Coord posActuelle = new Coord(x, y);
                Case caseGrille = new Case(this, posActuelle);
                grilleCases[x][y] = caseGrille;

                if (coordThesee.equals(posActuelle)) {
                    caseGrille.ajouterThesee();
                } else if (coordSortie.equals(posActuelle)) {
                    caseGrille.ajouterSortie();
                } else {
                    Color color = grille[x][y] == 1 ? Color.BLACK : Color.WHITE;
                    caseGrille.setBackground(color);
                }
                grillePanel.add(caseGrille);
            }
        }
    }

    /**
     * Cette méthode vérifie si les coordonnées de la sortie sont définies dans la
     * grille en comparant ses valeurs à -1.
     * 
     * @return
     *         "true" si les coordonnées sont différentes de -1, sinon elle renvoie
     *         "false".
     */
    public boolean sortiePlacee() {
        return !(GrilleInterface.coordSortie.x == -1 && GrilleInterface.coordSortie.y == -1);
    }

    /**
     * Cette méthode vérifie si les coordonnées de Thésée sont définies dans la
     * grille en comparant ses valeurs à -1.
     * 
     * @return
     *         "true" si les coordonnées sont différentes de -1, sinon elle renvoie
     *         "false".
     */
    public boolean theseePlacee() {
        return !(GrilleInterface.coordThesee.x == -1 && GrilleInterface.coordThesee.y == -1);
    }
}
