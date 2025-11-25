public class ClienteFidelidade extends Cliente implements Desconto {
    private int pontos;

    public ClienteFidelidade(int id, String nome, String cpf) {
        super(id, nome, cpf);
        this.pontos = 0;
    }

    public void adicionarPontos(int valor) {
        pontos += valor;
    }

    public int getPontos() {
        return pontos;
    }

    @Override
    public double aplicarDesconto(double valor) {
        return valor * 0.90; // 10% de desconto
    }
}
