package caixa;

import java.util.HashMap;
import java.util.Map;

public class MockHardware implements Hardware {
    private boolean falha = false;

    private Map<String, String> contaCartao = new HashMap<String, String>();
    public Map<String, String> getContaCartao() {
        return contaCartao;
    }
    @Override
    public String pegarNumeroDaContaCartao(String numeroCartao) {
        if (falha)
            throw new RuntimeException("Falha na busca da conta");
        if(contaCartao.containsKey(numeroCartao))
            return contaCartao.get(numeroCartao);
        return "Conta não cadastrada";
    }

    public void adicionaConta(String numeroCartao, String numeroConta) {
        contaCartao.put(numeroCartao, numeroConta);
    }

    @Override
    public void entregarDinheiro() {
        if(falha)
            throw new RuntimeException("Falha na entrega do dinheiro");
    }

    @Override
    public void lerEnvelope(double valor) {
        if(valor < 0)
            throw new IllegalArgumentException("Valor invalido");
        if(falha)
            throw new RuntimeException("Falha no depósito do dinheiro");
    }

    public void setFalha(boolean falha) {
        this.falha = falha;
    }
}
