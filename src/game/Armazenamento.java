package game;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Armazenamento {
    BufferedWriter armazena;

    public Armazenamento() throws IOException {
        armazena =new BufferedWriter(new FileWriter(
                "/home/efchaves/IdeaProjects/TDD/src/game/arquivo.txt"));
    }

    public String armazena(String usuario, String tipo, int pontos) throws IOException {
        try {
            String formato = usuario + ", " + tipo + ", " + pontos +"\n";
            armazena.append(formato);
            return "Armazenamento realizado com sucesso";
        } catch (IOException e) {
            return "Não foi possível armazenar";
        }
    }

    public int recuperaPontosUsuario(String usuario, String tipo) throws IOException {
        int pontos = 0;
        BufferedReader recupera = new BufferedReader(
                new FileReader("/home/efchaves/IdeaProjects/TDD/src/game/arquivo.txt"));
        while(recupera.ready()) {
            String linha = recupera.readLine();
            if(linha.contains(usuario) && linha.contains(tipo)) {
                pontos += Integer.parseInt(linha.split(", ")[2]);
            }
        }
        return pontos;
    }

    public void fechar() throws IOException {
        armazena.close();
    }

    public List<String> recuperaUsuarios() throws IOException {
        List<String> usuarios = new ArrayList<String>();
        BufferedReader recupera = new BufferedReader(
                new FileReader("/home/efchaves/IdeaProjects/TDD/src/game/arquivo.txt"));
        while(recupera.ready()) {
            String linha = recupera.readLine();
            usuarios.add(linha.split(", ")[0]);
        }
        Collections.sort(usuarios);
        return usuarios.stream().distinct().collect(Collectors.toList());
    }

    public List<String> tiposPontos(String usuario) throws IOException {
        List<String> pontos = new ArrayList<String>();
        BufferedReader recupera = new BufferedReader(
                new FileReader("/home/efchaves/IdeaProjects/TDD/src/game/arquivo.txt"));
        while(recupera.ready()) {
            String linha = recupera.readLine();
            if(linha.contains(usuario)) {
                pontos.add(linha.split(", ")[1]);
            }
        }
        Collections.sort(pontos);
        return pontos.stream().distinct().collect(Collectors.toList());
    }
}
