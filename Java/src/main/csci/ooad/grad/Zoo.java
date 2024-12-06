package csci.ooad.grad;

import csci.ooad.grad.Entities.EntityFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Zoo {

    private final List<Exhibit> exhibits;

    private Zoo(List<Exhibit> exhibits) {

        this.exhibits = exhibits;
    }

    public void takeTurn() {
        for (Exhibit exhibit : exhibits) {
            exhibit.getEnclosureNoises();
            exhibit.getPatronNoises();
        }
    }

    public class Builder {

        private final List<Exhibit> exhibits;
        private final EntityFactory entityFactory;

        private Builder() {
            exhibits = new ArrayList<>();
            entityFactory = new EntityFactory();
        }

        public Builder getBuilder() {
            return new Builder();
        }

        public Zoo Build() {
            return new Zoo(exhibits);
        }

        public void createAndAddExhibits(int numberOfExhibits) {
            for (int i = 0; i < numberOfExhibits; i++) {
                exhibits.add(new Exhibit());
            }
        }

        public void createAndAddCats(int numberOfCats) {
            for (int i = 0; i < numberOfCats; i++) {
                getRandomExhibit().addEnclosedEnity(entityFactory.createCat());
            }
        }

        public void createAndAddEnclosedPeople(int numberOfPeople) {
            for (int i = 0; i < numberOfPeople; i++) {
                getRandomExhibit().addEnclosedEnity(entityFactory.createPerson());
            }
        }

        public void createAndAddDogs(int numberOfDogs) {
            for (int i = 0; i < numberOfDogs; i++) {
                getRandomExhibit().addEnclosedEnity(entityFactory.createDog());
            }
        }

        public void createAndAddDisguisedDogs(int numberOfDisguisedDogs) {
            for (int i = 0; i < numberOfDisguisedDogs; i++) {
                getRandomExhibit().addEnclosedEnity(entityFactory.createDisguisedDog());
            }
        }

        public void createAndAddPatrons(int numberOfPatrons) {
            for (int i = 0; i < numberOfPatrons; i++) {
                getRandomExhibit().enter(entityFactory.createPerson());
            }
        }

        private Exhibit getRandomExhibit() {
            return exhibits.get(new Random().nextInt(exhibits.size()));
        }
    }
}