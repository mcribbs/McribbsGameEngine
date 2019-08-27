package net.mcribbs;

import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Game {
   private static JFrame mainWindow;

   public static void main(String[] args) {
      System.out.println("Starting game...");
      createWindow();
   }

   private static void exit() {
      System.out.println("Quitting");
      mainWindow.dispose();
      System.exit(0);
   }

   private static void createWindow() {
      mainWindow = new JFrame("Matt's Game");
      mainWindow.setBounds(50,100,400,150);

      mainWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      mainWindow.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent event) {
            exit();
         }
      });

      mainWindow.setVisible(true);
   }
}
