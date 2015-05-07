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

public class PasswordRecovery extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel painel = new JPanel();
	JLabel question, answer, pass1, pass2;
	JTextField input_question, input_answer;
	JPasswordField input_pass1, input_pass2;
	JButton submit_recovery, submit_cancel;
	String db_answ = null, username = null;
	
	public PasswordRecovery(String user, String quest){
		username = user;
		setTitle("Recovery Password");
		GridBagLayout layout = new GridBagLayout();
		painel.setLayout(layout);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = (screenSize.getWidth() / 2) - 200;
		double height = (screenSize.getHeight() / 2) - 275;
		setBounds((int) width, (int) height, 400, 550);
				
		question = new JLabel("Question");
		painel.add(question, new GBC(1,1,1,1).setWeight(1, 1).setAnchor(GBC.WEST).setInsets(10, 40, 0, 0));
		input_question = new JTextField(15);
		input_question.setText(quest);
		painel.add(input_question, new GBC(1,2,1,1).setWeight(2, 0.5).setAnchor(GBC.NORTHWEST).setInsets(5, 25, 25, 150).setFill(GBC.BOTH));

		answer = new JLabel("Answer");
		painel.add(answer, new GBC(1,3,1,1).setWeight(1, 1).setAnchor(GBC.WEST).setInsets(0, 40, 0, 0));
		input_answer = new JTextField(15);
		painel.add(input_answer, new GBC(1,4,1,1).setWeight(2, 0.5).setAnchor(GBC.NORTHWEST).setInsets(5, 25, 25, 150).setFill(GBC.BOTH));

		pass1 = new JLabel("Password");
		painel.add(pass1, new GBC(1,5,1,1).setWeight(1, 1).setAnchor(GBC.WEST).setInsets(0, 40, 0, 0));
		input_pass1 = new JPasswordField();
		painel.add(input_pass1, new GBC(1,6,1,1).setWeight(2, 0.5).setAnchor(GBC.NORTHWEST).setInsets(5, 25, 25, 25).setFill(GBC.BOTH));
		
		pass2 = new JLabel("* Password");
		painel.add(pass2, new GBC(1,7,1,1).setWeight(1, 1).setAnchor(GBC.WEST).setInsets(0, 40, 0, 0));
		input_pass2 = new JPasswordField();
		painel.add(input_pass2, new GBC(1,8,1,1).setWeight(2, 0.5).setAnchor(GBC.NORTHWEST).setInsets(5, 25, 35, 25).setFill(GBC.BOTH));
		
		submit_recovery = new JButton("Confirm");
		painel.add(submit_recovery, new GBC(1,9,1,1).setWeight(1, 0.3).setAnchor(GBC.CENTER).setInsets(0, 20, 10, 20).setFill(GBC.BOTH));
		
		submit_cancel = new JButton("Cancel");
		painel.add(submit_cancel, new GBC(1,10,1,1).setWeight(1, 0.2).setAnchor(GBC.CENTER).setInsets(0, 35, 15, 35).setFill(GBC.BOTH));
		
		
		ClickRecovery recovery = new ClickRecovery();
		submit_recovery.addActionListener(recovery);
		
		ClickBack back = new ClickBack();
		submit_cancel.addActionListener(back);
		
		Container ct = getContentPane();
		ct.add(painel);
	}
	
	class ClickRecovery implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String input_answer, pass1, pass2;
			input_answer = PasswordRecovery.this.input_answer.getText();
			pass1 = String.valueOf(PasswordRecovery.this.input_pass1.getPassword());
			pass2 = String.valueOf(PasswordRecovery.this.input_pass2.getPassword());
			Connect conn = new Connect();
			boolean returned = conn.recovery(PasswordRecovery.this.username, input_answer, pass1, pass2);
			if(returned){
				PasswordRecovery.this.setVisible(false);
			}
		}
		
	}
	
	class ClickBack implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			PasswordRecovery.this.setVisible(false);
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
