package Controller;

import Model.Game;
import View.DrawPane;
import javafx.application.Platform;

public class GameEngine implements Runnable {

	private Thread thread;

	private Game game;
	private DrawPane view;
	private GameController controller;

	private boolean isRunning;
	private int interval = 1000;

	public GameEngine(Game game, DrawPane view, GameController controller) {
		this.game = game;
		this.view = view;
		this.controller = controller;
	}

	@Override
	public void run() {
		isRunning = true;
		while (isRunning) {
			try {
				Thread.sleep(interval);
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						game.update();
						view.update(game);
					}
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		thread = null;
	}

	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	public void stop() {
		isRunning = false;
	}
	
	public void setSpeed(int speed) {
		interval = interval - (speed * 10);
	}
}
