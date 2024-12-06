import { Entity } from "./Entity";
import { CanBark } from "./CanBark";

export class Dog extends Entity implements CanBark {
    constructor(name: string) {
        super(name);
        this.setNoise("BARK");
    }

    public bark(): string {
        return this.getNoise();
    }
}