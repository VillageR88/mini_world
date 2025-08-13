package mini_world;

import java.util.Scanner;

public class App {

  private static void drawWorld(Grid grid) {
    for (char[] row : grid.getGrid()) {
      for (char element : row) {
        System.out.print(element != 0 ? element : '_');
        System.out.print("  ");
      }
      System.out.print("\n");
    }
  }

  public static void main(String[] args) {
    Scanner myScanner = new Scanner(System.in);
    Grid grid = new Grid();
    String myInput = "";
    while (!"q".equals(myInput)) {
      App.drawWorld(grid);
      System.out.print("\n");
      System.out.println(
        "any word or letter to continue simulation or q to quit."
      );
      myInput = myScanner.nextLine();
    }
    myScanner.close();
  }
}
