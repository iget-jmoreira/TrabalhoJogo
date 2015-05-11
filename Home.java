package TrabalhoJogo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Home extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel painel = new JPanel();
	JButton submit_play, submit_records, submit_quit;
	
	public Home(String username){
	setTitle(username);
	GridBagLayout layout = new GridBagLayout();
	painel.setLayout(layout);
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double width = (screenSize.getWidth() / 2) - 200;
	double height = (screenSize.getHeight() / 2) - 150;
	setBounds((int) width, (int) height, 400, 300);
	
	submit_play = new JButton("Play Game");
	painel.add(submit_play, new GBC(1,1,1,1).setWeight(1, 0.3).setAnchor(GBC.CENTER).setInsets(0, 10, 15, 10).setFill(GBC.BOTH));
	
	submit_records = new JButton("Records");
	painel.add(submit_records, new GBC(1,2,1,1).setWeight(1, 0.3).setAnchor(GBC.CENTER).setInsets(0,10,15,10).setFill(GBC.BOTH));
	
	submit_quit = new JButton("Quit Game");
	painel.add(submit_quit, new GBC(1,3,1,1).setWeight(1, 0.3).setAnchor(GBC.CENTER).setInsets(0,10,15,10).setFill(GBC.BOTH));
	
	ClickPlay play = new ClickPlay(username);
	submit_play.addActionListener(play);
	
	ClickRecords records = new ClickRecords(username);
	submit_records.addActionListener(records);
	
	ClickQuit quit = new ClickQuit();
	submit_quit.addActionListener(quit);
	
	Container ct = getContentPane();
	ct.add(painel);
	
	}
	
	class ClickPlay implements ActionListener{
		private String username;
		
		public ClickPlay(String username){
			this.username = username;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Home.this.setVisible(false);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Game game = new Game(this.username);
			game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			game.setVisible(true);
		}
		
	}
	
	class ClickRecords implements ActionListener{
		private String username;
		
		public ClickRecords(String username){
			this.username = username;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Home.this.setVisible(false);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Records rec = new Records(this.username);
			rec.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			rec.setVisible(true);
		}
		
	}
	
	class ClickQuit implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Home.this.setVisible(false);
			JOptionPane.showMessageDialog(null, "See You... bye bye.", "Bye Bye", JOptionPane.ERROR_MESSAGE);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Index index = new Index();
			index.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			index.setVisible(true);
		}
		
	}
	
}
