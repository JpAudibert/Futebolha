package futebolha;

public class Bola {

    private final char simboloBola = '@';
    private int posicaoTabuleiroLinha;
    private int posicaoTabuleiroColuna;

    public Bola() {
    }
    
    public Bola(int posicaoTabuleiroLinha, int posicaoTabuleiroColuna) {
        this.posicaoTabuleiroLinha = posicaoTabuleiroLinha;
        this.posicaoTabuleiroColuna = posicaoTabuleiroColuna;
    }

    public char getSimboloBola() {
        return simboloBola;
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

//    public static int getColunaBola() {
//        int pos = -1;
//        for (int i = 0; i < MAX_COLUNA; i++) {
//            for (int j = 0; j < MAX_LINHA; j++) {
//                if (campo[i][j] == SIMBOLO_BOLA) {
//                    pos = j;
//                    return pos;
//                }
//            }
//        }
//        return pos;
//    }
//
//    public static int getLinhaBola() {
//        int pos = -1;
//        for (int i = 0; i < MAX_LINHA; i++) {
//            for (int j = 0; j < MAX_COLUNA; j++) {
//                if (campo[i][j] == SIMBOLO_BOLA) {
//                    pos = i;
//                    return pos;
//                }
//            }
//        }
//        return pos;
//    }
}
