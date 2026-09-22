
public class CasaDaDiscordia extends Casa{

    public CasaDaDiscordia(int posicao){
        super(posicao);
    }
    
    public void aplicarEfeito(Jogador jogador){

        System.out.println("Casa da discórdia: escolha um jogador para voltar ao início do jogo!");
    
        jogador.setPosicao(1);
        System.out.println(jogador.getNome() + " retorna para a casa 1");

    }


}
