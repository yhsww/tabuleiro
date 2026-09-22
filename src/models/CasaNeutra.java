public class CasaNeutra extends Casa{
    
    public CasaNeutra(int posicao){
        super(posicao);
    }

    public void aplicarEfeito(Jogador jogador){

        System.out.println(jogador.getNome() + " está na casa " + jogador.getPosicao());
    }

}
