package game.mock;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class PlacarMock {
    ArmazenamentoMock mock = new MockArmazenamento();

    public void adicionarMock(MockArmazenamento mock) {
        this.mock = mock;
    }
    public String registra(String usuario, String tipo, int pontos) throws IOException {
        mock.armazena(usuario, tipo, pontos);
        return "Ponto registrado com sucesso";
    }

    public String pontosUsuario(String usuario) throws IOException {
        List<String> tipos = mock.tiposPontos(usuario);
        String resultado = "";
        int contador = 0;
        for (String tipo : tipos) {
            if(contador==0)
                resultado = resultado + tipo + ": " +
                        mock.recuperaPontosUsuario(usuario, tipo);
            else{
                resultado = resultado + ", " + tipo + ": " +
                        mock.recuperaPontosUsuario(usuario, tipo);
            }
            contador++;
        }
        return resultado;
    }

    public String ranquear(String tipo) throws IOException {
        List<String> usuarios = mock.recuperaUsuarios();
        Map<String, Integer> map = new HashMap<>();
        String resultado = "";
        for (String usuario : usuarios) {
            map.put(usuario, mock.recuperaPontosUsuario(usuario, tipo));
        }
        Map<String, Integer> mapOrdenado =
                map.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) // Ordenação decrescente
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new
                        ));

        int contador = 0;
        for(String usuario : mapOrdenado.keySet()) {
            if (mapOrdenado.get(usuario) > 0) {
                if (contador == 0)
                    resultado = resultado + usuario + ": " + mapOrdenado.get(usuario);
                else
                    resultado = resultado + ", " + usuario + ": " + mapOrdenado.get(usuario);
                contador++;
            }
        }
        return resultado;
    }
    public void adicionaArmazenamento(ArmazenamentoMock mock) {
        this.mock = mock;
    }
}
