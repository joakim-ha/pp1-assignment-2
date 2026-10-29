package ax.ha.pp1.wordgame;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * En liten klient för skolans språkmodell (OpenAI-kompatibelt API via Open WebUI).
 * Klassen är färdig och behöver inte ändras. Den används i del D.
 *
 * Inställningarna läses från miljövariabler, så att ingen nyckel hamnar i git:
 *   PP1_LLM_URL    hela adressen, t.ex. https://.../api/chat/completions
 *   PP1_LLM_MODEL  modellens namn
 *   PP1_LLM_KEY    API-nyckeln från Open WebUI (kan utelämnas om servern inte kräver nyckel)
 *
 * Alla fel ger IllegalStateException med ett meddelande som går att visa för användaren.
 */
public class LlmClient {
    private final String url;
    private final String model;
    private final String key;
    private final HttpClient http = HttpClient.newBuilder()
        .connectTimeout(Duration.ofSeconds(10))
        .build();

    /** Läser inställningarna från miljövariablerna. */
    public LlmClient() {
        this(System.getenv("PP1_LLM_URL"), System.getenv("PP1_LLM_MODEL"), System.getenv("PP1_LLM_KEY"));
    }

    public LlmClient(String url, String model, String key) {
        if (url == null || url.isBlank() || model == null || model.isBlank()) {
            throw new IllegalStateException("Miljövariablerna PP1_LLM_URL och PP1_LLM_MODEL måste vara satta");
        }
        this.url = url;
        this.model = model;
        this.key = key;
    }

    /** Skickar en fråga och returnerar modellens svar som text. */
    public String ask(String prompt) {
        String body = "{\"model\":" + quote(model)
            + ",\"stream\":false,\"messages\":[{\"role\":\"user\",\"content\":" + quote(prompt) + "}]}";
        var builder = HttpRequest.newBuilder(URI.create(url))
            .version(HttpClient.Version.HTTP_1_1)   // krävs för att Open WebUI ska svara
            .timeout(Duration.ofSeconds(60))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(body));
        if (key != null && !key.isBlank()) {
            builder.header("Authorization", "Bearer " + key);
        }
        HttpResponse<String> response;
        try {
            response = http.send(builder.build(), HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new IllegalStateException("Kunde inte nå språkmodellen (VPN?): " + e.getMessage(), e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Anropet avbröts", e);
        }
        if (response.statusCode() != 200) {
            throw new IllegalStateException("Språkmodellen svarade med HTTP " + response.statusCode());
        }
        return extractContent(response.body());
    }

    // Plockar ut texten i choices[0].message.content ur svaret, utan JSON-bibliotek.
    static String extractContent(String json) {
        int message = json.indexOf("\"message\"");
        int key = json.indexOf("\"content\"", Math.max(message, 0));
        if (key < 0) {
            throw new IllegalStateException("Oväntat svar från språkmodellen");
        }
        int start = json.indexOf('"', json.indexOf(':', key) + 1);
        var sb = new StringBuilder();
        for (int i = start + 1; i < json.length(); i++) {
            char c = json.charAt(i);
            if (c == '"') {
                return sb.toString();
            }
            if (c == '\\' && i + 1 < json.length()) {
                char next = json.charAt(++i);
                switch (next) {
                    case 'n' -> sb.append('\n');
                    case 't' -> sb.append('\t');
                    case 'r' -> sb.append('\r');
                    case 'b' -> sb.append('\b');
                    case 'f' -> sb.append('\f');
                    case 'u' -> {
                        sb.append((char) Integer.parseInt(json.substring(i + 1, i + 5), 16));
                        i += 4;
                    }
                    default -> sb.append(next);    // \" \\ \/
                }
            } else {
                sb.append(c);
            }
        }
        throw new IllegalStateException("Oväntat svar från språkmodellen");
    }

    // Gör om en sträng till en JSON-sträng med citattecken.
    static String quote(String text) {
        var sb = new StringBuilder("\"");
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            switch (c) {
                case '"' -> sb.append("\\\"");
                case '\\' -> sb.append("\\\\");
                case '\n' -> sb.append("\\n");
                case '\r' -> sb.append("\\r");
                case '\t' -> sb.append("\\t");
                default -> {
                    if (c < 0x20) {
                        sb.append(String.format("\\u%04x", (int) c));
                    } else {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.append('"').toString();
    }
}
