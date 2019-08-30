package net.mcribbs.engine.renderer;

import java.awt.*;

public interface Renderer {
    void clear();

    void drawPoint(int x, int y);
    void drawLine(int x1, int y1, int x2, int y2, Color c);





    void drawString(String s, int x, int y, Color c);
}
