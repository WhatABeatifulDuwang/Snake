package Model;

public class Game {

	private Snake snake;
	private Spot spot;
	
	public Game() {
		
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
