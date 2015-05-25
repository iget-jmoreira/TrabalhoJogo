package TrabalhoJogo;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToolBar;


public class CheckEmail extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel painel = new JPanel();
	JLabel email, question, answer, password;
	JTextField input_question, input_answer, input_email;
	JPasswordField input_password;
	JButton submit_check;
	JToolBar toolbar;

	public CheckEmail(){
		setTitle("Check Email to Recovery Password");
		painel.setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = (screenSize.getWidth() / 2) - 200;
		setBounds((int) width, 100, 400, 230);
		
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
		
		email = new JLabel("Email");
		email.setBounds(40, 50, 360, 25);
		painel.add(email);
		input_email = new JTextField();
		input_email.setBounds(40, 75, 260, 25);
		painel.add(input_email);
		
		submit_check = new JButton("Check Email");
		submit_check.setBounds(90, 130, 200, 30);
		painel.add(submit_check);
		
		ClickCheck check = new ClickCheck();
		submit_check.addActionListener(check);
		
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
			CheckEmail.this.setVisible(false);
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
			CheckEmail.this.setVisible(false);
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
			CheckEmail.this.setVisible(false);
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
			CheckEmail.this.setVisible(false);
			Instructions c = new Instructions();
			c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			c.setVisible(true);
		}
	}

	class ClickCheck implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Connect conn = new Connect();
			boolean returned = conn.checkEmail(CheckEmail.this.input_email.getText());
			if(returned == true){
				CheckEmail.this.setVisible(false);
			} else{
				JOptionPane.showMessageDialog(null, "This email is not registered!", "Error!", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}