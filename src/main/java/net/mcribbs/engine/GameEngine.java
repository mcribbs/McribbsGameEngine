package net.mcribbs.engine;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameEngine {

    private GameContainer gc;
    private boolean showFPS = false;

    public GameEngine(GameContainer gc) {
        this.gc = gc;
    }

    public void start() {
        // Let game set things up
        gc.onStartup();

        // Hook up graphics
        gc.window = WindowManager.getInstance(gc);
        gc.window.createWindow(this);

        // Hook up input
        gc.input = InputManager.getInstance(gc);
        new HotkeyListener(gc.window.canvas);

        doLoop();
    }


    private void doLoop() {
        gc.running = true;
        long lastTime = System.currentTimeMillis();

        while (gc.running) {
            // Time tracking
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - lastTime;
            lastTime = currentTime;
            float fps = 1000f / elapsedTime;

            // Call game to do it's thing!
            gc.onFrameUpdate(elapsedTime);

            // Draw fps
            if (showFPS) {
                gc.window.renderer.drawString(5, 15, String.format("%.0f", fps), Color.green);
            }

            // Update the screen
            gc.window.g.drawImage(gc.window.image, 0, 0, (int) (gc.width * gc.scale), (int) (gc.height * gc.scale), null);
            try {
                gc.window.buff.show();
            } catch (IllegalStateException e) {
                // On shutdown sometimes reaches after buffers have been destroyed
            }

            // Be nice to the CPU
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void exit() {
        // Let game cleanup
        gc.onShutdown();
        gc.window.g.dispose();
    }

    private class HotkeyListener implements KeyListener {
        private boolean controlHeld = false;

        HotkeyListener(Canvas c) {
            c.addKeyListener(this);
        }

        @Override
        public void keyTyped(KeyEvent e) {
            // Not needed
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_CONTROL)
                controlHeld = true;
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_CONTROL)
                controlHeld = false;
            if (controlHeld && (e.getKeyCode() == KeyEvent.VK_F))
                showFPS = !showFPS;
        }
    }
}
