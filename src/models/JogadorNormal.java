import java.util.concurrent.ThreadLocalRandom;

public class JogadorNormal extends Jogador{

    public JogadorNormal(String nome, Cor cor){
        super(nome, cor);
    }

    public int andarCasas(){

        int dado1 = ThreadLocalRandom.current().nextInt(1, 6);
        int dado2 = ThreadLocalRandom.current().nextInt(1, 6);
        return this.resultadoAndar = dado1 + dado2;   
    }
    
}
