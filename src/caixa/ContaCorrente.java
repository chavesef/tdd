package caixa;

import java.util.HashMap;
import java.util.Map;

public class ContaCorrente implements ServicoRemoto{
    private double saldo;
    private String numeroConta;
    private String numeroCartao;

    @Override
    public ContaCorrente recuperarConta(int numero) {
        return null;
    }

    @Override
    public void persistirConta(double valor) {
        if (valor > 0){
            saldo += valor;
        }else{
            saldo += valor;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }
}
