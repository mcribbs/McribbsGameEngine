package net.mcribbs.engine.renderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class CustomRenderer implements Renderer {

    private int width, height;
    private int[] p;

    public CustomRenderer(BufferedImage image) {
        width = image.getWidth();
        height = image.getHeight();
        p = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
    }

    public void clear() {
        for (int i = 0; i < p.length; i++) {
            p[i] = 0;
        }
    }

    public void drawPoint(int x, int y) {
        p[y*width + x] = Color.green.getRGB();
    }

    public void drawLine(int x1, int y1, int x2, int y2, Color c) {
    }








    public void drawString(String s, int x, int y, Color c) {
    }
}
