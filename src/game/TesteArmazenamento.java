package game;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TesteArmazenamento {
    Armazenamento a;

    @Before
    public void setUp() throws Exception {
        a = new Armazenamento();
    }

    @Test
    public void armazenaUsuario() throws IOException {
        assertEquals("Armazenamento realizado com sucesso",
                a.armazena("usuário", "tipo", 10));
        assertEquals("Armazenamento realizado com sucesso",
                a.armazena("elias", "tipo", 10));
        a.fechar();
    }

    @Test
    public void recuperaPontosUsuario() throws IOException {
        a.armazena("Elias", "ponto", 10);
        a.armazena("Elias", "ponto", 20);
        a.armazena("Elias", "estrela", 15);
        a.fechar();
        assertEquals(30, a.recuperaPontosUsuario("Elias", "ponto"));
        assertEquals(15, a.recuperaPontosUsuario("Elias", "estrela"));
        assertEquals(0, a.recuperaPontosUsuario("Elias", "energia"));
    }

    @Test
    public void retornarUsuariosComPontos() throws IOException {
        a.armazena("Elias", "ponto", 10);
        a.armazena("Calleri", "ponto", 20);
        a.armazena("Elias", "estrela", 15);
        a.armazena("Chicken Little", "energia", 15);
        a.fechar();
        assertEquals(List.of("Calleri", "Chicken Little", "Elias"),
                a.recuperaUsuarios());
    }

    @Test
    public void tiposPontosUsuario() throws IOException {
        a.armazena("Elias", "ponto", 10);
        a.armazena("Calleri", "ponto", 20);
        a.armazena("Elias", "estrela", 15);
        a.armazena("Chicken Little", "energia", 15);
        a.fechar();
        assertEquals(List.of("estrela", "ponto"),
                a.tiposPontos("Elias"));
    }
}
