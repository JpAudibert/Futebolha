package futebolha;

public class Player {

    private char identificao;
    private int posicaoTabuleiroLinha;
    private int posicaoTabuleiroColuna;

    public Player() {
    }

    public Player(char identificao, int posicaoTabuleiroLinha, int posicaoTabuleiroColuna) {
        this.identificao = identificao;
        this.posicaoTabuleiroLinha = posicaoTabuleiroLinha;
        this.posicaoTabuleiroColuna = posicaoTabuleiroColuna;
    }

    public char getIdentificao() {
        return identificao;
    }

    public void setIdentificao(char identificao) {
        this.identificao = identificao;
    }

    public int getPosicaoTabuleiroLinha() {
        return posicaoTabuleiroLinha;
    }

    public void setPosicaoTabuleiroLinha(int posicaoTabuleiroLinha) {
        this.posicaoTabuleiroLinha = posicaoTabuleiroLinha;
    }

    public int getPosicaoTabuleiroColuna() {
        return posicaoTabuleiroColuna;
    }

    public void setPosicaoTabuleiroColuna(int posicaoTabuleiroColuna) {
        this.posicaoTabuleiroColuna = posicaoTabuleiroColuna;
    }

//    public static int getLinhaPlayer(char player) {
//        int pos = -1;
//        for (int i = 0; i < MAX_COLUNA; i++) {
//            for (int j = 0; j < MAX_LINHA; j++) {
//                if (campo[i][j] == player) {
//                    pos = i;
//                    return pos;
//                }
//            }
//        }
//        return pos;
//    }
//
//    public static int getColunaPlayer(char player) {
//        int pos = -1;
//        for (int i = 0; i < MAX_LINHA; i++) {
//            for (int j = 0; j < MAX_COLUNA; j++) {
//                if (campo[i][j] == player) {
//                    pos = j;
//                    return pos;
//                }
//            }
//        }
//        return pos;
//    }
}
