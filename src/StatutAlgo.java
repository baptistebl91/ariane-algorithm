public class StatutAlgo {

    /**
     * La classe "StatutAlgo" est une classe qui représente l'état d'un algorithme
     * (ou d'un programme).
     * Elle a trois attributs.
     */
    public boolean fini;
    public boolean mouvementRefuse;
    public Coord nouvellesCoord;

    /**
     * Le constructeur prend ces trois attributs en argument et initialise les
     * variables de l'objet avec ces valeurs.
     * 
     * @param fini
     * @param mouvementRefuse
     * @param nouvellesCoord
     */
    public StatutAlgo(boolean fini, boolean mouvementRefuse, Coord nouvellesCoord) {
        this.fini = fini;
        this.mouvementRefuse = mouvementRefuse;
        this.nouvellesCoord = nouvellesCoord;
    }
}
