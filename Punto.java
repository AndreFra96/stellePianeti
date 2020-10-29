package stellePianeti;

import java.util.Objects;

/**
 * Punto rappresenta un punto nello spazio
 */
public class Punto {
    private final int x;
    private final int y;
    private final int z;

    public Punto(final int x, final int y, final int z) {
        this.x = Objects.requireNonNull(x);
        this.y = Objects.requireNonNull(y);
        this.z = Objects.requireNonNull(z);
    }

    public Punto somma(Punto nuovoPunto) {
        Objects.requireNonNull(nuovoPunto);
        return new Punto(this.getX() + nuovoPunto.getX(), this.getY() + nuovoPunto.getY(),
                this.getY() + nuovoPunto.getY());
    }

    public Punto sottrazione(Punto nuovoPunto) {
        Objects.requireNonNull(nuovoPunto);
        return new Punto(this.getX() - nuovoPunto.getX(), this.getY() - nuovoPunto.getY(),
                this.getY() - nuovoPunto.getY());
    }

    public int norma() {
        int norma = this.getX() > 0 ? this.getX() : -this.getX();
        norma += this.getY() > 0 ? this.getY() : -this.getY();
        norma += this.getZ() > 0 ? this.getZ() : -this.getZ();
        return norma;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "(" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")";
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Punto))
            return false;
        Punto actual = (Punto) obj;
        return (actual.getX() == this.getX() && actual.getY() == this.getY() && actual.getZ() == this.getZ());
    }
}
