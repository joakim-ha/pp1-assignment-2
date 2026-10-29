package ax.ha.pp1.wordgame;

import java.util.Arrays;

/**
 * Ordlistan för spelet: vanliga svenska ord med fem bokstäver, skrivna med versaler.
 * Klassen är färdig och behöver inte ändras.
 */
public class WordList {
    private static final String[] WORDS = {
        "BANAN", "PÄRON", "MELON", "DADEL", "SOPPA", "PASTA", "PIZZA", "BULLE", "TÅRTA", "GLASS",
        "KANEL", "SIRAP", "KAFFE", "MJÖLK", "FLÄSK", "PURJO", "BÖNOR", "ÄRTOR", "LIMPA", "TIGER",
        "ZEBRA", "KOALA", "PANDA", "KAMEL", "LEJON", "HJORT", "UGGLA", "KRÅKA", "SVALA", "GÄDDA",
        "MANET", "KANIN", "RÅTTA", "LILJA", "MOSSA", "FJÄLL", "BACKE", "KULLE", "BLIXT", "STORM",
        "DIMMA", "FROST", "ISBIT", "SOFFA", "LAMPA", "HYLLA", "MATTA", "KUDDE", "TÄCKE", "TAVLA",
        "KANNA", "PANNA", "NACKE", "TUMME", "NAGEL", "TUNGA", "JACKA", "BYXOR", "TRÖJA", "MÖSSA",
        "VANTE", "KÄNGA", "BÄLTE", "SLIPS", "KAPPA", "KAVAJ", "PENNA", "VÄSKA", "DOCKA", "CYKEL",
        "FÄRJA", "RAKET", "MOTOR", "PIANO", "FLÖJT", "KYRKA", "SKOLA", "BUTIK", "AFFÄR", "KIOSK",
        "STALL", "SNÄLL", "STARK", "LITEN", "TJOCK", "FRISK", "TRÖTT", "MODIG", "SNABB", "SVART",
        "SPELA", "HOPPA", "SIMMA", "DANSA", "STEKA", "STÄDA", "VAKNA", "TÄNKA", "PRATA", "FRÅGA",
        "SVARA", "TITTA", "KASTA", "FÅNGA", "BYGGA", "CYKLA", "ÖPPNA", "GRÅTA", "HÄMTA", "RÄKNA",
        "VÄNTA", "BÖRJA", "SLUTA", "MÄRKA", "TÄLTA", "SEGLA", "FISKA", "KALLA", "PAPPA", "MAMMA",
        "KUSIN", "POLIS", "PILOT", "BONDE", "PRINS", "TROLL", "JÄTTE", "DRAKE", "SKATT", "KARTA",
        "PAKET", "KALAS", "MUSIK", "KONST", "RADIO", "VIDEO", "DATOR", "MOBIL", "SKÄRM", "ROBOT",
        "KABEL", "PIXEL", "TIMME", "VECKA", "MÅNAD", "VÄRLD", "KRAFT", "MINNE", "TANKE", "SPRÅK",
        "SÖTMA",
    };

    /** Returnerar en kopia av ordlistan, så att ingen kan ändra originalet. */
    public static String[] all() {
        return Arrays.copyOf(WORDS, WORDS.length);
    }
}
