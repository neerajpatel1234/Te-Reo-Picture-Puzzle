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
        Game game = new Game();
        game.startGame(game);
    }

    public void startGame(Game game) {
        game.setupPhrases();
        game.setupWords();
        game.setupColours();

        System.out.println("--------- Welcome to the Te Reo Māori game! --------- \n");
        incorrectAnswers = 0;
        score = 0;

        while (gameRunning) {
            runTurn();
            if (incorrectAnswers >= 3) {
                gameRunning = false;
            }
        }

        System.out.println("-------------------- !GAME OVER! --------------------");
        System.out.println("          Final Score: " + score + ",  Incorrect Answers: " + incorrectAnswers);
    }

    public void runTurn() {
        int randomNum = (int) (Math.random() * 3);
        switch (randomNum) {
            case 0:
                runColourTurn();
                break;
            case 1:
                runWordTurn();
                break;
            case 2:
                runPhraseTurn();
                break;
            default:
                throw new IllegalArgumentException("Invalid random number generated");
        }
    }

    private void runColourTurn() {
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

        String playerInput = getPlayerInput();

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

    private void runWordTurn() {
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

        String playerInput = getPlayerInput();

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

    private void runPhraseTurn() {
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

        String playerInput = getPlayerInput();

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

    public static String getPlayerInput() {
        String input = "";
        while (input.isEmpty()) {
            if (System.console() != null) {
                input = System.console().readLine();
            } else {
                System.out.println("No console available. Please provide input:");
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextLine();
            }
        }
        return input.toUpperCase();
    }

    public void setupPhrases() {
        phrasesList = new ArrayList<>();
        phrasesList.add(new Phrase("Kia ora", "Hello"));
        phrasesList.add(new Phrase("Kei te pēhea koe?", "How are you?"));
        phrasesList.add(new Phrase("Kei te pai ahau", "I am good"));
        phrasesList.add(new Phrase("Nō hea koe?", "Where are you from?"));
        phrasesList.add(new Phrase("Nō Ingarangi ahau", "I am from England"));
        phrasesList.add(new Phrase("Ko wai tō ingoa?", "What is your name?"));
        phrasesList.add(new Phrase("Ko Jack tōku ingoa", "My name is Jack"));
        phrasesList.add(new Phrase("Ka kite anō", "See you later"));
        phrasesList.add(new Phrase("Ka kite", "Goodbye"));
        phrasesList.add(new Phrase("Ka kite anō", "See you later"));
    }

    public void setupWords() {
        wordsList = new ArrayList<>();
        wordsList.add(new Word("Tahi", "One"));
        wordsList.add(new Word("Rua" , "Two"));
        wordsList.add(new Word("Toru" , "Three"));
        wordsList.add(new Word("Whā" , "Four"));
        wordsList.add(new Word("Rima" , "Five"));
        wordsList.add(new Word("Ono" , "Six"));
        wordsList.add(new Word("Whitu" , "Seven"));
        wordsList.add(new Word("Waru" , "Eight"));
        wordsList.add(new Word("Iwa" , "Nine"));
        wordsList.add(new Word("Tekau" , "Ten"));
        wordsList.add(new Word("Kotahi tekau" , "Eleven"));
        wordsList.add(new Word("Rua tekau" , "Twenty"));
        wordsList.add(new Word("Tahi rau" , "One hundred"));
    }

    public void setupColours() {
        coloursList = new HashMap<>();
        coloursList.put("Whero", new Colour("Whero", "Red"));
        coloursList.put("Karaka", new Colour("Karaka", "Orange"));
        coloursList.put("Kākāriki", new Colour("Kākāriki", "Green"));
        coloursList.put("Kikorangi", new Colour("Kikorangi", "Blue"));
        coloursList.put("Tūāuri", new Colour("Tūāuri", "Brown"));
        coloursList.put("Mā", new Colour("Mā", "White"));
        coloursList.put("Mangu", new Colour("Mangu", "Black"));
        coloursList.put("Pango", new Colour("Pango", "Black"));
        coloursList.put("Parauri", new Colour("Parauri", "Grey"));
        coloursList.put("Kōwhai", new Colour("Kōwhai", "Yellow"));
    }

    public String toString() {
        return "Score: " + score + "\nIncorrect Answers: " + incorrectAnswers;
    }

   public List<Phrase> getPhrasesList() {
        return phrasesList;
    }

    public List<Word> getWordsList() {
        return wordsList;
    }

    public Map<String, Colour> getColoursList() {
        return coloursList;
    }




}