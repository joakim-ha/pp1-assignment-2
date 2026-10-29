package ax.ha.pp1.wordgame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LlmWordsTest {

    // Ett exempel att utgå från. Skriv resten av testerna i del D.
    // Testerna ska inte anropa språkmodellen, eftersom dess svar varierar.
    @Test
    void parseFindsOneWordPerLine() {
        String answer = "KALLA\ntårta";

        assertArrayEquals(new String[] {"KALLA", "TÅRTA"}, LlmWords.parse(answer));
    }
}
