import { Entity } from "./Entity";

export interface CanMeow {
    meow(annoyedAt: Entity): string;
}

// Type guard for CanMeow
export function isCanMeow(entity: any): entity is CanMeow {
    return typeof entity.meow === 'function';
}
