package TrabalhoJogo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PieceSettings {
	
	public void drawPiece(int x, int y, JPanel painel, int piece, String username){
		int xPos, yPos;
		PieceSettings p = new PieceSettings();
		String[] positions = p.genPiece(piece, x, y);
		
		String p0 = positions[0];
		String c1[] = p0.split(",");
		xPos = Integer.parseInt(c1[0]);
		yPos = Integer.parseInt(c1[1]);
		Game.cube1 = new JLabel( new ImageIcon(getClass().getResource("cube.png")));
		Game.cube1.setBounds(xPos, yPos, 19, 19);
		painel.add(Game.cube1);
		
		String p1 = positions[1];
		String c2[] = p1.split(",");
		xPos = Integer.parseInt(c2[0]);
		yPos = Integer.parseInt(c2[1]);
		Game.cube2 = new JLabel( new ImageIcon(getClass().getResource("cube.png")));
		Game.cube2.setBounds(xPos, yPos, 19, 19);
		painel.add(Game.cube2);
		
		String p2 = positions[2];
		String c3[] = p2.split(",");
		xPos = Integer.parseInt(c3[0]);
		yPos = Integer.parseInt(c3[1]);
		Game.cube3 = new JLabel( new ImageIcon(getClass().getResource("cube.png")));
		Game.cube3.setBounds(xPos, yPos, 19, 19);
		painel.add(Game.cube3);
		
		String p3 = positions[3];
		String c4[] = p3.split(",");
		xPos = Integer.parseInt(c4[0]);
		yPos = Integer.parseInt(c4[1]);
		Game.cube4 = new JLabel( new ImageIcon(getClass().getResource("cube.png")));
		Game.cube4.setBounds(xPos, yPos, 19, 19);
		painel.add(Game.cube4);
	}
	
	public String[] genPiece(int n, int x, int y){
		String[] piecePositions = new String[4];
		switch(n){
		case 1:
			//cube
			piecePositions[0] = x+","+y;
			piecePositions[1] = x+","+(y+20);
			piecePositions[2] = (x+20)+","+y;
			piecePositions[3] = (x+20)+","+(y+20);
			Game.sizeY = 40;
			Game.sizeX = 40;
			break;
		case 2:
			// L to top
			piecePositions[0] = x+","+(y+20);
			piecePositions[1] = (x+20)+","+(y+20);
			piecePositions[2] = (x+40)+","+(y+20);
			piecePositions[3] = (x+40)+","+y;
			Game.sizeY = 40;
			Game.sizeX = 60;
			break;
		case 3:
			// L to right
			piecePositions[0] = x+","+y;
			piecePositions[1] = x+","+(y+20);
			piecePositions[2] = x+","+(y+40);
			piecePositions[3] = (x+20)+","+(y+40);
			Game.sizeY = 60;
			Game.sizeX = 40;
			break;
		case 4:
			// L to down
			piecePositions[0] = x+","+y;
			piecePositions[1] = (x+20)+","+y;
			piecePositions[2] = (x+40)+","+y;
			piecePositions[3] = x+","+(y+20);
			Game.sizeY = 40;
			break;
		case 5:
			// L to left
			piecePositions[0] = (x+20)+","+y;
			piecePositions[1] = (x+20)+","+(y+20);
			piecePositions[2] = (x+20)+","+(y+40);
			piecePositions[3] = x+","+(y+40);
			Game.sizeY = 60;
			Game.sizeX = 40;
			break;
		case 6:
			// line standing
			piecePositions[0] = x+","+y;
			piecePositions[1] = x+","+(y+20);
			piecePositions[2] = x+","+(y+40);
			piecePositions[3] = x+","+(y+60);
			Game.sizeY = 80;
			Game.sizeX = 20;
			break;
		case 7:
			// lying line
			piecePositions[0] = x+","+y;
			piecePositions[1] = (x+20)+","+y;
			piecePositions[2] = (x+40)+","+y;
			piecePositions[3] = (x+60)+","+y;
			Game.sizeY = 20;
			Game.sizeX = 80;
			break;
		case 8:
			// S to top
			piecePositions[0] = x+","+y;
			piecePositions[1] = x+","+(y+20);
			piecePositions[2] = (x+20)+","+(y+20);
			piecePositions[3] = (x+20)+","+(y+40);
			Game.sizeY = 60;
			Game.sizeX = 40;
			break;
		case 9:
			// S top right
			piecePositions[0] = (x+20)+","+y;
			piecePositions[1] = (x+40)+","+y;
			piecePositions[2] = x+","+(y+20);
			piecePositions[3] = (x+20)+","+(y+20);
			Game.sizeY = 40;
			Game.sizeX = 60;
			break;
		case 10:
			// line-point to top
			piecePositions[0] = (x+20)+","+y;
			piecePositions[1] = x+","+(y+20);
			piecePositions[2] = (x+20)+","+(y+20);
			piecePositions[3] = (x+40)+","+(y+20);
			Game.sizeY = 40;
			Game.sizeX = 60;
			break;
		case 11:
			// linte-point to right
			piecePositions[0] = x+","+y;
			piecePositions[1] = x+","+(y+20);
			piecePositions[2] = x+","+(y+40);
			piecePositions[3] = (x+20)+","+(y+20);
			Game.sizeY = 60;
			Game.sizeX = 40;
			break;
		case 12:
			// line-point to down
			piecePositions[0] = x+","+y;
			piecePositions[1] = (x+20)+","+y;
			piecePositions[2] = (x+40)+","+y;
			piecePositions[3] = (x+20)+","+(y+20);
			Game.sizeY = 40;
			Game.sizeX = 60;
			break;
		case 13:
			// line-point to left
			piecePositions[0] = x+","+(y+20);
			piecePositions[1] = (x+20)+","+y;
			piecePositions[2] = (x+20)+","+(y+20);
			piecePositions[3] = (x+20)+","+(y+40);
			Game.sizeY = 60;
			Game.sizeX = 40;
			break;
		}
		
		return piecePositions;
	}
}
