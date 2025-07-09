package br.com.projeto.LocaizadorDePerfilGITHUB.funcionalidade;

import br.com.projeto.LocaizadorDePerfilGITHUB.perfil.Perfil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Salvar {
Gson gson = new GsonBuilder()
        .setPrettyPrinting()
        .create();

    public void salvarHistorico(List<Perfil> historico) throws IOException {
        FileWriter arquivo = new FileWriter("historico.txt");
        if(historico.isEmpty()){
            arquivo.write("Histórico Limpo!");
            arquivo.close();
        }else {
            arquivo.write(gson.toJson(historico));
            arquivo.close();
        }
    }

    public void deletarHistorico(List<Perfil> historico) {
        historico.clear();
        System.out.println("Nomes removidos com sucesso!");
    }
}
