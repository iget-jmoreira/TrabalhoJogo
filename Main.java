package TrabalhoJogo;

import javax.swing.JFrame;


public class Main {
	
	public static void main(String[] args) {
//		Index page = new Index();
		
//		Instructions page = new Instructions();
		
		Game page = new Game("tinho744");

//		Connect con = new Connect();
//		con.teste();
		
//		Records page = new Records("tinho744");
		
//		Home page = new Home("tinho744");
		
		page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		page.setVisible(true);
		
		
	}

}