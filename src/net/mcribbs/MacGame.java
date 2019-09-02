package net.mcribbs;

import net.mcribbs.engine.GameContainer;
import net.mcribbs.engine.GameEngine;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

class MacGame extends GameContainer {

   private MacGame() {
      super();
   }

   public static void main(String[] args) {
      System.out.println("Starting game...");
      MacGame myGame = new MacGame();
      GameEngine engine = new GameEngine(myGame);
      engine.start();
   }

   @Override
   protected void onStartup() {
      this.title = "Matt's Game";
      this.width = 320;
      this.height = 240;
      this.scale = 3f;
   }

   @Override
   protected void onFrameUpdate(float elapsedTime) {
      renderer.clear();

      if(input.isKeyPressed(KeyEvent.VK_CONTROL)) {
         System.out.println("Control pressed");
      }
      if(input.isKeyPressed(KeyEvent.VK_F)) {
         System.out.println("F pressed");
      }
      if(input.isKeyReleased(KeyEvent.VK_CONTROL)) {
         System.out.println("Control released");
      }
      if(input.isKeyReleased(KeyEvent.VK_F)) {
         System.out.println("F released");
      }

      Random r = new Random();
      for (int i = 0; i < 2000; i++) {
         int x = Math.abs(r.nextInt()) % width;
         int y = Math.abs(r.nextInt()) % height;
         Color c = new Color(Math.abs(r.nextInt()) % 255, Math.abs(r.nextInt()) % 255, Math.abs(r.nextInt()) % 255);

         renderer.draw(x, y, c);
      }
   }

   @Override
   protected void onShutdown() {
      System.out.println("Quitting");
      System.exit(0);
   }
}
