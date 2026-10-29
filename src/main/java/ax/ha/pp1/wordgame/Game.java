package ax.ha.pp1.wordgame;

/**
 * En spelomgång: ett hemligt ord och högst sex gissningar.
 * Klassen vet ingenting om dialogrutor.
 *
 * Kodskelettet kompilerar men är inte implementerat, och det har inga fält:
 * vilka fält klassen behöver bestämmer du själv i del B. Signaturerna får inte ändras.
 */
public class Game {
    public static final int MAX_GUESSES = 6;

    /** Startar en omgång. Svaret hämtas med source.next(). */
    public Game(WordSource source) {
        // TODO del B
    }

    /**
     * Gör en gissning och returnerar resultatet. Kastar IllegalArgumentException om
     * ordet är ogiltigt (gissningen räknas då inte), och IllegalStateException om
     * spelet redan är slut.
     */
    public GuessResult guess(String word) {
        throw new UnsupportedOperationException("Inte implementerad än");
    }

    /** Sant om senaste gissningen var rätt. */
    public boolean isWon() {
        throw new UnsupportedOperationException("Inte implementerad än");
    }

    /** Sant om spelet är slut: vunnet eller sex gissningar gjorda. */
    public boolean isOver() {
        throw new UnsupportedOperationException("Inte implementerad än");
    }

    /** Antal gjorda gissningar. */
    public int getGuessCount() {
        throw new UnsupportedOperationException("Inte implementerad än");
    }

    /** Antal gissningar kvar. */
    public int getGuessesLeft() {
        throw new UnsupportedOperationException("Inte implementerad än");
    }

    /**
     * Svaret. Kastar IllegalStateException om spelet inte är slut, så att svaret
     * inte kan avslöjas för tidigt.
     */
    public String getAnswer() {
        throw new UnsupportedOperationException("Inte implementerad än");
    }

    /** Spelbrädet: en rad per gissning i formen från GuessResult, med radbrytning efter varje rad. */
    @Override
    public String toString() {
        throw new UnsupportedOperationException("Inte implementerad än");
    }
}
