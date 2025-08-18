package mini_world.model;

public class Grid {

  private final Entity[][] grid = new Entity[10][10];
  private int time = 1;
  private final boolean[][] skipLegDayCoordinates = new boolean[10][10];

  public void eraseSkipLegDayCoordinates() {
    for (int y = 0; y < 10; y++) {
      for (int x = 0; x < 10; x++) {
        skipLegDayCoordinates[y][x] = false;
      }
    }
  }

  public int getTime() {
    return time;
  }

  public void setGrid(int x, int y, Entity entity) {
    this.grid[y][x] = entity;
  }

  public boolean isNotNullEntity(int x, int y) {
    return grid[y][x] != null;
  }

  public boolean canSpawnEntity(int x, int y) {
    return grid[y][x].getCanSpawnEntity();
  }

  public int getEntitySide(int x, int y) {
    return grid[y][x].getSide();
  }

  public boolean isProductionDay() {
    return time % 7 == 1;
  }

  private class ScanResult {

    int[][] possibleLocations;
    int possibilitiesLength;

    public ScanResult(int[][] possibleLocations, int possibilitiesLength) {
      this.possibleLocations = possibleLocations;
      this.possibilitiesLength = possibilitiesLength;
    }
  }

  private enum Stance {
    AVOID,
    FIGHT,
  }

  private ScanResult perimeterScan(
    int x,
    int y,
    boolean condition,
    Stance stance
  ) {
    if (condition) {
      int firstSectorX = x - 1;
      int firstSectorY = y - 1;
      ScanResult scanResult = new ScanResult(new int[9][2], 0);
      for (
        int vertical = firstSectorY;
        vertical < firstSectorY + 3;
        vertical++
      ) for (
        int horizontal = firstSectorX;
        horizontal < firstSectorX + 3;
        horizontal++
      ) {
        if (horizontal < 0 || horizontal > 9) continue;
        if (vertical < 0 || vertical > 9) continue;
        if (
          stance == Stance.AVOID && grid[vertical][horizontal] != null
        ) continue;
        if (stance == Stance.FIGHT) {
          if (grid[vertical][horizontal] == null) continue;
          if (
            grid[vertical][horizontal].getSide() == grid[y][x].getSide()
          ) continue;
        }
        scanResult.possibleLocations[scanResult.possibilitiesLength][0] =
          vertical;
        scanResult.possibleLocations[scanResult.possibilitiesLength][1] =
          horizontal;
        scanResult.possibilitiesLength++;
      }
      return scanResult;
    }
    return null;
  }

  public void produceUnits() {
    for (int y = 0; y < 10; y++) {
      for (int x = 0; x < 10; x++) {
        Entity entity = grid[y][x];
        ScanResult scanResult = perimeterScan(
          x,
          y,
          entity != null && entity.getCanSpawnEntity(),
          Stance.AVOID
        );
        if (scanResult == null) continue;
        if (scanResult.possibilitiesLength > 0) {
          int rolledDeployment = (int) (
            Math.random() * scanResult.possibilitiesLength
          );
          int dY = scanResult.possibleLocations[rolledDeployment][0];
          int dX = scanResult.possibleLocations[rolledDeployment][1];
          char unitSymbol = Character.toLowerCase(entity.getSymbol());
          int unitSide = entity.getSide();
          Unit unit = new Unit(unitSymbol, unitSide);
          grid[dY][dX] = unit;
          skipLegDayCoordinates[dY][dX] = true;
        }
      }
    }
  }

  public void doFight() {
    for (int y = 0; y < 10; y++) {
      for (int x = 0; x < 10; x++) {
        Entity entity = grid[y][x];
        ScanResult scanResult = perimeterScan(
          x,
          y,
          entity != null,
          Stance.FIGHT
        );
        if (scanResult == null) continue;
        if (scanResult.possibilitiesLength > 0) {
          int rolledFight = (int) (
            Math.random() * scanResult.possibilitiesLength
          );
          int fY = scanResult.possibleLocations[rolledFight][0];
          int fX = scanResult.possibleLocations[rolledFight][1];
          if ((int) (Math.random() * 2) == 1) grid[fY][fX] =
            null; else grid[y][x] = null;
        }
      }
    }
  }

  public void moveUnits() {
    for (int y = 0; y < 10; y++) {
      for (int x = 0; x < 10; x++) {
        Entity entity = grid[y][x];
        ScanResult scanResult = perimeterScan(
          x,
          y,
          entity != null && entity.getCanMove(),
          Stance.AVOID
        );
        if (skipLegDayCoordinates[y][x] == true) continue;
        if (scanResult == null) continue;
        if (scanResult.possibilitiesLength > 0) {
          int rolledMove = (int) (
            Math.random() * scanResult.possibilitiesLength
          );
          int mY = scanResult.possibleLocations[rolledMove][0];
          int mX = scanResult.possibleLocations[rolledMove][1];
          grid[mY][mX] = grid[y][x];
          skipLegDayCoordinates[mY][mX] = true;
          grid[y][x] = null;
        }
      }
    }
  }

  public void proceedTime() {
    time++;
  }
}
