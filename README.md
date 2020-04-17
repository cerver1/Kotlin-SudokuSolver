# Kotlin-SudokuSolver

### ***Solve any valid sudoku board in a matter of seconds!***

This program first traverses the sudoku board searching for any empty positions.  
In this case all empty positions marked as 0, the program then attempts to fill it with a valid value(1..9).

## *Pseudocode*

**Traverse the board in search of any empty positions(0).**

    If any position of the row is == 0(empty):
      return the index of the 0 and return the index of the row
    Else:
      check the next row

**Once an empty position(0) is found.  
Try to put a number in range of 1..9 and within the empty spot.**

    If the number fits without breaking the row, column, or subgrid:
      Place search the board for another zero.
    Elsif the number breaks the row, column, or subgrid:
      Recurse of the board

**Once all empty spots are filled the board is completed,  
the board is printed and the program is terminated.**


