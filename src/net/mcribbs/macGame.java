package net.mcribbs;

import net.mcribbs.engine.Game;
import net.mcribbs.engine.GameEngine;

class macGame extends Game {

   private macGame(String title) {
      super(title);
   }

   public static void main(String[] args) {
      System.out.println("Starting game...");
      GameEngine engine = new GameEngine(new macGame("Matt's macGame"));
      engine.start();
   }

   @Override
   protected void onStartup() {
      System.out.println("In onStartup");
   }

   @Override
   protected void onFrameUpdate() {

   }

   @Override
   protected void onShutdown() {
      System.out.println("Quitting");
      System.exit(0);
   }
}
