package Controller;

import Model.Game;
import View.DashBoard;
import View.DrawPane;
import View.GameOverScene;

public class GameController {

	private DrawPane board;
	private DashBoard setting;
	private GameOverScene endScreen;
	
	private GameEngine engine;
	private Game game;
	
	public GameController() {
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
	
	
//	
//	public void checkSpot() {
//		if (getGame().getSpot().getMarker() == Marker.FIRE) {
//			// Switch to gameoverscene
//		}
//		else if (getGame().getSpot().getMarker() == Marker.BEAR) {
//			Math.floor(getGame().getSnake().getBody().length);
//			if (getGame().getSnake().getBody().length < 5) {
//				// Switch to gameoverscene
//			}
//		}
//		else if (getGame().getSpot().getMarker() == Marker.MOUSE) {
//			getGame().getSnake().setBody(new BodyPart[5]);
//			// dit maal 5
//		}
//	}
	
	public DrawPane getBoard() {
		return board;
	}
	
	public DashBoard getSettings() {
		return setting;
	}
	
	public GameOverScene getEndScreen() {
		return endScreen;
	}
	
	public Game getGame() {
		return game;
	}
}
