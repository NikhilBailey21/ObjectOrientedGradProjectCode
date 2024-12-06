package csci.ooad.grad;

import csci.ooad.grad.Entities.CanAdmire;
import csci.ooad.grad.Entities.EntityFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

        for (Exhibit exhibit : exhibits) {

            CanAdmire patron = exhibit.getRandomPatron();
            if (Objects.isNull(patron)) continue;

            exhibit.exit(patron);
            getRandomExhibit(exhibits).enter(patron);
        }
    }

    private static Exhibit getRandomExhibit(List<Exhibit> exhibits) {
        return exhibits.get(new Random().nextInt(exhibits.size()));
    }

    public static class Builder {

        private final List<Exhibit> exhibits;
        private final EntityFactory entityFactory;

        private Builder() {
            exhibits = new ArrayList<>();
            entityFactory = new EntityFactory();
        }

        public static Builder getBuilder() {
            return new Builder();
        }

        public Zoo Build() {
            return new Zoo(exhibits);
        }

        public Builder createAndAddExhibits(int numberOfExhibits) {
            for (int i = 0; i < numberOfExhibits; i++) {
                exhibits.add(new Exhibit());
            }
            return this;
        }

        public Builder createAndAddCats(int numberOfCats) {
            for (int i = 0; i < numberOfCats; i++) {
                getRandomExhibit(exhibits).addEnclosedEnity(entityFactory.createCat());
            }
            return this;
        }

        public Builder createAndAddEnclosedPeople(int numberOfPeople) {
            for (int i = 0; i < numberOfPeople; i++) {
                getRandomExhibit(exhibits).addEnclosedEnity(entityFactory.createPerson());
            }
            return this;
        }

        public Builder createAndAddDogs(int numberOfDogs) {
            for (int i = 0; i < numberOfDogs; i++) {
                getRandomExhibit(exhibits).addEnclosedEnity(entityFactory.createDog());
            }
            return this;
        }

        public Builder createAndAddDisguisedDogs(int numberOfDisguisedDogs) {
            for (int i = 0; i < numberOfDisguisedDogs; i++) {
                getRandomExhibit(exhibits).addEnclosedEnity(entityFactory.createDisguisedDog());
            }
            return this;
        }

        public Builder createAndAddPatrons(int numberOfPatrons) {
            for (int i = 0; i < numberOfPatrons; i++) {
                getRandomExhibit(exhibits).enter(entityFactory.createPerson());
            }
            return this;
        }
    }
}