package futebolha;

public class Player {

    private char identificao;
    private int linha;
    private int coluna;

    public Player() {
    }

    public Player(char identificao, int linha, int coluna) {
        this.identificao = identificao;
        this.linha = linha;
        this.coluna = coluna;
    }

    public char getIdentificao() {
        return identificao;
    }

    public void setIdentificao(char identificao) {
        this.identificao = identificao;
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
