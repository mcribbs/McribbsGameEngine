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
        mainWindow = new JFrame(game.getTitle());
        mainWindow.setBounds(50,100,400,150);

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
