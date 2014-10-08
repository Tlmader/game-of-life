gameoflife
==========

University of New Orleans - CSCI 1583 Homework 5

Briefly, John Conway's Game of Life is a game of cellular automata. The game consists of a grid ofsquares that are either on or off. At each time step, each cell is evaluated and is either turned on or off based on the evaluation of 4 rules. The four rules are as follows:

- Any live cell with fewer than two live neighbours dies, as if caused by
under-population.
- Any live cell with two or three live neighbours lives on to the next
generation.
- Any live cell with more than three live neighbours dies, as if by
overcrowding.
- Any dead cell with exactly three live neighbours becomes a live cell, as if
by reproduction.

At each step in the game, every cell is evaluated against these four rules to
determine if it will be on or off for the next step of the game.

The program will accept as a command line argument a string that holds the
name of an input file. It will read from the input file the size of the grid and the
starting values for all of the squares.
