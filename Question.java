public class Question{
  //Properties for each question
  String qName;
  String qAnswer1;
  String qAnswer2;
  String qAnswer3;
  String qAnswer4;
  int qCorrectAnswer;
  int qPointValue;
  String qCategory;

  //Default constructor
  Question(){
    qName = "";
    qAnswer1 = "";
    qAnswer2 = "";
    qAnswer3 = "";
    qAnswer4 = "";
    qCorrectAnswer = 0;
    qPointValue = 0;
    qCategory = "";
  }

  //Customer constructor
  Question(String newName, String newAnswer1, String newAnswer2, String newAnswer3, String newAnswer4, int correctAnswer, int newValue, String newCategory){
    qName = newName;
    qAnswer1 = newAnswer1;
    qAnswer2 = newAnswer2;
    qAnswer3 = newAnswer3;
    qAnswer4 = newAnswer4;
    qCorrectAnswer = correctAnswer;
    qPointValue = newValue;
    qCategory = newCategory;
  }

  //Accessor methods

  //Mutator methods

}