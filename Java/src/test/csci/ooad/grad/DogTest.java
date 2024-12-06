package csci.ooad.grad;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import csci.ooad.grad.Entities.EntityFactory;
import csci.ooad.grad.Entities.Entity;

public class DogTest {
   EntityFactory entityFactory = new EntityFactory();

    @Test
    void testGetName() {
        Entity dog = entityFactory.createDog();
       Assertions.assertNotEquals(dog.getName(), "");
    }
}