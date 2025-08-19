package mini_world.logic;

import mini_world.model.Grid;
import mini_world.ui.MainApp;

public class Main {

  private static final Grid grid = new Grid();

  /**
   * @UIOnly
   * Use only in ui sub-package
   */
  public static void simulateNextDay() {
    grid.simulateNextDay();
  }

  public static boolean getEntityNotNull(int x, int y) {
    return grid.isNotNullEntity(x, y);
  }

  public static boolean getEntityCanSpawnEntity(int x, int y) {
    return grid.canSpawnEntity(x, y);
  }

  public static int getEntitySide(int x, int y) {
    return grid.getEntitySide(x, y);
  }

  public static int getTime() {
    return grid.getTime();
  }

  public static boolean isProductionDay() {
    return grid.isProductionDay();
  }

  public static void main(String[] args) {
    MainApp.launch(MainApp.class, args);
  }
}
