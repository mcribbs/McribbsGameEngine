package net.mcribbs.engine;

import net.mcribbs.engine.GameContainer;

import java.awt.event.*;

public class InputManager implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

    private GameContainer gc;

    private static final int NUM_KEYS = 256;
    private boolean[] keys = new boolean[NUM_KEYS];
    private boolean[] keysLast = new boolean[NUM_KEYS];

    private static final int NUM_BUTTONS = 5;
    private boolean[] buttons = new boolean[NUM_BUTTONS];
    private boolean[] buttonsLast = new boolean[NUM_BUTTONS];

    protected float mouseX, mouseY;
    protected int mouseScroll;


    public InputManager(GameContainer gc) {
        this.gc = gc;

        mouseX = 0;
        mouseY = 0;
        mouseScroll = 0;

        gc.canvas.addKeyListener(this);
        gc.canvas.addMouseListener(this);
        gc.canvas.addMouseMotionListener(this);
        gc.canvas.addMouseWheelListener(this);
    }

    protected void update() {
        for (int i = 0; i < NUM_KEYS; i++) {
            keysLast[i] = keys[i];
        }
        for (int i = 0; i < NUM_BUTTONS; i++) {
            buttonsLast[i] = buttons[i];
        }
    }

    protected boolean isKeyHeld(int key) {
        return keys[key];
    }

    protected boolean isKeyUp(int key) {
        return !keys[key] && keysLast[key];
    }

    protected boolean isKeyDown(int key) {
        return keys[key] && keysLast[key];
    }

    protected boolean isButtonHeld(int button) {
        return buttons[button];
    }

    protected boolean isButtonUp(int button) {
        return !buttons[button] && buttonsLast[button];
    }

    protected boolean isButtonDown(int button) {
        return buttons[button] && !buttonsLast[button];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        buttons[e.getButton()] = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        buttons[e.getButton()] = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

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
