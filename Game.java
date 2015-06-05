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
	boolean stopThread = false;
	JPanel painel = new JPanel();
	JPanel gameStats = new JPanel();
	JLabel c, current_score, score_title, current_level, level_title;
	int randomPiece, score, speedThread = 1000, speedThreadAux = 0, level;
	String coord = "200,10", dir, username;
	ArrayList<String> coords = new ArrayList<String>();
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
		
		Action goHome = new GoHomeAction();
		Action continueStopGame = new ContinueStopGameAction();
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 600, 30);
		
		menu = new JMenu("Menu");
		menuBar.add(menu);
		
		menuItem = new JMenuItem("Continue/Pause Game");
		menuItem.addActionListener(continueStopGame);
		menu.add(menuItem);
		menuItem = new JMenuItem("Go Home");
		menuItem.addActionListener(goHome);
		menu.add(menuItem);
		gameStats.add(menuBar);
		
		this.randomPiece = new Random().nextInt(13)+1;
//		this.randomPiece = 2;
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
		
		addKeyListener(new Game.Move());
		
		Container ct = getContentPane();
		ct.add(painel);
		ct.add(gameStats);
	}
	
	public class GoHomeAction extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class ContinueStopGameAction extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(Game.this.speedThreadAux == 0){
				Game.this.speedThreadAux = Game.this.speedThread;
				Game.this.speedThread = 5000;
				String[] aux = Game.this.coord.split(",");
				int newY = Integer.parseInt(aux[1]) - 20;
				Game.this.coord = aux[0]+","+newY;
				System.out.println(Game.this.speedThread+" - normal");
				System.out.println(Game.this.speedThreadAux+" - aux");
			} else{
				Game.GoDown.currentThread().getState();
				Game.this.speedThread = Game.this.speedThreadAux;
				Game.this.speedThreadAux = 0;
				System.out.println(Game.this.speedThread+" - normal");
				System.out.println(Game.this.speedThreadAux+" - aux");
				Game.this.painel.repaint();
			}
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
			if(evt.getKeyCode() == KeyEvent.VK_D){
				if(gp.movePiece(Game.this.coords, Game.this.coord, "right", Game.this.randomPiece)){
					String[] aux = Game.this.coord.split(",");
					int newX = Integer.parseInt(aux[0]) + 20;
					Game.this.coord = newX+","+aux[1];
					painel.removeAll();
					Game.this.loadPieces();
					gp.drawPiece(Game.this.coord, Game.this.randomPiece, Game.this.painel);
				}
			} else if(evt.getKeyCode() == KeyEvent.VK_A){
				if(gp.movePiece(Game.this.coords, Game.this.coord, "left", Game.this.randomPiece)){
					String[] aux = Game.this.coord.split(",");
					int newX = Integer.parseInt(aux[0]) - 20;
					Game.this.coord = newX+","+aux[1];
					painel.removeAll();
					Game.this.loadPieces();
					gp.drawPiece(Game.this.coord, Game.this.randomPiece, Game.this.painel);
				}
			} else if(evt.getKeyCode() == KeyEvent.VK_S){
				if(gp.movePiece(Game.this.coords, Game.this.coord, "superDown", Game.this.randomPiece)){
					String[] aux = Game.this.coord.split(",");
					int newY = Integer.parseInt(aux[1]) + 40;
					Game.this.coord = aux[0]+","+newY;
					painel.removeAll();
					Game.this.loadPieces();
					gp.drawPiece(Game.this.coord, Game.this.randomPiece, Game.this.painel);
				}
			} else if(evt.getKeyCode() == KeyEvent.VK_SPACE){
				gp.getOptionalPieces(Game.this.username, Game.this);
				painel.removeAll();
				Game.this.loadPieces();
				gp.drawPiece(Game.this.coord, Game.this.randomPiece, Game.this.painel);
				Game.this.painel.repaint();
				//CRIAR CONDIÇÃO PRA NAO PODER VIRAR
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
					Game.this.loadPieces();
					g.drawPiece(Game.this.coord, Game.this.randomPiece, Game.this.painel);
					
				} else{
					if(Game.this.coord.equals("200,30")){
						Connect c = new Connect();
						c.saveRecord(Game.this.username, Game.this.score);
						JOptionPane.showMessageDialog(null, "Game Over!", "OOPS...", JOptionPane.ERROR_MESSAGE);
						break;
					} else{
						Game.this.score += 20;
						Game.this.loadScores();
						if(Game.this.score == 100){
							Game.this.level += 1;
						}
						Game.this.loadLevels();
						g.addPositions(Game.this.coord, Game.this.randomPiece, Game.this.coords);
//						System.out.println(Game.this.coords);
						Game.this.coord = "200,10";
						Game.this.randomPiece = new Random().nextInt(13)+1;
//						Game.this.randomPiece = 1;
						g.drawPiece(Game.this.coord, Game.this.randomPiece, Game.this.painel);
					}
					Game.this.gameStats.repaint();
				}
				Game.this.painel.repaint();
			}
		}
	}
	
}
