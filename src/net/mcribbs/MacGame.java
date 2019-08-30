package net.mcribbs;

import net.mcribbs.engine.GameContainer;
import net.mcribbs.engine.GameEngine;

import java.awt.*;
import java.util.Random;

class MacGame extends GameContainer {

   private MacGame() {
      super();
   }

   public static void main(String[] args) {
      System.out.println("Starting game...");
      MacGame myGame = new MacGame();
      myGame.title = "Matt's Game";
      myGame.width = 320;
      myGame.height = 240;
      myGame.scale = 3f;
      GameEngine engine = new GameEngine(myGame);
      engine.start();
   }

   @Override
   protected void onStartup() {
      System.out.println("In onStartup");
   }

   @Override
   protected void onFrameUpdate(float elapsedTime) {
      renderer.clear();

      Random r = new Random();
      for (int i = 0; i < 2000; i++) {
         int x = Math.abs(r.nextInt()) % width;
         int y = Math.abs(r.nextInt()) % height;
         renderer.drawPoint(x, y);
      }
   }

   @Override
   protected void onShutdown() {
      System.out.println("Quitting");
      System.exit(0);
   }
}
