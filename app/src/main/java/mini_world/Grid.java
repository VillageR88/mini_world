package mini_world;

public class Grid {

  private final char[][] grid = new char[10][10];

  public char[][] getGrid() {
    return grid;
  }

  public void setGrid(int x, int y, char newSymbol) {
    this.grid[x][y] = newSymbol;
  }
}
