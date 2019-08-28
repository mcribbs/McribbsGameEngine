package net.mcribbs.engine;

public abstract class Game {

    private String title;

    protected Game(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    protected abstract void onStartup();
    protected abstract void onFrameUpdate();
    protected abstract void onShutdown();
}
