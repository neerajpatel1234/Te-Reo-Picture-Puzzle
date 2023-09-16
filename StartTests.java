import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

/**
 * This class is the test class for the Game class.
 * @version 1.0
 */
class StartTests {

    /**
     * This method will set up the test class.
     */
    @Test
    void testGetRandNum() {
        int randNum = Game.getRandNum(10);
        assertTrue(randNum >= 0 && randNum < 10);
    }

    /**
     * This method will test the player input.
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
     * This method will test the setup phrases.
     */
    @Test
    void testSetupPhrases() {
        Game.setupPhrases();
        assertNotNull(Game.phrasesList);
        assertFalse(Game.phrasesList.isEmpty());
    }

    /**
     * This method will test the setup words.
     */
    @Test
    void testSetupWords() {
        Game.setupWords();
        assertNotNull(Game.wordsList);
        assertFalse(Game.wordsList.isEmpty());
    }

    /**
     * This method will test the setup colours.
     */
    @Test
    void testSetupColours() {
        Game.setupColours();
        assertNotNull(Game.coloursList);
        assertFalse(Game.coloursList.isEmpty());
    }

}
