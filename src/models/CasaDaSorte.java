public class CasaDaSorte extends Casa{

    public CasaDaSorte(int posicao){
        super(posicao);
    }

    public Jogador aplicarEfeito(Jogador jogador){

        if(!(jogador instanceof JogadorAzarado)){
            jogador.posicao += 3;
            System.out.println(" Casa da sorte: jogador anda mais 3 casas!");
            System.out.println(jogador.getNome() + " está na casa " + jogador.getPosicao());
        }else{
            System.out.println(jogador.getNome() + " está na casa " + jogador.getPosicao());
        }

        return jogador;
        
    }



    
}
