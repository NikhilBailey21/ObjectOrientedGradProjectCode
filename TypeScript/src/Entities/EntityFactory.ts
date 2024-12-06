import { Entity } from "./Entity";
import { Cat } from "./Cat";
import { Dog } from "./Dog";
import { CatAdapter } from "./CatAdapter";
import { Person } from "./Person";

export class EntityFactory {
    private readonly catNames: string[] = ["Sally", "Kitty", "Raider", "Rosie"];
    private readonly dogNames: string[] = ["Rover", "Rex", "Spot", "Fido"];
    private readonly peopleNames: string[] = ["John", "Adam", "Emily", "Anna"];

    public createCat(): Entity {
        return new Cat(this.getRandomName(this.catNames));
    }

    public createDog(): Entity {
        return new Dog(this.getRandomName(this.dogNames));
    }

    public createDisguisedDog(): Entity {
        return new CatAdapter(new Dog(this.getRandomName(this.dogNames)));
    }

    public createPerson(): Person {
        return new Person(this.getRandomName(this.peopleNames));
    }

    private getRandomName(options: string[]): string {
        const randomIndex = Math.floor(Math.random() * options.length);
        return options[randomIndex];
    }
}