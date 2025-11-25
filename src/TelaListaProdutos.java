import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaListaProdutos extends JFrame {

    public TelaListaProdutos(Farmacia farmacia) {
        setTitle("Lista de Produtos");
        setSize(500, 300);
        setLocationRelativeTo(null);

        String[] colunas = {"ID", "Nome", "Preço", "Estoque"};

        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (Produto p : farmacia.getProdutos()) {
            model.addRow(new Object[]{
                    p.getId(),
                    p.getNome(),
                    p.getPreco(),
                    p.getEstoque()
            });
        }

        JTable tabela = new JTable(model);
        JScrollPane scroll = new JScrollPane(tabela);

        add(scroll);
    }
}
