package pt.c02oo.s02classe.s03lombriga;

public class AquarioLombriga {
	int tamanhoAquario;
    int tamanhoLombriga;
    int posicaoCabeca;
    int direcao =0;
    
    
    public  AquarioLombriga(int tamanhoAquario, int tamanhoLombriga, int posicaoInicial){
        this.tamanhoAquario = tamanhoAquario;
        if(tamanhoAquario >= tamanhoLombriga){
            this.tamanhoLombriga = tamanhoLombriga;
            
        }
        else{
            this.tamanhoLombriga = tamanhoAquario;
        }
        if(posicaoInicial > tamanhoAquario || posicaoInicial <= 0){
            posicaoCabeca = 1;
        }
        else{
            posicaoCabeca = posicaoInicial;
        }
        
    }
    
    public void crescer(){
        if(direcao ==0){
            if(tamanhoLombriga + posicaoCabeca - 1 < tamanhoAquario ){
                tamanhoLombriga++;
            }
        }
        else{
            if(tamanhoLombriga + (tamanhoAquario-posicaoCabeca)< tamanhoAquario ){
                tamanhoLombriga++;
            }
        }
    }
    
    public void virar(){
        if(direcao ==0){
        	posicaoCabeca = posicaoCabeca + tamanhoLombriga -1;
            direcao = 1;
        }
        else{
        	posicaoCabeca = posicaoCabeca - tamanhoLombriga +1;
            direcao =0;
        }
    }
    
    public void mover(){
        if(direcao == 0){
            if(posicaoCabeca == 1){
                virar();
            }
            else{
                posicaoCabeca--;
            }
        }
        else{
            if(posicaoCabeca == tamanhoAquario){
                virar();
            }
            else{
                posicaoCabeca++;
            }
        }
        
    }
    public String apresenta(){
        String result = "";
        for(int i=0; i< tamanhoAquario;i++){
            result += "#";
        }
        
        result = result.substring(0,posicaoCabeca-1) + "O" + result.substring(posicaoCabeca);
        
        if(direcao == 0){
            for(int i=1; i<tamanhoLombriga;i++){
                result = result.substring(0,posicaoCabeca+ i -1) + "@" + result.substring(posicaoCabeca+i);
            }
        }
        else{
            for(int i =1;i<tamanhoLombriga;i++){
                result = result.substring(0,posicaoCabeca- i -1) + "@" + result.substring(posicaoCabeca-i);
            }
        }
        return result;
    }
    
}
