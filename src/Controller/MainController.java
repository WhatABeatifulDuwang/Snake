package Controller;

import View.GameOverScene;
import View.GameScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController extends Application{

	private Stage stage;
	private GameController game;
	
	public static void startUp(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("PROG4 ASS Snake Ody Chen");
		game = new GameController(this);
		Scene gameScene = new GameScene(game);
		primaryStage.setScene(gameScene);
		primaryStage.setResizable(false);
		this.stage = primaryStage;
		this.stage.show();
	}
	
	public void switchToGameOver() {
		Scene gameOverScene = new GameOverScene(game);
		this.stage.setScene(gameOverScene);
		this.stage.show();
	}
}
