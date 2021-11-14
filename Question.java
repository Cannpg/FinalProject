public class Question{
  //Properties for each question
  String qName;
  String qAnswer1;
  String qAnswer2;
  String qAnswer3;
  String qAnswer4;
  int qCorrectAnswer;
  int qPointValue;
  boolean qAnswered;
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
    qAnswered = false;
    qCategory = "";
  }

  //Customer constructor
  Question(String newName, String newAnswer1, String newAnswer2, String newAnswer3, String newAnswer4, int correctAnswer, int newValue, boolean newAnswered, String newCategory){
    qName = newName;
    qAnswer1 = newAnswer1;
    qAnswer2 = newAnswer2;
    qAnswer3 = newAnswer3;
    qAnswer4 = newAnswer4;
    qCorrectAnswer = correctAnswer;
    qPointValue = newValue;
    qAnswered = newAnswered;
    qCategory = newCategory;
  }

  //Accessor methods

  public String getqName() {
    return qName;
  }
  public String getqAnswer1() {
    return qAnswer1;
  }
  public String getqAnswer2() {
    return qAnswer2;
  }
  public String getqAnswer3() {
    return qAnswer3;
  }
  public String getqAnswer4() {
    return qAnswer4;
  }
  public int getqCorrectAnswer() {
    return qCorrectAnswer;
  }
  public int getqPointValue() {
    return qPointValue;
  }
  public boolean getqAnswered() {
    return qAnswered;
  }
  public String getqCategory() {
    return qCategory;
  }

  //Mutator methods
  public void setqName(String qName) {
    this.qName = qName;
  }
  public void setqAnswer1(String qAnswer1) {
    this.qAnswer1 = qAnswer1;
  }
  public void setqAnswer2(String qAnswer2) {
    this.qAnswer2 = qAnswer2;
  }
  public void setqAnswer3(String qAnswer3) {
    this.qAnswer3 = qAnswer3;
  }
  public void setqAnswer4(String qAnswer4) {
    this.qAnswer4 = qAnswer4;
  }
  public void setqCorrectAnswer(int qCorrectAnswer) {
    this.qCorrectAnswer = qCorrectAnswer;
  }
  public void setqPointValue(int qPointValue) {
    this.qPointValue = qPointValue;
  }
  public void setqAnswered(boolean qAnswered) {
    this.qAnswered = qAnswered;
  }
  public void setqCategory(String qCategory) {
    this.qCategory = qCategory;
  }

}