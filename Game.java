package TrabalhoJogo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.AbstractAction;
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
	int number = 0;
	int movementX = 4;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel painel = new JPanel();
	JPanel gridPainel = new JPanel();
	JLabel cube, score_title, score, level_title, level, time_title, time;
	JButton submit_pause, submit_back;
	
	public Game(String username){
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
		
		Random r = new Random();
		int randomPiece = r.nextInt(13)+1;
		GeneratePieces gen = new GeneratePieces();
		this.drawPiece(gen.genPiece(randomPiece, this.movementX, 1));
		
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		menubar.add(menu);
		JMenuItem item1 = new JMenuItem("Pause Game");
		menu.add(item1);
		JMenuItem item2 = new JMenuItem("Quit Game");
		menu.add(item2);
		menubar.setBounds(0, 0, 600, 30);
		painel.add(menubar);
		
		
//		Action left = new LeftAction();
//		Action right = new RightAction();
		
//		InputMap imap = gridPainel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
//        imap.put(KeyStroke.getKeyStroke("A"), "left");
//        imap.put(KeyStroke.getKeyStroke("D"), "right");
		
//		ActionMap amap = gridPainel.getActionMap();
//        amap.put("A", left);
//        amap.put("D", right);
//        gridPainel.setActionMap(amap);
        

		
		// criar metodo move piece que recebe a peça desenhada e x e y
		// esse metodo sera responsavel por mover ESSA peça
		// quando a peça atingir um Ymaximo ira parar, salvar a posição de cada cubinho em um array que desenhara o jogo
		// depois sera gerada uma nova peça e o jogo continuará normalmente
		
		//desenha top e bottom
		for(int i=0;i<12;i++)
		{
			//topo
			cube = new JLabel(new ImageIcon("C:\\topQuadradinho.png"));
			gridPainel.add(cube, new GBC(i,0,1,1).setWeight(1, 1).setInsets(0, 1, 2, 1));
			//bottom
			cube = new JLabel(new ImageIcon("C:\\botQuadradinho.png"));
			gridPainel.add(cube, new GBC(i,13,1,1).setInsets(0, 0, 0, 0));
		}
		//desenha R&L
		for(int i=0;i<14;i++)
		{
			//left
			cube = new JLabel(new ImageIcon("C:\\leftQuadradinho.png"));
			gridPainel.add(cube, new GBC(0,i,1,1).setWeight(1, 1));
			//right
			cube = new JLabel(new ImageIcon("C:\\rightQuadradinho.png"));
			gridPainel.add(cube, new GBC(11,i,1,1).setWeight(1, 1));
		}
		
		Container ct = getContentPane();
		ct.add(gridPainel);
		ct.add(painel);
	}
	
	class MoveAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private char sentido;

		public void actionPerformed(ActionEvent e) {
			// move sem testar limites
			if(this.sentido == 'D'){
				Game.this.movementX += 1;
			}else{
				Game.this.movementX -= 1;
			}
			repaint();
			System.out.println(this.sentido);
		}
	}
	
	interface Sentido{
		public int getPositionX();
		public char getSentido();
	}
	
	class GoLeft implements Sentido{
		public char SENTIDO = 'A';
		public int getPositionX()
		{
			return -1;
		}
		public char getSentido()
		{
			return SENTIDO;
		}
	}
	
	class GoRight implements Sentido{
		public char SENTIDO = 'D';
		public int getPositionX()
		{
			return 1;
		}
		public char getSentido()
		{
			return SENTIDO;
		}
	}
	
	public void drawPiece(String[][] positions)
	{
		for(int a = 4; a < 7; a++)
		{
			for(int b = 0; b < 4; b++)
			{
				String val = positions[a][b];
				if(val == "true")
				{
					System.out.println(val);
					cube = new JLabel(new ImageIcon("C:\\quadradinho.png"));
					this.gridPainel.add(cube, new GBC(a,b,1,1));
				}
			}
		}
	}
}
