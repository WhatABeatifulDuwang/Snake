package Controller;

import View.DashBoard;
import View.DrawPane;
import View.GameOverScene;
import javafx.animation.AnimationTimer;

public class GameController {

	private DrawPane board;
	private DashBoard setting;
	private GameOverScene endScreen;
	private AnimationTimer timer;
	
	public GameController() {
		board = new DrawPane(this);
		setting = new DashBoard(this);
		endScreen = new GameOverScene(this);
	}
	
	public void startGame() {
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
}
