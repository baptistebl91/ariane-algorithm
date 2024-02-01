/**
 * Classe Coord avec deux attributs (x et y) de type entier et un constructeur
 * prenant en paramètre deux entiers x et y.
 */
public class Coord {

    public int x;
    public int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Méthode pour vérifier si deux objets Coord sont égaux en comparant leurs
     * coordonnées x et y.
     * 
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        if (this.getClass() != object.getClass()) {
            return false;
        }
        Coord coord = (Coord) object;
        return this.x == coord.x && this.y == coord.y;
    }

    /**
     * Cette méthode retourne une chaîne de caractères représentant les valeurs de x
     * et y d'un objet Coord.
     * 
     * @return
     */
    @Override

    public String toString() {
        return "x = " + this.x + ", y = " + this.y;
    }
}
