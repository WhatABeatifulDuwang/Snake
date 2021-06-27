package View;

import Controller.GameController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameOverScene extends Scene{

	private final static int FONTSIZE = 50;
	private final static Font FONT = new Font("Arial", FONTSIZE);
	
	private GameController controller;
	
	public GameOverScene(GameController controller) {
		super(new Pane());
		this.controller = controller;
		VBox pane = new VBox();
		pane.setAlignment(Pos.CENTER);
		pane.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
		pane.getChildren().add(createTextLabel());
		pane.getChildren().add(createTimerLabel());
	}
	
	public Label createTextLabel() {
		Label gameOver = new Label("GAME OVER");
		gameOver.setFont(FONT);
		
		return gameOver;
	}
	
	public Label createTimerLabel() {
		Label timerLabel = new Label("Timer");
		timerLabel.setFont(FONT);
		timerLabel.setText(controller.getSettings().getEndTime());
		
		return timerLabel;
	}
}
