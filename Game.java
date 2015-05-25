package TrabalhoJogo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game extends JFrame {
	String[] currentPosition;
	int number = 0;
	public int movementX = 205;
	public int movementY = 20;
	String username;
	int currentPiece;
	static int sizeX, sizeY;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel painel = new JPanel();
	static JLabel cube1, cube2, cube3, cube4, score_title, score, level_title, level, time_title, time;
	JButton submit_pause, submit_back, goL, goR;
	
	public Game(String username){
		this.username = username;
		setTitle(username);
		painel.setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = (screenSize.getWidth() / 2) - 225;
		setBounds((int) width, 100, 450, 400);
		
		Random r = new Random();
		this.currentPiece = r.nextInt(13)+1;
		PieceSettings p = new PieceSettings();
		p.drawPiece(this.movementX, this.movementY, painel, this.currentPiece, this.username);
		
		Action moveR = new MoveAction("R");
		Action moveL = new MoveAction("L");
		
		goL = new JButton("<");
		goL.addActionListener(moveL);
		goL.setBounds(10, 80, 80, 30);
		painel.add(goL);
		
		goR = new JButton(">");
		goR.addActionListener(moveR);
		goR.setBounds(100, 80, 80, 30);
		painel.add(goR);
		
		GoDown g = new GoDown();
		g.start();
		
		Container ct = getContentPane();
		ct.add(painel);
	}
	
	public boolean passToDown(int sizeY){
		int v = 380 - sizeY;
		if(this.movementY >= v){
			return false;
		} else{
			return true;
		}
	}
	
	public boolean passToLeft(int sizeX){
		if(this.movementX <= 5){
			return false;
		} else{
			return true;
		}
	}
	
	public boolean passToRight(int sizeX){
		int v = 445 - sizeX;
		if(this.movementX >= v){
			return false;
		} else{
			return true;
		}
	}
	
	class GoDown extends Thread{
		public void run(){
			while(true){
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(Game.this.passToDown(Game.this.sizeY) == true){
					Game.this.movementY += 20;
					Game.this.add(cube1);
					Game.this.add(cube2);
					Game.this.add(cube3);
					Game.this.add(cube4);
					PieceSettings p = new PieceSettings();
					p.drawPiece(Game.this.movementX, Game.this.movementY, painel, Game.this.currentPiece, Game.this.username);
					Game.this.repaint();
				} else{
					Random r = new Random();
					Game.this.currentPiece = r.nextInt(13)+1;
					PieceSettings p = new PieceSettings();
					Game.this.movementX = 205;
					Game.this.movementY = 0;
					p.drawPiece(Game.this.movementX, Game.this.movementY, painel, Game.this.currentPiece, Game.this.username);
				}
			}
		}
	}
	
	class MoveAction extends AbstractAction{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String dir;
		public MoveAction (String string){
			this.dir = string;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(dir.equals("R")){
				if(Game.this.passToRight(sizeX) == true){
					Game.this.movementX += 20;
				}
			}
			if(dir.equals("L")){
				if(Game.this.passToLeft(sizeX) == true){
					Game.this.movementX -= 20;
				}
			}
			Game.this.add(cube1);
			Game.this.add(cube2);
			Game.this.add(cube3);
			Game.this.add(cube4);
			PieceSettings p = new PieceSettings();
			p.drawPiece(Game.this.movementX, Game.this.movementY, painel, Game.this.currentPiece, Game.this.username);
			Game.this.repaint();
		}
		
	}
}
