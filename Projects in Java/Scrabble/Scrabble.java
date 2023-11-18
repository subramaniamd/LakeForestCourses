//********************************************************************
// RockPaperScissors.java Author: class
//
// Demonstrates the use of one listener for multiple buttons.
//********************************************************************
import javax.swing.JFrame;
public class Scrabble
{
 //-----------------------------------------------------------------
 // Creates the main program frame.
 //-----------------------------------------------------------------
 public static void main(String[] args)
 {
 JFrame frame = new JFrame("Let's Play Scrabble!");
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.getContentPane().add(new ScrabblePanel());

 frame.pack();
 frame.setVisible(true);
 }
}
