import { Cat } from "./Cat";
import { Dog } from "./Dog";
import { Entity } from "./Entity";

export class CatAdapter extends Cat {
    private readonly dog: Dog;

    constructor(dog: Dog) {
        super(dog.getName());
        this.dog = dog;
    }

    public meow(annoyedAt: Entity): string {
        return `${this.dog.bark()} at ${annoyedAt.getName()}`;
    }

    public getNoise(): string {
        return this.dog.getNoise();
    }

    public getName(): string {
        return this.dog.getName();
    }
}