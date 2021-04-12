package futebolha;

public class Bola {

    private final char simboloBola = '@';
    private int linha;
    private int coluna;

    public Bola() {
    }

    public Bola(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public char getSimboloBola() {
        return simboloBola;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

}
