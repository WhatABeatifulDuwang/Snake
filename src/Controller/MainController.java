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
		Scene scene = new GameScene(new GameController());
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

}
