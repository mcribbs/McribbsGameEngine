package net.mcribbs.engine.renderer;

import java.awt.*;

public interface Renderer {

    // Draws a single Pixel
    void draw(int x, int y);
    void draw(int x, int y, Color c);
    // Draws a line from (x1,y1) to (x2,y2)
    void drawLine(int x1, int y1, int x2, int y2);
    void drawLine(int x1, int y1, int x2, int y2, Color c);
    // Draws a circle located at (x,y) with radius
    void drawCircle(int x, int y, int radius);
    void drawCircle(int x, int y, int radius, Color c);
    // Fills a circle located at (x,y) with radius
    void fillCircle(int x, int y, int radius);
    void fillCircle(int x, int y, int radius, Color c);
    // Draws a rectangle at (x,y) to (x+w,y+h)
    void drawRect(int x, int y, int w, int h);
    void drawRect(int x, int y, int w, int h, Color c);
    // Fills a rectangle at (x,y) to (x+w,y+h)
    void fillRect(int x, int y, int w, int h);
    void fillRect(int x, int y, int w, int h, Color c);
    // Draws a triangle between points (x1,y1), (x2,y2) and (x3,y3)
    void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3);
    void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3, Color c);
    // Flat fills a triangle between points (x1,y1), (x2,y2) and (x3,y3)
    void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3);
    void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3, Color c);
    // Draws an entire sprite at location (x,y)
    //void drawSprite(int x, int y, Sprite sprite, uint scale = 1);
    // Draws an area of a sprite at location (x,y), where the
    // selected area is (ox,oy) to (ox+w,oy+h)
    //void drawPartialSprite(int x, int y, Sprite sprite, int ox, int oy, int w, int h, uint scale = 1);
    // Draws a single line of text
    //void drawString(int x, int y, String text, Color c, int scale);
    void drawString(int x, int y, String text);
    void drawString(int x, int y, String text, Color c);
    // Clears entire draw target to Pixel
    void clear();
    void clear(Color p);


}
