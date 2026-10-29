package ax.ha.pp1.wordgame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Färdiga tester för Game. Ändra inte testerna, utan implementera klassen tills de är gröna.
 * Varje test skapar ett spel med en WordSource med ett enda ord, så att svaret alltid är känt.
 */
class GameTest {

    private static Game gameWith(String answer) {
        return new Game(new WordSource(new String[] {answer}));
    }

    @Test
    void newGameHasAllGuessesLeft() {
        Game game = gameWith("KALLA");

        assertEquals(0, game.getGuessCount());
        assertEquals(Game.MAX_GUESSES, game.getGuessesLeft());
        assertFalse(game.isOver());
        assertFalse(game.isWon());
    }

    @Test
    void eachGuessUsesUpOneGuess() {
        Game game = gameWith("KALLA");

        game.guess("PANNA");
        game.guess("ALLAS");

        assertEquals(2, game.getGuessCount());
        assertEquals(Game.MAX_GUESSES - 2, game.getGuessesLeft());
        assertFalse(game.isOver());
    }

    @Test
    void guessReturnsTheResultForTheGuess() {
        Game game = gameWith("KALLA");

        GuessResult result = game.guess("allas");

        assertEquals("(A)(L)[L](A)-S-", result.toString());
    }

    @Test
    void correctGuessWinsTheGame() {
        Game game = gameWith("KALLA");

        game.guess("PANNA");
        GuessResult result = game.guess("KALLA");

        assertTrue(result.isCorrect());
        assertTrue(game.isWon());
        assertTrue(game.isOver());
    }

    @Test
    void sixWrongGuessesLoseTheGame() {
        Game game = gameWith("KALLA");

        for (int i = 0; i < Game.MAX_GUESSES; i++) {
            assertFalse(game.isOver());
            game.guess("PANNA");
        }

        assertTrue(game.isOver());
        assertFalse(game.isWon());
        assertEquals(0, game.getGuessesLeft());
    }

    @Test
    void invalidGuessDoesNotCount() {
        Game game = gameWith("KALLA");

        assertThrows(IllegalArgumentException.class, () -> game.guess("KAL"));

        assertEquals(0, game.getGuessCount());
    }

    @Test
    void noGuessesAreAllowedAfterTheGameIsOver() {
        Game game = gameWith("KALLA");
        game.guess("KALLA");

        assertThrows(IllegalStateException.class, () -> game.guess("PANNA"));

        assertEquals(1, game.getGuessCount());
    }

    @Test
    void answerIsHiddenUntilTheGameIsOver() {
        Game game = gameWith("KALLA");

        assertThrows(IllegalStateException.class, () -> game.getAnswer());

        game.guess("KALLA");
        assertEquals("KALLA", game.getAnswer());
    }

    @Test
    void boardShowsOneRowPerGuessInOrder() {
        Game game = gameWith("KALLA");

        game.guess("ALLAS");
        game.guess("KALLA");

        assertEquals("(A)(L)[L](A)-S-\n[K][A][L][L][A]\n", game.toString());
    }
}
