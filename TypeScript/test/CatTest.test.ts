import { EntityFactory } from '../src/Entities/EntityFactory';
import { isCanMeow } from '../src/Entities/CanMeow';
import { Entity } from '../src/Entities/Entity';

describe('Cat Tests', () => {
    const entityFactory = new EntityFactory();

    test('testGetName', () => {
        let cat: Entity = entityFactory.createCat();
        expect(cat.getName()).not.toBe('');
    });

    test('testMeow', () => {
        const catOne: Entity = entityFactory.createCat();
        const catTwo: Entity = entityFactory.createCat();

        expect(isCanMeow(catOne)).toBe(true);
        expect(isCanMeow(catTwo)).toBe(true);

        expect(isCanMeow(catOne) && catOne.meow(catTwo).includes('meow')).toBe(true);
        expect(isCanMeow(catOne) && catOne.meow(catTwo).includes(catTwo.getName())).toBe(true);
        expect(isCanMeow(catTwo) && catTwo.meow(catOne).includes('meow')).toBe(true);
        expect(isCanMeow(catTwo) && catTwo.meow(catOne).includes(catOne.getName())).toBe(true);
    });

    test('testCatAdapter', () => {
        const catOne: Entity = entityFactory.createDisguisedDog();
        const catTwo: Entity = entityFactory.createCat();

        expect(isCanMeow(catOne) && catOne.meow(catTwo).includes(catOne.getNoise())).toBe(true);
        expect(isCanMeow(catOne) && catOne.meow(catTwo).includes(catTwo.getName())).toBe(true);
        expect(isCanMeow(catTwo) && catTwo.meow(catOne).includes(catTwo.getNoise())).toBe(true);
        expect(isCanMeow(catTwo) && catTwo.meow(catOne).includes(catOne.getName())).toBe(true);
    });
});
