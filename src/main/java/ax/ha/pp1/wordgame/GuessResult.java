package ax.ha.pp1.wordgame;

/**
 * Resultatet av en gissning: gissningens bokstäver och en markering per bokstav.
 * Klassen ska vara oföränderlig.
 *
 * Kodskelettet kompilerar men är inte implementerat. Skriv testerna i del A först,
 * och implementera sedan klassen i del B. Signaturerna får inte ändras.
 */
public final class GuessResult {
    public static final int ABSENT = 0;     // finns inte (fler gånger) i ordet
    public static final int MISPLACED = 1;  // finns, men på en annan plats
    public static final int CORRECT = 2;    // rätt bokstav på rätt plats

    /**
     * Skapar ett resultat. Kastar IllegalArgumentException om längderna skiljer sig
     * eller om en markering är ogiltig.
     */
    public GuessResult(String guess, int[] marks) {
        // TODO del B
    }

    /** Gissningen med versaler, t.ex. "ALLAS". */
    public String getGuess() {
        throw new UnsupportedOperationException("Inte implementerad än");
    }

    /** Antal bokstäver. */
    public int length() {
        throw new UnsupportedOperationException("Inte implementerad än");
    }

    /** Bokstaven på plats index (0–4). */
    public char letterAt(int index) {
        throw new UnsupportedOperationException("Inte implementerad än");
    }

    /** Markeringen på plats index: ABSENT, MISPLACED eller CORRECT. */
    public int markAt(int index) {
        throw new UnsupportedOperationException("Inte implementerad än");
    }

    /** Alla markeringar, t.ex. {1, 1, 2, 1, 0}. */
    public int[] getMarks() {
        throw new UnsupportedOperationException("Inte implementerad än");
    }

    /** Sant om alla bokstäver är CORRECT. */
    public boolean isCorrect() {
        throw new UnsupportedOperationException("Inte implementerad än");
    }

    /** Till exempel (A)(L)[L](A)-S- för gissningen ALLAS mot svaret KALLA. */
    @Override
    public String toString() {
        throw new UnsupportedOperationException("Inte implementerad än");
    }
}
