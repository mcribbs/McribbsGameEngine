package net.mcribbs.engine.renderer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BuiltinRenderer extends AbstractRenderer {
    private int width, height;
    private Graphics g;

    public BuiltinRenderer(BufferedImage image) {
        width = image.getWidth();
        height = image.getHeight();
        g = image.getGraphics();
    }

    @Override
    public void draw(int x, int y, Color c) {
        g.setColor(c);
        g.drawLine(x, y, x, y);
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2, Color c) {
        g.setColor(c);
        g.drawLine(x1, y1, x2, y2);
    }

    @Override
    public void drawCircle(int x, int y, int radius, Color c) {
        g.setColor(c);
        g.drawOval(x - radius, y - radius, radius*2, radius*2);
    }

    @Override
    public void fillCircle(int x, int y, int radius, Color c) {
        g.setColor(c);
        g.fillOval(x - radius, y - radius, radius*2, radius*2);
    }

    @Override
    public void drawRect(int x, int y, int w, int h, Color c) {
        g.setColor(c);
        g.drawRect(x, y, w, h);
    }

    @Override
    public void fillRect(int x, int y, int w, int h, Color c) {
        g.setColor(c);
        g.fillRect(x, y, w, h);
    }

    @Override
    public void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3, Color c) {
        int[] pX = new int[] {x1, x2, x3};
        int[] pY = new int[] {y1, y2, y3};
        g.setColor(c);
        g.drawPolygon(pX, pY, 3);
    }

    @Override
    public void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3, Color c) {
        int[] pX = new int[] {x1, x2, x3};
        int[] pY = new int[] {y1, y2, y3};
        g.setColor(c);
        g.fillPolygon(pX, pY, 3);
    }

    @Override
    public void drawString(int x, int y, String text, Color c) {
        g.setColor(c);
        g.drawString(text, x, y);
    }

    @Override
    public void clear(Color c) {
        g.setColor(c);
        g.fillRect(0, 0, width, height);
    }
}
