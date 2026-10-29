package ax.ha.pp1.wordgame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/** Färdiga tester för GuessResult. Ändra inte testerna, utan implementera klassen tills de är gröna. */
class GuessResultTest {

    @Test
    void toStringShowsEachLetterWithItsMark() {
        GuessResult result = new GuessResult("ALLAS", new int[] {1, 1, 2, 1, 0});

        assertEquals("(A)(L)[L](A)-S-", result.toString());
    }

    @Test
    void gettersDescribeTheGuess() {
        GuessResult result = new GuessResult("ALLAS", new int[] {1, 1, 2, 1, 0});

        assertEquals("ALLAS", result.getGuess());
        assertEquals(5, result.length());
        assertEquals('S', result.letterAt(4));
        assertEquals(GuessResult.CORRECT, result.markAt(2));
        assertArrayEquals(new int[] {1, 1, 2, 1, 0}, result.getMarks());
    }

    @Test
    void isCorrectOnlyWhenEveryLetterIsCorrect() {
        GuessResult allCorrect = new GuessResult("KALLA", new int[] {2, 2, 2, 2, 2});
        GuessResult oneMisplaced = new GuessResult("KALLA", new int[] {2, 2, 2, 2, 1});

        assertTrue(allCorrect.isCorrect());
        assertFalse(oneMisplaced.isCorrect());
    }

    @Test
    void guessResultCannotBeModifiedThroughTheArrayPassedIn() {
        int[] marks = {2, 2, 2, 2, 2};
        GuessResult result = new GuessResult("KALLA", marks);

        marks[0] = GuessResult.ABSENT;

        assertTrue(result.isCorrect());
        assertEquals(GuessResult.CORRECT, result.markAt(0));
    }

    @Test
    void guessResultCannotBeModifiedThroughGetMarks() {
        GuessResult result = new GuessResult("KALLA", new int[] {2, 2, 2, 2, 2});

        result.getMarks()[0] = GuessResult.ABSENT;

        assertTrue(result.isCorrect());
        assertEquals(GuessResult.CORRECT, result.markAt(0));
    }

    @Test
    void constructorRejectsMarksThatDoNotMatchTheGuess() {
        assertThrows(IllegalArgumentException.class,
                () -> new GuessResult("KALLA", new int[] {2, 2}));
        assertThrows(IllegalArgumentException.class,
                () -> new GuessResult("KALLA", new int[] {2, 2, 2, 2, 3}));
        assertThrows(IllegalArgumentException.class,
                () -> new GuessResult("KALLA", new int[] {2, 2, 2, 2, -1}));
    }
}
