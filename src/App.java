import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // fazer uma conexão http e buscar os top 250 filmes
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var resquest = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(resquest, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);

        // pegar só os dados que interessam (titulo, poster e classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // exibir e manipular os dados 
        for (Map<String, String> filme : listaDeFilmes) {
            System.out.println(filme.get("title") + " - " + filme.get("rank") + " - " + filme.get("imDbRating"));
        }
    }
}
