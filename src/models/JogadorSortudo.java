import java.util.concurrent.ThreadLocalRandom;

public class JogadorSortudo extends Jogador{
    
    public JogadorSortudo(String nome, Cor cor){
        super(nome, cor);
    }

    public boolean jogarDados(){
        
        boolean jogaDeNovo = false;
        int resultado = 0, dado1 = 0, dado2 = 0;

        while (resultado <= 6) {
            dado1 = ThreadLocalRandom.current().nextInt(1, 6);
            dado2 = ThreadLocalRandom.current().nextInt(1, 6);
            resultado = dado1 + dado2;
            this.posicao += resultado;
        }

        System.out.println(this.nome + " anda " + resultado + " casas");

        if(dado1 == dado2){
            jogaDeNovo = true;
        }

        return jogaDeNovo;
        
    }
}
