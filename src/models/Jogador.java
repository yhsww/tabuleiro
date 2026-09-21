public abstract class Jogador {

    protected String nome;
    protected Cor cor;
    protected int posicao;
    protected int resultadoAndar;

    public Jogador(String nome, Cor cor){
        this.nome = nome;
        this.cor = cor;
        this.posicao = 0;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setCor(Cor cor){
        this.cor = cor;
    }

    public void setPosicao(int posicao){
        this.posicao = posicao;
    }

    public int getPosicao(){
        return this.posicao;
    }

    public Cor getCor(){
        return this.cor;
    }

    public int getResultadoDados(){
        return this.resultadoAndar;
    }

    public abstract int jogarDados();

}
