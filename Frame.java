import java.awt.Dimension;

import javax.swing.JFrame;

public class Frame extends JFrame implements Runnable {
	
	public static final Dimension SIZE = new Dimension(730, 800);
	
	private Drawing panel;
	private MouseHandler handler;
	
	public Frame() {
		
		panel = new Drawing(SIZE);
		add(panel);
		
		handler = new MouseHandler();
		addMouseListener(handler);
		
		pack();
	}

	public static void main(String[] args) {
		
		//Create frame
		Frame frame = new Frame();
    
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setSize(SIZE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		new Thread(frame).start();
	}
	
	static Life life = new Life();

	@Override
	public void run() {
			
		Life life = new Life();
	
		int count = 0;
		
		while (true) {
				
			//calculation		
			if (handler.paused) {
				count = 0;
			} else if (count++ > 10) {
				life.update();
				count = 0;
			}
			
			//drawing
			panel.setBoard(life.board);
			panel.repaint();
				
			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				break;
			}
			
		}
		
		
	}
	
	//replaces the current board with a glider gun
	public static void drawGun() {
		life.fill();
		life.board[1][5] = 'X';
		life.board[1][6] = 'X';
		life.board[2][5] = 'X';
		life.board[2][6] = 'X';
		
		life.board[11][5] = 'X';
		life.board[11][6] = 'X';
		life.board[11][7] = 'X';
		life.board[12][4] = 'X';
		life.board[12][8] = 'X';
		life.board[12][4] = 'X';
		life.board[13][9] = 'X';
		life.board[13][3] = 'X';
		life.board[14][9] = 'X';
		life.board[14][3] = 'X';
		life.board[15][6] = 'X';
		life.board[16][4] = 'X';
		life.board[16][8] = 'X';
		life.board[17][5] = 'X';
		life.board[17][6] = 'X';
		life.board[17][7] = 'X';
		life.board[18][6] = 'X';
		

		life.board[21][3] = 'X';
		life.board[21][4] = 'X';
		life.board[21][5] = 'X';
		life.board[22][3] = 'X';
		life.board[22][4] = 'X';
		life.board[22][5] = 'X';
		life.board[23][2] = 'X';
		life.board[23][6] = 'X';
		life.board[25][2] = 'X';
		life.board[25][6] = 'X';
		life.board[25][1] = 'X';
		life.board[25][7] = 'X';
		
		life.board[35][3] = 'X';
		life.board[35][4] = 'X';
		life.board[36][3] = 'X';
		life.board[36][4] = 'X';
	}
	
	
}