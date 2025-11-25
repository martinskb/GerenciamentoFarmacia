import javax.swing.*;
import java.awt.*;

public class TelaCadastroCliente extends JFrame {

    public TelaCadastroCliente(Farmacia farmacia) {
        setTitle("Cadastrar Cliente");
        setSize(300, 200);
        setLocationRelativeTo(null);

        JLabel lblId = new JLabel("ID:");
        JLabel lblNome = new JLabel("Nome:");
        JLabel lblCpf = new JLabel("CPF:");
        JLabel lblTipo = new JLabel("Tipo:");

        JTextField txtId = new JTextField();
        JTextField txtNome = new JTextField();
        JTextField txtCpf = new JTextField();

        String[] tipos = {"Normal", "Fidelidade"};
        JComboBox<String> cbTipo = new JComboBox<>(tipos);

        JButton btnSalvar = new JButton("Salvar");

        btnSalvar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                String nome = txtNome.getText();
                String cpf = txtCpf.getText();

                Cliente c;

                if (cbTipo.getSelectedItem().equals("Fidelidade")) {
                    c = new ClienteFidelidade(id, nome, cpf);
                } else {
                    c = new Cliente(id, nome, cpf);
                }

                farmacia.adicionarCliente(c);
                JOptionPane.showMessageDialog(null, "Cliente cadastrado!");
                dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            }
        });

        setLayout(new GridLayout(5, 2));
        add(lblId); add(txtId);
        add(lblNome); add(txtNome);
        add(lblCpf); add(txtCpf);
        add(lblTipo); add(cbTipo);
        add(btnSalvar);
    }
}
