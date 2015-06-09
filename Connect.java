package TrabalhoJogo;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Connect {
	
	private Connection conn;
	private String driver = "com.mysql.jdbc.Driver";
	
	private String server = "jdbc:mysql://localhost/game";
	private String user = "root";
	private String password = "";
	
	public boolean login(String username, String pass){
		Statement stmt;
		ResultSet rs;
		boolean returned = false;
		try{
			Class.forName(this.driver);
			conn = DriverManager.getConnection(this.server, this.user, this.password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM `users` WHERE username='"+username+"' AND password='"+pass+"'");
			if(rs.next()){
				Home init = new Home(username);
				init.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				init.setVisible(true);
				returned = true;
			} else{
				JOptionPane.showMessageDialog(null, "Username or Password are not!", "Login Fail", JOptionPane.ERROR_MESSAGE);
			}
		} catch(ClassNotFoundException e){
			System.out.println("Erro no Driver "+e.getMessage());
			e.printStackTrace();
		} catch(SQLException e){
			System.out.println("Erro do BD "+e.getMessage());
			e.printStackTrace();
		}
		return returned;
	}
	
	public boolean saveRegister(String username, String pass1, String pass2, String email, String question, String answer){
		Statement stmt;
		ResultSet rs;
		boolean returned = false;
		try{
			Class.forName(this.driver);
			conn = DriverManager.getConnection(this.server, this.user, this.password);
			stmt = conn.createStatement();
			if(pass1.equals(pass2)){
				rs = stmt.executeQuery("SELECT * FROM `users` WHERE username='"+username+"' OR email='"+email+"'");
				if(rs.next()){
					//Falha
					JOptionPane.showMessageDialog(null, "Username or Email already exists!", "Error", JOptionPane.ERROR_MESSAGE);
					returned = false;
				} else{
					if((!username.equals("")) && (!pass1.equals("")) && (!email.equals("")) && (!question.equals("")) && (!answer.equals(""))){
						//Salva
						rs.close();
						stmt.close();
						stmt = conn.createStatement();
						stmt.executeUpdate("INSERT INTO users (username, password, email, question, answer) VALUES ('"+username+"','"+pass1+"','"+email+"', '"+question+"', '"+answer+"')");
						Home init = new Home(username);
						init.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						init.setVisible(true);
						returned = true;
					} else{
						JOptionPane.showMessageDialog(null, "Invalid Datas!", "Error", JOptionPane.ERROR_MESSAGE);
						returned = false;
					}
				} 
			} else{
				JOptionPane.showMessageDialog(null, "Incorrect Passwords!", "Error", JOptionPane.ERROR_MESSAGE);
			}
			stmt.close();
			conn.close();
			
		} catch(ClassNotFoundException e){
			System.out.println("Erro no Driver "+e.getMessage());
			e.printStackTrace();
		} catch(SQLException e){
			System.out.println("Erro do BD "+e.getMessage());
			e.printStackTrace();
		}
		return returned;
	}
	
	public boolean checkEmail(String email){
		Statement stmt;
		ResultSet rs;
		boolean returned = false;
		
		try{
			Class.forName(this.driver);
			conn = DriverManager.getConnection(this.server, this.user, this.password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM `users` WHERE email='"+email+"'");
			if(rs.next()){
				returned = true;
				PasswordRecovery recov = new PasswordRecovery(rs.getString("username"), rs.getString("question"));
				recov.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				recov.setVisible(true);
			} else{
				returned = false;
			}
			rs.close();
			stmt.close();
			
		} catch(ClassNotFoundException e){
			System.out.println("Erro no Driver "+e.getMessage());
			e.printStackTrace();
		} catch(SQLException e){
			System.out.println("Erro do BD "+e.getMessage());
			e.printStackTrace();
		}
		return returned;
	}
	
	public boolean recovery(String username, String answer, String pass1, String pass2){
		Statement stmt;
		boolean returned = false;
		if(pass1.equals(pass2)){
			try{
				Class.forName(this.driver);
				conn = DriverManager.getConnection(this.server, this.user, this.password);
				stmt = conn.createStatement();
//				rs = stmt.executeQuery("SELECT * FROM `users` WHERE username='"+username+"' AND answer='"+answer+"'");
				stmt.executeUpdate("UPDATE `users` SET password='"+pass1+"' WHERE username='"+username+"'");
				returned = true;
				JOptionPane.showMessageDialog(null, "Password Changed!", "Message!", JOptionPane.ERROR_MESSAGE);
				Home home = new Home(username);
				home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				home.setVisible(true);
			} catch(ClassNotFoundException e){
				System.out.println("Erro no Driver "+e.getMessage());
				e.printStackTrace();
			} catch(SQLException e){
				System.out.println("Erro do BD "+e.getMessage());
				e.printStackTrace();
			}
		} else{
			JOptionPane.showMessageDialog(null, "Incorrect Passwords!", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return returned;
	}
	
	public void saveRecord(String username, int score){
		Statement stmt;
		String date = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		
		try{
			Class.forName(this.driver);
			conn = DriverManager.getConnection(this.server, this.user, this.password);
			stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO `records` (username,score, date) VALUES ('"+username+"', '"+score+"', '"+date+"')");
			stmt.close();
			conn.close();
			
		} catch(ClassNotFoundException e){
			System.out.println("Erro no Driver "+e.getMessage());
			e.printStackTrace();
		} catch(SQLException e){
			System.out.println("Erro do BD "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public String[][] getRecords(){
		ResultSet rs;
		Statement stmt;
		String records[][] = new String[15][3];
		try{
			Class.forName(this.driver);
			conn = DriverManager.getConnection(this.server, this.user, this.password);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery("SELECT * FROM records ORDER BY score DESC");
			int i = 1;
			while(rs.next())
			{
				records[i][0] = rs.getString("username");
				records[i][1] = rs.getString("score");
				records[i][2] = rs.getString("date");
				i++;
			}
			
		} catch(ClassNotFoundException e){
			System.out.println("Erro no Driver "+e.getMessage());
			e.printStackTrace();
		} catch(SQLException e){
			System.out.println("Erro do BD "+e.getMessage());
			e.printStackTrace();
		}
		return records;
	}
	
	public void teste(){
		
		try{
			Class.forName(this.driver);
			this.conn = DriverManager.getConnection(this.server, this.user, this.password);
			System.out.println("ok!");
		} catch(ClassNotFoundException e){
			System.out.println("Erro no Driver "+e.getMessage());
			e.printStackTrace();
		} catch(SQLException e){
			System.out.println("Erro do BD "+e.getMessage());
			e.printStackTrace();
		}
	}
	
}
