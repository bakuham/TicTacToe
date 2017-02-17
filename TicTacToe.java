import java.util.Scanner;

public class TicTacToe {
	
	private static char[][] gameBoard;
	private static Scanner input = new Scanner(System.in);
	private static int spot = 0, count=0, player, answer;
	
	public static void main(String[] args) {
		
		gameBoard = new char[3][3];
		System.out.println("Are you ready to play?");
		gameBoard = initializeBoard(gameBoard);
		printBoard(gameBoard);
		System.out.println();
		
		System.out.println("Player 1 is x and Player 2 is o. Who is going first, 1 or 2?");
		player = input.nextInt();
		
		if (player == 1) {
			firstX(gameBoard);
		}
		if (player == 2) {
			firstO(gameBoard);
		}
	}
	
	public static char[][] initializeBoard(char[][]board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = ' ';
			}
		}
		return board;
	}
	
	public static void printBoard(char[][] board) {
		for (int i = 0; i < board.length-1; i++) {
			for (int j = 0; j < board[i].length-1; j++) {
				System.out.print(board[i][j] + "  |  ");
			}
			System.out.print(board[i][2]);
			System.out.println();
			System.out.print("--------------");
			System.out.println();
		}
		for (int i = 2; i < board.length; i++) {
			for (int j = 0; j < board[i].length-1 ; j++) {
				System.out.print(board[i][j] + "  |  ");
			}
			System.out.print(board[i][2]);
		}
		
	}
	
	public static void firstX(char[][]board) {
		System.out.println("The spots on the board are numbered like this: ");
		int k = 1;
		for (int i = 0; i < board.length-1; i++) {
			for (int j = 0; j < board[i].length-1; j++) {
				System.out.print(k + "  |  ");
				k++;
			}
			System.out.print(k);
			k++;
			System.out.println();
			System.out.print("--------------");
			System.out.println();
		}
		for (int i = 2; i < board.length; i++) {
			for (int j = 0; j < board[i].length-1; j++) {
				System.out.print(k + "  |  ");
				k++;
			}
			System.out.print(k);		
		}
		System.out.println();
		playX(board);
	}
	
	public static void firstO(char[][] board) {
		System.out.println("The spots on the board are numbered like this: ");
		int k = 1;
		for (int i = 0; i < board.length-1; i++) {
			for (int j = 0; j < board[i].length-1; j++) {
				System.out.print(k + "  |  ");
				k++;
			}
			System.out.print(k);
			k++;
			System.out.println();
			System.out.print("--------------");
			System.out.println();
		}
		for (int i = 2; i < board.length; i++) {
			for (int j = 0; j < board[i].length-1; j++) {
				System.out.print(k + "  |  ");
				k++;
			}
			System.out.print(k);		
		}
		System.out.println();
		playO(board);
	}
	
	public static boolean condition(char[][] board) {
		if ((board[0][0] == 'x' && 
			board[0][1] == 'x' &&
			board[0][2] == 'x') ||
			(board[0][0] == 'o' && 
			board[0][1] == 'o' &&
			board[0][2] == 'o')) {
				return true;
		}
		if ((board[1][0] == 'x' && 
			board[1][1] == 'x' &&
			board[1][2] == 'x') ||
			(board[1][0] == 'o' && 
			board[1][1] == 'o' &&
			board[1][2] == 'o')){
				return true;
		}
		if ((board[2][0] == 'x' && 
			board[2][1] == 'x' &&
			board[2][2] == 'x') ||
			(board[2][0] == 'o' && 
			board[2][1] == 'o' &&
			board[2][2] == 'o')) {
				return true;
		}
		if ((board[0][0] == 'x' && 
			board[1][0] == 'x' &&
			board[2][0] == 'x') ||
			(board[0][0] == 'o' && 
			board[1][0] == 'o' &&
			board[2][0] == 'o')) {
				return true;
		}
		if ((board[0][1] == 'x' && 
			board[1][1] == 'x' &&
			board[2][1] == 'x') ||
			(board[0][1] == 'o' && 
			board[1][1] == 'o' &&
			board[2][1] == 'o')) {
				return true;
		}
		if ((board[0][2] == 'x' && 
			board[1][2] == 'x' &&
			board[2][2] == 'x') ||
			(board[0][2] == 'o' && 
			board[1][2] == 'o' &&
			board[2][2] == 'o')) {
				return true;
		}
		if ((board[0][0] == 'x' && 
			board[1][1] == 'x' &&
			board[2][2] == 'x') ||
			(board[0][0] == 'o' && 
			board[1][1] == 'o' &&
			board[2][2] == 'o')) {
				return true;
		}
		if ((board[0][2] == 'x' && 
			board[1][1] == 'x' &&
			board[2][0] == 'x') ||
			(board[0][2] == 'o' && 
			board[1][1] == 'o' &&
			board[2][0] == 'o')) {
				return true;
		}
		return false;
	}
	
	public static void playX(char[][] board) {
		System.out.println("Player 1's turn. Pick a spot.");
		spot = input.nextInt();
		if (spot == 1 ||
			spot == 2 ||
			spot == 3) {	
				if (board[0][spot-1] != ' ') {
					System.out.println("That spot is taken, try again.");
					playX(board);
				}
				board[0][spot-1] = 'x';
		}
		if (spot == 4 ||
			spot == 5 ||
			spot == 6) {
				if (board[1][spot-4] != ' ') {
					System.out.println("That spot is taken, try again.");
					playX(board);
				}
				board[1][spot-4] = 'x';
		}
		if (spot == 7 ||
			spot == 8 ||
			spot == 9) {
				if (board[2][spot-7] != ' ') {
					System.out.println("That spot is taken, try again.");
					playX(board);
				}
				board[2][spot-7] = 'x';
		}
		count++;
		printBoard(board);
		if (condition(board)) {
			win();
		}
		if (count == 9) {
			tie();
		}
		System.out.println();
		System.out.println("Player 2's turn. Pick a spot.");
		spot = input.nextInt();
		if (spot == 1 ||
			spot == 2 ||
			spot == 3) {
				if (board[0][spot-1] != ' ') {
					System.out.println("That spot is taken, try again.");
					playO(board);
				}
				board[0][spot-1] = 'o';
		}
		if (spot == 4 ||
			spot == 5 ||
			spot == 6) {
				if (board[1][spot-4] != ' ') {
					System.out.println("That spot is taken, try again.");
					playO(board);
				}
				board[1][spot-4] = 'o';
		}
		if (spot == 7 ||
			spot == 8 ||
			spot == 9) {
				if (board[2][spot-7] != ' ') {
					System.out.println("That spot is taken, pick again.");
					playO(board);
				}
				board[2][spot-7] = 'o';
		}
		count++;
		printBoard(board);
		if (condition(board)) {
			win();
		}
		if (count == 9) {
			tie();
		}
		System.out.println();
		playX(board);
	}
	
	public static void playO(char[][] board) {
		System.out.println("Player 2's turn. Pick a spot.");
		spot = input.nextInt();
		if (spot == 1 ||
			spot == 2 ||
			spot == 3) {	
				if (board[0][spot-1] != ' ') {
					System.out.println("That spot is taken, try again.");
					playO(board);
				}
				board[0][spot-1] = 'o';
		}
		if (spot == 4 ||
			spot == 5 ||
			spot == 6) {
				if (board[1][spot-4] != ' ') {
					System.out.println("That spot is taken, try again.");
					playO(board);
				}
				board[1][spot-4] = 'o';
		}
		if (spot == 7 ||
			spot == 8 ||
			spot == 9) {
				if (board[2][spot-7] != ' ') {
					System.out.println("That spot is taken, try again.");
					playO(board);
				}
				board[2][spot-7] = 'o';
		}
		count++;
		printBoard(board);
		if (condition(board)) {
			win();
		}
		if (count == 9) {
			tie();
		}
		System.out.println();
		System.out.println("Player 1's turn. Pick a spot.");
		spot = input.nextInt();
		if (spot == 1 ||
			spot == 2 ||
			spot == 3) {
				if (board[0][spot-1] != ' ') {
					System.out.println("That spot is taken, try again.");
					playX(board);
				}
				board[0][spot-1] = 'x';
		}
		if (spot == 4 ||
			spot == 5 ||
			spot == 6) {
				if (board[1][spot-4] != ' ') {
					System.out.println("That spot is taken, try again.");
					playX(board);
				}
				board[1][spot-4] = 'x';
		}
		if (spot == 7 ||
			spot == 8 ||
			spot == 9) {
				if (board[2][spot-7] != ' ') {
					System.out.println("That spot is taken, pick again.");
					playX(board);
				}
				board[2][spot-7] = 'x';
		}
		count++;
		printBoard(board);
		if (condition(board)) {
			win();
		}
		if (count == 9) {
			tie();
		}
		System.out.println();
		playO(board);
	}
	
	public static void win() {
		System.out.println();
		System.out.println("Congratulations, you win!");
		System.out.println("Would you like to play again? 1 for yes, 2 for no.");
		answer = input.nextInt();
		if (answer == 1) {
			initializeBoard(gameBoard);
			System.out.println("Okay, is player 1 or 2 going first?");
			answer = input.nextInt();
			if (answer == 1) {
				printBoard(gameBoard);
				System.out.println();
				playX(gameBoard);
			}
			if (answer == 2) {
				printBoard(gameBoard);
				System.out.println();
				playO(gameBoard);
			}
		}
		if (answer == 2) {
			System.out.println("Okay, thanks for playing!");
			System.exit(1);
		}
	}
	
	public static void tie() {
		System.out.println();
		System.out.println("It's a tie!");
		System.out.println("Would you like to play again? 1 for yes, 2 for no.");
		answer = input.nextInt();
		if (answer == 1) {
			initializeBoard(gameBoard);
			System.out.println("Okay, is player 1 or 2 going first?");
			answer = input.nextInt();
			if (answer == 1) {
				printBoard(gameBoard);
				System.out.println();
				playX(gameBoard);
			}
			if (answer == 2) {
				printBoard(gameBoard);
				System.out.println();
				playO(gameBoard);
			}
		}
		if (answer == 2) {
			System.out.println("Okay, thanks for playing!");
			System.exit(1);
		}
		else {
			System.out.println("Sorry, that wasn't 1 or 2.");
		}
	}
}
