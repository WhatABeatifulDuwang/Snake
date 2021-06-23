package View;

import Controller.GameController;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameOverScene extends VBox{

	private final static int FONTSIZE = 50;
	private final static Font FONT = new Font("Arial", FONTSIZE);
	
	public GameOverScene(GameController controller) {
		this.setAlignment(Pos.CENTER);
		this.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
		createTextLabel();
		createTimerLabel();
	}
	
	public void createTextLabel() {
		Label gameOver = new Label("GAME OVER");
		gameOver.setFont(FONT);
		
		this.getChildren().add(gameOver);
	}
	
	public void createTimerLabel() {
		Label timerLabel = new Label("Timer");
		timerLabel.setFont(FONT);
		
		this.getChildren().add(timerLabel);
	}
}
