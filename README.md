# Zoo Simulator

This is a graduate project designed as a zoo simulator to showcase the differences and similarities between Java and TypeScript in implementing Object-Oriented Programming (OOP) principles. The simulator provides a basic code base referenced in a research paper exploring object-oriented design philosophies in both languages.

---

## Table of Contents
1. [Overview](#overview)
2. [How to Run the Code](#how-to-run-the-code)
3. [Testing the Code](#testing-the-code)
4. [Object-Oriented Patterns Used](#object-oriented-patterns-used)
5. [Program Structure](#program-structure)

---

## Overview

The Zoo Simulator models a zoo with animals, enclosures, and zookeeper interactions. It demonstrates core OOP principles like inheritance, polymorphism, and encapsulation while implementing advanced design patterns such as the **Strategy Pattern** and **Observer Pattern**. The implementation has two parallel versions: one in **Java** and one in **TypeScript**.

---

## How to Run the Code

### Java Version
1. **Prerequisites**:
    - Install Java 17 or later.
    - Install Gradle for build and dependency management.
    - Ensure JUnit 5 is available for testing.

2. **Steps**:
   ```bash
   # Navigate to the Java project directory
   cd Java

   # Compile and run the program
   gradle run
   
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
   cd zoo-simulator-java

   # Compile and run the program
   gradle run
   
---

## Testing the Code
### Java
Tests are written using JUnit 5. To execute tests:
```bash
    # Run all tests
    gradle test
```


### TypeScript
Tests are written using Jest. To execute tests, first locate to the directory ~/TypeScript, then run the following commands:
``` bash
    # Install dependencies
    npm install
    
    # Run all tests
    npm test
```

---

## Object-Oriented Patterns Used

### Strategy Pattern
Used to allow animals to exhibit different behaviors (e.g., walking, flying, swimming) without modifying the animal classes themselves.

**Example:**
- `WalkBehavior`, `FlyBehavior`, and `SwimBehavior` can be assigned dynamically to `Animal` objects.

### Observer Pattern
Used to notify zookeepers when an animal's state changes (e.g., health drops below a threshold).

**Example:**
- `Animal` acts as the subject, and `Zookeeper` is the observer.

---

## Program Structure

### Java

```plaintext
zoo-simulator-java/
├── src/main/java/com/zoo/
│   ├── Animal.java            # Base class for animals
│   ├── Enclosure.java         # Represents a zoo enclosure
│   ├── behaviors/             # Directory for behavior strategies
│   │   ├── WalkBehavior.java
│   │   ├── FlyBehavior.java
│   │   ├── SwimBehavior.java
│   └── observers/
│       ├── Observer.java      # Observer interface
│       ├── Zookeeper.java     # Observer implementation
├── build.gradle               # Gradle configuration