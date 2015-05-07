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


public class Register extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel painel = new JPanel();
	JLabel username, pass1, pass2, email, question, answer;
	JTextField input_username, input_email, input_question, input_answer;
	JPasswordField input_pass1, input_pass2;
	JButton submit_register, submit_cancel;
	
	public Register(){
		setTitle("Create New User");
		GridBagLayout layout = new GridBagLayout();
		painel.setLayout(layout);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = (screenSize.getWidth() / 2) - 200;
		double height = (screenSize.getHeight() / 2) - 300;
		setBounds((int) width, (int) height, 400, 600);
		
		username = new JLabel("Username");
		painel.add(username, new GBC(1,1,1,1).setWeight(1, 1).setAnchor(GBC.WEST).setInsets(10, 40, 0, 0));
		input_username = new JTextField(18);
		painel.add(input_username, new GBC(1,2,1,1).setWeight(2, 0.5).setAnchor(GBC.NORTHWEST).setInsets(0, 25, 0, 100).setFill(GBC.BOTH));
		
		pass1 = new JLabel("Password");
		painel.add(pass1, new GBC(1,3,1,1).setWeight(1, 1).setAnchor(GBC.WEST).setInsets(0, 40, 0, 0));
		input_pass1 = new JPasswordField(15);
		painel.add(input_pass1, new GBC(1,4,1,1).setWeight(2, 0.5).setAnchor(GBC.NORTHWEST).setInsets(0, 25, 0, 150).setFill(GBC.BOTH));

		pass2 = new JLabel("* Password");
		painel.add(pass2, new GBC(1,5,1,1).setWeight(1, 1).setAnchor(GBC.WEST).setInsets(0, 40, 0, 0));
		input_pass2 = new JPasswordField(15);
		painel.add(input_pass2, new GBC(1,6,1,1).setWeight(2, 0.5).setAnchor(GBC.NORTHWEST).setInsets(0, 25, 0, 150).setFill(GBC.BOTH));

		email = new JLabel("Email");
		painel.add(email, new GBC(1,7,1,1).setWeight(1, 1).setAnchor(GBC.WEST).setInsets(0, 40, 0, 0));
		input_email = new JTextField();
		painel.add(input_email, new GBC(1,8,1,1).setWeight(2, 0.5).setAnchor(GBC.NORTHWEST).setInsets(0, 25, 0, 25).setFill(GBC.BOTH));
		
		question = new JLabel("Secret Question");
		painel.add(question, new GBC(1,9,1,1).setWeight(1, 1).setAnchor(GBC.WEST).setInsets(0, 40, 0, 0));
		input_question = new JTextField();
		painel.add(input_question, new GBC(1,10,1,1).setWeight(2, 0.5).setAnchor(GBC.NORTHWEST).setInsets(0, 25, 0, 25).setFill(GBC.BOTH));
		
		answer = new JLabel("Answer");
		painel.add(answer, new GBC(1,11,1,1).setWeight(1, 1).setAnchor(GBC.WEST).setInsets(0, 40, 0, 0));
		input_answer = new JTextField();
		painel.add(input_answer, new GBC(1,12,1,1).setWeight(2, 0.5).setAnchor(GBC.NORTHWEST).setInsets(0, 25, 20, 25).setFill(GBC.BOTH));
		
		submit_register = new JButton("Save Register");
		painel.add(submit_register, new GBC(1,13,1,1).setWeight(1, 0.3).setAnchor(GBC.CENTER).setInsets(0, 20, 10, 20).setFill(GBC.BOTH));
		
		submit_cancel = new JButton("Cancel");
		painel.add(submit_cancel, new GBC(1,14,1,1).setWeight(1, 0.2).setAnchor(GBC.CENTER).setInsets(0, 35, 15, 35).setFill(GBC.BOTH));
		
		
		ClickCreate create = new ClickCreate();
		submit_register.addActionListener(create);
		
		ClickCancel cancel = new ClickCancel();
		submit_cancel.addActionListener(cancel);
		
		Container ct = getContentPane();
		ct.add(painel);
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
	
	class ClickCancel implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Register.this.setVisible(false);
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
