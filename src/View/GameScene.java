package View;

import Controller.GameController;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class GameScene extends Scene{
	
	public GameScene(GameController controller) {
		super(new Pane());
		BorderPane game = new BorderPane();
		game.setCenter(controller.getBoard());;
		game.setBottom(controller.getSettings());
		setRoot(game);
	}
	
	public void switchRoot(Pane root) {
		setRoot(root);
	}

}
