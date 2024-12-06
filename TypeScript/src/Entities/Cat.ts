import { Entity } from "./Entity";
import { CanMeow } from "./CanMeow";

export class Cat extends Entity implements CanMeow {
    constructor(name: string) {
        super(name);
        this.noise = "meow";
    }

    public meow(annoyedAt: Entity): string {
        return `${this.getNoise()} to ${annoyedAt.getName()}`;
    }
}
