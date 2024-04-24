package caixa;

public interface Hardware {
    public String pegarNumeroDaContaCartao(String numeroCartao);
    public void entregarDinheiro();
    public void lerEnvelope(double valor);

}
