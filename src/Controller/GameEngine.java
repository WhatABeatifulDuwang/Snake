package Controller;

import Model.Game;
import View.DrawPane;
import javafx.application.Platform;

public class GameEngine implements Runnable {

	private final int START_INTERVAL = 1500;

	private Thread thread;
	private Game game;
	private DrawPane view;
	private GameController controller;

	private boolean isRunning;
	private int interval = START_INTERVAL;

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
						if (game.isSnakeDead()) {
							isRunning = false;
							thread = null;
							controller.getSettings().pauseTimer();
							controller.gameOver();
						}
						game.update();
						view.update(game);
					}
				});
			} catch (InterruptedException e) {
				isRunning = false;
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

	// sets interval speed based on speedvalue from slider
	public void setSpeed(int speed) {
		interval = START_INTERVAL - (speed * 100);
	}
}
