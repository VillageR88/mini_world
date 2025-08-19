package mini_world.model;

public class Entity {

  private final boolean canSpawnEntity;
  private final boolean canMove;
  private final boolean canFight;
  private final char symbol;
  private final int side;

  public boolean getCanSpawnEntity() {
    return canSpawnEntity;
  }

  public boolean getCanMove() {
    return canMove;
  }

  public boolean getCanFight() {
    return canFight;
  }

  public char getSymbol() {
    return symbol;
  }

  public int getSide() {
    return side;
  }

  public Entity(
    boolean canSpawnEntity,
    boolean canMove,
    boolean canFight,
    char symbol,
    int side
  ) {
    this.canSpawnEntity = canSpawnEntity;
    this.canMove = canMove;
    this.canFight = canFight;
    this.symbol = symbol;
    this.side = side;
  }
}
