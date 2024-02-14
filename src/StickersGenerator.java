import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class StickersGenerator {

    private static final String OUTPUT_DIR = "saida";

    public StickersGenerator() {
        createOutputDir();
    }

    private void createOutputDir() {
        File dir = new File(OUTPUT_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    public void generateStickers(InputStream inputStream, String nomeArquivo) throws Exception {
        // leitura de imagem
        BufferedImage originalImage = ImageIO.read(inputStream);

        // definir a nova altura com um espaço menor
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int spaceForText = 0; // ajuste este valor conforme necessário
        int newHeight = height + spaceForText;
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para a nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        // melhorar a qualidade do texto
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // configurar a fonte
        String fontName = "Comic Sans MS"; // ou "Impact"
        int fontSize = width / 8; // ajustar o tamanho da fonte conforme necessário
        Font font = new Font(fontName, Font.BOLD, fontSize);

        // verificar se a fonte está instalada
        if (!graphics.getFontMetrics(font).getFont().getName().equals(fontName)) {
            System.out.println("Fonte '" + fontName + "' não disponível. Usando fonte padrão.");
        }

        graphics.setFont(font);

        // adicionar contorno ao texto
        String text = "NICE!";
        FontRenderContext frc = graphics.getFontRenderContext();
        GlyphVector gv = font.createGlyphVector(frc, text);
        double textWidth = gv.getVisualBounds().getWidth();

        // centralizar o texto horizontalmente e ajustar verticalmente
        int x = (width - (int) textWidth) / 2;
        int y = height + (spaceForText - 5); // ajustar a posição y do texto conforme necessário

        // desenhar contorno
        Stroke stroke = new BasicStroke(2f);
        graphics.setStroke(stroke);
        graphics.setColor(Color.BLACK);
        graphics.draw(gv.getOutline(x, y));

        // desenhar texto
        graphics.setColor(Color.YELLOW);
        graphics.fill(gv.getOutline(x, y));

        // escrever a nova imagem em um arquivo no diretório de saída
        ImageIO.write(newImage, "png", new File(OUTPUT_DIR + File.separator + nomeArquivo));
    }
}
