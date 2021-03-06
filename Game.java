package TrabalhoJogo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	boolean stopThread = false, endThread = false;
	JPanel painel = new JPanel();
	JPanel gameStats = new JPanel();
	JLabel c, current_score, score_title, current_level, level_title, current_timer, timer_title;
	int randomPiece, score, speedThread = 500, speedThreadAux = 0, level, timer = 30;
	String coord = "200,10", dir, username;
	ArrayList<String> coords = new ArrayList<String>();
	ArrayList<Integer> lines = new ArrayList<Integer>();
	int optionalPieces = 1;
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem menuItem;
	public Game(String username){
		this.username = username;
		this.coords.add("");
		setTitle("Game");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = (screenSize.getWidth() / 2) - 300;
		setBounds((int) width, 100, 600, 402);
		
		painel.setLayout(null);
		painel.setBounds(0, 30, 400, 345);
		painel.setBackground(Color.WHITE);
		gameStats.setLayout(null);
		gameStats.setBounds(400, 0, 200, 402);
		
		Action quitGame = new QuitGameAction();
//		Action muteUnmuteGame = new MuteUnmuteGameAction();
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 600, 30);
		
		menu = new JMenu("Menu");
		menuBar.add(menu);
		
//		menuItem = new JMenuItem("Mute/Unmute Game");
//		menuItem.addActionListener(muteUnmuteGame);
//		menu.add(menuItem);
		menuItem = new JMenuItem("Quit Game");
		menuItem.addActionListener(quitGame);
		menu.add(menuItem);
		gameStats.add(menuBar);
		
		this.randomPiece = new Random().nextInt(13)+1;
