export abstract class Entity {
    private readonly name: string;
    protected noise: string;

    protected constructor(name: string) {
        this.name = name;
        this.noise = ""
    }

    public getName(): string {
        return this.name;
    }

    public getNoise(): string {
        return this.noise;
    }

    protected setNoise(noise: string): void {
        this.noise = noise;
    }

    // Type guard for Entity
    public static isEntity(entity: any): entity is Entity {
        return entity && typeof entity.getName === 'function' && 'noise' in entity;
    }
}
