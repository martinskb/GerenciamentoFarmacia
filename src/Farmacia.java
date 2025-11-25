import java.util.ArrayList;
import java.util.List;

public class Farmacia {
    private List<Produto> produtos;
    private List<Cliente> clientes;
    private List<Venda> vendas;

    public Farmacia() {
        produtos = new ArrayList<>();
        clientes = new ArrayList<>();
        vendas = new ArrayList<>();
    }

    public void adicionarProduto(Produto p) {
        produtos.add(p);
    }

    public void adicionarCliente(Cliente c) {
        clientes.add(c);
    }

    public Produto buscarProduto(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public Cliente buscarCliente(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public void registrarVenda(Venda v) {
        vendas.add(v);
    }

    public List<Produto> getProdutos() { return produtos; }
    public List<Cliente> getClientes() { return clientes; }
    public List<Venda> getVendas() { return vendas; }
}
