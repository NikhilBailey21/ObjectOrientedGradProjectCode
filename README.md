# Zoo Simulator

This is a graduate project designed as a zoo simulator similar to Polymorphia to showcase the differences and similarities between Java and TypeScript in implementing Object-Oriented Programming (OOP) principles. The simulator provides a basic code base referenced in a research paper exploring object-oriented design philosophies in both languages.

---

## Table of Contents
1. [Overview](#overview)
2. [How to Run the Code](#how-to-run-the-code)
3. [Object-Oriented Patterns Used](#object-oriented-patterns-used-in-this-project)

---

## Overview

The Zoo Simulator models a zoo with animals, enclosures, and zookeeper interactions. It demonstrates core OOP principles like inheritance, polymorphism, and encapsulation while implementing advanced design patterns such as the **Strategy Pattern** and **Observer Pattern**. The implementation has two parallel versions: one in **Java** and one in **TypeScript**.

---

## How to Run the Code

### Java Version
1. **Prerequisites**:
    - Install Java 23.
    - Install Gradle for build and dependency management.
    - Ensure JUnit 5 is available for testing.

2. **Steps**:
right-click the test folder and run all tests.

   
### TypeScript Version

1. **Prerequisites**:
   - Install Node.js and npm (Node Package Manager).
   - Install TypeScript globally using npm:
   ```bash
    npm install -g typescript
   ```

2. **Steps**:
   ```bash
   # Navigate to the Java project directory
   cd TypeScript

   # install neccessary dependencies
   npm install
   
   # Run the test
   npm test
   
---

## Object-Oriented Patterns Used in this Project

### Strategy Pattern
Used to allow entities to exhibit different behaviors without modifying the entities themselves.

**Example:**
- By using an `Entity` to implement `CanAdmire`, `CanBark`, and `CanMeow` interfaces to create the `Person`, `Dog`, and `Cat` classes.
- [CanAdmire (Java)](src/main/java/csci/ooad/grad/Entities/CanAdmire.java)
- [CanBark (Java)](src/main/java/csci/ooad/grad/Entities/CanBark.java)
- [CanMeow (Java)](src/main/java/csci/ooad/grad/Entities/CanMeow.java)
- [CanAdmire (TypeScript)](TypeScript/src/Entities/CanAdmire.ts)
- [CanBark (TypeScript)](TypeScript/src/Entities/CanBark.ts)
- [CanMeow (TypeScript)](TypeScript/src/Entities/CanMeow.ts)

### Observer Pattern
Used to notify clients when an event happened.

**Example:**
- `Observer` would notify the client whenever Entity or Person made some noises
- [Observer (Java)](src/main/java/csci/ooad/grad/Observer.java)
- [Observer (TypeScript)](TypeScript/src/Observer.ts)

### Singleton Pattern
Make sures that only one instance exists to provide a global point access point

**Example:**
- `EventBus` would collect all the observers that are attached to it, and served as a centralised control to notify all at once.
- [EventBus (Java)](src/main/java/csci/ooad/grad/EventBus.java)
- [EventBus (TypeScript)](TypeScript/src/EventBus.ts)
### Builder Pattern
Used to create complex object without having to write multiple construction methods

**Example:**
- `Zoo` class allows client to customize the Zoo based on the number of `Cats`, `Dogs`, `Person` and `Exhibits`
- [Zoo (Java)](src/main/java/csci/ooad/grad/Zoo.java)
- [Zoo (TypeScript)](TypeScript/src/Zoo.ts)
### Factory Pattern
Used to create objects without revealing their concrete classes

**Example**
- `EntityFactory` class creates all entities, and will return an object when the user called the `createX` method.
- [EntityFactory (Java)](src/main/java/csci/ooad/grad/Entities/EntityFactory.java)
- [EntityFactory (TypeScript)](TypeScript/src/Entities/EntityFactory.ts)

### Adapter Pattern
Used to bridge the gap between two incompatible classes without changing the class itself.
- `CatAdapter` class create a `Dog` disguised as a `Cat` which it could Meow, by using dependency injection.
- [CatAdapter (Java)](src/main/java/csci/ooad/grad/Entities/CatAdapter.java)
- [CatAdapter (TypeScript)](TypeScript/src/Entities/CatAdapter.ts)



