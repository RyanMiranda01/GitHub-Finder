package br.com.projeto.LocaizadorDePerfilGITHUB.funcionalidade;

import br.com.projeto.LocaizadorDePerfilGITHUB.perfil.ConverterTexto;
import br.com.projeto.LocaizadorDePerfilGITHUB.erros.ErroConsultaGitHubException;
import br.com.projeto.LocaizadorDePerfilGITHUB.perfil.Perfil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Localizador {

    List<Perfil> historicoPerfis = new ArrayList<>();
    Salvar salv = new Salvar();
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();


    public void getHistoricoPerfis() {
        System.out.println("Seu histórico de pesquisa");
        for(Perfil perfil : historicoPerfis) {
            System.out.println(perfil);
            System.out.println();
        }
    }

    public void pesquisa(String avatar_url) throws IOException, InterruptedException {

        var endereco = "https://api.github.com/users/" + avatar_url.replace(" ", "+");
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        //Remover texto Json
            /*client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenAccept(System.out::println)
                    .join();
*/
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        var json = response.body();
        if( response.statusCode()== 404){
            throw new ErroConsultaGitHubException("br.com.projeto.LocaizadorDePerfilGITHUB.perfil.Perfil não encontrado, verifique se digitou corretamente!!");
        }


        ConverterTexto convertido = gson.fromJson(json, ConverterTexto.class);

        Perfil perfil = new Perfil(convertido);

        historicoPerfis.add(perfil);

        System.out.println(perfil);

        salv.salvarHistorico(historicoPerfis);

    }

    public void excluirHistorico() throws IOException {
    salv.deletarHistorico(historicoPerfis);

    salv.salvarHistorico(historicoPerfis);
    }
}
