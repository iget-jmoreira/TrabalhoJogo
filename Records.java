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
import javax.swing.JTable;


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
		setBounds((int) width, 100, 600, 400);
		
		String columns[] = {"username", "score", "date"};
		Connect c = new Connect();
		String[][] records = c.getRecords();
		
		JTable table = new JTable(records, columns);
		table.setValueAt(this.turnBold("Username"), 0, 0);
		table.setValueAt(this.turnBold("Score"), 0, 1);
		table.setValueAt(this.turnBold("Date"), 0, 2);
		painel.add(table, new GBC(1,1,1,1).setWeight(1, 1).setFill(GBC.BOTH));
		
		submit_back = new JButton("Voltar");
		painel.add(submit_back, new GBC(1,2,1,1).setWeight(1, 1));
		
		ClickBack back = new ClickBack(username);
		submit_back.addActionListener(back);
		
		Container ct = getContentPane();
		ct.add(painel);
	}
	
	public String turnBold(String word){
		return "<html><b><h3>"+word+"</h3></b></html>";
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
