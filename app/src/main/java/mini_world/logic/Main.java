package mini_world.logic;

import mini_world.model.Base;
import mini_world.model.Grid;
import mini_world.ui.MainApp;

public class Main {

  private static final Grid grid = new Grid();

  private static void seedGrid(Grid grid) {
    Base player1Base = new Base('A', 1);
    Base player2Base = new Base('B', 2);
    grid.setGrid(0, 0, player1Base);
    grid.setGrid(9, 9, player2Base);
  }

  private static void simulateOneDay(Grid grid) {
    if (Main.grid.isProductionDay()) grid.produceUnits();
    grid.doFight();
    grid.moveUnits();
    grid.eraseSkipLegDayCoordinates();
  }

  /**
   * @UIOnly
   * Use only in ui sub-package
   */
  public static void simulateNextDay() {
    grid.proceedTime();
    simulateOneDay(grid);
  }

  public static boolean getEntityNotNull(int x, int y) {
    return grid.grid[y][x] != null;
  }

  public static boolean getEntityCanSpawnEntity(int x, int y) {
    return grid.grid[y][x].getCanSpawnEntity();
  }

  public static int getEntitySide(int x, int y) {
    return grid.grid[y][x].side;
  }

  public static int getTime() {
    return grid.time;
  }

  public static boolean isProductionDay() {
    return grid.isProductionDay();
  }

  public static void main(String[] args) {
    Main.seedGrid(grid);
    Main.simulateOneDay(grid);
    MainApp.launch(MainApp.class, args);
  }
}
