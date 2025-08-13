package mini_world;

public class Grid {

  private final Entity[][] grid = new Entity[10][10];
  private int time = 1;

  public Entity[][] getGrid() {
    return grid;
  }

  public void setGrid(int x, int y, Entity entity) {
    this.grid[y][x] = entity;
  }

  public int getTime() {
    return time;
  }

  public boolean isProductionDay() {
    return time % 7 == 1;
  }

  @SuppressWarnings("UnnecessaryContinue")
  public void produceUnits() {
    for (int y = 0; y < 10; y++) {
      for (int x = 0; x < 10; x++) {
        Entity entity = grid[y][x];
        if (entity != null && entity.canSpawnEntity) {
          int firstSectorX = x - 1;
          int firstSectorY = y - 1;
          int[][] possibleDeploymentLocations = new int[9][2];
          int possibleDeploymentLength = 0;
          for (
            int vertical = firstSectorY;
            vertical < firstSectorY + 3;
            vertical++
          ) for (
            int horizontal = firstSectorX;
            horizontal < firstSectorX + 3;
            horizontal++
          ) {
            if (horizontal < 0 || horizontal > 9) continue; // X is out of boundaries
            else if (vertical < 0 || vertical > 9) continue; // Y is out of boundaries
            else if (grid[vertical][horizontal] != null) continue; // Sector is already taken by -> grid[vertical][horizontal].symbol
            else {
              possibleDeploymentLocations[possibleDeploymentLength][0] =
                vertical;
              possibleDeploymentLocations[possibleDeploymentLength][1] =
                horizontal;
              possibleDeploymentLength++;
            }
          }
          if (possibleDeploymentLength > 0) {
            int rolledDeployment = (int) (
              Math.random() * possibleDeploymentLength
            );
            int dY = possibleDeploymentLocations[rolledDeployment][0];
            int dX = possibleDeploymentLocations[rolledDeployment][1];
            char unitSymbol = Character.toLowerCase(entity.symbol);
            int unitSide = entity.side;
            Unit unit = new Unit(unitSymbol, unitSide);
            grid[dY][dX] = unit;
          }
        }
      }
    }
  }

  public void proceedTime() {
    time++;
  }
}
