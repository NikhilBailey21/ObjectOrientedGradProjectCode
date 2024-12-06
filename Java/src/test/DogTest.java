public class DogTest {
    EntityFactory entityFactory = new entityFactory();

    @Test
    void testGetName() {
        Entity dog = entityFactory.createDog();
        assertNotNull(dog.getName())
    }
}