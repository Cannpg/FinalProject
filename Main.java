import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

class Main {
  public static void main(String[] args) {
    Game g = new Game();
    g.createQuestionObjects();
    System.out.println(g.Category1.size());
  }
}