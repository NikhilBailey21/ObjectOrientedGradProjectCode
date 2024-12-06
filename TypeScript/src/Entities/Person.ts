import { Entity } from "./Entity";
import { CanAdmire } from "./CanAdmire";

export class Person extends Entity implements CanAdmire {
    constructor(name: string) {
        super(name);
        this.setNoise("Wow, that's so beautiful");
    }

    public admire(admiring: Entity): string {
        return `${this.getNoise()} at ${admiring.getName()}`;
    }
}