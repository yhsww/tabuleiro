import java.util.ArrayList;
import java.util.List;

import src.util.Utilitarios;

public class Jogo {

    private static List<Jogador> jogadores;
    private Tabuleiro tabuleiro;

    public Jogo(){
        this.jogadores = new ArrayList<>();
        this.tabuleiro = new Tabuleiro();
    }

    public void adicionarJogador(){

        if(this.jogadores.size() >= 6){
            System.out.println("Limite máximo de jogadores foi atingido.");
        }

        Jogador novoJogador = null;

        System.out.println("Nome do novo jogador: ");
        String nome = Utilitarios.stringValida();

        Cor corNovoJogador = null;

        List<Cor> coresDisponiveis = new ArrayList<>();

        for(Jogador jogador : Jogo.jogadores){

            for(Cor cor: Cor.values()){

                if(!cor.equals(jogador.getCor())){
                    coresDisponiveis.add(cor);
                }

            }
        }

        int i = 0;
        System.out.println("Escolha uma das cores disponíveis: ");
        for(Cor escolhaCor : coresDisponiveis){
            System.out.println((i+1)+ " - " + escolhaCor.getTipoCor());
        }

        int escolha = Utilitarios.inteiroValido();

        while(escolha < 1 && escolha > coresDisponiveis.size()){
            System.out.println("Cor indisponível. Insira novamente: ");
            escolha = Utilitarios.inteiroValido();
        }

        corNovoJogador = coresDisponiveis.get(i);

        

    }
    
}
