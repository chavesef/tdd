package mock;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TesteCarrinhoCompras {
    CarrinhoCompras c;

    @Before
    public void setUp() {
        c = new CarrinhoCompras();
    }

    @Test
    public void totalCarrinho(){
        c.adicionaProduto(new Produto("tenis", 100));
        c.adicionaProduto(new Produto("camiseta", 50));
        c.adicionaProduto(new Produto("bermuda", 70));
        assertEquals(220, c.total());
    }

    @Test
    public void escutaAdicaoDeProduto(){
        MockObservadorCarrinho mock = new MockObservadorCarrinho();
        c.adicionarObservador(mock);
        c.adicionaProduto(new Produto("tenis", 100));
        mock.verificaRecebimentoProduto("tenis", 100);
    }

    @Test
    public void adicionarDoisObservadores(){
        MockObservadorCarrinho mock1 = new MockObservadorCarrinho();
        MockObservadorCarrinho mock2 = new MockObservadorCarrinho();
        c.adicionarObservador(mock1);
        c.adicionarObservador(mock2);
        c.adicionaProduto(new Produto("tenis", 100));
        mock1.verificaRecebimentoProduto("tenis", 100);
        mock2.verificaRecebimentoProduto("tenis", 100);
    }

    @Test
    public void continuaComErroEmObservador(){
        MockObservadorCarrinho mock1 = new MockObservadorCarrinho();
        MockObservadorCarrinho mock2 = new MockObservadorCarrinho();
        mock2.queroQueVoceDePau();
        MockObservadorCarrinho mock3 = new MockObservadorCarrinho();
        c.adicionarObservador(mock1);
        c.adicionarObservador(mock2);
        c.adicionarObservador(mock3);
        c.adicionaProduto(new Produto("tenis", 100));
        mock1.verificaRecebimentoProduto("tenis", 100);
        mock3.verificaRecebimentoProduto("tenis", 100);
    }
}
