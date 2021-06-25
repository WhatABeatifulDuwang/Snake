package Controller;

import Model.BodyPart;
import Model.Direction;
import Model.Game;
import Model.Marker;
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
		engine = new GameEngine(game, board);
	}
	
	public void startGame() {
		engine.start();
		move(Direction.RIGHT);
	}
	
	public void pauseGame() {
		engine.stop();
	}
	
	public void increaseSpeed(int speed) {
		engine.setSpeed(speed);
	}
	
	public void move(Direction direction) {
		int currentPosX = getGame().getSnake().getX();
		int currentPosY = getGame().getSnake().getY();
		switch(direction) {
		case UP:
			getGame().getSnake().setY(currentPosY++);
			break;
		case RIGHT:
			getGame().getSnake().setY(currentPosX++);
			break;
		case DOWN:
			getGame().getSnake().setY(currentPosY--);
			break;
		case LEFT:
			getGame().getSnake().setY(currentPosX--);
			break;
		}
	}
	
	public void checkSpot() {
		if (getGame().getSpot().getMarker() == Marker.FIRE) {
			// Switch to gameoverscene
		}
		else if (getGame().getSpot().getMarker() == Marker.BEAR) {
			Math.floor(getGame().getSnake().getBody().length);
			if (getGame().getSnake().getBody().length < 5) {
				// Switch to gameoverscene
			}
		}
		else if (getGame().getSpot().getMarker() == Marker.MOUSE) {
			getGame().getSnake().setBody(new BodyPart[5]);
			// dit maal 5
		}
	}
	
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
