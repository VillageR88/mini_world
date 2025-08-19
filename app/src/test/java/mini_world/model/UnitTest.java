package mini_world.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class UnitTest {

  @Test
  void canCreateNewUnit() {
    Unit unit = new Unit('A', 1);
    assertNotNull(unit, "Can create new Unit");
  }
}
