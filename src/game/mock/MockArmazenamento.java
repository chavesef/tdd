package game.mock;

import java.util.List;

public class MockArmazenamento implements ArmazenamentoMock {

    @Override
    public void armazena(String usuario, String tipo, int pontos) {

    }

    @Override
    public List<String> tiposPontos(String usuario) {
        if(usuario.equals("Elias"))
            return List.of("estrela", "ponto");
        return List.of();
    }

    @Override
    public int recuperaPontosUsuario(String usuario, String tipo) {
        if(usuario.equals("Elias") && tipo.equals("estrela"))
            return 10;
        if(usuario.equals("Elias") && tipo.equals("ponto"))
            return 25;
        if(usuario.equals("Chicken Little") && tipo.equals("ponto"))
            return 50;
        if(usuario.equals("Calleri") && tipo.equals("ponto"))
            return 45;
        if(usuario.equals("Chicken Little") && tipo.equals("energia"))
            return 20;
        return 0;
    }

    @Override
    public List<String> recuperaUsuarios() {
        return List.of("Chicken Little", "Calleri", "Elias");
    }

    public void fechar() {

    }
}
