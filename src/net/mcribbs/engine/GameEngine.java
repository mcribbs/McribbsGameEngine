package net.mcribbs.engine;

import net.mcribbs.engine.renderer.BuiltinRenderer;
import net.mcribbs.engine.renderer.CustomRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class GameEngine {

    private GameContainer gc;
    private boolean running = false;

    private JFrame frame;
    private BufferStrategy buff;
    private Graphics g;

    public GameEngine(GameContainer gc) {
        this.gc = gc;
    }

    public void start() {
        // Let game set things up
        gc.onStartup();

        // Hook up graphics and input
        createWindow();
        gc.input = new InputManager(gc);

        doLoop();
    }

    private void createWindow() {
        // Create drawing surface
        gc.image = new BufferedImage(gc.width, gc.height, BufferedImage.TYPE_INT_RGB);
        gc.canvas = new Canvas();
        Dimension s = new Dimension((int)(gc.width * gc.scale), (int)(gc.height * gc.scale));
        gc.canvas.setPreferredSize(s);
        gc.canvas.setMaximumSize(s);
        gc.canvas.setMinimumSize(s);

        /// Setup window
        frame = new JFrame(gc.title);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                running = false;
                frame.dispose();
                // Let game cleanup
                gc.onShutdown();
            }
        });
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.add(gc.canvas, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Add drawing canvas
        gc.canvas.createBufferStrategy(2);
        buff = gc.canvas.getBufferStrategy();
        g = buff.getDrawGraphics();

        // Attach a renderer
        gc.renderer = new BuiltinRenderer(gc.image);
        //gc.renderer = new CustomRenderer(gc.image);
    }

    private void doLoop() {
        running = true;
        long lastTime = System.currentTimeMillis();

        while(running) {
            // Time tracking
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - lastTime;
            lastTime = currentTime;
            float fps = 1000f/elapsedTime;

            // Call game to do it's thing!
            gc.onFrameUpdate(elapsedTime);
            gc.renderer.drawString(5, 15, String.format("%.2f", fps), Color.green);

            // Update the screen
            g.drawImage(gc.image, 0,0, (int)(gc.width * gc.scale), (int)(gc.height * gc.scale), null);
            try {
                buff.show();
            }
            catch (IllegalStateException e) {
                // On shutdown sometimes reaches after buffers have been destroyed
            }

            // Get new input state
            gc.input.update();

            // Be nice to the CPU
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
