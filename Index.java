package TrabalhoJogo;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class Index extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel painel = new JPanel();
	JLabel login, password;
	JTextField input_login;
	JPasswordField input_password;
	JButton submit_login;
	JToolBar toolbar;
	
	public Index(){
		setTitle("Login");
		painel.setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = (screenSize.getWidth() / 2) - 200;
		setBounds((int) width, 100, 400, 380);
		
		Action goIndex = new GoIndexAction("Index");
		Action goRegister = new GoRegisterAction("Register");
		Action goCheckEmail = new GoCheckEmailAction("Recovery");
		Action goInstructions = new GoInstructionsAction("Instructions");
		
		toolbar = new JToolBar();
		toolbar.add(new JButton(goIndex));
		toolbar.add(new JButton(goRegister));
		toolbar.add(new JButton(goCheckEmail));
		toolbar.add(new JButton(goInstructions));
		toolbar.setBounds(0, 0, 400, 30);
		painel.add(toolbar);
		
		login = new JLabel("Login");
		login.setBounds(50, 80, 340, 25);
		painel.add(login);
		input_login = new JTextField(12);
		input_login.setBounds(50, 105, 260, 30);
		painel.add(input_login);
		
		password = new JLabel("Password");
		password.setBounds(50, 140, 340, 25);
		painel.add(password);
		input_password = new JPasswordField(12);
		input_password.setBounds(50, 175, 260, 30);
		input_password.addKeyListener(new Index.KeyLogin());
		painel.add(input_password);
		
		submit_login = new JButton("Login");
		submit_login.setBounds(90, 240, 200, 30);
		painel.add(submit_login);
		
		ClickLogin login = new ClickLogin();
		submit_login.addActionListener(login);
		
		Container ct = getContentPane();
		ct.add(painel);
		
	}
	
	class GoIndexAction extends AbstractAction{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public GoIndexAction(String nome){
			super(nome);
			this.putValue(SHORT_DESCRIPTION, nome);
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Index.this.setVisible(false);
			Index i = new Index();
			i.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			i.setVisible(true);
		}
		
	}
	
	class GoRegisterAction extends AbstractAction{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public GoRegisterAction(String nome){
			super(nome);
			this.putValue(SHORT_DESCRIPTION, nome);
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Index.this.setVisible(false);
			Register r = new Register();
			r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			r.setVisible(true);
		}
		
	}
	
	class GoCheckEmailAction extends AbstractAction{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public GoCheckEmailAction(String nome){
			super(nome);
			this.putValue(SHORT_DESCRIPTION, nome);
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Index.this.setVisible(false);
			CheckEmail c = new CheckEmail();
			c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			c.setVisible(true);
		}
	}
	
	class GoInstructionsAction extends AbstractAction{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public GoInstructionsAction(String nome){
			super(nome);
			this.putValue(SHORT_DESCRIPTION, nome);
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Index.this.setVisible(false);
			Instructions c = new Instructions();
			c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			c.setVisible(true);
		}
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
	
	class KeyLogin implements KeyListener{

		@Override
		public void keyPressed(KeyEvent evt) {
			// TODO Auto-generated method stub
			System.out.println();
			if(evt.getKeyCode() == KeyEvent.VK_ENTER){
				String username = Index.this.input_login.getText();
				String password = String.valueOf(Index.this.input_password.getPassword());
				Connect conn = new Connect();
				boolean returned = conn.login(username, password);
				if(returned == true){
					Index.this.setVisible(false);
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
	
}
