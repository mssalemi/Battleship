import java.util.*;


public class BattleshipGame {
	
	final int OPPONENT_SHIPS = 3;
	final int BOARD_DIMENSIONS = 10;
	final int [] possibleShips = {1,2,3,4};
	
	ShipPosition [][] board;
	boolean gameOver = false;
	
	
	BattleshipGame(){
		board = new ShipPosition[BOARD_DIMENSIONS][BOARD_DIMENSIONS];
		setEmptyBoard();
	}
	
	
	public void setEmptyBoard(){
		for (int i=0;i<board.length;i++){
			for (int j=0;j<board.length;j++){
				board[i][j] = new ShipPosition(j,i,false);
			}
		}
	}
	
	public void printBoard(){
		System.out.print("\t");
		for (int i=0;i<board.length;i++){
			System.out.print(i + "\t");
		}
		System.out.println();
		for (int i=0;i<board.length;i++){
			System.out.print(i + "\t");
			for (int j=0;j<board.length;j++){
				System.out.print(board[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public void setOpponent(){
		Random rand = new Random();
		for (int i=0;i<OPPONENT_SHIPS;i++){
			// Chooses Random Ship Size
			int shipSize = possibleShips[rand.nextInt(possibleShips.length)];
			System.out.println("Setting ship of size " + shipSize);
			// Set Start Positions
			int startPosition = BOARD_DIMENSIONS - shipSize;
			int xPos = rand.nextInt(startPosition);
			int yPos = rand.nextInt(BOARD_DIMENSIONS);
			System.out.println(yPos + "," + xPos);
			for(int j=0;j<shipSize;j++){
				board[yPos][xPos].toShip();
				xPos++;
			}
		}
	}
	
	public void play(){
		while(!gameOver){
			System.out.println("Guess:");
			Scanner reader = new Scanner(System.in);
			makeGuess(reader.nextLine());
		}
		printBoard();
	}
	
	public void makeGuess(String guess){
		if(guess.length() != 3){
			System.out.println("Please make a valid guess");
			System.out.println("x y is the valid fomat");
		}
		String guessY = guess.split(",")[0];
		String guessX = guess.split(",")[1]; 
		board[Integer.parseInt(guessY)][Integer.parseInt(guessX)].hitSpot();
		printBoard();
	}
	
}
