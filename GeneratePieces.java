package TrabalhoJogo;

class GeneratePieces{
	int n = 0;
	String pieceName = null;
	String username = null;
	
	//as peças nao estao funcionando em todas as posições
	
	public String[][] genPiece(int randomPiece, int x, int y)
	{
		String[][] positions = new String[12][15];
		if(randomPiece == 1){
			positions[x][y] = "true";
			positions[x+1][y] = "true";
			positions[x][y+1] = "true";
			positions[x+1][y+1] = "true";
			this.pieceName = "cube";
		}
		if(randomPiece == 2){
			positions[x][y] = "true";
			positions[x+1][y] = "true";
			positions[x+2][y] = "true";
			positions[x+2][y] = "true";
			this.pieceName = "line";
		}
		if(randomPiece == 3){
			positions[x][y] = "true";
			positions[x][y+1] = "true";
			positions[x][y+2] = "true";
			positions[x][y+2] = "true";
			this.pieceName = "lineU";
		}
		if(randomPiece == 4){
			positions[x+1][y] = "true";
			positions[x][y+1] = "true";
			positions[x+1][y+1] = "true";
			positions[x+2][y+1] = "true";
			this.pieceName = "linePointU";
		}
		if(randomPiece == 5){
			positions[x][y] = "true";
			positions[x][y+1] = "true";
			positions[x][y+2] = "true";
			positions[x+1][y+1] = "true";
			this.pieceName = "linePointR";
		}
		if(randomPiece == 6){
			positions[x][y] = "true";
			positions[x+1][y] = "true";
			positions[x+2][y] = "true";
			positions[x+1][y+1] = "true";
			this.pieceName = "linePointD";
		}
		if(randomPiece == 7){
			positions[x][y+1] = "true";
			positions[x+1][y] = "true";
			positions[x+1][y+1] = "true";
			positions[x+1][y+2] = "true";
			this.pieceName = "linePointL";
		}
		if(randomPiece == 8){
			positions[x][y+1] = "true";
			positions[x+1][y+1] = "true";
			positions[x+2][y+1] = "true";
			positions[x+2][y] = "true";
			this.pieceName = "lU";
		}
		if(randomPiece == 9){
			positions[x][y] = "true";
			positions[x][y+1] = "true";
			positions[x][y+2] = "true";
			positions[x+1][y+2] = "true";
			this.pieceName = "Lr";
		}
		if(randomPiece == 10){
			positions[x][y] = "true";
			positions[x][y+1] = "true";
			positions[x+1][y] = "true";
			positions[x+2][y] = "true";
			this.pieceName = "lD";
		}
		if(randomPiece == 11){
			positions[x][y] = "true";
			positions[x+1][y] = "true";
			positions[x+1][y+1] = "true";
			positions[x+1][y+2] = "true";
			this.pieceName = "lL";
		}
		if(randomPiece == 12){
			positions[x][y] = "true";
			positions[x][y+1] = "true";
			positions[x+1][y+1] = "true";
			positions[x+1][y+2] = "true";
			this.pieceName = "sU";
		}
		if(randomPiece == 13){
			positions[x+1][y] = "true";
			positions[x+2][y] = "true";
			positions[x][y+1] = "true";
			positions[x+1][y+1] = "true";
			this.pieceName = "sR";
		}
		return positions;
	}
}
