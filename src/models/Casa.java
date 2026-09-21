public abstract class Casa {

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

    public abstract Jogador aplicarEfeito(Jogador jogador);

    
}
