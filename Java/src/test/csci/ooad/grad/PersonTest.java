package csci.ooad.grad;

import csci.ooad.grad.Entities.CanAdmire;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import csci.ooad.grad.Entities.EntityFactory;
import csci.ooad.grad.Entities.Entity;

public class PersonTest {
    EntityFactory entityFactory = new EntityFactory();

    @Test
    void testGetName() {
        Entity person = entityFactory.createPerson();
        Assertions.assertNotEquals(person.getName(), "");
    }

    @Test void testAdmire() {

        Entity personOne = entityFactory.createPerson();
        Entity personTwo = entityFactory.createPerson();

        assert(personOne instanceof CanAdmire);
        assert(personTwo instanceof CanAdmire);

        assert(((CanAdmire) personOne).admire(personTwo).contains(personOne.getNoise()));
        assert(((CanAdmire) personOne).admire(personTwo).contains(personTwo.getName()));
        assert(((CanAdmire) personTwo).admire(personOne).contains(personTwo.getNoise()));
        assert(((CanAdmire) personTwo).admire(personOne).contains(personOne.getName()));
    }
}