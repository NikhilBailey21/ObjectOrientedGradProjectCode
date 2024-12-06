import { Entity } from "./Entity";

export interface CanAdmire {
    admire(admiring: Entity): string;
}

// Type guard for CanAdmire
export function isCanAdmire(entity: any): entity is CanAdmire {
    return typeof entity.admire === 'function';
}