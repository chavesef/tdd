package game;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestePlacar {
    Placar p;
    @Before
    public void setUp() throws Exception {
        p = new Placar();
    }
    @Test
    public void registrarPonto() throws IOException {
        Armazenamento armazenamento = new Armazenamento();
        p.adicionaArmazenamento(armazenamento);
        assertEquals("Ponto registrado com sucesso",
                p.registra("Elias", "ponto", 10));
    }

    @Test
    public void retornarPontosUsuario() throws IOException {
        Armazenamento armazenamento = new Armazenamento();
        p.adicionaArmazenamento(armazenamento);
        p.registra("Elias", "ponto", 10);
        p.registra("Elias", "ponto", 15);
        p.registra("Elias", "estrela", 10);
        p.registra("Chicken Little", "energia", 20);
        p.registra("Calleri", "ponto", 30);
        armazenamento.fechar();
        assertEquals("estrela: 10, ponto: 25",
                p.pontosUsuario("Elias"));
    }

    @Test
    public void ranking() throws IOException {
        Armazenamento armazenamento = new Armazenamento();
        p.adicionaArmazenamento(armazenamento);
        p.registra("Elias", "ponto", 10);
        p.registra("Chicken Little", "energia", 20);
        p.registra("Calleri", "ponto", 30);
        p.registra("Calleri", "ponto", 15);
        p.registra("Chicken Little", "ponto", 50);
        armazenamento.fechar();
        assertEquals("Chicken Little: 50, Calleri: 45, Elias: 10",
                p.ranquear("ponto"));
    }

    @Test
    public void rankingSemPonto() throws IOException {
        Armazenamento armazenamento = new Armazenamento();
        p.adicionaArmazenamento(armazenamento);
        p.registra("Elias", "ponto", 10);
        p.registra("Chicken Little", "energia", 20);
        p.registra("Calleri", "ponto", 30);
        p.registra("Calleri", "ponto", 15);
        p.registra("Chicken Little", "ponto", 50);
        armazenamento.fechar();
        assertEquals("Chicken Little: 20",
                p.ranquear("energia"));
    }

}
