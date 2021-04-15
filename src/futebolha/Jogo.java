package futebolha;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Jogo {

    private int numeroLinhas = 20;
    private int numeroColunas = 50;
    private int numeroTimes = 2;
    private int numeroJogadores = 1;
    private char[][] campo;
    private boolean acabou = false;

    private final char ESPACO_LIVRE = '.';
    private final char LINHA_PONTUACAO = '=';
    private final char BOLA = '@';
    private char TIME_1 = 'A';
    private char TIME_2 = 'a';
    private int tempoPausa = 2000;

    private final int PORTA = 1342;
    private byte[] buffer = new byte[1024];
    private DatagramSocket socket;
    private DatagramPacket packet;

    public Jogo(int numeroLinhas, int numeroColunas, int numeroTimes, int numeroJogadores, int tempoPausa) {
        this.numeroLinhas = numeroLinhas;
        this.numeroColunas = numeroColunas;
        this.numeroTimes = numeroTimes;
        this.numeroJogadores = numeroJogadores;
        this.tempoPausa = tempoPausa;
    }

    public int getNumeroLinhas() {
        return numeroLinhas;
    }

    public int getNumeroColunas() {
        return numeroColunas;
    }

    public int getNumeroJogadores() {
        return numeroJogadores;
    }

    public int getTempoPausa() {
        return tempoPausa;
    }

    public char getEspacoLivre() {
        return ESPACO_LIVRE;
    }

    public int getNumeroTimes() {
        return numeroTimes;
    }

    public char[][] getCampo() {
        return campo;
    }

    public void setCampo(char[][] campo) {
        this.campo = campo;
    }

    public void setAcabou(boolean acabou) {
        this.acabou = acabou;
    }

    public boolean getAcabou() {
        return this.acabou;
    }

    public void limpaTela() {
        for (int i = 0; i < 25; i++) {
            System.out.println("");
        }
    }

    public char[][] criaCampo() {
        char[][] campo = new char[numeroLinhas][numeroColunas];

        for (int i = 0; i < numeroLinhas; i++) {
            for (int j = 0; j < numeroColunas; j++) {
                campo[i][j] = ESPACO_LIVRE;
            }
        }

        return campo;
    }

    public char[][] inicializaJogo() {
        char vetPos[] = {'A', 'a'};
        char[][] campo = criaCampo();

        for (int p = 0; p < numeroTimes; p++) {
            for (int i = 0; i < numeroJogadores; i++) {  // time 1                
                char indentificacaoPlayer = (char) (vetPos[p] + i);

                int posicaoJogadorLinha = -1;
                int posicaoJogadorColuna = -1;
                do {
                    posicaoJogadorLinha = (int) (Math.random() * numeroLinhas);
                    posicaoJogadorColuna = (int) (Math.random() * numeroColunas);

                } while (campo[posicaoJogadorLinha][posicaoJogadorColuna] != ESPACO_LIVRE);
                Player player = new Player(indentificacaoPlayer, posicaoJogadorLinha, posicaoJogadorColuna);
                campo[player.getLinha()][player.getColuna()] = player.getIdentificao();
            }
        }

        int posicaoBolaLinha = -1;
        int posicaoBolaColuna = -1;
        do {
            posicaoBolaLinha = (int) (Math.random() * numeroLinhas);
            posicaoBolaColuna = (int) (Math.random() * numeroColunas);

        } while (campo[posicaoBolaLinha][posicaoBolaColuna] != ESPACO_LIVRE);
        Bola bola = new Bola(posicaoBolaLinha, posicaoBolaColuna);
        campo[bola.getLinha()][bola.getColuna()] = bola.getSimboloBola();

        return campo;
    }

    public void mostraCampo(boolean newGame) {
        limpaTela();

        if (newGame) {
            this.setCampo(inicializaJogo());
        } else {
            char[][] campo = this.getCampo();
        }

        for (int i = 0; i < numeroColunas; i++) {
            System.out.print(TIME_1); // linha de pontuação
        }
        for (int i = 0; i < numeroLinhas; i++) {
            System.out.println();
            for (int j = 0; j < numeroColunas; j++) {
                System.out.print(campo[i][j]);
            }
        }

        System.out.println();
        for (int i = 0; i < numeroColunas; i++) {
            System.out.print(TIME_2); // linha de pontuação
        }

        try {
            Thread.sleep(tempoPausa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Player getPlayer(char identificacao) {
        int linha, coluna;

        Player player = new Player();
        for (int i = 0; i < numeroLinhas; i++) {
            for (int j = 0; j < numeroColunas; j++) {
                if (campo[i][j] == identificacao) {
                    linha = i;
                    coluna = j;
                    player.setIdentificao(identificacao);
                    player.setLinha(linha);
                    player.setColuna(coluna);
                }
            }
        }
        return player;
    }

    public Bola getBola() {
        int linha, coluna;

        Bola bola = new Bola();
        for (int i = 0; i < numeroLinhas; i++) {
            for (int j = 0; j < numeroColunas; j++) {
                if (campo[i][j] == BOLA) {
                    linha = i;
                    coluna = j;
                    bola.setLinha(linha);
                    bola.setColuna(coluna);
                }
            }
        }
        return bola;
    }

    public void movePlayer(char player, char movimento) {
        //TODO IMPLEMENTAR MOVIMENTACAO
        // player, simbolo valido dos jogadores no campo
        // movimentos:
        //         w ou W --> para cima
        //         x ou X --> para baixo
        //         a ou A --> para esquerda
        //         d ou D --> para direita
        //         sempre que for para cima da bola ela vai para o mesmo lado do
        //         movimento, no caso da latera, atravessa e começa no outro lado
        //         sempre que chegar a um extremo, time inverso ganha.

        Player playerToBeMoved = getPlayer(player);
        Bola bola = getBola();

        char movementDone = String.valueOf(movimento).toLowerCase().charAt(0);

        switch (movementDone) {
            case 'w':
                ballMovement(bola.getLinha(), bola.getColuna(), bola.getLinha() - 1, bola.getColuna(), playerToBeMoved.getLinha() - 1, playerToBeMoved.getColuna());

                if (playerToBeMoved.getLinha() > 0) {
                    playerMovement(playerToBeMoved.getLinha(), playerToBeMoved.getColuna(), playerToBeMoved.getLinha() - 1, playerToBeMoved.getColuna());
                }
                break;
            case 'a':
                if (bola.getColuna() == 0) {
                    campo[bola.getLinha()][numeroColunas - 1] = bola.getSimboloBola();
                    campo[bola.getLinha()][0] = ESPACO_LIVRE;
                } else {
                    ballMovement(bola.getLinha(), bola.getColuna(), bola.getLinha(), bola.getColuna() - 1, playerToBeMoved.getLinha(), playerToBeMoved.getColuna() - 1);
                }

                if (playerToBeMoved.getColuna() == 0) {
                    playerMovement(playerToBeMoved.getLinha(), playerToBeMoved.getColuna(), playerToBeMoved.getLinha(), numeroColunas - 1);
                } else {
                    playerMovement(playerToBeMoved.getLinha(), playerToBeMoved.getColuna(), playerToBeMoved.getLinha(), playerToBeMoved.getColuna() - 1);
                }
                break;
            case 's':
                ballMovement(bola.getLinha(), bola.getColuna(), bola.getLinha() + 1, bola.getColuna(), playerToBeMoved.getLinha() + 1, playerToBeMoved.getColuna());

                if (playerToBeMoved.getLinha() != numeroLinhas) {
                    playerMovement(playerToBeMoved.getLinha(), playerToBeMoved.getColuna(), playerToBeMoved.getLinha() + 1, playerToBeMoved.getColuna());
                }
                break;
            case 'd':
                if (bola.getColuna() == numeroColunas) {
                    campo[bola.getLinha()][0] = bola.getSimboloBola();
                    campo[bola.getLinha()][numeroColunas - 1] = ESPACO_LIVRE;
                } else {
                    ballMovement(bola.getLinha(), bola.getColuna(), bola.getLinha(), bola.getColuna() - 1, playerToBeMoved.getLinha(), playerToBeMoved.getColuna() - 1);
                }

                if (playerToBeMoved.getColuna() == numeroColunas) {
                    playerMovement(playerToBeMoved.getLinha(), playerToBeMoved.getColuna(), playerToBeMoved.getLinha(), 0);
                } else {
                    playerMovement(playerToBeMoved.getLinha(), playerToBeMoved.getColuna(), playerToBeMoved.getLinha(), playerToBeMoved.getColuna() - 1);
                }
                break;
        }

        // aqui será recebida um pacote UDP com a movimentação de determinado jogador
    }

    public void ballMovement(int currentBallLine, int currentBallColumn, int ballDestinyLine, int ballDestinyColumn, int playerDestinyLine, int playerDestinyColumn) {
        if (isSamePosition(currentBallLine, currentBallColumn, playerDestinyLine, playerDestinyColumn)) {
            if (ballDestinyLine == -1) {
                System.out.println("Time " + TIME_2 + " venceu!!");
                setAcabou(true);
            } else if (ballDestinyLine == getNumeroLinhas()) {
                System.out.println("Time " + TIME_1 + " venceu!!");
                setAcabou(true);
            } else {
                if (this.campo[ballDestinyLine][ballDestinyColumn] == ESPACO_LIVRE) {
                    this.campo[ballDestinyLine][ballDestinyColumn] = campo[currentBallLine][currentBallColumn];
                    this.campo[currentBallLine][currentBallColumn] = ESPACO_LIVRE;
                }
            }
        }
    }

    public void playerMovement(int currentPlayerLine, int currentPlayerColumn, int playerDestinyLine, int playerDestinyColumn) {
        if (this.campo[playerDestinyLine][playerDestinyColumn] == ESPACO_LIVRE) {
            this.campo[playerDestinyLine][playerDestinyColumn] = campo[currentPlayerLine][currentPlayerColumn];
            this.campo[currentPlayerLine][currentPlayerColumn] = ESPACO_LIVRE;
        }
    }

    public boolean isSamePosition(int currentBallLine, int currentBallColumn, int playerDestinyLine, int playerDestinyColumn) {
        return playerDestinyLine == currentBallLine && playerDestinyColumn == currentBallColumn;
    }

    public boolean waitForMovement() {
        try {                   
            socket.receive(packet);

            String message = new String(buffer, 0, packet.getLength());
            
            if (message.startsWith("play(") && message.endsWith(");")) {
                char player = getPlayerOrMoveFromMessage(message, 0);
                char movement = getPlayerOrMoveFromMessage(message, 1);

                movePlayer(player, movement);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public char getPlayerOrMoveFromMessage(String message, int position) {
        String messageReceived;
        char toBeReturned;

        messageReceived = message.split(",")[position];

        toBeReturned = position == 0 ? messageReceived.charAt(messageReceived.length() - 1) : messageReceived.charAt(0);

        return toBeReturned;

    }
}
