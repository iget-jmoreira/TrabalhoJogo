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


public class CheckEmail extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel painel = new JPanel();
	JLabel email, question, answer, password;
	JTextField input_question, input_answer, input_email;
	JPasswordField input_password;
	JButton submit_back, submit_check;

	public CheckEmail(){
		setTitle("Check Email to Recovery Password");
		GridBagLayout layout = new GridBagLayout();
		painel.setLayout(layout);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = (screenSize.getWidth() / 2) - 200;
		double height = (screenSize.getHeight() / 2) - 115;
		setBounds((int) width, (int) height, 400, 230);
		
		email = new JLabel("Email");
		painel.add(email, new GBC(1,1,1,1).setWeight(1, 1).setAnchor(GBC.WEST).setInsets(10, 40, 0, 0));
		input_email = new JTextField();
		painel.add(input_email, new GBC(1,2,1,1).setWeight(1, 0.3).setAnchor(GBC.NORTHWEST).setInsets(0, 25, 30, 100).setFill(GBC.BOTH));
		
		submit_check = new JButton("Check Email");
		painel.add(submit_check, new GBC(1,3,1,1).setWeight(1, 0.3).setAnchor(GBC.CENTER).setInsets(0, 20, 10, 20).setFill(GBC.BOTH));
		
		submit_back = new JButton("Back");
		painel.add(submit_back, new GBC(1,4,1,1).setWeight(1, 0.2).setAnchor(GBC.CENTER).setInsets(0, 25, 15, 35).setFill(GBC.BOTH));
		
		ClickCheck check = new ClickCheck();
		submit_check.addActionListener(check);
		
		ClickBack back = new ClickBack();
		submit_back.addActionListener(back);
		
		Container ct = getContentPane();
		ct.add(painel);
	}

	class ClickCheck implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Connect conn = new Connect();
			boolean returned = conn.checkEmail(CheckEmail.this.input_email.getText());
			if(returned == true){
				CheckEmail.this.setVisible(false);
			}
		}
	}

	class ClickBack implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			CheckEmail.this.setVisible(false);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Index index = new Index();
			index.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			index.setVisible(true);
		}
	}
}