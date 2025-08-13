package mini_world;

public class Grid {

  private final char[][] grid = new char[10][10];
  private int time = 1;

  public char[][] getGrid() {
    return grid;
  }

  public void setGrid(int x, int y, char newSymbol) {
    this.grid[x][y] = newSymbol;
  }

  public int getTime() {
    return time;
  }

  public boolean isProductionDay() {
    return time % 7 == 1;
  }

  public void proceedTime() {
    time++;
  }
}
