import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;


public class GuessingGame implements ActionListener {
  JTextField userGuess;
  JButton Guess, playAgain;
  JLabel enterGuess, guessHighLow, lastGuess;
  Random r = new Random();
  int randNum;


  GuessingGame() {
    Random r = new Random();
    randNum = r.nextInt(100) + 1;

    JFrame frame = new JFrame("Guessing Game");
    frame.setLayout(new FlowLayout());
    frame.setSize(240, 120);

    userGuess = new JTextField(10);
    userGuess.setActionCommand("myTF");

    Guess = new JButton("Guess");
    playAgain = new JButton("Play Again");

    userGuess.addActionListener(this);
    Guess.addActionListener(this);
    playAgain.addActionListener(this);

    enterGuess = new JLabel("Enter your guess:");
    guessHighLow = new JLabel("");
    lastGuess = new JLabel("");

    frame.add(enterGuess);
    frame.add(userGuess);
    frame.add(Guess);
    frame.add(guessHighLow);
    frame.add(lastGuess);
    frame.add(playAgain);

    frame.setVisible(true);

  }

public void actionPerformed(ActionEvent ae) {
  if(ae.getActionCommand().equals("Guess")) {
    int guess = Integer.parseInt(userGuess.getText());

    if(guess > randNum) {
      guessHighLow.setText("Too High!");
    }
    if(guess < randNum){
      guessHighLow.setText("Too Low!");
    }
    if (guess == randNum) {
      guessHighLow.setText("You got it!");
    }
    lastGuess.setText("Last guess was: " + guess);
  }
  else if (ae.getActionCommand().equals("Play Again")){
      randNum = r.nextInt(100) + 1;

      enterGuess.setText("Enter your guess: ");
      guessHighLow.setText("");
      lastGuess.setText("");
      userGuess.setText("");
    }
    else {
      guessHighLow.setText("You pressed Enter. Please press the Guess button.");
    }
}

}