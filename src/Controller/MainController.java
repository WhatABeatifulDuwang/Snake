package Controller;

import View.GameScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController extends Application{
	
	public static void startUp(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("PROG4 ASS Snake Ody Chen");
		GameController game = new GameController();
		Scene gameScene = new GameScene(game);
		game.setGameScene(gameScene);
		primaryStage.setScene(gameScene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}
