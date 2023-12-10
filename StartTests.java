import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

/**
 * This class is the test class for the Game class.
 * @version 1.0
 */
class StartTests {

    /**
     * This method will test the getRandNum method.
     */
    @Test
    void testGetRandNum() {
        int randNum = Game.getRandNum(10);
        assertTrue(randNum >= 0 && randNum < 10);
    }

    /**
     * This method will test the getPlayerInput method.
     */
    @Test
    void testPlayerInput() {
        // Assuming getPlayerInput() reads from console input
        // You may need to manually test this method in your IDE

        // Mocking user input for testing
        // You may need to replace this with your own mock input
        System.setIn(new ByteArrayInputStream("TEST".getBytes()));
        String input = Game.getPlayerInput();
        assertEquals("TEST", input);
    }

    /**
     * This method will test the setupPhrases method.
     */
    @Test
    void testSetupPhrases() {
        Game game = new Game();
        game.setupPhrases();
        assertNotNull(game.getPhrasesList());
        assertFalse(game.getPhrasesList().isEmpty());
    }

    /**
     * This method will test the setupWords method.
     */
    @Test
    void testSetupWords() {
        Game game = new Game();
        game.setupWords();
        assertNotNull(game.getWordsList());
        assertFalse(game.getWordsList().isEmpty());
    }

    /**
     * This method will test the setupColours method.
     */
    @Test
    void testSetupColours() {
        Game game = new Game();
        game.setupColours();
        assertNotNull(game.getColoursList());
        assertFalse(game.getColoursList().isEmpty());
    }
}
