package net.mcribbs.engine.renderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class CustomRenderer extends AbstractRenderer {

    private int width, height;
    private int[] p;

    public CustomRenderer(BufferedImage image) {
        width = image.getWidth();
        height = image.getHeight();
        p = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
    }

    @Override
    public void draw(int x, int y, Color c) {
        p[y*width + x] = c.getRGB();
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2, Color c) {

    }

    @Override
    public void drawCircle(int x, int y, int radius, Color c) {

    }

    @Override
    public void fillCircle(int x, int y, int radius, Color c) {

    }

    @Override
    public void drawRect(int x, int y, int w, int h, Color c) {

    }

    @Override
    public void fillRect(int x, int y, int w, int h, Color c) {

    }

    @Override
    public void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3, Color c) {

    }

    @Override
    public void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3, Color c) {

    }

    @Override
    public void drawString(int x, int y, String text, Color c) {

    }

    @Override
    public void clear(Color c) {
        for (int i = 0; i < p.length; i++) {
            p[i] = 0;
        }
    }
}
