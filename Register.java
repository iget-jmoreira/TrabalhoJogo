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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToolBar;


public class Register extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel painel = new JPanel();
	JLabel username, pass1, pass2, email, question, answer;
	JTextField input_username, input_email, input_question, input_answer;
	JPasswordField input_pass1, input_pass2;
	JButton submit_register;
	JToolBar toolbar;
	
	public Register(){
		setTitle("Create New User");
		painel.setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = (screenSize.getWidth() / 2) - 200;
		setBounds((int) width, 100, 400, 530);
		
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
		
		username = new JLabel("Username");
		username.setBounds(40, 50, 360, 25);
		painel.add(username);
		input_username = new JTextField(18);
		input_username.setBounds(40, 75, 260, 25);
		painel.add(input_username);
		
		pass1 = new JLabel("Password");
		pass1.setBounds(40, 110, 260, 25);
		painel.add(pass1);
		input_pass1 = new JPasswordField(15);
		input_pass1.setBounds(40, 135, 260, 25);
		painel.add(input_pass1);

		pass2 = new JLabel("* Password");
		pass2.setBounds(40, 170, 260, 25);
		painel.add(pass2);
		input_pass2 = new JPasswordField(15);
		input_pass2.setBounds(40, 195, 260, 25);
		painel.add(input_pass2);

		email = new JLabel("Email");
		email.setBounds(40, 230, 260, 25);
		painel.add(email);
		input_email = new JTextField();
		input_email.setBounds(40, 255, 260, 25);
		painel.add(input_email);
		
		question = new JLabel("Secret Question");
		question.setBounds(40, 290, 260, 25);
		painel.add(question);
		input_question = new JTextField();
		input_question.setBounds(40, 315, 260, 25);
		painel.add(input_question);
		
		answer = new JLabel("Answer");
		answer.setBounds(40, 350, 260, 25);
		painel.add(answer);
		input_answer = new JTextField();
		input_answer.setBounds(40, 375, 260, 25);
		painel.add(input_answer);
		
		submit_register = new JButton("Save Register");
		submit_register.setBounds(90, 425, 200, 30);
		painel.add(submit_register);
		
		ClickCreate create = new ClickCreate();
		submit_register.addActionListener(create);
		
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
			Register.this.setVisible(false);
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
			Register.this.setVisible(false);
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
			Register.this.setVisible(false);
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
			Register.this.setVisible(false);
			Instructions c = new Instructions();
			c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			c.setVisible(true);
		}
	}
	
	class ClickCreate implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String username = Register.this.input_username.getText();
			String email = Register.this.input_email.getText();
			String pass1 = String.valueOf(Register.this.input_pass1.getPassword());
			String pass2 = String.valueOf(Register.this.input_pass2.getPassword());
			String question = String.valueOf(Register.this.input_question.getText());
			String answer = String.valueOf(Register.this.input_answer.getText());
			
			Connect conn = new Connect();
			boolean returned = conn.saveRegister(username, pass1, pass2, email, question, answer);
			if(returned == true){
				Register.this.setVisible(false);
			}
			
		}
		
	}
}
