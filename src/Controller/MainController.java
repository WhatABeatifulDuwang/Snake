package Controller;

import View.GameScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainController extends Application{

	public static void startUp(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("PROG4 ASS Snake Ody Chen");
		primaryStage.setScene(new GameScene(new GameController()));
		primaryStage.setResizable(false);
		primaryStage.show();
	}

}
