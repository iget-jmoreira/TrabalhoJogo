package TrabalhoJogo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Game extends JFrame {
	String[] currentPosition;
	public int movementX = 205;
	public int movementY = 20;
	String username;
	int currentPiece, endCurrentColumn1, endCurrentColumn2, endCurrentColumn3, endCurrentColumn4;
	static int sizeX, sizeY;
	ArrayList<String> GamePieces = new ArrayList<String>();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel painel = new JPanel();
	static JLabel cube1, cube2, cube3, cube4, scoreTitle, score, levelTitle, level, timeTitle, time, cube;
	JButton submit_pause, submit_back, goL, goR;
	int endY1;
	
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem menuItem;
	public Game(String username){
		this.username = username;
		setTitle(username);
		painel.setLayout(null);
		painel.setBackground(Color.WHITE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = (screenSize.getWidth() / 2) - 225;
		setBounds((int) width, 100, 450, 400);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 450, 30);
		
		menu = new JMenu("Menu");
		menuBar.add(menu);
		
		menuItem = new JMenuItem("Pause Game");
		menu.add(menuItem);
		Action goHome = new GoHomeAction();
		menuItem = new JMenuItem("Go Home");
		menuItem.addActionListener(goHome);
		menu.add(menuItem);
		painel.add(menuBar);
		
		
		scoreTitle = new JLabel("<html><font style='font-size:14px;'>Score</font></html>");
		scoreTitle.setBounds(340, 30, 120, 30);
		painel.add(scoreTitle);
		score = new JLabel("<html><font style='font-size:10px;'>928374</font></html>");
		score.setBounds(350, 50, 120, 30);
		painel.add(score);
		
		levelTitle = new JLabel("<html><font style='font-size:14px'>Level</font></html>");
		levelTitle.setBounds(340, 90, 120, 30);
		painel.add(levelTitle);
		level = new JLabel("<html><font style='font-size:10px;'>12</font></html>");
		level.setBounds(350, 10, 120, 30);
		painel.add(level);
		
		timeTitle = new JLabel("<html><font style='font-size:14px'>Time</font></html>");
		timeTitle.setBounds(340, 150, 120, 30);
		painel.add(timeTitle);
		time = new JLabel("<html><font style='font-size:10px;'>21</font></html>");
		time.setBounds(350, 170, 120, 30);
		painel.add(time);
		
		
		int top = 20;
		for(int i = 0; i<12; i++){
		cube = new JLabel(new ImageIcon(getClass().getResource("right.png")));
		cube.setBounds(300, top, 30, 30);
		painel.add(cube);
		top+=30;
		}
		
		Random r = new Random();
		this.currentPiece = r.nextInt(13)+1;
		PieceSettings p = new PieceSettings();
		p.drawPiece(this.movementX, this.movementY, painel, this.currentPiece, this.username);
		
//		Action moveR = new MoveAction("R");
//		Action moveL = new MoveAction("L");
		
//		goL = new JButton("<");
//		goL.addActionListener(moveL);
//		goL.setBounds(10, 80, 80, 30);
//		painel.add(goL);
//		
//		goR = new JButton(">");
//		goR.addActionListener(moveR);
//		goR.setBounds(100, 80, 80, 30);
//		painel.add(goR);
		
		
		
		
		GoDown g = new GoDown();
		g.start();
		
		Container ct = getContentPane();
		ct.add(painel);
	}
	
	
	class GoHomeAction extends AbstractAction{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Game.this.setVisible(false);
			Game.this.GamePieces.clear();
			Game.this.dispose();
			Home h = new Home(Game.this.username);
			h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			h.setVisible(true);
		}
		
	}
	
	public boolean passToDown(int sizeY, int endy1){
		int v = 380 - sizeY;
		boolean result = true;
		if(this.movementY >= v){
			result = false;
		}

		int value = Game.this.movementY + (20 * endy1);
		for(int i = 0; i<Game.this.GamePieces.size();i++){
			if(Game.this.GamePieces.get(i).equals(Game.this.movementX+","+value)){
				
			}
		}
		
		return result;
	}
	
	public boolean passToLeft(int sizeX){
		if(this.movementX <= 5){
			return false;
		} else{
			return true;
		}
	}
	
	public boolean passToRight(int sizeX){
		int v = 275 - sizeX;
		if(this.movementX >= v){
			return false;
		} else{
			return true;
		}
	}
	
	class GoDown extends Thread{
		public void run(){
			PieceSettings p = new PieceSettings();
			while(true){
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int[] value = p.genEndPiece(Game.this.currentPiece);
				if(Game.this.passToDown(Game.sizeY, value[0]) == true){
					Game.this.movementY += 20;
					Game.this.add(cube1);
					Game.this.add(cube2);
					Game.this.add(cube3);
					Game.this.add(cube4);
										
					if(Game.this.endCurrentColumn1 != 0){
						Game.this.endCurrentColumn1 += 20;
					}
					if(Game.this.endCurrentColumn2 != 0){
						Game.this.endCurrentColumn2 += 20;
					}
					if(Game.this.endCurrentColumn3 != 0){
						Game.this.endCurrentColumn3 += 20;
					}
					if(Game.this.endCurrentColumn4 != 0){
						Game.this.endCurrentColumn4 += 20;
					}
					p.drawPiece(Game.this.movementX, Game.this.movementY, painel, Game.this.currentPiece, Game.this.username);
					Game.this.repaint();
				} else{
					int[] a = p.genEndPiece(Game.this.currentPiece);
					Game.this.endCurrentColumn1 = a[0];
					Game.this.endCurrentColumn2 = a[1];
					Game.this.endCurrentColumn3 = a[2];
					Game.this.endCurrentColumn4 = a[3];
					
					String[] finalPosition = p.genPiece(Game.this.currentPiece, Game.this.movementX, Game.this.movementY);
					Game.this.GamePieces.add(finalPosition[0]);
					Game.this.GamePieces.add(finalPosition[1]);
					Game.this.GamePieces.add(finalPosition[2]);
					Game.this.GamePieces.add(finalPosition[3]);
					Game.this.drawGame();
					Game.this.add(cube1);
					Game.this.add(cube2);
					Game.this.add(cube3);
					Game.this.add(cube4);
					Random r = new Random();
					Game.this.currentPiece = r.nextInt(13)+1;
					Game.this.movementX = 205;
					Game.this.movementY = 0;
					p.drawPiece(Game.this.movementX, Game.this.movementY, painel, Game.this.currentPiece, Game.this.username);
					painel.repaint();
				}
			}
		}
	}
	
	public void drawGame(){
		int n = Game.this.GamePieces.size()-1;
		while(n >= 0){
			JLabel cube = new JLabel(new ImageIcon(getClass().getResource("cube.png")));
			String x[] = Game.this.GamePieces.get(n).split(",");
			cube.setBounds(Integer.parseInt(x[0]), Integer.parseInt(x[1]), 19, 19);
			painel.add(cube);
			n--;
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
