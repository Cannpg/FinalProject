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

  //create ArrayList for each Pool
  ArrayList<Object> Category1 = new ArrayList<Object>();
  ArrayList<Object> Category2 = new ArrayList<Object>();
  ArrayList<Object> Category3 = new ArrayList<Object>();

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

          // System.out.println(qName);
          // System.out.println(qAnswer1);
          // System.out.println(qAnswer2);
          // System.out.println(qAnswer3);
          // System.out.println(qAnswer4);
          // System.out.println(qCorrectAnswer);
          // System.out.println(qPointValue);
          // System.out.println(qCategory);

          Question q1 = new Question(qName, qAnswer1, qAnswer2, qAnswer3, qAnswer4, qCorrectAnswer, qPointValue, qCategory);

          //System.out.println(q1);
          Category1.add(q1);   
        }

        reader.close();
      }
    catch (IOException exception) {
    System.out.println("An error occurred: " + exception);
    }
  }
}