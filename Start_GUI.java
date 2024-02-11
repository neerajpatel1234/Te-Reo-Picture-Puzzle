import javax.swing.*;

public class Start_GUI {
  /**
   * Main method to start the game
   * @param args command line arguments
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(Start_GUI::showSelectorMenu);
  }

  /**
   * Show the selector menu
   */
  private static void showSelectorMenu() {
    JFrame frame = new JFrame("Te Reo Picture Game");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

    // ----- Create the buttons -----
    JButton button1 = new JButton("Command Line Game");
    JButton button2 = new JButton("GUI Game");
    button1.setAlignmentX(JButton.CENTER_ALIGNMENT);
    button2.setAlignmentX(JButton.CENTER_ALIGNMENT);


    // ----- Add action listeners to the buttons -----
    button1.addActionListener(e -> selectedCommandLine());
    button2.addActionListener(e -> selectedGUI());

    // ----- Add the buttons to the frame -----
    frame.add(button1);
    frame.add(button2);

    // ----- Set the frame size and location ------
    frame.setSize(250, 90);
    frame.setLocationRelativeTo(null);

    JOptionPane.showMessageDialog(null, """
                                                            Welcome to the Te Reo Picture Game!
            The game will randomly select a word, colour or phrase and you will need to enter the picture to the word, colour or phrase.
                                                    You will have 3 attempts to get the correct answer.
                                                                         Good luck!                                                        \s""");
    frame.setVisible(true);
  }

  private static void selectedCommandLine() {
    CLI_Game game = new CLI_Game();
    game.startGame();
  }

  private static void selectedGUI() {
    GUI_Game game = new GUI_Game();
    game.startGame();
  }
}
