import javax.swing.*;


class Main {
  public static void main(String[] args) {
    Game g = new Game();
    //run function to create question objects
    g.createQuestionObjects();

    SwingUtilities.invokeLater(new Runnable() {
     public void run() {
        new Game();
     }
   });
  }
}