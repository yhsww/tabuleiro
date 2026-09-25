import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CasaSurpresa extends Casa{

    public CasaSurpresa(int posicao){
        super(posicao);
    }
    
    public void aplicarEfeito(Jogador jogador, List<Jogador> jogadores){

      //1 - azarado, 2 - sortudo, 3 - normal

      System.out.println("Casa Surpresa: altera o tipo de jogador!");

        int cartaSorteada = ThreadLocalRandom.current().nextInt(1, 4);
        boolean repetido;

        do{

            repetido = (cartaSorteada == 1 && jogador instanceof JogadorAzarado ||
                        cartaSorteada == 2 && jogador instanceof JogadorSortudo ||
                        cartaSorteada == 3 && jogador instanceof JogadorNormal);

        }while(repetido);

        if(cartaSorteada == 1){
            System.out.println("Carta Surpresa: jogador agora é azarado!");
            System.out.println(jogador.getNome() + " está na casa " + jogador.getPosicao());
            jogador = new JogadorAzarado(jogador.getNome(), jogador.getCor());
            return;
        }

        if(cartaSorteada == 2){
            System.out.println("Carta Surpesa: jogador agora é sortudo!");
            System.out.println(jogador.getNome() + " está na casa " + jogador.getPosicao());
            jogador = new JogadorSortudo(jogador.getNome(), jogador.getCor());
            return;
        }

            System.out.println("Carta Surpesa: jogador agora é normal!");
            System.out.println(jogador.getNome() + " está na casa " + jogador.getPosicao());
            jogador = new JogadorNormal(jogador.getNome(), jogador.getCor());

        
    }
}
