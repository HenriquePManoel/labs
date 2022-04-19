package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
	private boolean ocupacoes[][] = new boolean[7][7];
	private Peca pecas[][] = new Peca[7][7];
	
	

	
	public Tabuleiro() {
		/* cria um tabuleiro na configuracao inicial do jogo resta um*/
		for(int i =0; i<7; i++) {
			for(int j =0; j<7; j++) {
				Posicao posicao = new Posicao(i,j);
				if(posicao.valido() && !(i == 3 && j==3 )) {
					colocarPeca(new Peca(posicao));
					ocupacoes[i][j] = true;
				}
				else {
					ocupacoes[i][j] = false;
				}
			}
		}
	}
	
	
	
	public void colocarPeca(Peca peca) {
		pecas[peca.getPosicao().getY()][peca.getPosicao().getX()] = peca;
		ocupacoes[peca.getPosicao().getY()][peca.getPosicao().getX()] = true;
	}
	
	public Peca removerPeca(Posicao posicao) {
		Peca peca = new Peca();
		peca = pecas[posicao.getY()][posicao.getX()];
		pecas[posicao.getY()][posicao.getX()] = null;
		ocupacoes[posicao.getY()][posicao.getX()] = false;
		return peca;
	}
	
	public void fazerMovimento(Posicao posicaoInicial, Posicao destino) {
		/*dada uma posicao inicial e uma final faz o pedido para a peca em tal posicao se mover indicando as posicoes de outras pessas e caso valido
		 * realiza o movimento alternando a posicao da peca e removendo a peca a ser "comida" */
		if(posicaoInicial.valido()) {
			Posicao PecaDescartada = pecas[posicaoInicial.getY()][posicaoInicial.getX()].moverPeca(ocupacoes, destino);
			if(PecaDescartada!= null) {
				colocarPeca(removerPeca(posicaoInicial));
				removerPeca(PecaDescartada);
			}
		}
	}
	
	
	public char[][] apresenta(){
		char tabela[][] = new char[7][7];
		for(int i=0; i<7; i++) {
			for(int j =0; j<7; j++) {
				if(ocupacoes[i][j]) {
					tabela[i][j] = 'P';
				}
				else if(new Posicao(i,j).valido()){
					tabela[i][j] = '-';
				}
				else {
					tabela[i][j] = ' ';
				}
			}
		}
		return tabela;
	}
}
