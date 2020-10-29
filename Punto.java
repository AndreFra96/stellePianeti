package stellePianeti;

import java.util.Objects;

/**
 * Punto rappresenta un punto nello spazio
 */
public class Punto {
    private final int x;
    private final int y;
    private final int z;

    /**
     * Post-condizioni: Restituisce un nuovo punto
     */
    public Punto(final int x, final int y, final int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Post-condizioni: Restituisce un nuovo punto, corrispondente al punto ottenuto
     * sommando le coordinate del punto attuale con quelle del punto in input
     * <p>
     * lancia NullPointerException se il punto in input è null
     */
    public Punto somma(Punto nuovoPunto) {
        Objects.requireNonNull(nuovoPunto);
        return new Punto(this.getX() + nuovoPunto.getX(), this.getY() + nuovoPunto.getY(),
                this.getY() + nuovoPunto.getY());
    }

    /**
     * Post-condizioni: Restituisce un nuovo punto, corrispondente al punto ottenuto
     * sottraendo le coordinate del punto in input a quelle del punto attuale
     * <p>
     * lancia NullPointerException se il punto in input è null
     */
    public Punto sottrazione(Punto nuovoPunto) {
        Objects.requireNonNull(nuovoPunto);
        return new Punto(this.getX() - nuovoPunto.getX(), this.getY() - nuovoPunto.getY(),
                this.getY() - nuovoPunto.getY());
    }

    /**
     * Post-condizioni: Restituisce un intero corrispondente alla norma del Punto
     * attuale
     */
    public int norma() {
        int norma = this.getX() > 0 ? this.getX() : -this.getX();
        norma += this.getY() > 0 ? this.getY() : -this.getY();
        norma += this.getZ() > 0 ? this.getZ() : -this.getZ();
        return norma;
    }

    /**
     * Post-condizioni: restituisce un intero corrispondente alla coordinata x del
     * punto attuale
     */
    public int getX() {
        return x;
    }

    /**
     * Post-condizioni: restituisce un intero corrispondente alla coordinata y del
     * punto attuale
     */
    public int getY() {
        return y;
    }

    /**
     * Post-condizioni: restituisce un intero corrispondente alla coordinata z del
     * punto attuale
     */
    public int getZ() {
        return z;
    }

    /**
     * Post-condizioni: restituisce una rappresentazione del punto composta in
     * questo modo: (x, y, z)
     */
    @Override
    public String toString() {
        return "(" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")";
    }

    /**
     * Due punti hanno lo stesso hashcode quando il loro toString() è identico,
     * ovvero quando hanno x,y e z uguali Post-condizioni: restituisce un intero
     * corrispondente all'hashCode del toString() del punto
     */
    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    /**
     * Due punti sono uguali quando hanno tutte le stesse coordinate
     * Post-condizioni: Restituisce true se i due punti hanno le stesse coordinate
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Punto))
            return false;
        Punto actual = (Punto) obj;
        return (actual.getX() == this.getX() && actual.getY() == this.getY() && actual.getZ() == this.getZ());
    }
}
