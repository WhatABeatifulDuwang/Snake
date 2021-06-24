package View;

import Controller.GameController;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DrawPane extends GridPane{

	private final static int X = 15;
	private final static int Y = 19;
	private final static int PREFWIDTH = 760;
	private final static int PREFHEIGHT = 600;
	private final static int SQUARESIZE = 40;
	
	public DrawPane(GameController controller) {
		this.setPrefSize(PREFWIDTH, PREFHEIGHT);
		this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
		//Canvas canvas = new Canvas(PREFWIDTH * 25, PREFHEIGHT * 25);
		draw(new int[X][Y]);
	}
	
	public void draw(int[][] board) {
		for (int y = 0; y < 19; y++) {
			for (int x = 0; x < 15; x++) {
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
	}
}
