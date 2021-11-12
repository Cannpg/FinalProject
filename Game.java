import java.util.*;
import java.io.*;

public class Game{
  //properties for each Game session
  int gNumQuestions;
  int gNumTurns;
  double gTotalScore;

  //create RNG to determine questions
  Random r = new Random();
  double rng = r.nextDouble();

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
          String qCategory = reader.readLine();

          //use Constructor to create Question objects
          Question q = new Question(qName, qAnswer1, qAnswer2, qAnswer3, qAnswer4, qCorrectAnswer, qPointValue, qCategory);

          QuestionList.add(q);   
        }

        reader.close();
      }
    catch (IOException exception) {
    System.out.println("An error occurred: " + exception);
    }
  }

  void Question1(){
    Question q1 = QuestionList.get(0);
    System.out.println(q1.qName);
    System.out.println("1: " + q1.qAnswer1);
    System.out.println("2: " + q1.qAnswer2);
    System.out.println("3: " + q1.qAnswer3);
    System.out.println("4: " + q1.qAnswer4);
    System.out.println("\nWhich is the correct answer? (Type in the number of the answer you believe is correct)");
    int userGuess = s.nextInt();

  //while loop to allow multiple guesses
    while(userGuess != q1.qCorrectAnswer){
      //if the guess is outside of 1-4 throw error
      if(userGuess > 4 || userGuess < 1){
        while(userGuess > 4 || userGuess < 1){
          System.out.println("Please enter a number between 1 and 4.");
          userGuess = s.nextInt();
      }
      //if guess is within 1-4, but wrong, ask to try again
      //we could do something like reducing the number of points earned for each failed attempt
      System.out.println("That's incorrect! Please try again.");
      userGuess = s.nextInt();
    }}

    System.out.println("Congratulations! That's correct! You have earned " + q1.qPointValue + " points!");
  }
}