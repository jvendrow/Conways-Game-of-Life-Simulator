import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {

	public static boolean paused = false;
	
	@Override
	public void mouseClicked(MouseEvent e) {
				
		int x = e.getX();
		int y = e.getY() - 23;
		
		//Checks if Pause was clicked
		if (Drawing.PAUSE.contains(x, y)){
			paused = !paused;
		}
		
		//Checks if Gun was clicked
		if (Drawing.GUN.contains(x, y)){
			Frame.drawGun();
		}
				
	}

	@Override
	public void mousePressed(MouseEvent e) {

		int x = e.getX();
		int y = e.getY() - 23;
		
		int xcoord = x/Drawing.CELLSIZE;
		int ycoord = y/Drawing.CELLSIZE;
		
		//Checks for mouse press events on cells
		if (xcoord < Life.board.length && ycoord < Life.board[0].length) {
			
			if(Life.board[xcoord][ycoord] == 'X') {
				
				Life.board[xcoord][ycoord] = ' ';
				
			} else {
				
				Life.board[xcoord][ycoord] = 'X';
			}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
