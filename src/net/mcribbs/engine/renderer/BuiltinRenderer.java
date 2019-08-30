package net.mcribbs.engine.renderer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BuiltinRenderer implements Renderer {
    private int width, height;
    private Graphics g;

    public BuiltinRenderer(BufferedImage image) {
        width = image.getWidth();
        height = image.getHeight();
        g = image.getGraphics();
    }

    public void clear() {
        g.clearRect(0,0, width, height);
    }

    public void drawPoint(int x, int y) {
        g.drawLine(x, y, x, y);
    }

    public void drawLine(int x1, int y1, int x2, int y2, Color c) {
        g.setColor(c);
        g.drawLine(x1, y1, x2, y2);
    }








    public void drawString(String s, int x, int y, Color c) {
        g.setColor(c);
        g.drawString(s, x, y);
    }
}
