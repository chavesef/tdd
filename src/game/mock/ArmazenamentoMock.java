package game.mock;

import java.util.List;

public interface ArmazenamentoMock {

    void armazena(String usuario, String tipo, int pontos);

    List<String> tiposPontos(String usuario);

    int recuperaPontosUsuario(String usuario, String tipo);

    List<String> recuperaUsuarios();
}
