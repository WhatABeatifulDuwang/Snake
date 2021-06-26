package Model;

public class Game {

	private final int MAX_ROWS = 15;
	private final int MAX_COLS = 19;
	
	private Snake snake;
	private Spot spot;
	
	public Game() {
		snake = new Snake();
	}
	
	public void update() {
		if (!isSnakeDead()) {
			snake.move();			
		}
	}
	
	public boolean isSnakeDead() {
		boolean answer = false;
		
//		if (snake.hitSelf()) {
//			answer = true;
//		}
		if (snake.getX() > MAX_COLS || snake.getX() < 0) {
			answer = true;
		}
		if (snake.getY() > MAX_ROWS || snake.getY() < 0) {
			answer = true;
		}
//		if (snake.getX() == spot.getPositionX() && snake.getY() == spot.getPositionY()) {
//			if (spot.getMarker() == Marker.FIRE) {
//				answer = true;
//			}
//			if (spot.getMarker() == Marker.BEAR) {
//				if (snake.getSize() < 5) {
//					answer = true;
//				}
//			}
//		}
		
		return answer;
	}
	
	public Snake getSnake() {
		return snake;
	}
	
	public void setSnake(Snake snake) {
		this.snake = snake;
	}
	
	public Spot getSpot() {
		return spot;
	}
	
	public void setSpot(Spot spot) {
		this.spot = spot;
	}
}
