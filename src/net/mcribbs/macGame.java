package net.mcribbs;

import net.mcribbs.engine.Coords;
import net.mcribbs.engine.Game;
import net.mcribbs.engine.GameEngine;

class macGame extends Game {

   private macGame() {
      super();
   }

   public static void main(String[] args) {
      System.out.println("Starting game...");
      macGame myGame = new macGame();
      myGame.title = "Matt's Game";
      myGame.initialWindowPosition = new Coords(50,100);
      myGame.initialWindowSize = new Coords(640, 480);
      GameEngine engine = new GameEngine(myGame);
      engine.start();
   }

   @Override
   protected void onStartup() {
      System.out.println("In onStartup");
   }

   @Override
   protected void onFrameUpdate(float elapsedTime) {
   }

   @Override
   protected void onShutdown() {
      System.out.println("Quitting");
      System.exit(0);
   }
}
