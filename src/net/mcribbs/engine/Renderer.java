package net.mcribbs.engine;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.nio.Buffer;

public class Renderer {
    private int width, height;
    //private int[] p;
    //private BufferedImage image;
    private Graphics g;

    public Renderer(BufferedImage image) {
        //this.image = image;
        width = image.getWidth();
        height = image.getHeight();
        g = image.getGraphics();
        //p = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
    }

    public void clear() {
        //for (int i = 0; i < p.length; i++) {
            //p[i] = 0;
        //}
        g.clearRect(0,0, width, height);
    }

    public void drawPoint(int x, int y) {
        //p[y*image.getWidth() + x] = Color.green.getRGB();
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
