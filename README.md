# Inlämning 2: Ordspel

Startkod för inlämning 2 i Programmeringsparadigmer 1. Hela uppgiftsbeskrivningen finns i Canvas.

Projektet är ett Maven-projekt. Öppna mappen i IntelliJ IDEA, så känns det igen automatiskt.

| Var                                 | Innehåll                                                                                                                                                                                                                                        |
| ----------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `src/main/java/ax/ha/pp1/wordgame/` | Paketet `ax.ha.pp1.wordgame`: kodskeletten för `Evaluator`, `GuessResult` och `Game`, `Main` med en tom `main`-metod, de färdiga klasserna `WordList` och `WordSource`, den färdiga klienten `LlmClient` och kodskelettet `LlmWords` för del D. |
| `src/test/java/ax/ha/pp1/wordgame/` | Testklasserna `EvaluatorTest`, `GuessResultTest`, `GameTest` och `LlmWordsTest`, i samma paket. `EvaluatorTest` och `LlmWordsTest` har ett exempeltest var, och resten skriver du själv. `GuessResultTest` och `GameTest` är färdiga.           |
| `uml/`                              | Ditt klassdiagram från Astah (`.asta`) eller Mermaid (`.mmd`), och en exporterad bild                                                                                                                                                           |
| `answers/`                          | Dina svar på del E                                                                                                                                                                                                                              |

I del D hämtar spelet ord från skolans språkmodell. Inställningarna läggs i miljövariabler i körkonfigurationen, aldrig i koden, så att API-nyckeln inte hamnar på GitHub.

Kör testerna genom att högerklicka på `src/test/java` och välja **Run 'All Tests'**, eller med `mvn test` i en terminal. I början blir alla tester röda: det är meningen.

Checka in testerna från del A **innan** du börjar implementera i del B.

Vid varje push kör GitHub `mvn test` automatiskt (`.github/workflows/tests.yml`). Resultatet syns som en grön bock eller ett rött kryss vid commiten, och under fliken **Actions** ser du vilket test som gick fel.
