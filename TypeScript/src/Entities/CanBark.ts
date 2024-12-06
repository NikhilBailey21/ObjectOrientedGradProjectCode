export interface CanBark {
    bark(): string;
}

// Type guard for CanBark
export function isCanBark(entity: any): entity is CanBark {
    return typeof entity.bark === 'function';
}