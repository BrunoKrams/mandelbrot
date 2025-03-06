package de.brunokrams;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CanvasPrinter {

    public void createBitmap(Canvas canvas, String filePath) throws IOException {
        BufferedImage bufferedImage = new BufferedImage(canvas.getHeigth(), canvas.getWidth(), BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < canvas.getHeigth(); i++) {
            for (int j = 0; j < canvas.getWidth(); j++) {
                bufferedImage.setRGB(i, j, canvas.get(i, j).getRGB());
            }
        }
        File file = new File(filePath);
        ImageIO.write(bufferedImage, "bmp", file);

    }


}
