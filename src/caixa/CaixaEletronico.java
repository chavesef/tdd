package caixa;

import mock.ObservadorCarrinho;

import java.text.DecimalFormat;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class CaixaEletronico {
    private ContaCorrente contaCorrente = new ContaCorrente();
    private Hardware hardware = new MockHardware();
    DecimalFormat formatoMoeda = new DecimalFormat("R$#,##0.00");

    public String saldo() {
        return "O saldo é " + formatoMoeda.format(contaCorrente.getSaldo());
    }

    public double getSaldo() {
        return contaCorrente.getSaldo();
    }

    public String deposito(double valor) {
        try{
            hardware.lerEnvelope(valor);
            contaCorrente.persistirConta(valor);
            return "Depósito recebido com sucesso";
        }catch (Exception e){
            return "Depósito não efetuado";
        }
    }

    public String saque(double valor) {
        if(contaCorrente.getSaldo() >= valor){
            try {
                hardware.entregarDinheiro();
                contaCorrente.persistirConta(valor*-1);
                return "Retire seu dinheiro";
            } catch (Exception e) {
                return "Saque não efetuado";
            }
        }else{
            return "Saldo insuficiente";
        }
    }

    public String logar(String numeroCartao, String numeroConta) {
        if (Objects.equals(numeroConta,
                hardware.pegarNumeroDaContaCartao(numeroCartao))){
            return "Usuário Autenticado";
        }else{
            return "Não foi possível autenticar o usuário";
        }
    }

    public void adicionarObservador(Hardware hardware) {
        this.hardware = hardware;
    }
}
