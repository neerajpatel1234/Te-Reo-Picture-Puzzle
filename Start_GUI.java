import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start_GUI {
  /**
   * Main method to start the game
   * @param args
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(Start_GUI::showSelectorMenu);
  }

  private static void showSelectorMenu() {
    JFrame frame = new JFrame("Te Reo Picture Game by Neeraj Patel");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS)); // Set layout to vertical

    // ----- Create the buttons -----
    JButton button1 = new JButton("Command Line Game");
    JButton button2 = new JButton("GUI Game");

    // ----- Add action listeners to the buttons -----
    button1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        selectedCommandLine();
      }
    });

    button2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        selectedGUI();
      }
    });

    // ----- Add the buttons to the frame -----
    frame.add(button1);
    frame.add(button2);

    // ----- Set the frame size and location ------
    frame.pack(); // Adjust frame size based on contents
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  private static void selectedCommandLine() {
    CLI_Game game = new CLI_Game();
    game.startGame();
  }

  private static void selectedGUI() {
    GUI_Game game = new GUI_Game();
  }
}
