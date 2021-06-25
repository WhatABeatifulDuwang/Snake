package View;

import Controller.GameController;
import Model.Direction;
import Model.Game;
import Model.Snake;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class DrawPane extends GridPane{

	private final int MAX_X = 15;
	private final int MAX_Y = 19;
	private final int PREFWIDTH = 760;
	private final int PREFHEIGHT = 600;
	private final int SQUARESIZE = 40;
	private final int CIRCLESIZE = 20;
    private final int CIRCLE_X = (PREFWIDTH - CIRCLESIZE) / 2;
    private final int CIRCLE_Y = (PREFHEIGHT - CIRCLESIZE) / 2;
    
    private GameController controller;
	
	public DrawPane(GameController controller) {
		this.controller = controller;
		this.setPrefSize(PREFWIDTH, PREFHEIGHT);
		this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
		//Canvas canvas = new Canvas(PREFWIDTH * 25, PREFHEIGHT * 25);
		draw(null);
	}
	
	public void draw(Game game) {
		for (int y = 0; y < MAX_Y; y++) {
			for (int x = 0; x < MAX_X; x++) {
				drawEmptyCell(x, y);
				
				if (game != null) {
					drawSnake(game.getSnake(), x, y);					
					checkDirection(game.getSnake());
				}				
			}
		}
	}
	
	public void update(Game game) {
		this.getChildren().clear();
		draw(game);
	}
	
	private void drawSnake(Snake snake, int x, int y) {
		if (snake == null) return;
		if (!snake.isHead(x, y)) return;
		
		Circle head = new Circle(CIRCLE_X, CIRCLE_Y, CIRCLESIZE);
		head.setFill(Color.RED);	
		
		for (int count = 0; count < snake.getBody().length; count++) {
			Circle body = new Circle(CIRCLE_X, CIRCLE_Y, CIRCLESIZE);
			body.setFill(Color.YELLOW);			
			this.add(body, y, x + count);
		}
		
		this.add(head, y, x);
	}
	
	private void checkDirection(Snake snake) {
		this.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
			if (key.getCode() == KeyCode.W) {
				snake.getBody()[0].setDirection(Direction.UP);
				controller.move(Direction.UP);
			}
			if (key.getCode() == KeyCode.D) {
				snake.getBody()[0].setDirection(Direction.RIGHT);
				controller.move(Direction.RIGHT);
			}
			if (key.getCode() == KeyCode.S) {
				snake.getBody()[0].setDirection(Direction.DOWN);
				controller.move(Direction.DOWN);
			}
			if (key.getCode() == KeyCode.A) {
				snake.getBody()[0].setDirection(Direction.LEFT);
				controller.move(Direction.LEFT);
			}
		});
	}
	
	private void drawEmptyCell(int x, int y) {
		Rectangle square = new Rectangle();
		square.setHeight(SQUARESIZE);
		square.setWidth(SQUARESIZE);
		if (x % 2 == 0 && y % 2 == 0) {
			square.setFill(Color.DARKGRAY);					
		} 
		if (x % 2 == 0 && y % 2 != 0) {
			square.setFill(Color.GRAY);
		}
		if (x % 2 != 0 && y % 2 == 0) {
			square.setFill(Color.DIMGRAY);
		}
		if (x % 2 != 0 && y % 2 != 0) {
			square.setFill(Color.LIGHTGRAY);
		}

		this.add(square, y, x);
	}
}
