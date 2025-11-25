public class Medicamento extends Produto {
    private boolean exigeReceita;
    private String fabricante;

    public Medicamento(int id, String nome, double preco, int estoque,
                       boolean exigeReceita, String fabricante) {
        super(id, nome, preco, estoque);
        this.exigeReceita = exigeReceita;
        this.fabricante = fabricante;
    }

    public boolean isExigeReceita() { return exigeReceita; }
    public String getFabricante() { return fabricante; }
}
