/**
 * Ted Mader
 * John Conway's Game of Life
 * 10/15/2013
 **/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class GameOfLife{
	public static void main(String[] args) throws FileNotFoundException{
		
		System.out.println("\nWelcome to the Game of Life. This homework assignment made my brain hurt. Enjoy!");
		
		String fileName = args[0];
		File inputFile = new File(fileName);
		Scanner fileReader;
		fileReader = new Scanner(inputFile);
		Scanner input = new Scanner(System.in);
		
		int maxCols = 0;
		int maxRows = 0;
		int row = 0;
		int col = 0;
		
		maxCols = fileReader.nextInt();
		maxRows = fileReader.nextInt();
		
		System.out.println("From input file, " + fileName + ":");
		System.out.println("Number of rows: " + maxRows);
		System.out.println("Number of columns: " + maxCols);
		
		int[][] nextBoard = new int[maxRows][maxCols];
		int[][] currentBoard = new int[maxRows][maxCols];
		
		System.out.println("\nEnter number of steps.");
		int steps = input.nextInt();
		System.out.println("\nEnter delay per step in milliseconds (1000 = 1 second).");
		int timer = input.nextInt();
		//Take numbers from input file
		for(row = 0; row < maxRows; row++){
			for(col = 0; col < maxCols; col++){
				nextBoard[row][col] = fileReader.nextInt();
			}
		}	
		for(int counter = 0; counter < steps; counter++){
			//Print current array
			for(row = 0; row < maxRows; row++){
				for(col = 0; col < maxCols; col++){
					currentBoard[row][col] = nextBoard[row][col];
					System.out.print(currentBoard[row][col] + " ");
				}	
				System.out.println("");
			}
			System.out.println("");
			//Get next array
			for(row = 0; row < maxRows; row++){
				for(col = 0; col < maxCols; col++){
					int neighbors = 0;
					neighbors = getNeighbors(currentBoard, row, col, maxRows, maxCols);
					nextBoard[row][col] = checkRules(currentBoard, nextBoard, row, col, neighbors);
					//System.out.print("# of neighbors: " + neighbors);
				}
			}
			try {
				Thread.sleep(timer);
				} catch(InterruptedException ex){
					Thread.currentThread().interrupt();
			}
		}
	System.out.println("        _         ");
    System.out.println("       /(|        ");
    System.out.println("      (  :        ");
    System.out.println("     __\\  \\  _____");
    System.out.println("   (____)  `|     ");
    System.out.println("  (____)|   |     ");
    System.out.println("   (____).__|     ");
    System.out.println("    (___)__.|_____");
	}
	//Gets number of neighbors
	public static int getNeighbors(int[][] currentBoard, int row, int col, int maxRows, int maxCols){
		int nCount = 0;	//Neighbor count
		int rowMod;		//Row modifier
		int colMod;		//Column modifier
		//Top-left
		rowMod = -1;
		colMod = -1;
		nCount = nCounter(currentBoard, row, col, maxRows, maxCols, rowMod, colMod, nCount);
		//Top
		rowMod = -1;
		colMod = 0;
		nCount = nCounter(currentBoard, row, col, maxRows, maxCols, rowMod, colMod, nCount);
		//Top-right
		rowMod = -1;
		colMod = 1;
		nCount = nCounter(currentBoard, row, col, maxRows, maxCols, rowMod, colMod, nCount);
		//Left
		rowMod = 0;
		colMod = -1;
		nCount = nCounter(currentBoard, row, col, maxRows, maxCols, rowMod, colMod, nCount);
		//Right
		rowMod = 0;
		colMod = 1;
		nCount = nCounter(currentBoard, row, col, maxRows, maxCols, rowMod, colMod, nCount);
		//Bottom-Left
		rowMod = 1;
		colMod = -1;
		nCount = nCounter(currentBoard, row, col, maxRows, maxCols, rowMod, colMod, nCount);
		//Bottom
		rowMod = 1;
		colMod = 0;
		nCount = nCounter(currentBoard, row, col, maxRows, maxCols, rowMod, colMod, nCount);
		//Bottom-Right
		rowMod = 1;
		colMod = 1;
		nCount = nCounter(currentBoard, row, col, maxRows, maxCols, rowMod, colMod, nCount);
		return nCount;
	}
	//Checks if cell is out-of-bounds
	public static int checkBounds(int row, int col, int maxRows, int maxCols, int rowMod, int colMod){
		int boundState = 0;
		if((0 <= (row + rowMod) && (row + rowMod) < maxRows) && (0 <= (col + colMod) && (col + colMod) < maxCols)){
			boundState = 1;
		}
		return boundState;
	}
	//Counts neighbors
	public static int nCounter(int[][]currentBoard, int row, int col, int maxRows, int maxCols, int rowMod, int colMod, int nCount){
		int boundState = checkBounds(row, col, maxRows, maxCols, rowMod, colMod);
			if(boundState == 1){
				nCount = getNeighborState(currentBoard, row, col, rowMod, colMod, nCount);
			}
			if(boundState == 0){
				rowMod = edges(row, rowMod, maxRows);
				colMod = edges(col, colMod, maxCols);
				nCount = getNeighborState(currentBoard, row, col, rowMod, colMod, nCount);
			}
		return nCount;
	}
	//Checks if adjacent cell has life
	public static int getNeighborState(int[][] currentBoard, int row, int col, int rowMod, int colMod, int nCount){
		int state = 0;
		state = currentBoard[row+rowMod][col+colMod];
		if(state == 1){
			nCount = nCount + 1;
		}
		else{
			nCount = nCount;
		}
		return nCount;
	}
	//Allows patterns to continue past edges
	public static int edges(int pos, int mod, int max){
		if(pos + mod >= max){
			mod = mod - max;
		}
		if(pos + mod < 0){
			mod = mod + max;
		}
		return mod;
	}
	//Run each cell through the rules
	public static int checkRules(int[][] currentBoard, int[][] nextBoard, int row, int col, int neighbors){
		int lifeState = 0;
		if(currentBoard[row][col] == 1){
			lifeState = 1;
		}
		//For a space that is 'populated'
		if(lifeState == 1){
			if((neighbors <= 1) || (neighbors >= 4)){
				nextBoard[row][col] = 0;
			}
			if((neighbors == 2) || (neighbors == 3)){
				nextBoard[row][col] = 1;
			}
		}
		//For a space that is 'empty' or 'unpopulated'
		if(lifeState == 0){
			if(neighbors == 3){
				nextBoard[row][col] = 1;
			}
		}
		return nextBoard[row][col];
	}
}