package futebolha;

public class Jogo {

    private int numeroLinhas = 20;
    private int numeroColunas = 50;
    private int numeroTimes = 2;
    private int numeroJogadores = 1;
    private int tempoPausa = 500;
    private char[][] campo;

    private final char ESPACO_LIVRE = '.';
    private final char LINHA_PONTUACAO = '=';
    private final char BOLA = '@';

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
    
    public void setCampo(char[][] campo){
        this.campo = campo;
    }

    private void limpaTela() {
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
                campo[player.getPosicaoTabuleiroLinha()][player.getPosicaoTabuleiroColuna()] = player.getIdentificao();
            }
        }

        int posicaoBolaLinha = -1;
        int posicaoBolaColuna = -1;
        do {
            posicaoBolaLinha = (int) (Math.random() * numeroLinhas);
            posicaoBolaColuna = (int) (Math.random() * numeroColunas);

        } while (campo[posicaoBolaLinha][posicaoBolaColuna] != ESPACO_LIVRE);
        Bola bola = new Bola(posicaoBolaLinha, posicaoBolaColuna);
        campo[bola.getPosicaoTabuleiroLinha()][bola.getPosicaoTabuleiroColuna()] = bola.getSimboloBola();

        return campo;
    }

    public void mostraCampo() {
        limpaTela();
        this.setCampo(inicializaJogo());

        for (int i = 0; i < numeroColunas; i++) {
            System.out.print(LINHA_PONTUACAO); // linha de pontuação
        }
        for (int i = 0; i < numeroLinhas; i++) {
            System.out.println();
            for (int j = 0; j < numeroColunas; j++) {
                System.out.print(campo[i][j]);
            }
        }

        System.out.println();
        for (int i = 0; i < numeroColunas; i++) {
            System.out.print(LINHA_PONTUACAO); // linha de pontuação
        }

        try {
            Thread.sleep(tempoPausa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Player getPlayer(char identificacao) {
        int linha = -1;
        int coluna = -1;
        Player player = new Player();
        for (int i = 0; i < numeroLinhas; i++) {
            for (int j = 0; j < numeroColunas; j++) {
                if (campo[i][j] == identificacao) {
                    linha = i;
                    coluna = j;
                    player.setIdentificao(identificacao);
                    player.setPosicaoTabuleiroLinha(linha);
                    player.setPosicaoTabuleiroColuna(coluna);
                }
            }
        }
        return player;
    }

    public Bola getBola() {
        int linha = -1;
        int coluna = -1;
        Bola bola = new Bola();
        for (int i = 0; i < numeroLinhas; i++) {
            for (int j = 0; j < numeroColunas; j++) {
                if (campo[i][j] == BOLA) {
                    linha = i;
                    coluna = j;
                    bola.setPosicaoTabuleiroLinha(linha);
                    bola.setPosicaoTabuleiroColuna(coluna);
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

        // aqui será recebida um pacote UDP com a movimentação de determinado jogador
    }
}
