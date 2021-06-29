package View;

import Controller.GameController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

public class DashBoard extends HBox {

	private final int PREFWIDTH = 760;
	private final int PREFHEIGHT = 50;
	private final int SLIDERWIDTH = 250;
	private final int SLIDERMIN = 1;
	private final int SLIDERMAX = 12;
	private final int SPACING = 20;
	private final int MAX_SPEED = 12;

	private int min;
	private int sec;
	private int ms;
	private int order;
	private int speedValue = 1;
	private boolean checkPoint;
	private String endTime;

	private Timeline timeline;
	private Label playTime;
	private Slider slider;
	private Button run;
	private Button exit;
	
	private GameController controller;

	public DashBoard(GameController controller) {
		this.controller = controller;
		this.setPrefSize(PREFWIDTH, PREFHEIGHT);
		this.setAlignment(Pos.CENTER);
		this.setSpacing(SPACING);
		createTimer();
		createPauseButton();
		createExitButton();
		createSpeedSlicer();
		createPlaytimeLabel();
	}

	public void createPauseButton() {
		run = new Button("Start");
		run.setOnAction(e -> {
			switchButtons();
		});

		this.getChildren().add(run);
	}

	private void switchButtons() {
		if (run.getText().equals("Start")) {
			startTimer();
			controller.startGame();
			run.setText("Pause");
		} else {
			pauseTimer();
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
		slider = new Slider(SLIDERMIN, SLIDERMAX, SLIDERMIN);
		slider.setMinWidth(SLIDERWIDTH);
		slider.setMinorTickCount(SLIDERMIN);
		slider.setMajorTickUnit(SLIDERMIN);
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		slider.setDisable(true);

		this.getChildren().add(slider);
	}

	public void createPlaytimeLabel() {
		playTime = new Label();
		playTime.setText("00:00:000");

		this.getChildren().add(playTime);
	}

	// creates a timer which tracks the time and calls some methods every 5 seconds
	public void createTimer() {
		timeline = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				setTime();
				if (sec != 0 && sec % 5 == 0 && checkPoint) {
					if (speedValue < MAX_SPEED) {
						speedValue = speedValue + 1;
						slider.setValue(speedValue);
						controller.increaseSpeed(speedValue);
					}
					controller.getGame().generateNewSpot(order);
					controller.generateBodyPart();
					order++;
					if (order == 3) {
						order = 0;
					}
					checkPoint = false;
				}
			}
		}));

		timeline.setCycleCount(Timeline.INDEFINITE);
	}

	// converts time to string for playtime label
	public void setTime() {
		if (ms == 1000) {
			ms = 0;
			sec++;
			checkPoint = true;
		}

		if (sec == 60) {
			sec = 0;
			min++;
		}

		playTime.setText((((min / 10) == 0) ? "0" : "") + min + ":" + (((sec / 10) == 0) ? "0" : "") + sec + ":"
				+ (((ms / 10) == 0) ? "00" : (((ms / 100) == 0) ? "0" : "")) + ms++);
		setEndTime(playTime.getText());
	}

	public void pauseTimer() {
		timeline.stop();
	}

	public void startTimer() {
		timeline.play();
	}

	public void setEndTime(String input) {
		endTime = input;
	}

	public String getEndTime() {
		return endTime;
	}
}
