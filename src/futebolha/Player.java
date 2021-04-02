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
}
