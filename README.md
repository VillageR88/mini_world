# Mini World

A simple turn-based console simulation written in Java.  
Players have bases, produce units periodically, move them on a grid, and engage in battles.

## Features
- 10x10 grid simulation
- Bases that produce units periodically
- Unit movement and combat logic
- Simple ASCII world rendering in console
- Quit anytime with `q`

## Requirements
- Java 22+ (or any compatible version)
- Gradle (wrapper included)

## Build
Use the Gradle wrapper to build the project:
```bash
.\gradlew.bat build
```

## Run
After building, run the application using:
```bash
java -cp app/build/classes/java/main mini_world.App
```

## Controls
- **Enter** → advance the simulation
- **q** → quit the simulation


## Future Development
- Introducing a graphical user interface (GUI) via JavaFX
- Improvements to game mechanics
- Implementing AI-driven unit behavior

## Notes

While AI is a valuable tool in the learning process, the entire code of this project is purely handwritten using traditional coding practices — no “vibe coding” or auto-generated solutions.