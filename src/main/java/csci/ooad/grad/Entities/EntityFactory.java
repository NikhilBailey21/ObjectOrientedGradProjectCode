package csci.ooad.grad.Entities;

import java.util.List;
import java.util.Random;

public class EntityFactory {

    private final List<String> catNames = List.of("Sally", "Kitty", "Raider", "Rosie");
    private final List<String> dogNames = List.of("Rover", "Rex", "Spot", "Fido");
    private final List<String> peopleNames = List.of("John", "Adam", "Emily", "Anna");

    public Entity createCat() {
        return new Cat(getRandomName(catNames));
    }

    public Entity createDog() {
        return new Dog(getRandomName(dogNames));
    }

    public Entity createDisguisedDog() {
        return new CatAdapter(new Dog(getRandomName(dogNames)));
    }

    public Person createPerson() {
        return new Person(getRandomName(peopleNames));
    }

    private String getRandomName(List<String> options) {
        return options.get(new Random().nextInt(options.size()));
    }
}