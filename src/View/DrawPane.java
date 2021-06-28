package View;

import java.util.ArrayList;

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

public class DrawPane extends GridPane {

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
		draw(controller.getGame());
	}

	public void draw(Game game) {
		for (int x = 0; x < MAX_COLS; x++) {
			for (int y = 0; y < MAX_ROWS; y++) {
				drawEmptyCell(x, y);

				if (game != null) {
					drawSnakeHead(game.getSnake(), x, y);
					drawSnakeBodyPart(game.getSnake().getBodyPart(x, y), x, y);
				}
			}
		}
		if (game != null) {
			drawRandomSpot(game.getAllSpotList());
		}
	}

	public void update(Game game) {
		this.getChildren().clear();
		draw(game);
	}

	private void drawSnakeHead(Snake snake, int x, int y) {
		if (snake == null)
			return;
		if (!snake.isHead(x, y))
			return;

		Circle head = new Circle(CIRCLE_X, CIRCLE_Y, CIRCLESIZE);
		head.setFill(Color.RED);

		this.add(head, x, y);
	}

	private void drawSnakeBodyPart(BodyPart body, int x, int y) {
		if (body == null)
			return;

		Circle bodyPart = new Circle(CIRCLE_X, CIRCLE_Y, CIRCLESIZE);
		bodyPart.setFill(Color.YELLOW);
		this.add(bodyPart, x, y);
	}

	private void drawRandomSpot(ArrayList<Spot> spots) {
		if (spots == null)
			return;

		Image image = null;
		for (int i = 0; i < spots.size(); i++) {
			ImageView randomSpot = new ImageView();
			if (spots.get(i).getMarker() == Marker.FIRE) {
				image = new Image("Resources/images/fire.png");
			}
			if (spots.get(i).getMarker() == Marker.BEAR) {
				image = new Image("Resources/images/bear.png");
			}
			if (spots.get(i).getMarker() == Marker.MOUSE) {
				image = new Image("Resources/images/mouse.png");
			}

			randomSpot.setImage(image);
			randomSpot.setFitHeight(SQUARESIZE);
			randomSpot.setFitWidth(SQUARESIZE);

			this.add(randomSpot, spots.get(i).getPositionX(), spots.get(i).getPositionY());
		}
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

		this.add(square, x, y);
	}
}
