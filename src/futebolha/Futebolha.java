package futebolha;

public class Futebolha {

    private static final int TEMPO_PAUSA = 500;
    private static final int NUMERO_LINHA = 20;
    private static final int NUMERO_COLUNA = 50;
    private static final int NUMERO_TIMES = 2;
    private static final int NUMERO_PLAYERS = 4;

    private static char players[] = new char[30];

    public static void main(String[] args) {
        
        Jogo jogo = new Jogo(NUMERO_LINHA, NUMERO_COLUNA, NUMERO_TIMES, NUMERO_PLAYERS, TEMPO_PAUSA);
        
        //while (true) {
        jogo.mostraCampo();
        System.out.println();
        
        Player player = jogo.getPlayer('A');
        Bola bola = jogo.getBola();

        System.out.println("ID: " + player.getIdentificao());
        System.out.println("Linha: " + player.getPosicaoTabuleiroLinha());
        System.out.println("Coluna: " + player.getPosicaoTabuleiroColuna());

        System.out.println("Linha Bola: " + bola.getPosicaoTabuleiroLinha());
        System.out.println("Coluna Bola: " + bola.getPosicaoTabuleiroColuna());

        //}
    }
}
