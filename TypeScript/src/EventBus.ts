import { Observer } from "./Observer";
import { EventType } from "./EventType";

export class EventBus {
    private static instance: EventBus | null = null;
    private readonly observers: Observer[] = [];

    private constructor() {}

    public static getInstance(): EventBus {
        if (this.instance === null) {
            this.instance = new EventBus();
        }
        return this.instance;
    }

    public attach(observer: Observer): void {
        this.observers.push(observer);
    }

    public post(eventType: EventType, message: string): void {
        for (const observer of this.observers) {
            observer.notify(eventType, message);
        }
    }
}
