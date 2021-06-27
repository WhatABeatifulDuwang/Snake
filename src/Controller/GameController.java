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

	public void startGame() {
		engine.start();
	}

	public void pauseGame() {
		engine.stop();
	}

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

	public void gameOver() {
		gameScene.setRoot(new GameOverScene(this));
	}

	public void setGameScene(Scene scene) {
		gameScene = scene;
	}
}
