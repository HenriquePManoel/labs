package pt.c02oo.s02classe.s03lombriga;

public class Animacao {
	String comandos;
    AquarioLombriga lombriga;
    
    public Animacao(){
    }
    
    public Animacao(String codigo){
        comandos = codigo.substring(6);
        lombriga = new AquarioLombriga(Integer.parseInt(codigo.substring(0,2)), Integer.parseInt(codigo.substring(2,4)), Integer.parseInt(codigo.substring(4,6)));
    }
    
    public String apresenta(){
        return lombriga.apresenta();
    }
    
    public void passo(){
    	if(comandos != "") {
	        switch(comandos.charAt(0)){
	            case 'C':
	                lombriga.crescer();
	                break;
	            case 'M':
	                lombriga.mover();
	                break;
	            case 'V':
	                lombriga.virar();
	                break;
	        }
	        comandos = comandos.substring(1);
    	}
    }
}
