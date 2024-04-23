package camel;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static camel.CamelCase.converterCamelCase;
import static org.junit.Assert.*;

public class TesteCamelCase {

    @Test
    public void testCamelCase() {
        assertEquals(List.of("nome"), converterCamelCase("nome"));
        assertEquals(List.of("CPF", "nome"), converterCamelCase("CPFNome"));
        assertEquals(List.of("nome"), converterCamelCase("Nome"));
        assertEquals(List.of("nome", "composto"), converterCamelCase("nomeComposto"));
        assertEquals(List.of("nome", "composto"), converterCamelCase("NomeComposto"));
        assertEquals(List.of("CPF"), converterCamelCase("CPF"));
        assertEquals(List.of("numero", "CPF"), converterCamelCase("numeroCPF"));
        assertEquals(List.of("recupera", "10", "primeiros"), converterCamelCase("recupera10Primeiros"));
        assertEquals(List.of("Invalida"), converterCamelCase("10Primeiros"));
        assertEquals(List.of("Invalida"), converterCamelCase("nome#Composto"));
    }

}
