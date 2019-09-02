package net.mcribbs.engine;

import java.awt.event.*;

public class InputManager {
    private static InputManager instance;
    private GameContainer gc;

    private static final int NUM_KEYS = 256;
    private boolean[] keysHeld = new boolean[NUM_KEYS];
    private boolean[] keysReleased = new boolean[NUM_KEYS];
    private boolean[] keysPressed = new boolean[NUM_KEYS];

    private static final int NUM_BUTTONS = 5;
    private boolean[] buttonsHeld = new boolean[NUM_BUTTONS];
    private boolean[] buttonsReleased = new boolean[NUM_BUTTONS];
    private boolean[] buttonsPressed = new boolean[NUM_BUTTONS];

    public float mouseX, mouseY;
    public int mouseScroll;


    private InputManager(GameContainer gc) {
        this.gc = gc;
        Listener listener = new Listener();

        mouseX = 0;
        mouseY = 0;
        mouseScroll = 0;

        gc.canvas.addKeyListener(listener);
        gc.canvas.addMouseListener(listener);
        gc.canvas.addMouseMotionListener(listener);
        gc.canvas.addMouseWheelListener(listener);
    }

    static InputManager getInstance(GameContainer gc) {
        if (instance == null) {
            instance = new InputManager(gc);
        }
        return instance;
    }

    public boolean isKeyHeld(int key) {
        return keysHeld[key];
    }

    public boolean isKeyReleased(int key) {
        boolean released = keysReleased[key];
        keysReleased[key] = false;
        return released;
    }

    public boolean isKeyPressed(int key) {
        boolean pressed = keysPressed[key];
        keysPressed[key] = false;
        return pressed;
    }

    public boolean isButtonHeld(int button) {
        return buttonsHeld[button];
    }

    public boolean isButtonReleased(int button) {
        boolean released = buttonsReleased[button];
        buttonsReleased[button] = false;
        return released;
    }

    public boolean isButtonPressed(int button) {
        boolean pressed = buttonsPressed[button];
        buttonsPressed[button] = false;
        return pressed;
    }

    private class Listener implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

        @Override
        public void keyTyped(KeyEvent e) {
            // Not needed
        }

        @Override
        public synchronized void keyPressed(KeyEvent e) {
            int k = e.getKeyCode();
            if (!keysHeld[k])
                keysPressed[k] = true;
            keysHeld[k] = true;
        }

        @Override
        public synchronized void keyReleased(KeyEvent e) {
            int k = e.getKeyCode();
            if (keysHeld[k])
                keysReleased[k] = true;
            keysHeld[k] = false;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            // Not needed
        }

        @Override
        public synchronized void mousePressed(MouseEvent e) {
            int b = e.getButton();
            if (!buttonsHeld[b])
                buttonsPressed[b] = true;
            buttonsHeld[b] = true;
        }

        @Override
        public synchronized void mouseReleased(MouseEvent e) {
            int b = e.getButton();
            if (buttonsHeld[b])
                buttonsReleased[b] = true;
            buttonsHeld[b] = false;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // Not needed
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // Not needed
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            mouseX = e.getX() / gc.scale;
            mouseY = e.getY() / gc.scale;
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            mouseX = e.getX() / gc.scale;
            mouseY = e.getY() / gc.scale;
        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            mouseScroll = e.getWheelRotation();
        }
    }
}
