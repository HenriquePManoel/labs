package pt.c02oo.s03relacionamento.s04restaum;

public class Peca {
	private Posicao posicao;
	
	public Peca(){
	}
	
	
	public Peca(Posicao posicao){
		this.posicao = posicao;
	}
	
	/*recebe uma posicao de destino e um boolean indicando se as posicoes do tabuleiro estao ou nao vazias, verifica se o movimento eh valido e caso seja
	retorna a posicao da peca a ser "comida" */
	public Posicao moverPeca(boolean ocupacoes[][], Posicao destino) {
		if(destino.valido() && !ocupacoes[destino.getY()][destino.getX()] &&
		(!(posicao.getY() - destino.getY() != 0 && posicao.getX() - destino.getX() !=0))) {
			if(posicao.getX() - destino.getX() == 2 && ocupacoes[posicao.getY()][posicao.getX() -1]){
				posicao = destino;
				return new Posicao(posicao.getY(), posicao.getX()+1);
			}
			else if((posicao.getX() - destino.getX() == -2 && ocupacoes[posicao.getY()][posicao.getX()+1])){
				posicao = destino;
				return new Posicao(posicao.getY(), posicao.getX()-1);
			}
			else if(posicao.getY() - destino.getY() == 2 && ocupacoes[posicao.getY()-1][posicao.getX()]) {
				posicao = destino;
				return new Posicao(posicao.getY()+1, posicao.getX());
			}
			else if(posicao.getY( )- destino.getY() == -2 && ocupacoes[posicao.getY()+1][posicao.getX()-1]) {
				posicao = destino;
				return new Posicao(posicao.getY()-1, posicao.getX()-1);
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}
	
	public Posicao getPosicao() {
		return posicao;
	}
}
