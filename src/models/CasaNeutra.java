public class CasaNeutra extends Casa{
    
    public CasaNeutra(int posicao){
        super(posicao);
    }

    public Jogador aplicarEfeito(Jogador jogador){

        System.out.println(jogador.getNome() + " está na casa " + this.posicao);

        return jogador;
    }

}
