package ax.ha.pp1.wordgame;

import java.util.Arrays;
import java.util.Random;

/**
 * Slumpar fram svar ur en ordlista. Spelet får sin WordSource utifrån,
 * så att testerna kan bestämma vilket ord som gäller.
 * Klassen är färdig och behöver inte ändras.
 */
public class WordSource {
    private final String[] words;
    private final Random random = new Random();

    public WordSource(String[] words) {
        if (words.length == 0) {
            throw new IllegalArgumentException("Ordlistan är tom");
        }
        this.words = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            if (!Evaluator.isValidWord(words[i])) {
                throw new IllegalArgumentException("Ogiltigt ord: " + words[i]);
            }
            this.words[i] = words[i].toUpperCase();
        }
    }

    public String next() {
        return words[random.nextInt(words.length)];
    }

    public int size() {
        return words.length;
    }

    @Override
    public String toString() {
        return "WordSource med " + words.length + " ord: " + Arrays.toString(words);
    }
}
