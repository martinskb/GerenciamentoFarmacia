import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaListaVendas extends JFrame {

    public TelaListaVendas(Farmacia farmacia) {

        setTitle("Lista de Vendas");
        setSize(600, 400);
        setLocationRelativeTo(null);

        String[] colunas = {"Cliente", "Itens", "Total"};

        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (Venda v : farmacia.getVendas()) {

            StringBuilder itensTxt = new StringBuilder();

            for (ItemVenda item : v.getItens()) {
                itensTxt.append(item.getProduto().getNome())
                        .append(" (x")
                        .append(item.getQuantidade())
                        .append("), ");
            }


            if (itensTxt.length() > 0) {
                itensTxt.delete(itensTxt.length() - 2, itensTxt.length());
            }

            model.addRow(new Object[]{
                    v.getCliente().getNome(),
                    itensTxt.toString(),
                    "R$ " + v.getTotal()
            });
        }

        JTable tabela = new JTable(model);
        JScrollPane scroll = new JScrollPane(tabela);

        add(scroll);
    }
}
