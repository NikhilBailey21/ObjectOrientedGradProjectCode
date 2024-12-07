package csci.ooad.grad;

import csci.ooad.grad.Entities.CanMeow;
import csci.ooad.grad.Entities.Entity;
import csci.ooad.grad.Entities.EntityFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CatTest {
   EntityFactory entityFactory = new EntityFactory();

    @Test
    void testGetName() {
        Entity cat = entityFactory.createCat();
       Assertions.assertNotEquals("", cat.getName());
    }

    @Test void testMeow() {
        Entity catOne = entityFactory.createCat();
        Entity catTwo = entityFactory.createCat();

        assert(catOne instanceof CanMeow);
        assert(catTwo instanceof CanMeow);

        assert(((CanMeow) catOne).meow(catTwo).contains("meow"));
        assert(((CanMeow) catOne).meow(catTwo).contains(catTwo.getName()));
        assert(((CanMeow) catTwo).meow(catOne).contains("meow"));
        assert(((CanMeow) catTwo).meow(catOne).contains(catOne.getName()));
    }

    @Test void testCatAdapter() {
        Entity catOne = entityFactory.createDisguisedDog();
        Entity catTwo = entityFactory.createCat();

        assert(((CanMeow) catOne).meow(catTwo).contains(catOne.getNoise()));
        assert(((CanMeow) catOne).meow(catTwo).contains(catTwo.getName()));
        assert(((CanMeow) catTwo).meow(catOne).contains(catTwo.getNoise()));
        assert(((CanMeow) catTwo).meow(catOne).contains(catOne.getName()));
    }
}