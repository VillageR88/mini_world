package mini_world.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class BaseTest {

  @Test
  void canCreateNewBase() {
    Base base = new Base('A', 1);
    assertNotNull(base, "Can create new Base");
  }
}
