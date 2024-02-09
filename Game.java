import java.util.*;

public class Game {
    private int score;
    private int incorrectAnswers;
    private boolean gameRunning;
    private List<Phrase> phrasesList;
    private List<Word> wordsList;
    private Map<String, Colour> coloursList;
    private Set<String> used;

    public Game() {
        this.score = 0;
        this.incorrectAnswers = 0;
        this.gameRunning = true;
        this.phrasesList = new ArrayList<>();
        this.wordsList = new ArrayList<>();
        this.coloursList = new HashMap<>();
        this.used = new HashSet<>();
    }

    public static void main(String[] args) {
        CLI.main(args);
    }

    public void startGame() {
        setupPhrases();
        setupWords();
        setupColours();

        System.out.println("--------- Welcome to the Te Reo Māori game! --------- \n");
        incorrectAnswers = 0;
        score = 0;

        Scanner scanner = new Scanner(System.in);
        while (gameRunning) {
            runTurn(scanner);
            if (incorrectAnswers >= 3) {
                gameRunning = false;
            }
        }

        System.out.println("-------------------- !GAME OVER! --------------------");
        System.out.println("          Final Score: " + score + ",  Incorrect Answers: " + incorrectAnswers);
    }

    public void runTurn(Scanner scanner) {
        int randomNum = (int) (Math.random() * 3);
        switch (randomNum) {
            case 0:
                runColourTurn(scanner);
                break;
            case 1:
                runWordTurn(scanner);
                break;
            case 2:
                runPhraseTurn(scanner);
                break;
            default:
                throw new IllegalArgumentException("Invalid random number generated");
        }
    }

    private void runColourTurn(Scanner scanner) {
        Colour ansColour = null;
        while (ansColour == null) {
            int randNum = getRandNum(coloursList.size());
            ansColour = coloursList.get(coloursList.keySet().toArray()[randNum]);
            if (used.contains(ansColour.name())) {
                ansColour = null;
            }
        }
        used.add(ansColour.name());

        System.out.println("What is the English translation of: " + ansColour.name() + "? ");

        String playerInput = getPlayerInput(scanner);

        if (playerInput.equals(ansColour.englishName().toUpperCase())) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect! The correct answer was: " + ansColour.englishName());
            incorrectAnswers++;
        }

        System.out.println("    Score: " + score + ",  Incorrect Answers: " + incorrectAnswers);
        System.out.println("---------------------------------------------------- \n");
    }

    private void runWordTurn(Scanner scanner) {
        Word ansWord = null;
        while (ansWord == null) {
            int randNum = getRandNum(wordsList.size());
            ansWord = wordsList.get(randNum);
            if (used.contains(ansWord.name())) {
                ansWord = null;
            }
        }
        used.add(ansWord.name());
        System.out.println("What is the English translation of: " + ansWord.name() + "? ");

        String playerInput = getPlayerInput(scanner);

        if (playerInput.equals(ansWord.definition().toUpperCase())) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect! The correct answer was: " + ansWord.definition());
            incorrectAnswers++;
        }

        System.out.println("    Score: " + score + ",  Incorrect Answers: " + incorrectAnswers);
        System.out.println("---------------------------------------------------- \n");
    }

    private void runPhraseTurn(Scanner scanner) {
        Phrase ansPhrase = null;
        while (ansPhrase == null) {
            int randNum = getRandNum(phrasesList.size());
            ansPhrase = phrasesList.get(randNum);
            if (used.contains(ansPhrase.phrase())) {
                ansPhrase = null;
            }
        }
        used.add(ansPhrase.phrase());
        System.out.println("What is the English translation of: " + ansPhrase.phrase() + "? ");

        String playerInput = getPlayerInput(scanner);

        if (playerInput.equals(ansPhrase.englishPhrase().toUpperCase())) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect! The correct answer was: " + ansPhrase.englishPhrase());
            incorrectAnswers++;
        }

        System.out.println("    Score: " + score + ",  Incorrect Answers: " + incorrectAnswers);
        System.out.println("---------------------------------------------------- \n");
    }

    static int getRandNum(int size) {
        int number =  (int) (Math.random() * size);
        if (number == size) {
            number--;
        }
        return number;
    }

    public static String getPlayerInput(Scanner scanner) {
        String input = "";
        while (input.isEmpty()) {
            input = scanner.nextLine().trim().toUpperCase();
        }
        return input;
    }

    public void setupPhrases() {
        phrasesList = new ArrayList<>();
        phrasesList.add(new Phrase("Kia ora", "Hello"));
        phrasesList.add(new Phrase("Kei te pēhea koe?", "How are you?"));
        // TODO Add more phrases...
    }

    public void setupWords() {
        wordsList = new ArrayList<>();
        wordsList.add(new Word("Tahi", "One"));
        wordsList.add(new Word("Rua" , "Two"));
        // TODO Add more words...
    }

    public void setupColours() {
        coloursList = new HashMap<>();
        coloursList.put("Whero", new Colour("Whero", "Red"));
        coloursList.put("Karaka", new Colour("Karaka", "Orange"));
        // TODO Add more colors...
    }

    @Override
    public String toString() {
        return "Score: " + score + "\nIncorrect Answers: " + incorrectAnswers;
    }
}
