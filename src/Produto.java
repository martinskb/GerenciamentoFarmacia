public class Produto {
    private int id;
    private String nome;
    private double preco;
    private int estoque;

    public Produto(int id, String nome, double preco, int estoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public void adicionarEstoque(int quantidade) {
        this.estoque += quantidade;
    }

    public boolean removerEstoque(int quantidade) {
        if (quantidade <= estoque) {
            estoque -= quantidade;
            return true;
        }
        return false;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getEstoque() { return estoque; }

    public void setNome(String nome) { this.nome = nome; }
    public void setPreco(double preco) { this.preco = preco; }
}
