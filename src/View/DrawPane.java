package View;

import Controller.GameController;
import Model.BodyPart;
import Model.Game;
import Model.Marker;
import Model.Snake;
import Model.Spot;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class DrawPane extends GridPane{

	private final int MAX_ROWS = 15;
	private final int MAX_COLS = 19;
	private final int PREFWIDTH = 760;
	private final int PREFHEIGHT = 600;
	private final int SQUARESIZE = 40;
	private final int CIRCLESIZE = 20;
    private final int CIRCLE_X = (PREFWIDTH - CIRCLESIZE) / 2;
    private final int CIRCLE_Y = (PREFHEIGHT - CIRCLESIZE) / 2;
	
	public DrawPane(GameController controller) {
		this.setPrefSize(PREFWIDTH, PREFHEIGHT);
		this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
		draw(null);
	}
	
	public void draw(Game game) {
		for (int x = 0; x < MAX_COLS; x++) {
			for (int y = 0; y < MAX_ROWS; y++) {
				drawEmptyCell(x, y);
				
				if (game != null) {
					drawSnakeHead(game.getSnake(), x, y);					
					drawSnakeBodyPart(game.getSnake().getBodyPart(x, y), x, y);
					drawRandomSpot(game.getSpot());
				}				
			}
		}
	}
	
	public void update(Game game) {
		this.getChildren().clear();
		draw(game);
	}
	
	private void drawSnakeHead(Snake snake, int x, int y) {
		if (snake == null) return;
		if (!snake.isHead(x, y)) return;
		
		Circle head = new Circle(CIRCLE_X, CIRCLE_Y, CIRCLESIZE);
		head.setFill(Color.RED);	
		
		this.add(head, x, y);
	}
	
	private void drawSnakeBodyPart(BodyPart body, int x, int y) {
		if (body == null) return;
//		if (body.isPosition(x, y)) return;
		
		Circle bodyPart = new Circle(CIRCLE_X, CIRCLE_Y, CIRCLESIZE);
		bodyPart.setFill(Color.YELLOW);			
		this.add(bodyPart, x, y);
	}
	
	private void drawRandomSpot(Spot spot) {
		if (spot == null) return;
		
		ImageView randomSpot = new ImageView();
		if (spot.getMarker() == Marker.FIRE) {
			randomSpot.setImage(new Image("/Resources/images/fire.png"));
		}
		if (spot.getMarker() == Marker.BEAR) {
			randomSpot.setImage(new Image("/Resources/images/bear.png"));
		}
		if (spot.getMarker() == Marker.MOUSE) {
			randomSpot.setImage(new Image("/Resources/images/mouse.png"));
		}
		
		this.add(randomSpot, spot.getPositionX(), spot.getPositionY());
	}
	
	private void drawEmptyCell(int x, int y) {
		Rectangle square = new Rectangle();
		Text text = new Text(x + ", " + y);
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

		this.add(square, x, y);
		this.add(text, x, y);
	}
}
