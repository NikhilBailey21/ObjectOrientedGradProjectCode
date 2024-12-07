package csci.ooad.grad;

import csci.ooad.grad.Entities.CanAdmire;
import csci.ooad.grad.Entities.EntityFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExhibitTest {

    EntityFactory entityFactory;
    Exhibit exhibit;
    CanAdmire patron;

    @BeforeEach
    void setUp() {
        entityFactory = new EntityFactory();
        exhibit = new Exhibit();

        exhibit.addEnclosedEnity(entityFactory.createCat());
        exhibit.addEnclosedEnity(entityFactory.createDog());

        patron = entityFactory.createPerson();
        exhibit.enter(patron);
    }

    @Test
    void testGetEnclosureNoises() {
       assert(exhibit.getEnclosureNoises().size() == 2);
    }

    @Test
    void testGetPatronNoises() {
        assert(exhibit.getPatronNoises().size() == 1);
    }

    @Test
    void testGetRandomPatron() {
        assert(exhibit.getRandomPatron() == patron);
    }

    @Test
    void testExit() {
        exhibit.exit(patron);
        assert(exhibit.getPatronNoises().isEmpty());
    }
}
