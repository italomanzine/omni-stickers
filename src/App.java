import java.io.InputStream;
import java.net.URI;
import java.net.URL;
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
        var gerador = new StickersGenerator();
        System.out.println("Iniciando a geração de stickers para " + listaDeFilmes.size() + " filmes.");
        for (Map<String, String> filme : listaDeFilmes) {
            try {
                String urlImagem = filme.get("image");
                // Ajustar a URL da imagem aqui
                urlImagem = urlImagem.substring(0, urlImagem.indexOf("@") + 1) + ".jpg";

                String titulo = filme.get("title");
                String rank = filme.get("rank"); // Supondo que você tenha a classificação (rank) dos filmes disponível
                                                 // aqui.

                System.out.println("Gerando sticker para: " + titulo);

                InputStream inputStream = new URL(urlImagem).openStream();
                String nomeArquivo = titulo.replaceAll("[^a-zA-Z0-9\\.\\-]", "_") + ".png"; // Limpar o título para
                                                                                            // criar um nome de arquivo
                                                                                            // seguro

                gerador.generateStickers(inputStream, nomeArquivo, rank);

            } catch (Exception e) {
                System.err.println("Erro ao gerar sticker para o filme: " + filme.get("title"));
                e.printStackTrace(); // Isso irá imprimir a pilha de exceções e ajudar a diagnosticar o problema
            }
        }

        System.out.println("Geração de stickers concluída.");
    }
}
