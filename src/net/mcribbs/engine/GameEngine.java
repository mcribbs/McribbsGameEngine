package net.mcribbs.engine;

import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameEngine {

    private Game game;
    private JFrame mainWindow;
    private boolean running = false;

    public GameEngine(Game game) {
        this.game = game;
    }

    public void start() {
        doInit();
        createWindow();
        doLoop();
    }

    private void doInit() {
        game.onStartup();
    }

    private void createWindow() {
        mainWindow = new JFrame(game.title + " - Initializing..." );
        mainWindow.setBounds(
                game.initialWindowPosition.x,
                game.initialWindowPosition.y,
                game.initialWindowSize.x,
                game.initialWindowSize.y);
        mainWindow.setResizable(false);

        mainWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainWindow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                running = false;
                mainWindow.dispose();
                game.onShutdown();
            }
        });

        mainWindow.setVisible(true);
    }

    private void doLoop() {
        running = true;

        while(running) {
            game.onFrameUpdate();
        }
    }
}
