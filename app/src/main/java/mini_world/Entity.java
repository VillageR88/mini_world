package mini_world;

public class Entity {

  boolean canSpawnEntity;
  boolean canMove;
  boolean canFight;
  char symbol;
  int side;

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
