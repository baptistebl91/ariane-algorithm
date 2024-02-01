
# Thésée Labyrinth Algorithm Project

This project explores an algorithm for guiding a mobile object, represented as Thésée, through a maze filled with obstacles to find an exit. Written in Java, the program simulates Thésée's journey through a grid-based labyrinth, aiming to reach the goal with minimal steps.

## Project Overview

- **Maze Representation:** The labyrinth is depicted as a square grid, where each cell can be either blocked or free. Thésée and the exit are placed on any two distinct free cells.
- **Movement Options:** Thésée can move north, south, east, or west. Movement consequences include staying in place if blocked, moving to a free cell, or reaching the exit to end the simulation.
- **Algorithm:** The core task is to dictate Thésée's next move at each step using a developed algorithm.

## Features

- **Grid Customization:** Users can load an existing grid or create a new one, modifying the grid size and individual cell states.
- **Algorithm Choice:** Two algorithms are available: a random one and a deterministic one based on Thésée's current coordinates and memory of past actions.
- **Simulation Modes:** Choose between manual (step-by-step) and automatic (no user interaction, with performance metrics displayed).
- **Graphics:** Thésée is represented by a red square 🟥, and the exit by a green square 🟩.

## Development and Compilation

Developed in Java using the official API, the program is aimed at collaborative development techniques. All interactions are graphical, with console outputs limited to error messages.

## Grid File Format

- The grid file uses a binary format, starting with grid size and positions of Thésée and the exit, followed by cell states (0 for free, 1 for blocked) described column by column.

## Commands

- `make`: Compiles the project.
- `make run`: Compiles and launches the project.
- `make clean`: Removes all compilation-related files.


