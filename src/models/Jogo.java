import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import src.util.Utilitarios;

public class Jogo {

    private static List<Jogador> jogadores;
    private Tabuleiro tabuleiro;
    private int rodada;

    public Jogo(){
        Jogo.jogadores = new ArrayList<>();
        this.tabuleiro = new Tabuleiro();
        this.tabuleiro.criarTabuleiro();
        this.rodada = 0;
    }

    public void adicionarJogador(){

        if(Jogo.jogadores.size() >= 6){
            System.out.println("Limite máximo de jogadores foi atingido.");
            return;
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
            System.out.println((i+1) + " - " + escolhaCor.getTipoCor());
        }

        int escolha = Utilitarios.inteiroValido();

        while(escolha < 1 && escolha > coresDisponiveis.size()){
            System.out.println("Cor indisponível. Insira novamente: ");
            escolha = Utilitarios.inteiroValido();
        }

        corNovoJogador = coresDisponiveis.get(i);

      //1 - azarado, 2 - sortudo, 3 - normal

        int numTipoJogador = ThreadLocalRandom.current().nextInt(1, 3);

        if(numTipoJogador == 1){
            novoJogador = new JogadorAzarado(nome, corNovoJogador);
            System.out.println("Tipo de jogador: azarado");
        }

        if(numTipoJogador == 2){
            novoJogador = new JogadorSortudo(nome, corNovoJogador);
            System.out.println("Tipo de jogador: sortudo");
        }

        if(numTipoJogador == 3){
            novoJogador = new JogadorNormal(nome, corNovoJogador);
            System.out.println("Tipo de jogador: normal");
        }

        Jogo.jogadores.add(novoJogador);

        System.out.println("Jogador " + novoJogador.getNome() + " - " + novoJogador.getCor().getTipoCor() + " adicionado(a) com sucesso!");

        }
        
    public void iniciarRodada(){

        if(Jogo.jogadores.stream().anyMatch(jogador -> jogador.getPosicao() >= 40)){

            System.out.println("------- FIM DE JOGO -------");
            System.out.println("Total de rodadas: " + this.rodada);

            List<Jogador> ordemJogadores = Jogo.jogadores.stream().sorted(Comparator.comparing(Jogador::getPosicao).reversed()).toList();
            Jogador vencedor = ordemJogadores.get(0);

           int i = 1;
            for(Jogador jogador : ordemJogadores){
                System.out.println(i + "ª lugar | Nome: " + jogador.getNome() + " | Cor: " + jogador.getCor() + " | Quantidade de rodadas:" + jogador.getQtdRodadas());
            }

            System.out.println("Vencedor: " + vencedor.getNome());
            return;

        }

        this.rodada += 1;

        boolean novaRodada = false;

        System.out.println("----- RODADA " + this.rodada + " -----");
        for (Jogador jogador : Jogo.jogadores) {

            System.out.println("Jogador da vez: ");
            System.out.println(jogador.getNome() + " - " + jogador.getCor().getTipoCor() + " - Posição: " + jogador.getPosicao());

            novaRodada = jogador.jogarDados();

            while(novaRodada){
                System.out.println(jogador.getNome() + " joga novamente");
                jogador.jogarDados();
            }

            for(Casa casa: Tabuleiro.casasTabuleiro){

                if(casa instanceof CasaMagica casaMagica){
                    casaMagica.aplicarEfeito(jogador, Jogo.jogadores);
                    jogador.qtdRodadas += 1;
                }else if(casa instanceof CasaPularRodada casaPularRodada){
                        casaPularRodada.aplicarEfeito(jogador);

                    }else{
                        casa.aplicarEfeito(jogador);
                        jogador.qtdRodadas += 1;
                    }
            }
            
        }



    }


}
    

