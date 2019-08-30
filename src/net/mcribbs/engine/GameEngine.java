package net.mcribbs.engine;

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
    private Canvas canvas;
    private BufferStrategy buff;
    private Graphics g;

    public GameEngine(GameContainer gc) {
        this.gc = gc;
    }

    public void start() {
        doInit();
        createWindow();
        doLoop();
    }

    private void doInit() {
        // Let game set things up
        gc.onStartup();
    }

    private void createWindow() {
        // Create drawing surface
        gc.image = new BufferedImage(gc.width, gc.height, BufferedImage.TYPE_INT_RGB);
        canvas = new Canvas();
        Dimension s = new Dimension((int)(gc.width * gc.scale), (int)(gc.height * gc.scale));
        canvas.setPreferredSize(s);
        canvas.setMaximumSize(s);
        canvas.setMinimumSize(s);

        /// Setup window
        frame = new JFrame(gc.title + " - Initializing..." );
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
        frame.add(canvas, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas.createBufferStrategy(2);
        buff = canvas.getBufferStrategy();
        g = buff.getDrawGraphics();

        gc.renderer = new Renderer(gc.image);
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
            //frame.setTitle(gc.title + " - FPS: " + fps);
            System.out.println(fps);

            // Call game to do it's thing!
            gc.onFrameUpdate(elapsedTime);

            // Update the screen
            g.drawImage(gc.image, 0,0, (int)(gc.width * gc.scale), (int)(gc.height * gc.scale), null);
            try {
                buff.show();
            }
            catch (IllegalStateException e) {
                // On shutdown sometimes reaches after buffers have been destroyed
            }

            // Be nice to the CPU
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
