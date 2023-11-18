//********************************************************************
// RockPaperScissors.java Author: class
//
// Demonstrates the use of one listener for multiple buttons.
//********************************************************************
import javax.swing.JFrame;
public class RockPaperScissors
{
 //-----------------------------------------------------------------
 // Creates the main program frame.
 //-----------------------------------------------------------------
 public static void main(String[] args)
 {
 JFrame frame = new JFrame("Rock, Paper, Scissors");
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.getContentPane().add(new RPSPanel());
 frame.getContentPane().add(new RPSPanel());
 frame.getContentPane().add(new RPSPanel());
 frame.getContentPane().add(new RPSPanel());

 frame.pack();
 frame.setVisible(true);
 }
}
