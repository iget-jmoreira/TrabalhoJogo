package TrabalhoJogo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePieces {
	JLabel cube1, cube2, cube3, cube4;
	public void getOptionalPieces(String username, Game g){
		int aux = g.optionalPieces;
		switch(g.randomPiece){
		case 1:
			g.randomPiece = 1;
			g.optionalPieces = 1;
			break;
		case 2:
			g.randomPiece = 3;
			g.optionalPieces = 2;
			break;
		case 3:
			g.randomPiece = 2;
			g.optionalPieces = 3;
			break;
		case 4:
			g.randomPiece = 5;
			g.optionalPieces = 6;
			break;
		case 5:
			g.randomPiece = 6;
			g.optionalPieces = 7;
			break;
		case 6:
			g.randomPiece = 7;
			g.optionalPieces = 4;
			break;
		case 7:
			g.randomPiece = 4;
			g.optionalPieces = 5;
			break;
		case 8:
			g.randomPiece = 9;
			g.optionalPieces = 10;
			break;
		case 9:
			g.randomPiece = 10;
			g.optionalPieces = 11;
			break;
		case 10:
			g.randomPiece = 11;
			g.optionalPieces = 8;
			break;
		case 11:
			g.randomPiece = 8;
			g.optionalPieces = 9;
			break;
		case 12:
			g.randomPiece = 13;
			g.optionalPieces = 13;
			break;
		case 13:
			g.randomPiece = 12;
			g.optionalPieces = 12;
			break;
		}
	}
	public void drawPiece(String coord, int randomPiece, JPanel painel){
		int x, y;
		String[] coords = coord.split(",");
		x = Integer.parseInt(coords[0]);
		y = Integer.parseInt(coords[1]);
		this.cube1 = new JLabel(new ImageIcon(getClass().getResource("cube.png")));
		this.cube2 = new JLabel(new ImageIcon(getClass().getResource("cube.png")));
		this.cube3 = new JLabel(new ImageIcon(getClass().getResource("cube.png")));
		this.cube4 = new JLabel(new ImageIcon(getClass().getResource("cube.png")));
		switch(randomPiece){
		case 1:
			// cubo
			this.cube1.setBounds(x, y, 19, 19);
			painel.add(this.cube1);
			this.cube2.setBounds(x, y+20, 19, 19);
			painel.add(this.cube2);
			this.cube3.setBounds(x+20, y, 19, 19);
			painel.add(this.cube3);
			this.cube4.setBounds(x+20, y+20, 19, 19);
			painel.add(this.cube4);
			break;
		case 2:
			// linha em pe
			this.cube1.setBounds(x, y, 19, 19);
			painel.add(this.cube1);
			this.cube2.setBounds(x, y+20, 19, 19);
			painel.add(this.cube2);
			this.cube3.setBounds(x, y+40, 19, 19);
			painel.add(this.cube3);
			this.cube4.setBounds(x, y+60, 19, 19);
			painel.add(this.cube4);
			break;
		case 3:
			// linha deitada
			this.cube1.setBounds(x, y, 19, 19);
			painel.add(this.cube1);
			this.cube2.setBounds(x+20, y, 19, 19);
			painel.add(this.cube2);
			this.cube3.setBounds(x+40, y, 19, 19);
			painel.add(this.cube3);
			this.cube4.setBounds(x+60, y, 19, 19);
			painel.add(this.cube4);
			break;
		case 4:
			// linha com ponto pra cima
			this.cube1.setBounds(x, y+20, 19, 19);
			painel.add(this.cube1);
			this.cube2.setBounds(x+20, y+20, 19, 19);
			painel.add(this.cube2);
			this.cube3.setBounds(x+20, y, 19, 19);
			painel.add(this.cube3);
			this.cube4.setBounds(x+40, y+20, 19, 19);
			painel.add(this.cube4);
			break;
		case 5:
			// linha com ponto pra direita
			this.cube1.setBounds(x, y, 19, 19);
			painel.add(this.cube1);
			this.cube2.setBounds(x, y+20, 19, 19);
			painel.add(this.cube2);
			this.cube3.setBounds(x, y+40, 19, 19);
			painel.add(this.cube3);
			this.cube4.setBounds(x+20, y+20, 19, 19);
			painel.add(this.cube4);
			break;
		case 6:
			// linha com ponto para baixo
			this.cube1.setBounds(x, y, 19, 19);
			painel.add(this.cube1);
			this.cube2.setBounds(x+20, y, 19, 19);
			painel.add(this.cube2);
			this.cube3.setBounds(x+40, y, 19, 19);
			painel.add(this.cube3);
			this.cube4.setBounds(x+20, y+20, 19, 19);
			painel.add(this.cube4);
			break;
		case 7:
			// linha com ponto para esquerda
			this.cube1.setBounds(x, y+20, 19, 19);
			painel.add(this.cube1);
			this.cube2.setBounds(x+20, y, 19, 19);
			painel.add(this.cube2);
			this.cube3.setBounds(x+20, y+20, 19, 19);
			painel.add(this.cube3);
			this.cube4.setBounds(x+20, y+40, 19, 19);
			painel.add(this.cube4);
			break;
		case 8:
			// L pra cima
			cube1.setBounds(x, y+20, 19, 19);
			painel.add(cube1);
			cube2.setBounds(x+20, y+20, 19, 19);
			painel.add(cube2);
			cube3.setBounds(x+40, y+20, 19, 19);
			painel.add(cube3);
			cube4.setBounds(x+40, y, 19, 19);
			painel.add(cube4);
			break;
		case 9:
			// L pra direita
			this.cube1.setBounds(x, y, 19, 19);
			painel.add(this.cube1);
			this.cube2.setBounds(x, y+20, 19, 19);
			painel.add(this.cube2);
			this.cube3.setBounds(x, y+40, 19, 19);
			painel.add(this.cube3);
			this.cube4.setBounds(x+20, y+40, 19, 19);
			painel.add(this.cube4);
			break;
		case 10:
			// L pra baixo
			this.cube1.setBounds(x, y, 19, 19);
			painel.add(this.cube1);
			this.cube2.setBounds(x, y+20, 19, 19);
			painel.add(this.cube2);
			this.cube3.setBounds(x+20, y, 19, 19);
			painel.add(this.cube3);
			this.cube4.setBounds(x+40, y, 19, 19);
			painel.add(this.cube4);
			break;
		case 11:
			// L pra esquerda
			this.cube1.setBounds(x, y, 19, 19);
			painel.add(this.cube1);
			this.cube2.setBounds(x+20, y, 19, 19);
			painel.add(this.cube2);
			this.cube3.setBounds(x+20, y+20, 19, 19);
			painel.add(this.cube3);
			this.cube4.setBounds(x+20, y+40, 19, 19);
			painel.add(this.cube4);
			break;
		case 12:
			// S em pé
			this.cube1.setBounds(x, y, 19, 19);
			painel.add(this.cube1);
			this.cube2.setBounds(x, y+20, 19, 19);
			painel.add(this.cube2);
			this.cube3.setBounds(x+20, y+20, 19, 19);
			painel.add(this.cube3);
			this.cube4.setBounds(x+20, y+40, 19, 19);
			painel.add(this.cube4);
			break;
		case 13:
			// S deitado
			this.cube1.setBounds(x, y+20, 19, 19);
			painel.add(this.cube1);
			this.cube2.setBounds(x+20, y+20, 19, 19);
			painel.add(this.cube2);
			this.cube3.setBounds(x+20, y, 19, 19);
			painel.add(this.cube3);
			this.cube4.setBounds(x+40, y, 19, 19);
			painel.add(this.cube4);
			break;
		}
	}
	
	public boolean movePiece(ArrayList<String> coords, String coord, String dir, int randomPiece){
		boolean returned = true;
		String[] pieces = new String[4];
		String curPiece[] = coord.split(",");
		int x = Integer.parseInt(curPiece[0]), y = Integer.parseInt(curPiece[1]);
		
		switch(randomPiece){
		case 1:
			// cubo
			pieces[0] = coord;
			pieces[1] = (x+20)+","+y;
			pieces[2] = x+","+(y+20);
			pieces[3] = (x+20)+","+(y+20);
			break;
		case 2:
			// linha em pe
			pieces[0] = coord;
			pieces[1] = x+","+(y+20);
			pieces[2] = x+","+(y+40);
			pieces[3] = x+","+(y+60);
			break;
		case 3:
			// linha deitada
			pieces[0] = coord;
			pieces[1] = (x+20)+","+y;
			pieces[2] = (x+40)+","+y;
			pieces[3] = (x+60)+","+y;
			break;
		case 4:
			// linha com ponto pra cima
			pieces[0] = (x+20)+","+y;
			pieces[1] = x+","+(y+20);
			pieces[2] = (x+20)+","+(y+20);
			pieces[3] = (x+40)+","+(y+20);
			break;
		case 5:
			// linha com ponto pra direita
			pieces[0] = coord;
			pieces[1] = x+","+(y+20);
			pieces[2] = x+","+(y+40);
			pieces[3] = (x+20)+","+(y+20);
			break;
		case 6:
			// linha com ponto para baixo
			pieces[0] = coord;
			pieces[1] = (x+20)+","+y;
			pieces[2] = (x+40)+","+y;
			pieces[3] = (x+20)+","+(y+20);
			break;
		case 7:
			// linha com ponto para esquerda
			pieces[0] = (x+20)+","+y;
			pieces[1] = (x+20)+","+(y+20);
			pieces[2] = (x+20)+","+(y+40);
			pieces[3] = x+","+(y+20);
			break;
		case 8:
			// L pra cima
			pieces[0] = x+","+(y+20);
			pieces[1] = (x+20)+","+(y+20);
			pieces[2] = (x+40)+","+(y+20);
			pieces[3] = (x+40)+","+y;
			break;
		case 9:
			// L pra direita
			pieces[0] = x+","+y;
			pieces[1] = x+","+(y+20);
			pieces[2] = x+","+(y+40);
			pieces[3] = (x+20)+","+(y+40);
			break;
		case 10:
			// L pra baixo
			pieces[0] = coord;
			pieces[1] = (x+20)+","+y;
			pieces[2] = (x+40)+","+y;
			pieces[3] = x+","+(y+20);
			break;
		case 11:
			// L pra esquerda
			pieces[0] = coord;
			pieces[1] = (x+20)+","+y;
			pieces[2] = (x+20)+","+(y+20);
			pieces[3] = (x+20)+","+(y+40);
			break;
		case 12:
			// S em pé
			pieces[0] = coord;
			pieces[1] = x+","+(y+20);
			pieces[2] = (x+20)+","+(y+20);
			pieces[3] = (x+20)+","+(y+40);
			break;
		case 13:
			// S deitado
			pieces[0] = (x+20)+","+y;
			pieces[1] = (x+40)+","+y;
			pieces[2] = x+","+(y+20);
			pieces[3] = (x+20)+","+(y+20);
			break;
		}
		
		if(dir.equals("right")){
			String[] aux0 = pieces[0].split(",");
			String[] aux1 = pieces[1].split(",");
			String[] aux2 = pieces[2].split(",");
			String[] aux3 = pieces[3].split(",");
			for(int i = 0; i < coords.size(); i++){
				if((coords.get(i).equals((Integer.parseInt(aux0[0]) + 20)+","+(Integer.parseInt(aux0[1]) + 20)))){
					returned = false;
				}
				if((coords.get(i).equals((Integer.parseInt(aux1[0]) + 20)+","+(Integer.parseInt(aux1[1]) + 20)))){
					returned = false;
				}
				if((coords.get(i).equals((Integer.parseInt(aux2[0]) + 20)+","+(Integer.parseInt(aux2[1]) + 20)))){
					returned = false;
				}
				if((coords.get(i).equals((Integer.parseInt(aux3[0]) + 20)+","+(Integer.parseInt(aux3[1]) + 20)))){
					returned = false;
				}
				int n[] = new int[4];
				n[0] = Integer.parseInt(aux0[0]) + 20;
				n[1] = Integer.parseInt(aux1[0]) + 20;
				n[2] = Integer.parseInt(aux2[0]) + 20;
				n[3] = Integer.parseInt(aux3[0]) + 20;
				if((n[0] == 400) || (n[1] == 400) || (n[2] == 400) || (n[3] == 400)){
					returned = false;
				}
			}
		} else if(dir.equals("left")){
			for(int i = 0; i < coords.size(); i++){
				String[] aux0 = pieces[0].split(",");
				String[] aux1 = pieces[1].split(",");
				String[] aux2 = pieces[2].split(",");
				String[] aux3 = pieces[3].split(",");
				if((coords.get(i).equals((Integer.parseInt(aux0[0]) - 20)+","+(Integer.parseInt(aux0[1]) + 20)))){
					returned = false;
				}
				if((coords.get(i).equals((Integer.parseInt(aux1[0]) - 20)+","+(Integer.parseInt(aux1[1]) + 20)))){
					returned = false;
				}
				if((coords.get(i).equals((Integer.parseInt(aux2[0]) - 20)+","+(Integer.parseInt(aux2[1]) + 20)))){
					returned = false;
				}
				if((coords.get(i).equals((Integer.parseInt(aux3[0]) - 20)+","+(Integer.parseInt(aux3[1]) + 20)))){
					returned = false;
				}
				int n[] = new int[4];
				n[0] = Integer.parseInt(aux0[0]);
				n[1] = Integer.parseInt(aux1[0]);
				n[2] = Integer.parseInt(aux2[0]);
				n[3] = Integer.parseInt(aux3[0]);
				if((n[0] == 0) || (n[1] == 0) || (n[2] == 0) || (n[3] == 0)){
					returned = false;
				}
			}
		} else if(dir.equals("down")){
			String[] aux0 = pieces[0].split(",");
			String[] aux1 = pieces[1].split(",");
			String[] aux2 = pieces[2].split(",");
			String[] aux3 = pieces[3].split(",");
			for(int i = 0; i < coords.size(); i++){
				if((coords.get(i).equals(aux0[0]+","+(Integer.parseInt(aux0[1]) + 20)))){
					returned = false;
				}
				if((coords.get(i).equals(aux1[0]+","+(Integer.parseInt(aux1[1]) + 20)))){
					returned = false;
				}
				if((coords.get(i).equals(aux2[0]+","+(Integer.parseInt(aux2[1]) + 20)))){
					returned = false;
				}
				if((coords.get(i).equals(aux3[0]+","+(Integer.parseInt(aux3[1]) + 20)))){
					returned = false;
				}
				int n[] = new int[4];
				n[0] = Integer.parseInt(aux0[1]);
				n[1] = Integer.parseInt(aux1[1]);
				n[2] = Integer.parseInt(aux2[1]);
				n[3] = Integer.parseInt(aux3[1]);
				if((n[0] == 350) || (n[1] == 350) || (n[2] == 350) || (n[3] == 350)){
					returned = false;
				}
			}
		} else if(dir.equals("superDown")){
			String[] aux0 = pieces[0].split(",");
			String[] aux1 = pieces[1].split(",");
			String[] aux2 = pieces[2].split(",");
			String[] aux3 = pieces[3].split(",");
			for(int i = 0; i < coords.size(); i++){
				if((coords.get(i).equals(aux0[0]+","+(Integer.parseInt(aux0[1]) + 60)))){
					returned = false;
				}
				if((coords.get(i).equals(aux1[0]+","+(Integer.parseInt(aux1[1]) + 60)))){
					returned = false;
				}
				if((coords.get(i).equals(aux2[0]+","+(Integer.parseInt(aux2[1]) + 60)))){
					returned = false;
				}
				if((coords.get(i).equals(aux3[0]+","+(Integer.parseInt(aux3[1]) + 60)))){
					returned = false;
				}
				int n[] = new int[4];
				n[0] = Integer.parseInt(aux0[1]) + 60;
				n[1] = Integer.parseInt(aux1[1]) + 60;
				n[2] = Integer.parseInt(aux2[1]) + 60;
				n[3] = Integer.parseInt(aux3[1]) + 60;
				if((n[0] >= 350) || (n[1] >= 350) || (n[2] >= 350) || (n[3] >= 350)){
					returned = false;
				}
			}
		} else if(dir.equals("rotate")){
			String[] aux0 = pieces[0].split(",");
			String[] aux1 = pieces[1].split(",");
			String[] aux2 = pieces[2].split(",");
			String[] aux3 = pieces[3].split(",");
			for(int i = 0; i < coords.size(); i++){
				if((coords.get(i).equals(aux0[0]+","+(Integer.parseInt(aux0[1]) + 20)))){
					returned = false;
				}
				if((coords.get(i).equals(aux1[0]+","+(Integer.parseInt(aux1[1]) + 20)))){
					returned = false;
				}
				if((coords.get(i).equals(aux2[0]+","+(Integer.parseInt(aux2[1]) + 20)))){
					returned = false;
				}
				if((coords.get(i).equals(aux3[0]+","+(Integer.parseInt(aux3[1]) + 20)))){
					returned = false;
				}
				int n[] = new int[4];
				n[0] = Integer.parseInt(aux0[1]);
				n[1] = Integer.parseInt(aux1[1]);
				n[2] = Integer.parseInt(aux2[1]);
				n[3] = Integer.parseInt(aux3[1]);
				if((n[0] >= 350) || (n[1] >= 350) || (n[2] >= 350) || (n[3] >= 350)){
					returned = false;
				}
			}
		}
		
		return returned;
	}
	
	public void addPositions(String coord, int randomPiece, ArrayList<String> coords, ArrayList<Integer> lines){
		if(coords.size() == 1){
			coords.clear();
		}
		String[] p = coord.split(",");
		int x = Integer.parseInt(p[0]), y = Integer.parseInt(p[1]);
		switch(randomPiece){
		case 1:
			// cubo
			coords.add(coord);
			coords.add((x+20)+","+y);
			coords.add(x+","+(y+20));
			coords.add((x+20)+","+(y+20));
			lines.add(y);
			lines.add(y);
			lines.add(y+20);
			lines.add(y+20);
			break;
		case 2:
			// linha em pe
			coords.add(coord);
			coords.add(x+","+(y+20));
			coords.add(x+","+(y+40));
			coords.add(x+","+(y+60));
			lines.add(y);
			lines.add(y+20);
			lines.add(y+40);
			lines.add(y+60);
			break;
		case 3:
			// linha deitada
			coords.add(coord);
			coords.add((x+20)+","+y);
			coords.add((x+40)+","+y);
			coords.add((x+60)+","+y);
			lines.add(y);
			lines.add(y);
			lines.add(y);
			lines.add(y);
			break;
		case 4:
			// linha com ponto pra cima
			coords.add(x+","+(y+20));
			coords.add((x+20)+","+y);
			coords.add((x+20)+","+(y+20));
			coords.add((x+40)+","+(y+20));
			lines.add(y+20);
			lines.add(y);
			lines.add(y+20);
			lines.add(y+20);
			break;
		case 5:
			// linha com ponto pra direita
			coords.add(coord);
			coords.add(x+","+(y+20));
			coords.add((x+20)+","+(y+20));
			coords.add(x+","+(y+40));
			lines.add(y);
			lines.add(y+20);
			lines.add(y+20);
			lines.add(y+40);
			break;
		case 6:
			// linha com ponto para baixo
			coords.add(coord);
			coords.add((x+20)+","+y);
			coords.add((x+40)+","+y);
			coords.add((x+20)+","+(y+20));
			lines.add(y);
			lines.add(y);
			lines.add(y);
			lines.add(y+20);
			break;
		case 7:
			// linha com ponto para esquerda
			coords.add((x+20)+","+y);
			coords.add((x+20)+","+(y+20));
			coords.add(x+","+(y+20));
			coords.add((x+20)+","+(y+40));
			lines.add(y);
			lines.add(y+20);
			lines.add(y+20);
			lines.add(y+40);
			break;
		case 8:
			// L pra cima
			coords.add(x+","+(y+20));
			coords.add((x+20)+","+(y+20));
			coords.add((x+40)+","+(y+20));
			coords.add((x+40)+","+y);
			lines.add(y+20);
			lines.add(y+20);
			lines.add(y+20);
			lines.add(y);
			break;
		case 9:
			// L pra direita
			coords.add(coord);
			coords.add(x+","+(y+20));
			coords.add(x+","+(y+40));
			coords.add((x+20)+","+(y+40));
			lines.add(y);
			lines.add(y+20);
			lines.add(y+40);
			lines.add(y+40);
			break;
		case 10:
			// L pra baixo
			coords.add(coord);
			coords.add((x+20)+","+y);
			coords.add((x+40)+","+y);
			coords.add(x+","+(y+20));
			lines.add(y);
			lines.add(y);
			lines.add(y);
			lines.add(y+20);
			break;
		case 11:
			// L pra esquerda
			coords.add(coord);
			coords.add((x+20)+","+y);
			coords.add((x+20)+","+(y+20));
			coords.add((x+20)+","+(y+40));
			lines.add(y);
			lines.add(y);
			lines.add(y+20);
			lines.add(y+40);
			break;
		case 12:
			// S em pé
			coords.add(coord);
			coords.add(x+","+(y+20));
			coords.add((x+20)+","+(y+20));
			coords.add((x+20)+","+(y+40));
			lines.add(y);
			lines.add(y+20);
			lines.add(y+20);
			lines.add(y+40);
			break;
		case 13:
			// S deitado
			coords.add((x+20)+","+y);
			coords.add((x+40)+","+y);
			coords.add(x+","+(y+20));
			coords.add((x+20)+","+(y+20));
			lines.add(y);
			lines.add(y);
			lines.add(y+20);
			lines.add(y+20);
			break;
		}
	}
	
	public int removeLine(ArrayList<Integer> lines, ArrayList<String> coords){
		ArrayList<Integer> removed = new ArrayList<Integer>();
		int size = lines.size();
		
		for(int i=0; i<size; i++){
			int count = 0;
			for(int a = 0; a<size; a++){
				if(Integer.toString(lines.get(i)).equals(Integer.toString(lines.get(a)))){
					count++;
				}
				if(count == 20){
					if(!removed.contains(lines.get(i))){
						removed.add(lines.get(i));
					}
				}
			}
		}
		removeLines(removed, lines);
		removeCoords(removed, coords);
		int n = removed.size();
		removed.clear();
		return n;
	}
	
	public void removeCoords(ArrayList<Integer> removed, ArrayList<String> coords){
		for(int i = 0; i<coords.size(); i++){
			String aux[] = coords.get(i).split(",");
			int y = Integer.parseInt(aux[1]);
			for(int l = 0; l<removed.size(); l++){
				if(removed.get(l) == y){
					coords.remove(i);
					i--;
				}
			}
		}
		turnDownCoords(removed, coords);
	}
	
	public void removeLines(ArrayList<Integer> removed, ArrayList<Integer> lines){
		for(int i = 0; i<removed.size(); i++){
			while(lines.contains(removed.get(i))){
				lines.remove(lines.indexOf(removed.get(i)));
			}
		}
		turnDownLines(removed, lines);
	}
	
	public void turnDownCoords(ArrayList<Integer> removed, ArrayList<String> coords){
		for(int i = 0; i<removed.size(); i++){
			for(int l = 0; l<coords.size(); l++){
				String[] aux = coords.get(l).split(",");
				int y = Integer.parseInt(aux[1]);
				if(y < removed.get(i)){
					coords.set(l, aux[0]+","+(y+20));
				}
			}
		}
	}
	
	public void turnDownLines(ArrayList<Integer> removed, ArrayList<Integer> lines){
		for(int i = 0; i<removed.size(); i++){
			for(int l = 0; l<lines.size(); l++){
				if(lines.get(l) < removed.get(i)){
					lines.set(l, (lines.get(l) + 20));
				}
			}
		}
	}
	
}
