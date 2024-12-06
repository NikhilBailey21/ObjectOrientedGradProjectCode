import { EntityFactory } from "../src/Entities/EntityFactory";
import {isCanAdmire} from "../src/Entities/CanAdmire";

// Initialize the entity factory
const entityFactory = new EntityFactory();

describe('PersonTest', () => {
    test('testGetName', () => {
        const person = entityFactory.createPerson();
        expect(person.getName()).not.toBe('');
    });

    test('testAdmire', () => {
        const personOne = entityFactory.createPerson();
        const personTwo = entityFactory.createPerson();

        // Ensure both entities implement CanAdmire
        expect(isCanAdmire(personOne)).toBe(true);
        expect(isCanAdmire(personTwo)).toBe(true);

        // Test the admiration behavior
        expect(personOne.admire(personTwo)).toContain(personOne.getNoise());
        expect(personOne.admire(personTwo)).toContain(personTwo.getName());
        expect(personTwo.admire(personOne)).toContain(personTwo.getNoise());
        expect(personTwo.admire(personOne)).toContain(personOne.getName());
    });
});
