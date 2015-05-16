package TrabalhoJogo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JToolBar;

public class Instructions extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel painel = new JPanel();
	JToolBar toolbar;
	public Instructions(){
		setTitle("Instructions");
		painel.setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = (screenSize.getWidth() / 2) - 225;
		setBounds((int) width, 100, 450, 400);
		
		Action goIndex = new GoIndexAction("Index");
		Action goRegister = new GoRegisterAction("Register");
		Action goCheckEmail = new GoCheckEmailAction("Recovery");
		Action goInstructions = new GoInstructionsAction("Instructions");
		
		toolbar = new JToolBar();
		toolbar.add(new JButton(goIndex));
		toolbar.add(new JButton(goRegister));
		toolbar.add(new JButton(goCheckEmail));
		toolbar.add(new JButton(goInstructions));
		toolbar.setBounds(0, 0, 450, 30);
		painel.add(toolbar);
		
		JTextPane tp = new JTextPane();
		tp.setText("Instructions\nMy Instructions Here");
		tp.setBounds(0, 30, 450, 200);
		painel.add(tp);
		
		
		
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
			Instructions.this.setVisible(false);
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
			Instructions.this.setVisible(false);
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
			Instructions.this.setVisible(false);
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
			Instructions.this.setVisible(false);
			Instructions c = new Instructions();
			c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			c.setVisible(true);
		}
	}
}
