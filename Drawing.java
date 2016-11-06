import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Drawing extends JPanel {
	
	public static final int CELLSIZE = 18;
	public static final Rectangle PAUSE = new Rectangle(5, Life.BOARDSIZE*CELLSIZE+5, 100, 50);
	
	public static final Rectangle GUN = new Rectangle(110, Life.BOARDSIZE*CELLSIZE+5, 100, 50);

  
	public char[][] board;
  
	Drawing(Dimension d) {
		setSize(d);
		
    
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}
  
	public void paint(Graphics graphics) {
	  
		graphics.clearRect(0, 0, Frame.SIZE.width, Frame.SIZE.height);
	  
	  
		for(int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[i][j] == ' ') {
					//do nothing
					graphics.drawRect(CELLSIZE*i, CELLSIZE*j, CELLSIZE, CELLSIZE);
				} else {
					graphics.fillRect(CELLSIZE*i, CELLSIZE*j, CELLSIZE, CELLSIZE);
				}
			}
		}
		graphics.setColor(Color.ORANGE);
		graphics.fillRect(PAUSE.x, PAUSE.y, PAUSE.width, PAUSE.height);
		graphics.setFont(new Font("Arial", Font.PLAIN, 30));
		
		graphics.setColor(Color.BLACK);
		graphics.drawString(MouseHandler.paused ? "Play" : "Pause", PAUSE.x+7, PAUSE.y+35);
		
		graphics.setColor(Color.RED);
		graphics.fillRect(GUN.x, GUN.y, GUN.width, GUN.height);
		//graphics.setFont(new Font("Arial", Font.PLAIN, 30));
		
		graphics.setColor(Color.BLACK);
		graphics.drawString("Gun", GUN.x+7, GUN.y+35);

  }
}
