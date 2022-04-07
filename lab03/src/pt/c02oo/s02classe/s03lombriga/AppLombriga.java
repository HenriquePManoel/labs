package pt.c02oo.s02classe.s03lombriga;



public class AppLombriga {
	

	public static void main(String[] args) {
		
		Toolkit tk = Toolkit.start();
		
		String[] lombrigas;
		lombrigas = tk.recuperaLombrigas();
		String codigo;
		Animacao anima;
		for(int i=0; i < lombrigas.length; i++) {
			tk.gravaPasso("=====");
			codigo = lombrigas[i];
			anima = new Animacao(codigo);
			for(int j=0; j < codigo.length()- 5; j++){
				tk.gravaPasso(anima.apresenta());
				anima.passo();
			}
		}
		tk.stop();
	}

}
