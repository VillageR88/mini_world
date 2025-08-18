package mini_world.model;

public class Entity {

  boolean canSpawnEntity;
  boolean canMove;
  boolean canFight;
  char symbol;
  public int side;

  public boolean getCanSpawnEntity() {
    return canSpawnEntity;
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
