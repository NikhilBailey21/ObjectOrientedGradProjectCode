import {CanAdmire, isCanAdmire} from "./Entities/CanAdmire";
import {CanBark, isCanBark} from "./Entities/CanBark";
import {CanMeow, isCanMeow} from "./Entities/CanMeow";
import { Entity } from "./Entities/Entity";
import { EventBus } from "./EventBus";
import { EventType } from "./EventType";

export class Exhibit {
    private patrons: CanAdmire[] = [];
    private enclosure: Entity[] = [];

    public getEnclosureNoises(): string[] {

        const noises: string[] = [];

        for (const entity of this.enclosure) {
            let noise = "";

            if (isCanBark(entity)) {
                noise = entity.bark();
            }
            if (isCanMeow(entity)) {

                const enclosureEntity = this.getRandomEnclosureEntity();
                if (enclosureEntity === null) continue;

                noise = entity.meow(enclosureEntity);
            }
            if (isCanAdmire(entity)) {

                const enclosureEntity = this.getRandomEnclosureEntity();
                if (enclosureEntity === null) continue;

                noise = entity.admire(enclosureEntity);
            }

            const enclosureEntity = this.getRandomEnclosureEntity();
            if (enclosureEntity === null) continue;

            noises.push(noise);
            EventBus.getInstance().post(EventType.EnclosureNoise, `${entity.getName()} said ${noise}`);
        }

        return noises;
    }

    public getPatronNoises(): string[] {
        const noises: string[] = [];

        for (const patron of this.patrons) {
            const enclosureEntity = this.getRandomEnclosureEntity();
            if (enclosureEntity === null) continue;

            const noise = patron.admire(enclosureEntity);
            noises.push(noise);

            if (!Entity.isEntity(patron)) throw "Patron is not entity when trying to get patron noises in exhibit"
            EventBus.getInstance().post(EventType.AdmireNoise, `${(patron as Entity).getName()} said ${noise}`);
        }

        return noises;
    }

    public addEnclosedEntity(entity: Entity): void {
        this.enclosure.push(entity);
    }

    public enter(patron: CanAdmire): void {
        this.patrons.push(patron);
    }

    public exit(patron: CanAdmire): void {
        this.patrons = this.patrons.filter(p => p !== patron);
    }

    private getRandomEnclosureEntity(): Entity | null {
        if (this.enclosure.length === 0) return null;
        return this.enclosure[Math.floor(Math.random() * this.enclosure.length)];
    }

    public getRandomPatron(): CanAdmire | null {
        if (this.patrons.length === 0) return null;
        return this.patrons[Math.floor(Math.random() * this.patrons.length)];
    }
}