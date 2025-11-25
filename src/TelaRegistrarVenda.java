import javax.swing.*;
import java.awt.*;

public class TelaRegistrarVenda extends JFrame {

    public TelaRegistrarVenda(Farmacia farmacia) {

        setTitle("Registrar Venda");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JLabel lblCliente = new JLabel("Cliente:");
        JLabel lblProduto = new JLabel("Produto:");
        JLabel lblQuantidade = new JLabel("Quantidade:");
        JLabel lblTotal = new JLabel("Total:");

        JComboBox<String> cbCliente = new JComboBox<>();
        JComboBox<String> cbProduto = new JComboBox<>();

        for (Cliente c : farmacia.getClientes()) {
            cbCliente.addItem(c.getId() + " - " + c.getNome());
        }

        for (Produto p : farmacia.getProdutos()) {
            cbProduto.addItem(p.getId() + " - " + p.getNome());
        }

        JTextField txtQuantidade = new JTextField();
        JLabel lblValorTotal = new JLabel("R$ 0.00");

        JButton btnCalcular = new JButton("Calcular Total");
        JButton btnRegistrar = new JButton("Registrar Venda");

        btnCalcular.addActionListener(e -> {
            try {
                int indexProduto = cbProduto.getSelectedIndex();
                Produto p = farmacia.getProdutos().get(indexProduto);

                int qtd = Integer.parseInt(txtQuantidade.getText());

                if (qtd > p.getEstoque()) {
                    JOptionPane.showMessageDialog(null,
                            "Estoque insuficiente! Disponível: " + p.getEstoque());
                    return;
                }

                double total = p.getPreco() * qtd;

                int indexCliente = cbCliente.getSelectedIndex();
                Cliente c = farmacia.getClientes().get(indexCliente);


                if (c instanceof Desconto d) {
                    total = d.aplicarDesconto(total);
                }

                lblValorTotal.setText("R$ " + total);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            }
        });

        btnRegistrar.addActionListener(e -> {
            try {
                int indexCliente = cbCliente.getSelectedIndex();
                Cliente cliente = farmacia.getClientes().get(indexCliente);

                int indexProduto = cbProduto.getSelectedIndex();
                Produto produto = farmacia.getProdutos().get(indexProduto);

                int qtd = Integer.parseInt(txtQuantidade.getText());

                if (qtd > produto.getEstoque()) {
                    JOptionPane.showMessageDialog(null,
                            "Erro: estoque insuficiente! Disponível: " + produto.getEstoque());
                    return;
                }

                Venda venda = new Venda(cliente);

                venda.adicionarItem(produto, qtd);
                venda.calcularTotal();

                farmacia.registrarVenda(venda);

                JOptionPane.showMessageDialog(null, "Venda registrada com sucesso!");

                dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao registrar venda: " + ex.getMessage());
            }
        });


        setLayout(new GridLayout(6, 2));
        add(lblCliente); add(cbCliente);
        add(lblProduto); add(cbProduto);
        add(lblQuantidade); add(txtQuantidade);
        add(lblTotal); add(lblValorTotal);
        add(btnCalcular); add(btnRegistrar);
    }
}
