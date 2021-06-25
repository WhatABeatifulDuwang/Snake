package View;

import Controller.GameController;
import Controller.Timer;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

public class DashBoard extends HBox{

	private final int PREFWIDTH = 760;
	private final int PREFHEIGHT = 50;
	private final int SLIDERMIN = 1;
	private final int SLIDERMAX = 12;
	private final int SPACING = 20;
	
	private AnimationTimer timer;
	private Timeline timeline;
//	private DoubleProperty minutes = new SimpleDoubleProperty();
//	private DoubleProperty splitMinutes = new SimpleDoubleProperty();
//	private DoubleProperty seconds = new SimpleDoubleProperty();
//	private DoubleProperty splitSeconds = new SimpleDoubleProperty();
//	private Duration time = Duration.ZERO;
//	private Duration splitTime = Duration.ZERO;
//	
//	private boolean running = true;
	private int min;
	private int sec;
	private int ms;
	private int speedValue;
	
	private Label playTime;
	private Button run;
	private Button exit;
	private GameController controller;
	
	public DashBoard(GameController controller) {
		this.controller = controller;
		this.setPrefSize(PREFWIDTH, PREFHEIGHT);
		this.setAlignment(Pos.CENTER);
		this.setSpacing(SPACING);
		createPauseButton();
		createExitButton();
		createSpeedSlicer();
		createPlaytimeLabel();
		createTimer();
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
			startTimer();
			controller.startGame();
			run.setText("Pause");			
		} else  {
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
		Slider slider = new Slider(SLIDERMIN, SLIDERMAX, SLIDERMAX);
		slider.setMinorTickCount(SLIDERMIN);
		slider.setMajorTickUnit(SLIDERMIN);
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		slider.setPadding(new Insets(5));
		slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				speedValue = (int) slider.getValue();
				controller.increaseSpeed(speedValue);
			}
		});
		
		this.getChildren().add(slider);
	}
	
	public void createPlaytimeLabel() {
		playTime = new Label();
		playTime.setText("00:00:000");
		
		this.getChildren().add(playTime);
	}
	
	public void createTimer() {
		timer = new Timer(1_000_000) {
			
			@Override
			public void doAction() {
				timeline = new Timeline(
						new KeyFrame(Duration.millis(1), 
						new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent event) {
								setTime();
							}
				}));
				
				timeline.setCycleCount(Timeline.INDEFINITE);
				timeline.play();
//				if (running) {
//					timeline.play();
//					running = false;
//				} else {
//					timeline.pause();
//					running = true;
//				}
			}
		};
	}
//                if (timeline != null) {
//                    splitTime = Duration.ZERO;
//                    splitMinutes.set(splitTime.toMinutes());
//                    splitSeconds.set(splitTime.toSeconds());
//                } else {
//                    timeline = new Timeline(
//                        new KeyFrame(Duration.seconds(1),
//                        new EventHandler<ActionEvent>() {
//                            @Override
//                            public void handle(ActionEvent t) {
//                                Duration duration = ((KeyFrame)t.getSource()).getTime();
//                                time = time.add(duration);
//                                splitTime = splitTime.add(duration);
//                                minutes.set(time.toSeconds());
//                                splitMinutes.set(splitTime.toMinutes());
//                                seconds.set(time.toSeconds());
//                                splitSeconds.set(splitTime.toSeconds());
//                            }
//                        }), new KeyFrame(Duration.millis(1))
//                    ); 
//                    timeline.setCycleCount(Timeline.INDEFINITE);
//                    timeline.play();
//                }
			
	public void setTime() {
		if (ms == 1000) {
			ms = 0;
			sec++;
		}
		
		if (sec == 60) {
			sec = 0;
			min++;
		}
		
		playTime.setText((((min/10) == 0) ? "0" : "") + min + ":"
				 + (((sec/10) == 0) ? "0" : "") + sec + ":" 
					+ (((ms/10) == 0) ? "00" : (((ms/100) == 0) ? "0" : "")) + ms++);
	}
	
	public void pauseTimer() {
		timer.stop();
	}
	
	public void startTimer() {
		timer.start();
	}

}
