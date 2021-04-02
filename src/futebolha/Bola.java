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
}
