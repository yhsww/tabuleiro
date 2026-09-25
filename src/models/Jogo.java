import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import src.util.Utilitarios;

public class Jogo {

    private static List<Jogador> jogadores;
    private Tabuleiro tabuleiro;
    private int rodada;
    private boolean modoDebug;

    public Jogo(boolean modoDebug){
        Jogo.jogadores = new ArrayList<>();
        this.tabuleiro = new Tabuleiro();
        this.tabuleiro.criarTabuleiro();
        this.modoDebug = modoDebug;
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

        List<Cor> coresDisponiveis = new ArrayList<>(List.of(Cor.values()));

        for(Jogador jogador: jogadores){
            coresDisponiveis.remove(jogador.getCor());
        }

        int i = 1;
        
        for(Cor escolhaCor : coresDisponiveis){
            System.out.println(i  + " - " + escolhaCor.getTipoCor());
            i++;
        }

        if(coresDisponiveis.isEmpty()){
            System.out.println("Não há mais cores disponíveis!");
            return;
        }

        System.out.println("Escolha uma das cores disponíveis: ");
        int escolha = Utilitarios.inteiroValido();

        while(escolha < 1 || escolha > coresDisponiveis.size()){
            System.out.println("Cor indisponível. Insira novamente: ");
            escolha = Utilitarios.inteiroValido();
        }

        corNovoJogador = coresDisponiveis.get(escolha-1);

      //1 - azarado, 2 - sortudo, 3 - normal

        int numTipoJogador = ThreadLocalRandom.current().nextInt(1, 4);

        if(numTipoJogador == 1){
            novoJogador = new JogadorAzarado(nome, corNovoJogador);
            System.out.println("Tipo de jogador: azarado");
        }else if(numTipoJogador == 2){
                novoJogador = new JogadorSortudo(nome, corNovoJogador);
                System.out.println("Tipo de jogador: sortudo");
            }else{
                    novoJogador = new JogadorNormal(nome, corNovoJogador);
                    System.out.println("Tipo de jogador: normal");
                }

        Jogo.jogadores.add(novoJogador);

        System.out.println(novoJogador.getNome() + " - " + novoJogador.getCor().getTipoCor() + " adicionado(a) com sucesso!");

        }
        
    public void iniciarRodada(){

        boolean partidaAutorizada = autorizarPartida();

        if(!partidaAutorizada){
            return;
        }

        if(Jogo.jogadores.stream().anyMatch(jogador -> jogador.getPosicao() >= 40)){

            System.out.println("------- FIM DE JOGO -------");
            System.out.println("Total de rodadas: " + this.rodada);

            List<Jogador> ordemJogadores = Jogo.jogadores.stream().sorted(Comparator.comparing(Jogador::getPosicao).reversed()).toList();
            Jogador vencedor = ordemJogadores.get(0);

           int i = 1;
            for(Jogador jogador : ordemJogadores){

                System.out.println(i + "ª lugar | Nome: " + jogador.getNome() + " | Cor: " + jogador.getCor() + " | Quantidade de rodadas:" + jogador.getQtdRodadas());
                i++;
            }

            System.out.println("Parabéns pela vitória, " + vencedor.getNome() + "!");
            return;

        }

        this.rodada += 1;

        System.out.println("----- RODADA n." + this.rodada + " -----");
        System.out.println("Jogadores");

        for(Jogador jogador: Jogo.jogadores){
            System.out.println("-------------");
            System.out.println(jogador.toString());
        }

        System.out.println();

        for (Jogador jogador : Jogo.jogadores) {

            if(!jogador.getPulaRodada()){
                System.out.println();

                System.out.println("Jogador da vez: ");
                System.out.println(jogador.getNome() + " - " + jogador.getCor().getTipoCor() + " - Posição atual: " + jogador.getPosicao());

                boolean novaRodada = false;

                if(modoDebug){

                    System.out.println("Insira a casa para a qual o jogador será movido: ");
                    int numCasa = Utilitarios.inteiroValido();

                    while(numCasa < 1 || numCasa > Tabuleiro.TOTAL_CASAS){
                        System.out.println("Posição inválida. Insira novamente: ");
                        numCasa = Utilitarios.inteiroValido();
                    }

                    jogador.setPosicao(numCasa);
                    novaRodada = false;

                }else{
                     novaRodada = jogador.jogarDados();
                }

                    int posicao = Math.max(0, Math.min(jogador.getPosicao()-1, Tabuleiro.TOTAL_CASAS-1));
                    Casa casa = Tabuleiro.casasTabuleiro.get(posicao);

                        if(casa instanceof CasaMagica casaMagica){

                            casaMagica.aplicarEfeito(jogador, Jogo.jogadores);
                            jogador.setQtdRodadas(jogador.getQtdRodadas() + 1);

                            }else if(casa instanceof CasaPularRodada casaPularRodada){

                                casaPularRodada.aplicarEfeito(jogador, Jogo.jogadores);

                                }else if(casa instanceof CasaDaDiscordia casaDaDiscordia){

                                        casaDaDiscordia.aplicarEfeito(jogador, jogadores);
                                        jogador.setQtdRodadas(jogador.getQtdRodadas() + 1);

                                    }else{     
                                        casa.aplicarEfeito(jogador, Jogo.jogadores);
                                        jogador.setQtdRodadas(jogador.getQtdRodadas() + 1);
                        

                                        }

                    while(novaRodada){
                        System.out.println(jogador.getNome() + " joga novamente");
                        novaRodada = jogador.jogarDados();
                    }


            }else{
                                        
                System.out.println(jogador.getNome() + " só poderá jogar na próxima rodada!");
                jogador.setPulaRodada(false);

            }
              
        }
               
        
    }

    public boolean autorizarPartida(){

        if(Jogo.jogadores.size() < 2){
            System.out.println("Quantidade insuficiente de jogadores!");
            return false;
        }

        long qtdTiposJogadores = Jogo.jogadores.stream().map(Jogador::getClass).distinct().count();

        if(qtdTiposJogadores < 2){
            System.out.println("O jogo deve ter pelo menos 2 tipos de jogadores distintos!");
            return false;
        }

        if(Jogo.jogadores.size() >= 5 && qtdTiposJogadores == 0){

            Jogador ultimo = Jogo.jogadores.getLast();
            Jogador novoJogador;
            
            if(ultimo instanceof JogadorAzarado){
                novoJogador = new JogadorNormal(ultimo.getNome(), ultimo.getCor());
            }else if(ultimo instanceof JogadorSortudo){
                novoJogador = new JogadorNormal(ultimo.getNome(), ultimo.getCor());
            }else{
                novoJogador = new JogadorAzarado(ultimo.getNome(), ultimo.getCor());
            }

            System.out.println(ultimo.getNome() + " teve tipo alterado!");
        }

        return true;
    }
}

    

