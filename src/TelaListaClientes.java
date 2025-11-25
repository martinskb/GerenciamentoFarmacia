import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaListaClientes extends JFrame {

    public TelaListaClientes(Farmacia farmacia) {
        setTitle("Lista de Clientes");
        setSize(500, 300);
        setLocationRelativeTo(null);

        String[] colunas = {"ID", "Nome", "CPF", "Tipo"};

        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (Cliente c : farmacia.getClientes()) {
            String tipo = (c instanceof ClienteFidelidade) ? "Fidelidade" : "Normal";

            model.addRow(new Object[]{
                    c.getId(),
                    c.getNome(),
                    c.getCpf(),
                    tipo
            });
        }

        JTable tabela = new JTable(model);
        JScrollPane scroll = new JScrollPane(tabela);

        add(scroll);
    }
}
