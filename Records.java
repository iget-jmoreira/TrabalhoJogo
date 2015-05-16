package TrabalhoJogo;
import java.awt.Container;
import java.awt.Dimension;
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
		painel.setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = (screenSize.getWidth() / 2) - 300;
		double height = (screenSize.getHeight() / 2) - 200;
		setBounds((int) width, (int) height, 600, 400);
		
		String columns[] = {"username", "score", "date"};
		Connect c = new Connect();
		String[][] records = c.getRecords();
		
		JTable table = new JTable(records, columns);
		table.setValueAt(this.turnBold("Username"), 0, 0);
		table.setValueAt(this.turnBold("Score"), 0, 1);
		table.setValueAt(this.turnBold("Date"), 0, 2);
		table.setBounds(50, 20, 500, 176);
		painel.add(table);
		
		submit_back = new JButton("Voltar");
		submit_back.setBounds(200, 300, 200, 30);
		painel.add(submit_back);
		
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
