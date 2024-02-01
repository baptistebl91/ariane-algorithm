/**
 * Cette classe définit des méthodes statiques pour déplacer une position dans
 * différentes directions.
 */
public class Deplacement {

    public static Coord deplacementHaut(Coord coord) {
        return new Coord(coord.x, coord.y - 1);
    }

    public static Coord deplacementBas(Coord coord) {
        return new Coord(coord.x, coord.y + 1);
    }

    public static Coord deplacementGauche(Coord coord) {
        return new Coord(coord.x - 1, coord.y);
    }

    public static Coord deplacementDroite(Coord coord) {
        return new Coord(coord.x + 1, coord.y);
    }
}
