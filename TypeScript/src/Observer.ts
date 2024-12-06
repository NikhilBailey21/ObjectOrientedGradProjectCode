import { EventType } from "./EventType";

export class Observer {
    public notify(eventType: EventType, message: string): void {
        console.log(`${eventType} Event occurred: ${message}`);
    }
}