public class CasaDaSorte extends Casa{

    public CasaDaSorte(int posicao){
        super(posicao);
    }

    public void aplicarEfeito(Jogador jogador){

        System.out.println("Casa da sorte: ande 3 casas se não for azarado!");
        if(!(jogador instanceof JogadorAzarado)){
            jogador.posicao += 3;
            System.out.println(" Casa da sorte: jogador anda mais 3 casas!");
            System.out.println(jogador.getNome() + " está na casa " + jogador.getPosicao());
        }else{
            System.out.println(jogador.getNome() + " está na casa " + jogador.getPosicao());
        }
        
    }



    
}
