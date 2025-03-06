package de.brunokrams;

import java.awt.*;

public class Canvas {

    private final int width;
    private final int heigth;

    private final Color[][] pixels;

    public Canvas(int heigth, int width) {
        this.heigth = heigth;
        this.width = width;
        pixels = new Color[heigth][width];
        for (int i = 0; i < heigth; i++) {
            for (int j = 0; j < width; j++) {
                pixels[i][j] = Color.WHITE;
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeigth() {
        return heigth;
    }

    public Color get(int x, int y) {
        return this.pixels[x][y];
    }

    public void set(int x, int y, Color color) {
        this.pixels[x][y] = color;
    }

}
