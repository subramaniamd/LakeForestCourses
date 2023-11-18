//********************************************************************
// RPSPanel.java Author: class
//
// Demonstrates the use of one listener for multiple buttons.
//********************************************************************
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class RPSPanel extends JPanel
{
 private JButton rock, paper, scissors, gameover;
 private JLabel label, label1, label2;
 private JPanel buttonPanel;
 private int me, winner, realtie;
 private int wins = 0;
 private int ties = 0; //correction due to winner calculation.
 private int losses = 0;
 private String mestring, compstring;
 private subpanel comp;
 //-----------------------------------------------------------------
 // Constructor: Sets up the GUI.
 //-----------------------------------------------------------------
 public RPSPanel()
 {
 rock = new JButton("Rock");
 paper = new JButton("Paper");
 scissors = new JButton("Scissors");
 gameover = new JButton("Results?");
 ButtonListener listener = new ButtonListener();
 rock.addActionListener(listener);
 paper.addActionListener(listener);
 scissors.addActionListener(listener);
 gameover.addActionListener(listener);
 label = new JLabel("Shoot!");
 label1 = new JLabel("You chose:");
 label2 = new JLabel("Computer chose:");
 buttonPanel = new JPanel();
 buttonPanel.setPreferredSize(new Dimension(300, 300));
 buttonPanel.setBackground(Color.blue);
 buttonPanel.add(rock);
 buttonPanel.add(paper);
 buttonPanel.add(scissors);
 buttonPanel.add(gameover);
 setPreferredSize(new Dimension(450, 450));
 setBackground(Color.green);
 add(label);
 add(label1);
 add(label2);


 add(buttonPanel);
 }

 //*****************************************************************
// Represents a listener for both buttons.
//*****************************************************************
private class ButtonListener implements ActionListener
{


//--------------------------------------------------------------
// Determines which button was pressed and sets the label
// text accordingly.
//--------------------------------------------------------------

public void actionPerformed(ActionEvent event)
{
  comp = new subpanel();
  int computer = comp.getComp();

///////COMPUTER/////////////////////////////////////////////////////////////////

if (computer == 0){
  compstring = "paper.";
  comp = new subpanel();
  computer = comp.getComp();


}
else if (computer == 1){
  compstring = "rock.";
  comp = new subpanel();
  computer = comp.getComp();


}
else {
  compstring = "scissor.";
  comp = new subpanel();
  computer = comp.getComp();


}

//////////////ME////////////////////////////////////////////////////////////////

if (event.getSource() == gameover){
  label.setText("Wins: " + wins);
  label1.setText("Losses: " + losses);
  label2.setText("Ties:" + ties);
  buttonPanel.setVisible(false);


}
else if (event.getSource() == rock){
  me = 1;
  mestring = "rock.";
  label1.setText("You chose: " + mestring);
  label2.setText("Computer chose: " + compstring);
}
else if (event.getSource() == scissors){
  me = 2;
  mestring = "scissors.";
  label1.setText("You chose: " + mestring);
  label2.setText("Computer chose: " + compstring);

}
else {
  me = 0;
  mestring = "paper.";
  label1.setText("You chose: " + mestring);
  label2.setText("Computer chose: " + compstring);

}

//////label: who chose what/////////////////////////////////////////////////////





////////label: RESULTS//////////////////////////////////////////////////////////

if (event.getSource() == gameover){
  //int realtie = ties - 1;
  ///////WINNER///////////////////////////////////////////////////////////////////

      winner = (me + 2 - computer) % 3;   ////use modulo to calculate who wins.
      if (winner == 0){
        label.setText("Computer wins!");
        losses++;
      }
      else if (winner == 2){
        label.setText("It's a tie!");
        ties++;
      }
      else if (winner == 1){
        label.setText("You win! Computer loses!");
        wins++;
      }
      else {}

  buttonPanel.setVisible(false);
  label.setText("Wins: " + wins);
  label1.setText("Losses: " + losses);
  label2.setText("Ties:" + ties);
}
}
}
}
