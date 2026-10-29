package ax.ha.pp1.wordgame;

/**
 * Hämtar ord till spelet från skolans språkmodell (del D).
 *
 * Kodskelettet kompilerar men är inte implementerat. Signaturerna får inte ändras.
 */
public class LlmWords {

    /**
     * Frågar modellen efter ungefär count ord och returnerar de giltiga orden i svaret.
     * Kastar IllegalStateException, via LlmClient, om modellen inte går att nå.
     */
    public static String[] fetch(LlmClient client, int count) {
        throw new UnsupportedOperationException("Inte implementerad än");
    }

    /** Alla giltiga ord i texten, med versaler, i den ordning de står. Ogiltiga hoppas över. Kan vara tom. */
    public static String[] parse(String text) {
        throw new UnsupportedOperationException("Inte implementerad än");
    }
}
