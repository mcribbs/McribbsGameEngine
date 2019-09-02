package net.mcribbs.engine;

import net.mcribbs.engine.renderer.Renderer;
import net.mcribbs.engine.renderer.BuiltinRenderer;
import net.mcribbs.engine.renderer.CustomRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class WindowManager {
    private static WindowManager instance;
    private GameContainer gc;

    private JFrame frame;
    BufferedImage image;
    Canvas canvas;
    BufferStrategy buff;
    Graphics g;
    public Renderer renderer;

    private WindowManager(GameContainer gc) {
        this.gc = gc;
    }

    static WindowManager getInstance(GameContainer gc) {
        if (instance == null) {
            instance = new WindowManager(gc);
        }
        return instance;
    }

    void createWindow(GameEngine e) {
        // Create drawing surface
        image = new BufferedImage(gc.width, gc.height, BufferedImage.TYPE_INT_RGB);
        canvas = new Canvas();
        Dimension s = new Dimension((int) (gc.width * gc.scale), (int) (gc.height * gc.scale));
        canvas.setPreferredSize(s);
        canvas.setMaximumSize(s);
        canvas.setMinimumSize(s);

        /// Setup window
        frame = new JFrame(gc.title);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                gc.running = false;
                frame.dispose();
                e.exit();
            }
        });
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.add(gc.window.canvas, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Add drawing canvas
        gc.window.canvas.createBufferStrategy(2);
        buff = gc.window.canvas.getBufferStrategy();
        g = buff.getDrawGraphics();

        // Attach a renderer
        gc.window.renderer = new BuiltinRenderer(gc.window.image);
        //gc.renderer = new CustomRenderer(gc.image);
    }

}
