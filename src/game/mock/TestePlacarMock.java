package game.mock;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestePlacarMock {

    PlacarMock p;
    MockArmazenamento mock;
    @Before
    public void setUp() throws Exception {
        p = new PlacarMock();
        mock = new MockArmazenamento();
    }

    @Test
    public void registrarPonto() throws IOException {
        p.adicionaArmazenamento(mock);
        assertEquals("Ponto registrado com sucesso",
                p.registra("Elias", "ponto", 10));
    }

    @Test
    public void retornarPontosUsuario() throws IOException {
        p.adicionaArmazenamento(mock);
        p.registra("Elias", "ponto", 10);
        p.registra("Elias", "ponto", 15);
        p.registra("Elias", "estrela", 10);
        p.registra("Chicken Little", "energia", 20);
        p.registra("Calleri", "ponto", 30);
        mock.fechar();
        assertEquals("estrela: 10, ponto: 25",
                p.pontosUsuario("Elias"));
    }

    @Test
    public void ranking() throws IOException {
        p.adicionaArmazenamento(mock);
        p.registra("Elias", "ponto", 10);
        p.registra("Elias", "ponto", 15);
        p.registra("Elias", "estrela", 10);
        p.registra("Chicken Little", "energia", 20);
        p.registra("Calleri", "ponto", 45);
        p.registra("Chicken Little", "ponto", 50);
        mock.fechar();
        assertEquals("Chicken Little: 50, Calleri: 45, Elias: 25",
                p.ranquear("ponto"));
    }

    @Test
    public void rankingSemPonto() throws IOException {
        p.adicionaArmazenamento(mock);
        p.registra("Elias", "ponto", 10);
        p.registra("Chicken Little", "energia", 20);
        p.registra("Calleri", "ponto", 30);
        p.registra("Calleri", "ponto", 15);
        p.registra("Chicken Little", "ponto", 50);
        mock.fechar();
        assertEquals("Chicken Little: 20",
                p.ranquear("energia"));
    }
}
