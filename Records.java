package TrabalhoJogo;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Records extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel painel = new JPanel();
	JLabel freeSpace, user, score, data;
	JButton submit_back;

	public Records(String username){
		setTitle("Records");
		GridBagLayout layout = new GridBagLayout();
		painel.setLayout(layout);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = (screenSize.getWidth() / 2) - 300;
		double height = (screenSize.getHeight() / 2) - 300;
		setBounds((int) width, (int) height, 600, 600);
		
		user = new JLabel("Username");
		painel.add(user, new GBC(1,1,1,1).setWeight(1, 1).setAnchor(GBC.EAST).setInsets(0, 10, 0, 0));
		score = new JLabel("Score");
		painel.add(score, new GBC(2,1,1,1).setWeight(1, 1).setAnchor(GBC.CENTER).setInsets(0, 10, 0, 0));
		data = new JLabel("Date");
		painel.add(data, new GBC(3,1,1,1).setWeight(1, 1).setAnchor(GBC.WEST).setInsets(0, 10, 0, 0));
		
		Connect c = new Connect();
		String users[] = c.getUsersRecord();
		String datas[] = c.getDatasRecord();
		Integer[] scores = c.getScoresRecord();
		for(int i = 1; i<=10; i++){
			if((users[i] != null)){
				user = new JLabel(users[i]);
				painel.add(user, new GBC(1,1+i,1,1).setWeight(1, 1).setAnchor(GBC.EAST).setInsets(0, 0, 0, 0));
				score = new JLabel(scores[i] + "");
				painel.add(score, new GBC(2,1+i,1,1).setWeight(1, 1).setAnchor(GBC.CENTER).setInsets(0, 0, 0, 0));
				data = new JLabel(datas[1]);
				painel.add(data, new GBC(3,1+i,1,1).setWeight(1, 1).setAnchor(GBC.WEST).setInsets(0, 0, 0, 0));
			} else{
				user = new JLabel("");
				painel.add(user, new GBC(1,1+i,1,1).setWeight(1, 1).setAnchor(GBC.EAST).setInsets(0, 0, 0, 0));
				score = new JLabel("");
				painel.add(score, new GBC(2,1+i,1,1).setWeight(1, 1).setAnchor(GBC.CENTER).setInsets(0, 0, 0, 0));
				data = new JLabel("");
				painel.add(data, new GBC(3,1+i,1,1).setWeight(1, 1).setAnchor(GBC.WEST).setInsets(0, 20, 0, 20));
			}
		}
		
		submit_back = new JButton("Voltar");
		painel.add(submit_back, new GBC(2,12,1,1).setWeight(1, 0.3).setAnchor(GBC.CENTER).setInsets(0, 10, 15, 10).setFill(GBC.BOTH));
		
		ClickBack back = new ClickBack(username);
		submit_back.addActionListener(back);
		
		Container ct = getContentPane();
		ct.add(painel);
	}
	
	class ClickBack implements ActionListener{
		private String username;
		public ClickBack(String username){
			this.username = username;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Records.this.setVisible(false);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Home ini= new Home(this.username);
			ini.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ini.setVisible(true);
		}
		
	}
}
