import java.util.ArrayList;
import java.util.List;

public class Venda {
    private Cliente cliente;
    private List<ItemVenda> itens;
    private double total;

    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.total = 0;
    }

    public void adicionarItem(Produto produto, int qtd) {
        if (produto.removerEstoque(qtd)) {
            itens.add(new ItemVenda(produto, qtd));
        }
    }

    public double calcularTotal() {
        total = 0;

        for (ItemVenda item : itens) {
            total += item.calcularTotal();
        }

        if (cliente instanceof Desconto d) {
            total = d.aplicarDesconto(total);
        }

        return total;
    }

    public Cliente getCliente() { return cliente; }
    public List<ItemVenda> getItens() { return itens; }
    public double getTotal() { return total; }
}
