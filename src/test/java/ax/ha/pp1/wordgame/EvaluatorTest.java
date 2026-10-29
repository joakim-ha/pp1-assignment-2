package ax.ha.pp1.wordgame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvaluatorTest {

    // Ett exempel att utgå från. Skriv resten av testerna i del A.
    @Test
    void allLettersCorrectGivesACorrectResult() {
        GuessResult result = Evaluator.evaluate("KALLA", "KALLA");

        assertTrue(result.isCorrect());
        assertEquals("[K][A][L][L][A]", result.toString());
    }
}
