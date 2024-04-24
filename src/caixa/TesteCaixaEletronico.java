package caixa;

import org.junit.Before;
import org.junit.Test;

import java.security.PublicKey;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TesteCaixaEletronico {
    CaixaEletronico c;
    @Before
    public void setUp() throws Exception {
        c = new CaixaEletronico();
    }
    @Test
    public void saldoInicial(){
        assertEquals("O saldo é R$0,00", c.saldo());
    }

    @Test
    public void saldoAtualizado(){
        c.deposito(1228.90);
        assertEquals("O saldo é R$1.228,90", c.saldo());
    }

    @Test
    public void deposito(){
        assertEquals("Depósito recebido com sucesso",c.deposito(179.89));
    }

    @Test
    public void saque(){
        c.deposito(189.90);
        assertEquals("Retire seu dinheiro", c.saque(109.12));
        assertEquals("Saldo insuficiente", c.saque(109.12));
    }

    @Test
    public void login(){
        MockHardware mock = new MockHardware();
        c.adicionarObservador(mock);
        mock.adicionaConta("123123123", "40812-1");
        assertEquals("Usuário Autenticado",
                c.logar("123123123", "40812-1"));
    }

    @Test
    public void falhaLogin(){
        MockHardware mock = new MockHardware();
        c.adicionarObservador(mock);
        mock.adicionaConta("123123123", "40812-1");
        assertEquals("Não foi possível autenticar o usuário",
                c.logar("123123123", "12331-1"));
    }

    @Test
    public void falhaDeposito(){
       assertEquals("Depósito não efetuado", c.deposito(-12.0));
    }

    @Test
    public void falhaBuscaConta(){
        MockHardware mock = new MockHardware();
        mock.setFalha(true);
        c.adicionarObservador(mock);
        mock.adicionaConta("123123123", "40812-1");
        try{
            c.logar("123123123", "12331-1");
            fail();
        }catch (Exception e){

        }
    }

    @Test
    public void contaNaoCadastrada(){
        MockHardware mock = new MockHardware();
        c.adicionarObservador(mock);
        mock.adicionaConta("123123123", "40812-1");
        c.logar("123123123", "143412-1");
    }

    @Test
    public void falhaEntregaDinheiro(){
        MockHardware mock = new MockHardware();
        c.deposito(121.0);
        mock.setFalha(true);
        c.adicionarObservador(mock);
        assertEquals("Saque não efetuado", c.saque(101.92));
    }
}
