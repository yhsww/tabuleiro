import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CasaSurpresa extends Casa{

    public CasaSurpresa(int posicao){
        super(posicao);
    }
    
    public Jogador aplicarEfeito(Jogador jogador){

      //1 - azarado, 2 - sortudo, 3 - normal

        int cartaSorteada = ThreadLocalRandom.current().nextInt(1, 3);

        while(cartaSorteada == 1 && jogador instanceof JogadorAzarado){
            cartaSorteada = ThreadLocalRandom.current().nextInt(1, 3);
        }

        while(cartaSorteada == 2 && jogador instanceof JogadorSortudo){
            cartaSorteada = ThreadLocalRandom.current().nextInt(1, 3);
        }

        while(cartaSorteada == 3 && jogador instanceof JogadorNormal){
            cartaSorteada = ThreadLocalRandom.current().nextInt(1, 3);
        }

        if(cartaSorteada == 1){
            System.out.println("Carta Surpresa: jogador agora é azarado!");
            System.out.println(jogador.getNome() + " está na casa " + jogador.getPosicao());
            JogadorAzarado jogadorAzarado = new JogadorAzarado(jogador.getNome(), jogador.getCor());
            jogadorAzarado.setPosicao(jogador.getPosicao());
            return jogadorAzarado;
        }

        if(cartaSorteada == 2){
            System.out.println("Carta Surpesa: jogador agora é sortudo!");
            System.out.println(jogador.getNome() + " está na casa " + jogador.getPosicao());
            JogadorSortudo jogadorSortudo = new JogadorSortudo(jogador.getNome(), jogador.getCor());
            jogadorSortudo.setPosicao(jogador.getPosicao());
            return jogadorSortudo;
        }

            System.out.println("Carta Surpesa: jogador agora é normal!");
            System.out.println(jogador.getNome() + " está na casa " + jogador.getPosicao());
            JogadorNormal jogadorNormal = new JogadorNormal(jogador.getNome(), jogador.getCor());
            jogadorNormal.setPosicao(jogador.getPosicao());
            return jogadorNormal;

        
    }
}
