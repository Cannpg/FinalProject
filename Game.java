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
  JLabel questionName = new JLabel();
  JButton questionBtn = new JButton("Click to get a question!");
  JButton btn1 = new JButton();
  JButton btn2 = new JButton();
  JButton btn3 = new JButton();
  JButton btn4 = new JButton();
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

  //function to check for the correct answer
  void chkAnswer(String SelectedAnswer, String Answer, int Points, int QuestionNum){

    if(SelectedAnswer.equals(Answer)){
      statusMessage.setText("That's correct! You have earned " + Points + " points!");
      gTotalScore += Points;
      questionBtn.setText("Next Question");
      pointCounter.setText("Current Points: " + gTotalScore);
      
      btn1.setEnabled(false);
      btn2.setEnabled(false);
      btn3.setEnabled(false);
      btn4.setEnabled(false);

      QuestionList.remove(QuestionNum);
    }
    else{
      statusMessage.setText("That's incorrect! Please try again.");
    }
  }

//reset function
  void resetScore(){
    btn1.setEnabled(false);
    btn2.setEnabled(false);
    btn3.setEnabled(false);
    btn4.setEnabled(false);
    btn1.setText("");
    btn2.setText("");
    btn3.setText("");
    btn4.setText("");
    statusMessage.setText("Welcome to the game! Press the Question Button to begin!");
    questionName.setText("");
    questionBtn.setText("Click to get a question!");
    gTotalScore = 0;
    pointCounter.setText("Current Points: " + gTotalScore);
    this.createQuestionObjects();
  }

//I named it test, but this is the main function that pulls from the Question ArrayList and generates each question
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
    //"End of the game" function
    else if(QuestionList.size() == 0){
      statusMessage.setText("Congratulations! You've completed the game!");
      btn1.setText("");
      btn2.setText("");
      btn3.setText("");
      btn4.setText("");
      questionName.setText("");
      questionBtn.setText("");
    }
  }


  //main constructor
  Game(){
    JFrame frame = new JFrame("Welcome to the game!");
    frame.setLayout(new FlowLayout());
    frame.setSize(600,400);

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
    frame.add(pointCounter);

    btn1.setEnabled(false);
    btn2.setEnabled(false);
    btn3.setEnabled(false);
    btn4.setEnabled(false);
    
    this.createQuestionObjects();

    frame.setVisible(true);
  }

  //actionlistener function
  public void actionPerformed(ActionEvent ae){
    //when you press the question button
    if(ae.getActionCommand().equals(questionBtn.getText())){
      this.test();
      btn1.setEnabled(true);
      btn2.setEnabled(true);
      btn3.setEnabled(true);
      btn4.setEnabled(true);
    }
    //else if for each button press. will check the button value (1-4) against the correct int
    else if(ae.getActionCommand().equals(btn1.getText())){
      //I use a substring(0,1) because all I want from the answer text is the number at the beginning
      chkAnswer(btn1.getText().substring(0,1), currentAnswer, currentValue, currentQuestion);
      //disabled the button after clicking to make sure that you can't click the right answer multiple times
      btn1.setEnabled(false);
    }
    else if(ae.getActionCommand().equals(btn2.getText())){
      chkAnswer(btn2.getText().substring(0,1), currentAnswer, currentValue, currentQuestion);
      btn2.setEnabled(false);
    }
    else if(ae.getActionCommand().equals(btn3.getText())){
      chkAnswer(btn3.getText().substring(0,1), currentAnswer, currentValue, currentQuestion);
      btn3.setEnabled(false);
    }
    else if(ae.getActionCommand().equals(btn4.getText())){
      chkAnswer(btn4.getText().substring(0,1), currentAnswer, currentValue, currentQuestion);
      btn4.setEnabled(false);
    }
    else if(ae.getActionCommand().equals("Reset")){
      this.resetScore();
    }
  }
}