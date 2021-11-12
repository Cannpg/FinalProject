import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

class Main {
  public static void main(String[] args) {
    Game g = new Game();
    //run function to create question objects
    g.createQuestionObjects();
    //get every question name
    for(int i=0; i<g.QuestionList.size(); i++){
      System.out.println(g.QuestionList.get(i).getqName());
    }
    //line break
    System.out.println();
    System.out.println("---------------------------");
    System.out.println("test question");

    g.Question1();
  }
}