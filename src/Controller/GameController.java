package Controller;

import Model.BodyPart;
import Model.Game;
import Model.Marker;
import View.DashBoard;
import View.DrawPane;
import View.GameOverScene;
import javafx.animation.AnimationTimer;

public class GameController {

	private DrawPane board;
	private DashBoard setting;
	private GameOverScene endScreen;
	private AnimationTimer timer;
	private Game game;
	
	public GameController() {
		board = new DrawPane(this);
		setting = new DashBoard(this);
		endScreen = new GameOverScene(this);
	}
	
	public void startGame() {
		createTimer();
		startTimer();
	}
	
	public void pauseGame() {
		pauseTimer();
	}
	
	public void increaseSpeed() {
		
	}
	
	public void createTimer() {
		timer = new Timer(1000) {
			
			@Override
			public void doAction() {
				increaseSpeed();
			}
		};	
	}
	
	public void pauseTimer() {
		timer.stop();
	}
	
	public void startTimer() {
		timer.start();
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
	
	public AnimationTimer getTimer() {
		return timer;
	}
	
	public Game getGame() {
		return game;
	}
}
