package TrabalhoJogo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game extends JFrame{
	boolean stopThread = false;
	JPanel painel = new JPanel();
	JLabel c;
	int randomPiece;
	String coord = "20,30", dir;
	ArrayList<String> coords = new ArrayList<String>();
	public Game(String username){
		this.coords.add("");
		setTitle("Game");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = (screenSize.getWidth() / 2) - 300;
		setBounds((int) width, 100, 600, 390);
		painel.setLayout(null);
		
		Random r = new Random();
		this.randomPiece = r.nextInt(13)+1;
		
		GamePieces gp = new GamePieces();
		gp.drawPiece(this.coord, this.randomPiece, painel);
		
		GoDown g = new GoDown();
		g.start();
		
		addKeyListener(new Game.Move());
		
		Container ct = getContentPane();
		ct.add(painel);
	}
	
	class Move implements KeyListener {
		
		@Override
		public void keyPressed(KeyEvent evt) {
			System.out.println("oi");
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
	
	class GoDown extends Thread{
		public void run() {
			while(true){
				try {
					Thread.sleep(700);
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
					if(Game.this.coord.equals("20,50")){
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Game Over!");
						Game.this.dispatchEvent(new WindowEvent(Game.this, WindowEvent.WINDOW_CLOSING));
					} else{
						g.addPositions(Game.this.coord, Game.this.randomPiece, Game.this.coords);
						Game.this.coord = "20,30";
						Game.this.randomPiece = new Random().nextInt(13)+1;
						painel.removeAll();
						Game.this.loadPieces();
						g.drawPiece(Game.this.coord, Game.this.randomPiece, Game.this.painel);
					}
				}
				Game.this.painel.repaint();
			}
		}
	}
	
}
