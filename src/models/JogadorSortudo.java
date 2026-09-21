import java.util.concurrent.ThreadLocalRandom;

public class JogadorSortudo extends Jogador{
    
    public JogadorSortudo(String nome, Cor cor){
        super(nome, cor);
    }

    public int jogarDados(){

        int resultado = 0;

        while (resultado <= 6) {
            int dado1 = ThreadLocalRandom.current().nextInt(1, 6);
            int dado2 = ThreadLocalRandom.current().nextInt(1, 6);
            resultado = dado1 + dado2;
        }

        return this.resultadoAndar = resultado;
        
    }
}
