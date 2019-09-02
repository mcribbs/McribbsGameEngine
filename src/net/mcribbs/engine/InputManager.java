package net.mcribbs.engine;

import java.awt.event.*;

public class InputManager {
    private static InputManager instance;
    private GameContainer gc;

    private static final int NUM_KEYS = 256;
    private boolean[] keys = new boolean[NUM_KEYS];
    private boolean[] keysLast = new boolean[NUM_KEYS];

    private static final int NUM_BUTTONS = 5;
    private boolean[] buttons = new boolean[NUM_BUTTONS];
    private boolean[] buttonsLast = new boolean[NUM_BUTTONS];

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

    synchronized void update() {
        // Save last key state for press/release detection
        System.arraycopy(keys, 0, keysLast, 0, NUM_KEYS);

        // Save last button state for press/release detection
        System.arraycopy(buttons, 0, buttonsLast, 0, NUM_BUTTONS);

        mouseScroll = 0;
    }

    public boolean isKeyHeld(int key) {
        return keys[key];
    }

    public boolean isKeyReleased(int key) {
        return !keys[key] && keysLast[key];
    }

    public boolean isKeyPressed(int key) {
        return keys[key] && !keysLast[key];
    }

    public boolean isButtonHeld(int button) {
        return buttons[button];
    }

    public boolean isButtonReleased(int button) {
        return !buttons[button] && buttonsLast[button];
    }

    public boolean isButtonPressed(int button) {
        return buttons[button] && !buttonsLast[button];
    }

    private class Listener implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

        @Override
        public void keyTyped(KeyEvent e) {
            // Not needed
        }

        @Override
        public synchronized void keyPressed(KeyEvent e) {
            keys[e.getKeyCode()] = true;
        }

        @Override
        public synchronized void keyReleased(KeyEvent e) {
            keys[e.getKeyCode()] = false;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            // Not needed
        }

        @Override
        public synchronized void mousePressed(MouseEvent e) {
            buttons[e.getButton()] = true;
        }

        @Override
        public synchronized void mouseReleased(MouseEvent e) {
            buttons[e.getButton()] = false;
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
