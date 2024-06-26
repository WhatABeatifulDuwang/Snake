package Controller;

import Model.Game;
import View.DashBoard;
import View.DrawPane;
import View.GameOverScene;
import javafx.scene.Scene;

public class GameController {

	private DrawPane board;
	private DashBoard setting;
	private GameOverScene endScreen;
	private Scene gameScene;

	private GameEngine engine;
	private Game game;

	public GameController() {
		game = new Game();
		board = new DrawPane(this);
		setting = new DashBoard(this);
		engine = new GameEngine(game, board, this);
	}

	// starts the game engine
	public void startGame() {
		engine.start();
	}

	// pauses the game engine
	public void pauseGame() {
		engine.stop();
	}

	// generates body parts for the snake
	public void generateBodyPart() {
		game.getSnake().addBodyPart();
	}

	// increases game speed
	public void increaseSpeed(int speed) {
		engine.setSpeed(speed);
	}

	public DrawPane getBoard() {
		return board;
	}

	public GameOverScene getEndScreen() {
		return endScreen;
	}

	public DashBoard getSettings() {
		return setting;
	}

	public Game getGame() {
		return game;
	}

	// switches to game over scene when conditions are met
	public void gameOver() {
		gameScene.setRoot(new GameOverScene(this));
	}

	// sets the game scene in maincontroller
	public void setGameScene(Scene scene) {
		gameScene = scene;
	}
}
