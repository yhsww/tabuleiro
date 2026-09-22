import java.util.List;

public class Casa {

    protected int posicao;

    public Casa(int posicao){
        this.posicao = posicao;
    }

    public int getPosicao(){
        return this.posicao;
    }

    public void setPosicao(int posicao){
        this.posicao = posicao;
    }

    public void aplicarEfeito(Jogador jogador){

        System.out.println(jogador.getNome() + " está na casa " + jogador.getPosicao());
        
    }

    
}
