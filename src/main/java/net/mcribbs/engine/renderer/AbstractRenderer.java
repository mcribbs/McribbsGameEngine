package net.mcribbs.engine.renderer;

import java.awt.*;

abstract class AbstractRenderer implements Renderer {
    // Draws a single Pixel
    public void draw(int x, int y) {
        draw(x, y, Color.WHITE);
    }
    // Draws a line from (x1,y1) to (x2,y2)
    public void drawLine(int x1, int y1, int x2, int y2) {
        drawLine(x1, y1, x2, y2, Color.WHITE);
    }

    public void drawCircle(int x, int y, int radius) {
        drawCircle(x, y, radius, Color.WHITE);
    }

    public void fillCircle(int x, int y, int radius) {
        fillCircle(x, y, radius, Color.WHITE);
    }

    public void drawRect(int x, int y, int w, int h) {
        drawRect(x, y, w, h, Color.WHITE);
    }

    public void fillRect(int x, int y, int w, int h) {
        fillRect(x, y, w, h, Color.WHITE);
    }

    public void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        drawTriangle(x1, y1, x2, y2, x3, y3, Color.WHITE);
    }

    public void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        fillTriangle(x1, y1, x2, y2, x3, y3, Color.WHITE);
    }
    //public void drawSprite(int x, int y, Sprite sprite, uint scale = 1);

    //public void drawPartialSprite(int x, int y, Sprite sprite, int ox, int oy, int w, int h, uint scale = 1);

    //public void drawString(int x, int y, String text, Color c, int scale);
    public void drawString(int x, int y, String text) {
        drawString(x, y, text, Color.WHITE);
    }

    public void clear() {
        clear(Color.BLACK);
    }
}
