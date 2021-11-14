import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 

public class Game implements ActionListener{
  //properties for each Game session
  int gTotalScore = 0;
  String currentAnswer = "";
  int currentValue = 0;
  int currentQuestion;

  //create RNG to determine questions
  Random r = new Random();

  //Scanner for user input
  Scanner s = new Scanner(System.in);

  //create ArrayList for each question
  ArrayList<Question> QuestionList = new ArrayList<Question>();

  //add Swing stuff here so that it can be accessed by other methods
  JLabel questionName = new JLabel("");
  JButton questionBtn = new JButton("Click to get a question!");
  JButton btn1 = new JButton("1");
  JButton btn2 = new JButton("2");
  JButton btn3 = new JButton("3");
  JButton btn4 = new JButton("4");
  JLabel statusMessage = new JLabel("Welcome to the game! Press the Question Button to begin!");
  JButton resetBtn = new JButton("Reset");
  JLabel pointCounter = new JLabel("Current Points: " + gTotalScore);

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
    questionName.setText(q1.qName);
    btn1.setText("1: " + q1.qAnswer1); //change to the button1.text and change the button1 actionListener to be ("1") so that we can still use the int to tell whether or not the user has selected the right answer.
    btn2.setText("2: " + q1.qAnswer2);
    btn3.setText("3: " + q1.qAnswer3);
    btn4.setText("4: " + q1.qAnswer4);
    statusMessage.setText("Which is the correct answer?");
    currentAnswer = String.valueOf(q1.qCorrectAnswer);
    currentValue = q1.qPointValue;
    currentQuestion = X;
  }

  void chkAnswer(String SelectedAnswer, String Answer, int Points, int QuestionNum){
    if(SelectedAnswer.equals(Answer)){
      statusMessage.setText("Congratulations! That's correct! You have earned " + Points + " points!");
      gTotalScore += Points;

      QuestionList.remove(QuestionNum);
    }
    else{
      statusMessage.setText("That's incorrect! Please try again.");
    }
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
    JFrame subframe1 = new JFrame();
    JFrame subframe2 = new JFrame();
    JFrame subframe3 = new JFrame();
    frame.setLayout(new FlowLayout());
    frame.setSize(400,400);

    questionBtn.addActionListener(this);
    btn1.addActionListener(this);
    btn2.addActionListener(this);
    btn3.addActionListener(this);
    btn4.addActionListener(this);
    resetBtn.addActionListener(this);

    frame.add(subframe1);
    frame.add(subframe2);
    frame.add(subframe3);

    subframe1.add(statusMessage);
    subframe2.add(questionName);
    subframe1.add(questionBtn);
    subframe2.add(btn1);
    subframe2.add(btn2);
    subframe2.add(btn3);
    subframe2.add(btn4);
    subframe3.add(resetBtn);
    subframe3.add(pointCounter);
    
    frame.setVisible(true);
    subframe1.setVisible(true);
    subframe2.setVisible(true);
    subframe3.setVisible(true);
  }

  public void actionPerformed(ActionEvent ae){
    if(ae.getActionCommand().equals("Click to get a question!")){
      this.createQuestionObjects();
      this.test();
    }
    else if(ae.getActionCommand().equals(btn1.getText())){
      chkAnswer(btn1.getText().substring(0,1), currentAnswer, currentValue, currentQuestion);
      System.out.println(currentAnswer);
    }
    else if(ae.getActionCommand().equals(btn2.getText())){
      chkAnswer(btn2.getText().substring(0,1), currentAnswer, currentValue, currentQuestion);
      System.out.println(currentAnswer);
    }
    else if(ae.getActionCommand().equals(btn3.getText())){
      chkAnswer(btn3.getText().substring(0,1), currentAnswer, currentValue, currentQuestion);
      System.out.println(currentAnswer);
    }
    else if(ae.getActionCommand().equals(btn4.getText())){
      chkAnswer(btn4.getText().substring(0,1), currentAnswer, currentValue, currentQuestion);
      System.out.println(currentAnswer);
    }
    else if(ae.getActionCommand().equals("Reset")){
      this.resetScore();
    }
  }
}