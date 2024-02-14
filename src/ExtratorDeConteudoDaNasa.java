import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo {
    public List<Conteudo> extraiConteudos(String json) {

        // extrair os dados que interessam (titulo e url da imagem)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        return listaDeAtributos.stream()
                .map(atributos -> new Conteudo(atributos.get("title"), atributos.get("url")))
                .collect(Collectors.toList());
    }
}
