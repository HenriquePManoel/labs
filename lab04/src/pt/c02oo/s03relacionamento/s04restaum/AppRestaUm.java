package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {

   public static void main(String[] args) {
      AppRestaUm.executaJogo(null, null);
   }
   
   public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
      Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
      
      String commands[] = tk.retrieveCommands();
      Tabuleiro tabuleiro = new Tabuleiro();
      int xInicial;
      int yInicial;
      int xDestino;
      int yDestino;
      
      
      tk.writeBoard("Tabuleiro inicial", tabuleiro.apresenta());
      for (int l = 0; l < commands.length; l++) {
      	xInicial = (int)commands[l].charAt(0) -97;
      	yInicial= Integer.parseInt(""+commands[l].charAt(1)) - 1;
      	xDestino = (int) commands[l].charAt(3) - 97;
      	yDestino = Integer.parseInt("" + commands[l].charAt(4)) -1;
      	tabuleiro.fazerMovimento(new Posicao(yInicial, xInicial), new Posicao(yDestino, xDestino));
      	tk.writeBoard("source: " + commands[l].substring(0,2)+ "; target: " + commands[l].substring(3,5), tabuleiro.apresenta());
      }
      tk.stop();
   }

}
