import { Exhibit } from '../src/Exhibit';
import { EntityFactory } from '../src/Entities/EntityFactory';
import { CanAdmire } from '../src/Entities/CanAdmire';

describe('Exhibit Test', () => {
    let entityFactory: EntityFactory;
    let exhibit: Exhibit;
    let patron: CanAdmire;

    beforeEach(() => {
        entityFactory = new EntityFactory();
        exhibit = new Exhibit();

        // Adding entities to the exhibit
        exhibit.addEnclosedEntity(entityFactory.createCat());
        exhibit.addEnclosedEntity(entityFactory.createDog());

        // Adding a patron to the exhibit
        patron = entityFactory.createPerson();
        exhibit.enter(patron);
    });

    it('should get the correct number of enclosure noises', () => {
        const noises = exhibit.getEnclosureNoises();
        // Expect 2 noises for the cat and dog
        expect(noises.length).toBe(2);
    });

    it('should get the correct number of patron noises', () => {
        const patronNoises = exhibit.getPatronNoises();
        // Expect 1 noise for the patron
        expect(patronNoises.length).toBe(1);
    });

    it('should get the correct random patron', () => {
        const randomPatron = exhibit.getRandomPatron();
        // Expect the random patron to be the one added
        expect(randomPatron).toBe(patron);
    });

    it('should exit the patron correctly', () => {
        exhibit.exit(patron);
        // Expect the patron noises to be empty after exit
        const patronNoises = exhibit.getPatronNoises();
        expect(patronNoises.length).toBe(0);
    });
});