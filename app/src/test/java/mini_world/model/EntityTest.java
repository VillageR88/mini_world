package mini_world.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class EntityTest {

  @Test
  void canCreateNewEntity() {
    Entity entity = new Entity(true, false, true, 'A', 1);
    assertNotNull(entity, "Can create new Entity");
  }
}
