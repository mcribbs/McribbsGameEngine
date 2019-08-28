package net.mcribbs.engine;

public abstract class Game {

    protected String title;
    protected Coords initialWindowPosition = new Coords();
    protected Coords initialWindowSize = new Coords(100, 100);

    protected Game() {
    }

    protected abstract void onStartup();
    protected abstract void onFrameUpdate(float elapsedTime);
    protected abstract void onShutdown();
}
