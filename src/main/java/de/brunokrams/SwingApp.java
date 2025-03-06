package de.brunokrams;

import org.apache.commons.numbers.complex.Complex;

import javax.swing.*;

public class SwingApp {

    private static final int width = 1200;
    private static final int height = 1200;

    public static void main(String[] args) {
        Canvas canvas = new Canvas(height, width);
        CanvasMapper canvasMapper = new CanvasMapper(canvas, Complex.ofCartesian(-2.0, -1.5), Complex.ofCartesian(1.0, 1.5));
        ColorEncoding colorEncoding = new MandelbrotEncoding(10);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                canvas.set(i, j, colorEncoding.encode(canvasMapper.map(new Pixel(i, j))));
            }
        }

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Mandelbrot set");
            CanvasPanel canvasPanel = new CanvasPanel(canvas);
            frame.add(canvasPanel);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

}
