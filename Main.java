import src.util.Utilitarios;

public class Main {

    public static void main(String[] args) {

        System.out.println("Deseja usar o modo debug? [s/n]");
        String resp = Utilitarios.stringValida();

        Jogo jogo;

        while(!resp.equalsIgnoreCase("s") && !resp.equalsIgnoreCase("n")){
            System.out.println("Opção inválida. Insira novamente [s/n]: ");
            resp = Utilitarios.stringValida();
        }

        if(resp.equalsIgnoreCase("s")){
            jogo = new Jogo(true);
        }else{
            jogo = new Jogo(false);
        }
        

        for(;;){

            System.out.println("Opções");
            System.out.println("1 - Adicionar jogador");
            System.out.println("2 - Iniciar nova rodada");
            System.out.println("3 - Encerrar partida");
            System.out.println("Insira sua opção: ");
            int escolha = Utilitarios.inteiroValido();

            switch (escolha) {
                case 1: jogo.adicionarJogador();break;
                case 2: jogo.iniciarRodada(); break;
                case 3: System.out.println("Partida finalizada!"); return;
                default: System.out.println("Opção inválida!"); break;
            }
        }
        
    }
    
}
