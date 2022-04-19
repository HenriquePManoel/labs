package pt.c02oo.s03relacionamento.s04restaum;

public class Posicao {
	
	/* classe que se refere a uma posicao no tabuleiro */
	private int x;
	private int y;
	
	public Posicao(int y, int x){
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	
	public boolean valido() {
		if(x < 0 || y < 0 || y > 6 || x > 6 || (x < 2 && y < 2) || (x < 2 && y > 4) || (x > 4 && y < 2) || (x > 4 && y > 4)) {
			return false;
		}
		return true;
	}


}
