package morpion;

import javafx.application.Platform;

public class Executable{
  public static void main(String[] arg){
    Platform.runLater(new Mastermind());
  }
}
