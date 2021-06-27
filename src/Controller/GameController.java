package Controller;

import Model.Game;
import View.DashBoard;
import View.DrawPane;
import View.GameOverScene;

public class GameController {

	private DrawPane board;
	private DashBoard setting;
	private GameOverScene endScreen;
	
	private MainController mainCtrl;
	private GameEngine engine;
	private Game game;
	
	public GameController(MainController mainCtrl) {
		this.mainCtrl = mainCtrl;
		game = new Game();
		board = new DrawPane(this);
		setting = new DashBoard(this);
		endScreen = new GameOverScene(this);
		engine = new GameEngine(game, board, this);
	}
	
	public void startGame() {
		engine.start();
	}
	
	public void pauseGame() {
		engine.stop();
	}
	
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
		mainCtrl.switchToGameOver();
	}
}
