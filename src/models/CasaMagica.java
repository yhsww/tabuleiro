import java.util.Comparator;
import java.util.List;

public class CasaMagica extends Casa{

    public CasaMagica(int posicao){
        super(posicao);
    }

    public void aplicarEfeito(Jogador jogador, List<Jogador> jogadores){

        System.out.println("Casa Mágica: jogador troca de posição com o último jogador!");
        List<Jogador> jogadoresPorPosicao = jogadores.stream().sorted(Comparator.comparing(Jogador::getPosicao)).toList();

        if(jogadoresPorPosicao.get(0) == jogador){
            System.out.println("Jogador deve permancer na mesma casa");
            return;
        }

        Jogador temp = jogador;
        jogador.setPosicao(jogadoresPorPosicao.get(0).getPosicao());
        jogadoresPorPosicao.get(0).setPosicao(temp.getPosicao());

        System.out.println(jogador.getNome() + " está na posição " + jogador.getPosicao());

    }
    
}
