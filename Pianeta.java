package stellePianeti;

import java.util.Objects;

/**
 * Un Pianeta è un corpo celeste mobile
 */
public class Pianeta extends CorpoCeleste {
    Punto speed;

    /**
     * Restituisce un nuovo pianeta
     */
    public Pianeta(String nome, Punto posizione, Punto speed) {
        super(nome, posizione, posizione.norma(), speed.norma());
        this.speed = Objects.requireNonNull(speed);
    }

    /**
     * Muove per time secondi il pianeta, la posizione al secondo successivo è
     * calcolata sommando alle coordinate della posizione attuale le coordinate
     * della velocità Effetti-collaterali: Modifica la posizione attuale del pianeta
     */
    public void move(int time) {
        for (int i = 0; i < time; i++) {
            this.setCoordinate(speed.somma(this.getCoordinate()));
        }
    }

    public void setSpeed(Punto speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Pianeta: " + this.getNome() + " posizione = " + this.getCoordinate() + " velocità = " + this.speed;
    }

    public void influenza(CorpoCeleste vicino) {
        Punto posPianeta1 = this.getCoordinate();
        Punto posPianeta2 = vicino.getCoordinate();

        if (vicino instanceof Pianeta) {
            Pianeta pianetaVicino = (Pianeta) vicino;

            if (posPianeta1.getX() > posPianeta2.getX()) {
                this.speed = this.speed.somma(new Punto(-1, 0, 0));
                pianetaVicino.speed = pianetaVicino.speed.somma(new Punto(1, 0, 0));
            } else if(posPianeta1.getX() < posPianeta2.getX()) {
                this.speed = this.speed.somma(new Punto(1, 0, 0));
                pianetaVicino.speed = pianetaVicino.speed.somma(new Punto(-1, 0, 0));
            }

            if (posPianeta1.getY() > posPianeta2.getY()) {
                this.speed = this.speed.somma(new Punto(0, -1, 0));
                pianetaVicino.speed = pianetaVicino.speed.somma(new Punto(0, 1, 0));
            } else if(posPianeta1.getY() < posPianeta2.getY()) {
                this.speed = this.speed.somma(new Punto(0, 1, 0));
                pianetaVicino.speed = pianetaVicino.speed.somma(new Punto(0, -1, 0));
            }

            if (posPianeta1.getZ() > posPianeta2.getZ()) {
                this.speed = this.speed.somma(new Punto(0, 0, -1));
                pianetaVicino.speed = pianetaVicino.speed.somma(new Punto(0, 0, 1));
            } else if (posPianeta1.getZ() < posPianeta2.getZ()) {
                this.speed = this.speed.somma(new Punto(0, 0, 1));
                pianetaVicino.speed = pianetaVicino.speed.somma(new Punto(0, 0, -1));
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Pianeta)) return false;
        Pianeta p = (Pianeta) obj;
        return p.getNome().equals(this.getNome());
    }

    @Override
    public int hashCode() {
        return this.getNome().hashCode();
    }

    @Override
    public int compareTo(CorpoCeleste o) {
        return this.getNome().compareTo(o.getNome());
    }
}
