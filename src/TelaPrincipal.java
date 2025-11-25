import javax.swing.*;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal(Farmacia farmacia) {

        setTitle("Sistema de Farmácia");
        setSize(300, 400);
        setLocationRelativeTo(null);

        JButton btnCadastroProduto = new JButton("Cadastrar Produto");
        JButton btnCadastroCliente = new JButton("Cadastrar Cliente");
        JButton btnRegistrarVenda = new JButton("Registrar Venda");
        JButton btnListarProdutos = new JButton("Listar Produtos");
        JButton btnListarClientes = new JButton("Listar Clientes");
        JButton btnListarVendas = new JButton("Listar Vendas"); // NOVO BOTÃO

        // Ações dos botões
        btnCadastroProduto.addActionListener(e ->
                new TelaCadastroProduto(farmacia).setVisible(true));

        btnCadastroCliente.addActionListener(e ->
                new TelaCadastroCliente(farmacia).setVisible(true));

        btnRegistrarVenda.addActionListener(e ->
                new TelaRegistrarVenda(farmacia).setVisible(true));

        btnListarProdutos.addActionListener(e ->
                new TelaListaProdutos(farmacia).setVisible(true));

        btnListarClientes.addActionListener(e ->
                new TelaListaClientes(farmacia).setVisible(true));

        // Ação do botão de listar vendas
        btnListarVendas.addActionListener(e ->
                new TelaListaVendas(farmacia).setVisible(true));

        // Layout da tela
        setLayout(new java.awt.GridLayout(6, 1));
        add(btnCadastroProduto);
        add(btnCadastroCliente);
        add(btnRegistrarVenda);
        add(btnListarProdutos);
        add(btnListarClientes);
        add(btnListarVendas);
    }
}
