package mini_world;

public class Grid {

  private final Entity[][] grid = new Entity[10][10];
  private int time = 1;

  public Entity[][] getGrid() {
    return grid;
  }

  public void setGrid(int x, int y, Entity entity) {
    this.grid[x][y] = entity;
  }

  public int getTime() {
    return time;
  }

  public boolean isProductionDay() {
    return time % 7 == 1;
  }

  public void produceUnits() {
    for (Entity[] row : grid) {
      for (Entity element : row) {}
    }
  }

  public void proceedTime() {
    time++;
  }
}
