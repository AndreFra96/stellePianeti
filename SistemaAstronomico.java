package stellePianeti;

import java.util.Iterator;
import java.util.Objects;
import java.util.TreeMap;
import java.util.Map.Entry;

/**
 * Un Sistema Astronomico è un insieme di Corpi Celesti.
 * <p>
 * Ogni corpo celeste contenuto in un SistemaAstronomico ha un nome unico.
 * <p>
 * I corpi celesti sono ordinati in ordine alfabetico del loro nome.
 * <p>
 * Il sistema astronomico più piccolo realizzabile è composto da un insieme
 * vuoto di corpi celesti
 */
public class SistemaAstronomico {
    TreeMap<String, CorpoCeleste> elementi;
    // TreeSet<CorpoCeleste> elementi;


    /**
     * Post-condizioni: restituisce un SistemaAsronomico vuoto
     */
    public SistemaAstronomico() {
        this.elementi = new TreeMap<>();
    }

    /**
     * Effetti-collaterali: aggiunge un nuovo CorpoCeleste al SistemaAstronomico
     * <p>
     * lancia NullPointerException se il CorpoCeleste in input è null
     * <p>
     * lancia IllegalArgumentException se è già presente il CorpoCeleste in input
     * nel SistemaAstronomico
     */
    public void addCorpoCeleste(CorpoCeleste input) {
        Objects.requireNonNull(input);
        if (this.elementi.containsKey(input.getNome()))
            throw new IllegalArgumentException("Il CorpoCeleste è già presente");
        nuovaInterazione(input);
        this.elementi.put(input.getNome(), input);
    }

    private void nuovaInterazione(CorpoCeleste nuovo){
        Iterator<Entry<String, CorpoCeleste>> iterator = this.elementi.entrySet().iterator();
        while (iterator.hasNext()) {
            CorpoCeleste next = iterator.next().getValue();
            if(next instanceof Pianeta && nuovo instanceof Pianeta){
                Pianeta temp = (Pianeta) nuovo;
                Pianeta temp1 = (Pianeta) next;
                temp.influenza(temp1);
            }
        }
    }

    public void simulazione(int time){
        Iterator<Entry<String, CorpoCeleste>> iterator = this.elementi.entrySet().iterator();
        while (iterator.hasNext()) {
            CorpoCeleste next = iterator.next().getValue();
            if(next instanceof Pianeta){
                Pianeta nextPlanet = (Pianeta) next;
                nextPlanet.move(1);
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        Iterator<Entry<String, CorpoCeleste>> iterator = this.elementi.entrySet().iterator();
        boolean first = true;
        while (iterator.hasNext()) {
            if (first) {
                stringBuilder.append(iterator.next().getValue());
                first = false;
            } else {
                stringBuilder.append("\n");
                stringBuilder.append(iterator.next().getValue());
            }
        }
        return stringBuilder.toString();
    }
}
