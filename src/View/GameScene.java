package View;

import Controller.GameController;
import Model.Direction;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class GameScene extends Scene{
	
	public GameScene(GameController controller) {
		super(new Pane());
		BorderPane game = new BorderPane();
		game.setCenter(controller.getBoard());;
		game.setBottom(controller.getSettings());
		setDirection(controller);
		setRoot(game);
	}
	
	public void switchRoot(Pane root) {
		setRoot(root);
	}
	
	// keeps track off keyboard input for WASD
	public void setDirection(GameController controller) {
		this.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
			if (key.getCode() == KeyCode.W) {
				controller.getGame().getSnake().setDirection(Direction.UP);
			}
			if (key.getCode() == KeyCode.D) {
				controller.getGame().getSnake().setDirection(Direction.RIGHT);
			}
			if (key.getCode() == KeyCode.S) {
				controller.getGame().getSnake().setDirection(Direction.DOWN);
			}
			if (key.getCode() == KeyCode.A) {
				controller.getGame().getSnake().setDirection(Direction.LEFT);
			}
		});
	}
}
