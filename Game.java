package TrabalhoJogo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
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
	String pieces[][] = new String[100][3];
	String positions[][];
	int number = 0;
	public int movementX = 4;
	public int movementY = 1;
	String username;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel painel = new JPanel();
	JPanel gridPainel = new JPanel();
	JLabel cube, score_title, score, level_title, level, time_title, time;
	JButton submit_pause, submit_back, teste;
	
	public Game(String username){
		this.username = username;
		setTitle(username);
		painel.setLayout(null);
		GridBagLayout layout = new GridBagLayout();
		gridPainel.setLayout(layout);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = (screenSize.getWidth() / 2) - 225;
		double height = (screenSize.getHeight() / 2) - 200;
		setBounds((int) width, (int) height, 450, 400);
		gridPainel.setSize(250,300);
		gridPainel.setBackground(Color.WHITE);
		gridPainel.setLocation(20, 30);
		
		/// GAME STATUS //////////
		score_title = new JLabel("<html><h3>Scores</h3></html>");
		score_title.setBounds(300, 40, 300, 20);
		painel.add(score_title);
		score = new JLabel("<html><p style='font-size: 21px;'>23455</p></html>");
		score.setBounds(320, 55, 300, 30);
		painel.add(score);
		
		level_title = new JLabel("<html><h3>Level</h3></html>");
		level_title.setBounds(300, 100, 300, 20);
		painel.add(level_title);
		level = new JLabel("<html><p style='font-size: 21px;'>12</p></html>");
		level.setBounds(320, 125, 300, 30);
		painel.add(level);
		
		time_title = new JLabel("<html><h3>Time</h3></html>");
		time_title.setBounds(300, 180, 300, 20);
		painel.add(time_title);
		time = new JLabel("<html><p style='font-size: 21px;'>07</p></html>");
		time.setBounds(320, 195, 300, 30);
		painel.add(time);
		//////////////////////////
		
		Random r = new Random();
		int randomPiece = r.nextInt(13)+1;
		Action moveR = new MoveRAction(this.movementX);
//		Action moveL = new MoveRAction(this.movementX);
		GeneratePieces gen = new GeneratePieces();
		this.drawPiece(gen.genPiece(randomPiece, this.movementX, this.movementY));
		
		teste = new JButton(">");
		teste.setBounds(320,260,70,30);
		teste.addActionListener(moveR);
		painel.add(teste);
		
		
		/// JMENU ///////////////
		Action pauseGame = new PauseAction();
		Action goHome = new GoHomeAction(this.username);
		
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		menubar.add(menu);
		JMenuItem item1 = new JMenuItem("Pause Game");
		item1.addActionListener(pauseGame);
		menu.add(item1);
		JMenuItem item2 = new JMenuItem("Quit Game");
		item2.addActionListener(goHome);
		menu.add(item2);
		menubar.setBounds(0, 0, 600, 30);
		painel.add(menubar);
		/////////////////////////
		
		// criar metodo move piece que recebe a pe�a desenhada e x e y
		// esse metodo sera responsavel por mover ESSA pe�a
		// quando a pe�a atingir um Ymaximo ira parar, salvar a posi��o de cada cubinho em um array que desenhara o jogo
		// depois sera gerada uma nova pe�a e o jogo continuar� normalmente
		
		this.drawBorders();
		
		Container ct = getContentPane();
		ct.add(gridPainel);
		ct.add(painel);
	}
	
	class MoveRAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		int x;
		
		public MoveRAction(int x){
			this.x = x;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Game.this.movementX += 1;
			Game.this.repaint();
		}
		
	}
	
	class MoveLAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Game.this.movementX += 1;
			repaint();
		}
		
	}
	
	class PauseAction extends AbstractAction {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("stop the game");
		}
		
	}
	
	class GoHomeAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String username;
		public GoHomeAction(String username){
			this.username = username;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Game.this.setVisible(false);
			Home h = new Home(this.username);
			h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			h.setVisible(true);
		}
		
	}
	
	public void drawPiece(String[][] positions)
	{
		for(int a = 0; a < 12; a++)
		{
			for(int b = 0; b < 15; b++)
			{
//				System.out.println(positions[a][b]);
				String val = positions[a][b];
				if(val == "true")
				{
//					System.out.println(val);
					cube = new JLabel(new ImageIcon(getClass().getResource("cube.png")));
					this.gridPainel.add(cube, new GBC(a,b,1,1));
					repaint();
				}
			}
		}
	}
	
	public void drawBorders()
	{
		//desenha top e bottom
		for(int i=0;i<12;i++)
		{
			//topo
			cube = new JLabel(new ImageIcon(getClass().getResource("top.png")));
			gridPainel.add(cube, new GBC(i,0,1,1).setWeight(1, 1).setInsets(0, 1, 2, 1));
			//bottom
			cube = new JLabel(new ImageIcon(getClass().getResource("bot.png")));
			gridPainel.add(cube, new GBC(i,13,1,1).setWeight(1,1).setInsets(0, 1, 2, 1));
		}
		//desenha R&L
		for(int i=0;i<14;i++)
		{
			//left
			cube = new JLabel(new ImageIcon(getClass().getResource("left.png")));
			gridPainel.add(cube, new GBC(0,i,1,1).setWeight(1, 1).setInsets(1, 0, 1, 0));
			//right
			cube = new JLabel(new ImageIcon(getClass().getResource("right.png")));
			gridPainel.add(cube, new GBC(11,i,1,1).setWeight(1, 1).setInsets(1, 0, 1, 0));
		}
	}
	
}
