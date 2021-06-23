package View;

import Controller.GameController;
import Controller.Timer;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;

public class DashBoard extends HBox{

	private final static int PREFWIDTH = 760;
	private final static int PREFHEIGHT = 600;
	private final static int SLIDERMIN = 1;
	private final static int SLIDERMAX = 12;
	private final static int SPACING = 20;
	private Button run;
	private Button exit;
	private GameController controller;
	
	public DashBoard(GameController controller) {
		this.setPrefSize(PREFWIDTH, PREFHEIGHT);
		this.setAlignment(Pos.CENTER);
		this.setSpacing(SPACING);
		createPauseButton();
		createExitButton();
		createSpeedSlicer();
		createPlaytimeLabel();
	}
	
	public void createPauseButton() {
		run = new Button("Start");
		run.setOnAction(e -> {
			createText();
		});
		
		this.getChildren().add(run);
	}
	
	private void createText() {
		if (run.getText().equals("Start")) {
			controller.startGame();
			run.setText("Pause");			
		} else {
			controller.pauseGame();
			run.setText("Start");
		}
	}
	
	public void createExitButton() {
		exit = new Button("Exit");
		exit.setOnAction(e -> Platform.exit());
		
		this.getChildren().add(exit);
	}
	
	public void createSpeedSlicer() {
		Slider slider = new Slider(SLIDERMIN, SLIDERMAX, SLIDERMAX);
		slider.setMinorTickCount(SLIDERMIN);
		slider.setMajorTickUnit(SLIDERMIN);
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		slider.setPadding(new Insets(5));
		
		this.getChildren().add(slider);
	}
	
	public void createPlaytimeLabel() {
		Label label = new Label("Timer");
		
		this.getChildren().add(label);
	}
	

}
