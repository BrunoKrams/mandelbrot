package de.brunokrams;

import org.apache.commons.numbers.complex.Complex;

import java.io.IOException;

public class PrintApp {

    private static final int width = 1200;
    private static final int height = 1200;


    private static final Canvas canvas = new Canvas(height, width);
    private static final CanvasMapper canvasMapper = new CanvasMapper(canvas, Complex.ofCartesian(-2.0, -1.5), Complex.ofCartesian(1.0, 1.5));


    public static void main(String[] args) throws IOException {
        CanvasPrinter canvasPrinter = new CanvasPrinter();
        for (int i = 1; i <= 30; i++) {
            ColorEncoding colorEncoding = new MandelbrotEncoding(i);
            paint(colorEncoding);
            String filename = "image" + String.format("%03d", i) + ".bmp";
            canvasPrinter.createBitmap(canvas, filename);
            System.out.println(filename + " created.");
        }
    }

    private static void paint(ColorEncoding colorEncoding) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                canvas.set(i, j, colorEncoding.encode(canvasMapper.map(new Pixel(i, j))));
            }
        }
    }

}
