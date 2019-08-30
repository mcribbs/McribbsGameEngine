package net.mcribbs.engine;

import java.awt.*;
import java.awt.image.DataBufferInt;

public class Renderer {
    private int pW, pH;
    private int[] p;

    public Renderer(GameContainer gc) {
        pW = gc.width;
        pH = gc.height;
        p = ((DataBufferInt) gc.image.getRaster().getDataBuffer()).getData();
    }

    public void clear() {
        for (int i = 0; i < p.length; i++) {
            p[i] = 0;
        }
    }

    public void drawPoint(int x, int y) {
       p[y*pW + x] = Color.green.getRGB();
    }
}
