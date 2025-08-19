package mini_world.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class GridTest {

  @Test
  void canCreateNewGrid() {
    Grid grid = new Grid();
    assertNotNull(grid, "Can create new Grid");
  }
}
