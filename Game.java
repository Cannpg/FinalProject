import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.SwingConstants;
import java.awt.*; 
import java.awt.event.*; 

public class Game implements ActionListener{
  //properties for each Game session
  int gNumQuestions;
  int gNumTurns;
  int gTotalScore = 0;

  //create RNG to determine questions
  Random r = new Random();

  //Scanner for user input
  Scanner s = new Scanner(System.in);

  //create ArrayList for each question
  ArrayList<Question> QuestionList = new ArrayList<Question>();

  //r/w operations
  void createQuestionObjects(){
    try{
        FileReader myFile;
        myFile = new FileReader("questions.txt");
        BufferedReader reader = new BufferedReader(myFile);

        while (reader.ready()) {
          String qName = reader.readLine();
          String qAnswer1 = reader.readLine();
          String qAnswer2 = reader.readLine();
          String qAnswer3 = reader.readLine();
          String qAnswer4 = reader.readLine();
          int qCorrectAnswer = Integer.parseInt(reader.readLine());
          int qPointValue = Integer.parseInt(reader.readLine());
          boolean qAnswered = Boolean.parseBoolean(reader.readLine());
          String qCategory = reader.readLine();

          //use Constructor to create Question objects
          Question q = new Question(qName, qAnswer1, qAnswer2, qAnswer3, qAnswer4, qCorrectAnswer, qPointValue, qAnswered, qCategory);

          QuestionList.add(q);   
        }

        reader.close();
      }
    catch (IOException exception) {
    System.out.println("An error occurred: " + exception);
    }
  }

  void QuestionX(int X){
    Question q1 = QuestionList.get(X);
    System.out.println(q1.qName);
    System.out.println("1: " + q1.qAnswer1); //change to the button1.text and change the button1 actionListener to be ("1") so that we can still use the int to tell whether or not the user has selected the right answer.
    System.out.println("2: " + q1.qAnswer2);
    System.out.println("3: " + q1.qAnswer3);
    System.out.println("4: " + q1.qAnswer4);
    System.out.println("\nWhich is the correct answer? (Type in the number of the answer you believe is correct)");

    //intead of using the scanner, we use the button click event's actionListener to tell use what the input is
    int userGuess = s.nextInt();

    //while loop to allow multiple guesses
    while(userGuess != q1.qCorrectAnswer){
      //this is irrelevant for the buttons
      //if the guess is outside of 1-4 throw error
      while(userGuess > 4 || userGuess < 1){
        System.out.println("Please enter a number between 1 and 4.");
        userGuess = s.nextInt();
      }
      //if guess is within 1-4, but wrong, ask to try again
      //we could do something like reducing the number of points earned for each failed attempt
      System.out.println("That's incorrect! Please try again.");
      userGuess = s.nextInt();
    }

    //change the dialogue label to be this
    System.out.println("Congratulations! That's correct! You have earned " + q1.qPointValue + " points!");
    gTotalScore += q1.qPointValue;

    QuestionList.remove(X);
  }

  void resetScore(){
    gTotalScore = 0;
  }

  void test(){
    double rng = r.nextDouble();

    if(QuestionList.size() == 6){
      if(rng <= 0.17){
        this.QuestionX(0);
      }
      else if(rng > 0.17 && rng <= 0.34){
        this.QuestionX(1);
      }
      else if(rng > 0.34 && rng <= 0.51){
        this.QuestionX(2);
      }
      else if(rng > 0.51 && rng <= 0.68){
        this.QuestionX(3);
      }
      else if(rng > 0.68 && rng <= 0.85){
        this.QuestionX(4);
      }
      else{
        this.QuestionX(5);
      }
    }
    else if(QuestionList.size() == 5){
      if(rng <= 0.20){
        this.QuestionX(0);
      }
      else if(rng > 0.20 && rng <= 0.40){
        this.QuestionX(1);
      }
      else if(rng > 0.40 && rng <= 0.60){
        this.QuestionX(2);
      }
      else if(rng > 0.60 && rng <= 0.80){
        this.QuestionX(3);
      }
      else{
        this.QuestionX(4);
      }
    }
    else if(QuestionList.size() == 4){
      if(rng <= 0.25){
        this.QuestionX(0);
      }
      else if(rng > 0.25 && rng <= 0.50){
        this.QuestionX(1);
      }
      else if(rng > 0.50 && rng <= 0.75){
        this.QuestionX(2);
      }
      else if(rng > 0.75 && rng <= 0.80){
        this.QuestionX(3);
      }
    }
    else if(QuestionList.size() == 3){
      if(rng <= 0.33){
        this.QuestionX(0);
      }
      else if(rng > 0.33 && rng <= 0.66){
        this.QuestionX(1);
      }
      else{
        this.QuestionX(2);
      }
    }
    else if(QuestionList.size() == 2){
      if(rng <= 0.50){
        this.QuestionX(0);
      }
      else{
        this.QuestionX(1);
      }
    }
    else if(QuestionList.size() == 1){
      this.QuestionX(0);
    }
    else if(QuestionList.size() == 0){
      System.out.println("Congratulations! You've completed the game!");
    }
  }

  Game(){
    JFrame frame = new JFrame("Welcome to the game!");
    frame.setLayout(new FlowLayout());
    frame.setSize(400,400);
    JLabel questionName = new JLabel("");
    JButton questionBtn = new JButton("Click to get a question!");
    JButton btn1 = new JButton("");
    JButton btn2 = new JButton("");
    JButton btn3 = new JButton("");
    JButton btn4 = new JButton("");
    JLabel statusMessage = new JLabel("Welcome to the game! Press the Question Button to begin!");
    JButton resetBtn = new JButton("Reset");

    questionBtn.addActionListener(this);
    btn1.addActionListener(this);
    btn2.addActionListener(this);
    btn3.addActionListener(this);
    btn4.addActionListener(this);
    resetBtn.addActionListener(this);

    frame.add(statusMessage);
    frame.add(questionName);
    frame.add(questionBtn);
    frame.add(btn1);
    frame.add(btn2);
    frame.add(btn3);
    frame.add(btn4);
    frame.add(resetBtn);
    
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent ae){
    if(ae.getActionCommand().equals("Click to get a question!")){
      this.test();
    }
    else if(ae.getActionCommand().equals("Play Again")){
      
    }
    else{

    }
  }
}