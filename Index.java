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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Index extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel painel = new JPanel();
	JLabel login, password;
	JTextField input_login;
	JPasswordField input_password;
	JButton submit_login, submit_register, submit_recovery;
	
	public Index(){
		setTitle("Login");
		GridBagLayout layout = new GridBagLayout();
		painel.setLayout(layout);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = (screenSize.getWidth() / 2) - 200;
		double height = (screenSize.getHeight() / 2) - 190;
		setBounds((int) width, (int) height, 400, 380);
		
		login = new JLabel("Login");
		painel.add(login, new GBC(1,1,1,1).setWeight(1, 1).setAnchor(GBC.WEST).setInsets(10, 40, 3, 0).setFill(GBC.BOTH));
		input_login = new JTextField(12);
		painel.add(input_login, new GBC(1,2,1,1).setWeight(2,0.5).setAnchor(GBC.NORTHWEST).setInsets(0, 25, 15, 100).setFill(GBC.BOTH));
		
		password = new JLabel("Password");
		painel.add(password, new GBC(1,3,1,1).setWeight(1, 1).setAnchor(GBC.WEST).setInsets(0, 40, 3, 0).setFill(GBC.BOTH));
		input_password = new JPasswordField(12);
		painel.add(input_password, new GBC(1,4,1,1).setWeight(2, 0.5).setAnchor(GBC.NORTHWEST).setInsets(0, 25, 40, 140).setFill(GBC.BOTH));
		
		submit_login = new JButton("Login");
		painel.add(submit_login, new GBC(1,5,1,1).setWeight(1, 0.3).setAnchor(GBC.NORTH).setInsets(0, 20, 10, 20).setFill(GBC.BOTH));
		submit_register = new JButton("Create Register");
		painel.add(submit_register, new GBC(1,6,1,1).setWeight(1, 0.2).setAnchor(GBC.NORTH).setInsets(0, 35, 10, 35).setFill(GBC.BOTH));
		submit_recovery = new JButton("Password Recovery");
		painel.add(submit_recovery, new GBC(1,7,1,1).setWeight(1, 0.2).setAnchor(GBC.NORTH).setInsets(0, 50, 15, 50).setFill(GBC.BOTH));
		
		ClickLogin login = new ClickLogin();
		submit_login.addActionListener(login);
		ClickRegister register = new ClickRegister();
		submit_register.addActionListener(register);
		ClickRecovery recovery = new ClickRecovery();
		submit_recovery.addActionListener(recovery);
		
		Container ct = getContentPane();
		ct.add(painel);
		
	}
	
	class ClickLogin implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String username = Index.this.input_login.getText();
			String password = String.valueOf(Index.this.input_password.getPassword());
			Connect conn = new Connect();
			boolean returned = conn.login(username, password);
			if(returned == true){
				Index.this.setVisible(false);
			}
		}
		
	}
	class ClickRegister implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Index.this.setVisible(false);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Register register = new Register();
			register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			register.setVisible(true);
		}
		
	}
	class ClickRecovery implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Index.this.setVisible(false);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		CheckEmail checkEmail = new CheckEmail();
		checkEmail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		checkEmail.setVisible(true);
	}
	
}

}
