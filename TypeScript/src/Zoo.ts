import { Exhibit } from "./Exhibit";
import { CanAdmire } from "./Entities/CanAdmire";
import { EntityFactory } from "./Entities/EntityFactory";

// Declare the Zoo namespace
export namespace Zoo {

    // Define the main Zoo class
    export class Zoo {
        private exhibits: Exhibit[];

        constructor(exhibits: Exhibit[]) {
            this.exhibits = exhibits;
        }

        public takeTurn(): void {
            // Get enclosure noises and patron noises for each exhibit
            for (const exhibit of this.exhibits) {
                exhibit.getEnclosureNoises();
                exhibit.getPatronNoises();
            }

            // Move patrons randomly between exhibits
            for (const exhibit of this.exhibits) {
                const patron = exhibit.getRandomPatron();
                if (!patron) continue;

                exhibit.exit(patron);
                Zoo.getRandomExhibit(this.exhibits).enter(patron);
            }
        }

        static getRandomExhibit(exhibits: Exhibit[]): Exhibit {
            const randomIndex = Math.floor(Math.random() * exhibits.length);
            return exhibits[randomIndex];
        }
    }

    // Builder class within Zoo namespace
    export class Builder {
        private exhibits: Exhibit[];
        private entityFactory: EntityFactory;

        constructor() {
            this.exhibits = [];
            this.entityFactory = new EntityFactory();
        }

        public static getBuilder(): Zoo.Builder {
            return new Builder();
        }

        public build(): Zoo {
            return new Zoo(this.exhibits);
        }

        public createAndAddExhibits(numberOfExhibits: number): Zoo.Builder {
            for (let i = 0; i < numberOfExhibits; i++) {
                this.exhibits.push(new Exhibit());
            }
            return this;
        }

        public createAndAddCats(numberOfCats: number): Zoo.Builder {
            for (let i = 0; i < numberOfCats; i++) {
                Zoo.getRandomExhibit(this.exhibits).addEnclosedEntity(this.entityFactory.createCat());
            }
            return this;
        }

        public createAndAddEnclosedPeople(numberOfPeople: number): Zoo.Builder {
            for (let i = 0; i < numberOfPeople; i++) {
                Zoo.getRandomExhibit(this.exhibits).addEnclosedEntity(this.entityFactory.createPerson());
            }
            return this;
        }

        public createAndAddDogs(numberOfDogs: number): Zoo.Builder {
            for (let i = 0; i < numberOfDogs; i++) {
                Zoo.getRandomExhibit(this.exhibits).addEnclosedEntity(this.entityFactory.createDog());
            }
            return this;
        }

        public createAndAddDisguisedDogs(numberOfDisguisedDogs: number): Zoo.Builder {
            for (let i = 0; i < numberOfDisguisedDogs; i++) {
                Zoo.getRandomExhibit(this.exhibits).addEnclosedEntity(this.entityFactory.createDisguisedDog());
            }
            return this;
        }

        public createAndAddPatrons(numberOfPatrons: number): Zoo.Builder {
            for (let i = 0; i < numberOfPatrons; i++) {
                Zoo.getRandomExhibit(this.exhibits).enter(this.entityFactory.createPerson());
            }
            return this;
        }
    }
}
