import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class FileReader{
	public static void main(String[] args){
		String fileName = args[0];
		File inputFile = new File(fileName);
		Scanner fileReader;
			fileReader = new Scanner(inputFile);
		
		int maxCols;
		int maxRows;
		
		maxCols = fileReader.nextInt();
		maxRows = fileReader.nextInt();
		
		System.out.println("Number of rows: " + maxRows);
		System.out.println("Number of rows: " + numColumns);
		
		
		int[][] gameBoard = new int[maxRows][maxCols];

		for(int row = 0; row < maxRows; row++){
			for((int col = 0; col < maxCols; col++){
				gameBoard[row][col] = fileReader.nextInt();
				
			}
		}
		for(int row = 0; row < maxRows; row++){
			for((int col = 0; col < maxCols; col++){
				System.out.println(gameBoard[row][col] + " ");
			}
		System.out.println("How many steps?");
		int steps = input.nextInt();
		}
		for(int counter = 0; counter < steps; counter++){
			gameBoard.getNeighbors(row, col, maxRows, maxCols);
			System.out.println(gameBoard[row][col] + " ");
		}
	}
		
	public static int getNeighbors(int row, int col, int maxRows, int maxCols){
		nCount = 0;
		for((0 <= row && row < maxRows) && (0 <= col && col < maxCols)){
		gameBoard[row-1][col] = state
		if(state==1){
		nCount++;
		}
		gameBoard[row][col-1] = state
		if(state==1){
		nCount++;
		}
		gameBoard[row-1][col-1] = state
		if(state==1){
		nCount++;
		}
		gameBoard[row+1][col] = state
		if(state==1){
		nCount++;
		}
		gameBoard[row][col+1] = state
		if(state==1){
		nCount++;
		}
		gameBoard[row+1][col+1]
		if(state==1){
		nCount++;
		}
		gameBoard[row+1][col-1]
		if(state==1){
		nCount++;
		}
		gameBoard[row-1][col+1]
		if(state==1){
		nCount++;
		}
		return nCount;
		}
	}