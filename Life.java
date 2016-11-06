
public class Life {
	
	public static final int BOARDSIZE = 40;
	
	public static char[][] board = new char[BOARDSIZE][BOARDSIZE];

	//Constructor
	public Life() {
		//Creates an array if spaces
		fill();
	}
	
	//Returns the current board
	public char[][] getBoard() {
		return board;
	}
	
	//Runs through a move
	public void update() {
		char[][] temp = copy(board);
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				if(neighbors(i, j) < 2 || neighbors(i, j) > 3) {
					temp[i][j] = ' ';
				} else if(neighbors(i, j) == 3) {
					temp[i][j] = 'X';
//					System.out.println(i + " " + j + " " + neighbors(i, j));
				}
			}
		}
		board = temp;
	}
	
	//Returns the amount of cells next to a certain cell
	public int neighbors(int x, int y) {
		int total = 0;
		if(x > 0 && y > 0 && board[x-1][y-1] != ' ') {
			total ++;
		}
		if(x > 0 && board[x-1][y] != ' ') {
			total ++;
		}
		if(x > 0 && y+1 < board.length && board[x-1][y+1] != ' ') {
			total ++;
		}
		if(y > 0 && board[x][y-1] != ' ') {
			total ++;
		}
		if(y+1 < board.length && board[x][y+1] != ' ') {
			total ++;
		}
		if(x+1 < board.length && y > 0 && board[x+1][y-1] != ' ') {
			total ++;
		}
		if(x+1 < board.length && board[x+1][y] != ' ') {
			total ++;
		}
		if(x+1 < board.length && y+1 < board.length && board[x+1][y+1] != ' ') {
			total ++;
		}
		return total;
	}
	
	
    //Fills an array with empty spaces
    public void fill() {
    	for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = ' ';
			}
		}
    }
    
    //Copies an array to a new array
    public char[][] copy(char[][] array) {
		char[][] newArray = new char[array.length][array.length];
		  for(int i = 0; i < array.length; i++) {
	            for(int k = 0; k < array.length; k++) {
	            	newArray[i][k] = array[i][k];
	            }
		  }
		return newArray;
	}
}
