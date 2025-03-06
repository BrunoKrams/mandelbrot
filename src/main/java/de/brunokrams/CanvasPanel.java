package de.brunokrams;

import javax.swing.*;
import java.awt.*;

public class CanvasPanel extends JPanel {

    private final Canvas canvas;

    public CanvasPanel(Canvas canvas) {
        setPreferredSize(new Dimension(canvas.getWidth(), canvas.getHeigth()));
        this.canvas = canvas;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (int x = 0; x < this.getWidth(); x++) {
            for (int y = 0; y < this.getHeight(); y++) {
                Color color = canvas.get(x, y);
                g2d.setColor(color);
                g2d.fillRect(x, y, 1, 1);
            }
        }
    }
}
