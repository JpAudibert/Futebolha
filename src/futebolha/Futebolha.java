package futebolha;

public class Futebolha {

    private static final int TEMPO_PAUSA = 500;
    private static final int NUMERO_LINHA = 20;
    private static final int NUMERO_COLUNA = 50;
    private static final int NUMERO_TIMES = 2;
    private static final int NUMERO_PLAYERS = 4;

    public static void main(String[] args) {
        boolean newGame = true;
        Jogo jogo = new Jogo(NUMERO_LINHA, NUMERO_COLUNA, NUMERO_TIMES, NUMERO_PLAYERS, TEMPO_PAUSA);
        Client client = new Client();

        jogo.mostraCampo(newGame);
        newGame = false;
        System.out.println("");
        System.out.println("Próxima Jogada");

        while (!jogo.getAcabou()) {
            jogo.mostraCampo(newGame);

            System.out.println("");
            client.scanMovement();

            if (jogo.waitForMovement(client.getPacket(), client.getSocket())) {
                System.out.println("Jogada Executada");
            }
        }
    }
}
