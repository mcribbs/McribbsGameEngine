package net.mcribbs.engine;

public abstract class GameContainer {
    protected String title;
    protected int height = 100;
    protected int width = 100;
    protected float scale = 1f;

    public WindowManager window;
    public InputManager input;

    boolean running = false;

    protected GameContainer() {}
    protected GameContainer(String title, int width, int height, int scale) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.scale = scale;
    }

    protected abstract void onStartup();
    protected abstract void onFrameUpdate(float elapsedTime);
    protected abstract void onShutdown();
}
