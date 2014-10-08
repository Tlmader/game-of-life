gameoflife
==========

University of New Orleans Software Design I Homework Five – Game of Life

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

After initializing the board, it will display it then apply the rules to determine
the state of the next step. Then display it, and apply the rules again. Then display
it, and apply the rules again. And again. And again…

The edges the grid wrap, that is: cells on an edge of the board can
feel the opposite edge of the grid. For example, if a cell on the right edge of
the board is on, its neighbours include cells on the left edge. This will allow
shapes that are moving across the grid to pass through one edge and come
out on the other side.
