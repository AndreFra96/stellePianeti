package stellePianeti;

import java.util.Objects;

/**
 * <p>
 * Un CorpoCeleste è una classe astratta rappresentante oggetti nello spezio.
 * <p>
 * Ogni CorpoCeleste ha un punto dello spazio in cui è posizionato attualmente,
 * ha energia cinetica ed energia potenziale
 */
public abstract class CorpoCeleste {
    private Punto coordinate;
    private long energiaCinetica;
    private long energiaPotenziale;
    private final String nome;

    /**
     * <p>
     * Post-condizioni: Restituisce un nuovo Punto
     * <p>
     * Lancia NullPointerException se il Punto in input è o se il nome è null
     */
    public CorpoCeleste(String nome, Punto posizione, long energiaCinetica, long energiaPotenziale) {
        this.nome = Objects.requireNonNull(nome);
        this.coordinate = Objects.requireNonNull(posizione);
        this.energiaCinetica = energiaCinetica;
        this.energiaPotenziale = energiaPotenziale;
    }

    /**
     * <p>
     * Post-condizioni: Resituisce il Punto corrispondente alle coordinate attuali
     * del corpoCeleste
     */
    public Punto getCoordinate() {
        return coordinate;
    }

    /**
     * <p>
     * Post-condizioni: Resituisce un intero corrispondente all'energia cinetica del
     * corpoCeleste
     */
    public long getEnergiaCinetica() {
        return energiaCinetica;
    }

    /**
     * <p>
     * Post-condizioni: Resituisce un intero corrispondente all'energia potenziale
     * del corpoCeleste
     */
    public long getEnergiaPotenziale() {
        return energiaPotenziale;
    }

    /**
     * <p>
     * Post-condizioni: Resituisce un intero corrispondente prodotto dell'energia
     * cinetica e di quella potenziale dell'oggetto
     */
    public long getEnergia() {
        return this.getEnergiaCinetica() + this.getEnergiaPotenziale();
    }

    /**
     * <p>
     * Effetti-collaterali: modifica le coordinate della posizione attuale con
     * quelle del punto in input
     * <p>
     * Post-condizioni: lancia NullPointerException se il punto in input è null
     */
    public void setCoordinate(Punto coordinate) {
        this.coordinate = Objects.requireNonNull(coordinate);
    }

    /**
     * Post-condizioni: restituisce una Stringa, il nome del corpoCeleste
     */
    public String getNome() {
        return nome;
    }
}
