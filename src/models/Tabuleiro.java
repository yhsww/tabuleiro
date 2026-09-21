import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {

    public static List<Casa> casasTabuleiro = new ArrayList<>(40);
    
    // 0 - 39
    // 1 - 40

    public void criarTabuleiro(){

        for(int i = 0; i < this.casasTabuleiro.size(); i++){
            this.casasTabuleiro.get(i).setPosicao(i+1);

        }
    }

}
