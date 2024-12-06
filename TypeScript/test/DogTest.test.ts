import { EntityFactory } from '../src/Entities/EntityFactory';
import { isCanBark } from '../src/Entities/CanBark';
import { Entity } from '../src/Entities/Entity';

describe('Cat Tests', () => {
    const entityFactory = new EntityFactory();

    test('testGetName', () => {
        const dog: Entity = entityFactory.createDog();
        expect(dog.getName()).not.toBe('');
    });

    test('testBark', () => {
        const dog: Entity = entityFactory.createDog();

        expect(isCanBark(dog)).toBe(true);

        expect(isCanBark(dog) && dog.bark().includes(dog.getNoise())).toBe(true);
    });
});