//		this.randomPiece = 3;
		GamePieces gp = new GamePieces();
		gp.drawPiece(this.coord, this.randomPiece, painel);
		
		score_title = new JLabel("Scores");
		score_title.setBounds(430, 40, 100, 30);
		gameStats.add(score_title);
		current_score = new JLabel(Integer.toString(this.score));
		gameStats.add(current_score);
		loadScores();
		
		level_title = new JLabel("Level");
		level_title.setBounds(430, 80, 100, 30);
		gameStats.add(level_title);
		current_level = new JLabel(Integer.toString(this.level));
		current_level.setBounds(440, 100, 100, 30);
		gameStats.add(current_level);
		loadLevels();
		
		GoDown g = new GoDown();
		g.start();
		
		Timer t = new Timer();
		t.start();
		
		addKeyListener(new Game.Move());
		
		Container ct = getContentPane();
		ct.add(painel);
		ct.add(gameStats);
	}
	
	public class QuitGameAction extends AbstractAction{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Game.this.endThread = true;
			Game.this.setVisible(false);
			Game.this.dispose();
			Home h = new Home(Game.this.username);
			h.setVisible(true);
			h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
	}
	
	public class MuteUnmuteGameAction extends AbstractAction{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
//			Music m = new Music();
		}
		
	}
	
	public void loadScores(){
		this.gameStats.remove(current_score);
		this.current_score = new JLabel(Integer.toString(this.score));
		this.current_score.setBounds(440, 60, 100, 30);
		this.gameStats.add(this.current_score);
	}
	
	public void loadLevels(){
		this.gameStats.remove(current_level);
		this.current_level = new JLabel(Integer.toString(this.level));
		this.current_level.setBounds(440, 100, 100, 30);
		this.gameStats.add(current_level);
	}
	
	public void loadPieces(){
		if(this.coords.size() > 1){
			for(int i = 0; i < this.coords.size(); i++){
				String aux[] = this.coords.get(i).split(",");
				int x = Integer.parseInt(aux[0]);
				int y = Integer.parseInt(aux[1]);
				this.c = new JLabel(new ImageIcon(getClass().getResource("cube.png")));
				this.c.setBounds(x, y-20, 19, 19);
				painel.add(this.c);
			}
		}
	}
	
	class Move implements KeyListener {
		
		@Override
		public void keyPressed(KeyEvent evt) {
			// TODO Auto-generated method stub
			GamePieces gp = new GamePieces();
			if((evt.getKeyCode() == KeyEvent.VK_D) || (evt.getKeyCode() == KeyEvent.VK_RIGHT)){
				if(gp.movePiece(Game.this.coords, Game.this.coord, "right", Game.this.randomPiece)){
					String[] aux = Game.this.coord.split(",");
					int newX = Integer.parseInt(aux[0]) + 20;
					Game.this.coord = newX+","+aux[1];
					painel.removeAll();
					Game.this.loadPieces();
					gp.drawPiece(Game.this.coord, Game.this.randomPiece, Game.this.painel);
				}
			} else if((evt.getKeyCode() == KeyEvent.VK_A) || (evt.getKeyCode() == KeyEvent.VK_LEFT)){
				if(gp.movePiece(Game.this.coords, Game.this.coord, "left", Game.this.randomPiece)){
					String[] aux = Game.this.coord.split(",");
					int newX = Integer.parseInt(aux[0]) - 20;
					Game.this.coord = newX+","+aux[1];
					painel.removeAll();
					Game.this.loadPieces();
					gp.drawPiece(Game.this.coord, Game.this.randomPiece, Game.this.painel);
				}
			} else if((evt.getKeyCode() == KeyEvent.VK_S) || (evt.getKeyCode() == KeyEvent.VK_DOWN)){
				if(gp.movePiece(Game.this.coords, Game.this.coord, "superDown", Game.this.randomPiece)){
					String[] aux = Game.this.coord.split(",");
					int newY = Integer.parseInt(aux[1]) + 40;
					Game.this.coord = aux[0]+","+newY;
					painel.removeAll();
					Game.this.loadPieces();
					gp.drawPiece(Game.this.coord, Game.this.randomPiece, Game.this.painel);
				}
			} else if(evt.getKeyCode() == KeyEvent.VK_SPACE){
				if(gp.movePiece(Game.this.coords, Game.this.coord, "rotate", Game.this.optionalPieces)){
					gp.getOptionalPieces(Game.this.username, Game.this);
					painel.removeAll();
					Game.this.loadPieces();
					gp.drawPiece(Game.this.coord, Game.this.randomPiece, Game.this.painel);
					Game.this.painel.repaint();
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class GoDown extends Thread{
		public void run() {
			while(true){
				if(Game.this.endThread == true){
					break;
				}
				try {
					Thread.sleep(Game.this.speedThread);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String[] x = Game.this.coord.split(",");
				
				Game.this.coord = x[0]+","+(Integer.parseInt(x[1]) + 20);
				
				GamePieces g = new GamePieces();
			
				if(g.movePiece(Game.this.coords, Game.this.coord, "down", Game.this.randomPiece)){
					painel.removeAll();
					if(Game.this.coords.size() > 1){
						int n = g.removeLine(Game.this.lines, Game.this.coords);
						Game.this.score += n*60;
						if(n > 0){
							Game.this.loadScores();
							if((Game.this.level > 0) && (Game.this.score >= (200*Game.this.level))){
								Game.this.level += 1;
								Game.this.speedThread /= 1.5;
							} else if(Game.this.score >= 200){
								Game.this.level += 1;
							}
							Game.this.loadLevels();
							Game.this.gameStats.repaint(400,30,200,202);
						}
					}
					Game.this.loadPieces();
					g.drawPiece(Game.this.coord, Game.this.randomPiece, Game.this.painel);
				} else{
					if(Game.this.coord.equals("200,30")){
						Connect c = new Connect();
						c.saveRecord(Game.this.username, Game.this.score);
						JOptionPane.showMessageDialog(null, "Game Over!", "OOPS...", JOptionPane.ERROR_MESSAGE);
						Game.this.setVisible(false);
						Home h = new Home(Game.this.username);
						h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						h.setVisible(true);
						Game.this.stopThread = true;
						break;
					} else{
						Game.this.score += 20;
						Game.this.loadScores();
						if((Game.this.level > 0) && (Game.this.score%(200*Game.this.level) == 0)){
							Game.this.level += 1;
							Game.this.speedThread /= 1.5;
						} else if(Game.this.score%200 == 0){
							Game.this.level += 1;
						}
						Game.this.loadLevels();
						g.addPositions(Game.this.coord, Game.this.randomPiece, Game.this.coords, Game.this.lines);
						Game.this.coord = "200,10";
						Game.this.randomPiece = new Random().nextInt(13)+1;
//						Game.this.randomPiece = 3;
						g.drawPiece(Game.this.coord, Game.this.randomPiece, Game.this.painel);
					}
					Game.this.gameStats.repaint(400,30,200,130);
				}
				Game.this.painel.repaint();
			}
		}
	}
	
	class Timer extends Thread{
		public void run(){
			while (true) {
				if(Game.this.endThread == true){
					break;
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if((Game.this.timer - 1) < 0){
					//altera velocidade
					Game.this.speedThread += 300;
					Game.this.timer = 30;
				} else{
					Game.this.timer -= 1;
				}
				System.out.println(Game.this.timer);
			}
		}
	}
	
}
