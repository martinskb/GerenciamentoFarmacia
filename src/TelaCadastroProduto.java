import javax.swing.*;
import java.awt.*;

public class TelaCadastroProduto extends JFrame {

    public TelaCadastroProduto(Farmacia farmacia) {
        setTitle("Cadastrar Produto");
        setSize(300, 300);
        setLocationRelativeTo(null);

        JLabel lblId = new JLabel("ID:");
        JLabel lblNome = new JLabel("Nome:");
        JLabel lblPreco = new JLabel("Preço:");
        JLabel lblEstoque = new JLabel("Estoque:");
        JLabel lblTipo = new JLabel("Tipo:");

        JTextField txtId = new JTextField();
        JTextField txtNome = new JTextField();
        JTextField txtPreco = new JTextField();
        JTextField txtEstoque = new JTextField();

        String[] tipos = {"Medicamento", "Produto Comum"};
        JComboBox<String> cbTipo = new JComboBox<>(tipos);

        JButton btnSalvar = new JButton("Salvar");

        btnSalvar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                String nome = txtNome.getText();
                double preco = Double.parseDouble(txtPreco.getText());
                int estoque = Integer.parseInt(txtEstoque.getText());

                Produto p;

                if (cbTipo.getSelectedItem().equals("Medicamento")) {
                    p = new Medicamento(id, nome, preco, estoque, false, "Genérico");
                } else {
                    p = new ProdutoComum(id, nome, preco, estoque);
                }

                farmacia.adicionarProduto(p);
                JOptionPane.showMessageDialog(null, "Produto cadastrado!");
                dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            }
        });

        setLayout(new GridLayout(6, 2));
        add(lblId); add(txtId);
        add(lblNome); add(txtNome);
        add(lblPreco); add(txtPreco);
        add(lblEstoque); add(txtEstoque);
        add(lblTipo); add(cbTipo);
        add(btnSalvar);
    }
}
