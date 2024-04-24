package caixa;

public interface ServicoRemoto {
    public ContaCorrente recuperarConta(int numero);
    public void persistirConta(double valor);
}
