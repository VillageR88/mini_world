package mini_world;

import java.util.Scanner;

public class App {

  private static void drawWorld(Grid grid) {
    for (Entity[] row : grid.getGrid()) {
      for (Entity element : row) {
        System.out.print(element != null ? element.symbol : '_');
        System.out.print("  ");
      }
      System.out.print("\n");
    }
  }

  public static void seedGrid(Grid grid) {
    Base player1Base = new Base('A', 1);
    grid.setGrid(0, 0, player1Base);
  }

  public static void main(String[] args) {
    System.out.println("Welcome to mini world.\n");
    Scanner myScanner = new Scanner(System.in);
    Grid grid = new Grid();
    seedGrid(grid);
    String myInput = "";
    while (!"q".equals(myInput)) {
      System.out.println(
        "Day " +
        grid.getTime() +
        (grid.isProductionDay() ? " (production day)" : "") +
        "\n"
      );
      if (grid.isProductionDay()) grid.produceUnits();
      grid.moveUnits();
      App.drawWorld(grid);
      System.out.print("\n");
      System.out.println(
        "any word or letter to continue simulation or q to quit."
      );
      myInput = myScanner.nextLine();
      grid.eraseSkipLegDayCoordinates();
      grid.proceedTime();
    }
    myScanner.close();
  }
}
