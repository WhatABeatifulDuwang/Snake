package Model;

import java.util.ArrayList;

public class Game {

	private final int MAX_ROWS = 15;
	private final int MAX_COLS = 19;
	
	private ArrayList<Spot> mouseList;
	private ArrayList<Spot> bearList;
	private ArrayList<Spot> fireList;
	private ArrayList<Spot> allSpotList;

	private Snake snake;
	
	public Game() {
		snake = new Snake();
		mouseList = new ArrayList<Spot>();
		bearList = new ArrayList<Spot>();
		fireList = new ArrayList<Spot>();
		allSpotList = new ArrayList<Spot>();
		startSpot();
	}
	
	public void update() {
		if (!isSnakeDead()) {
			snake.move();			
		}
	}
	
	public void startSpot() {
		mouseList.add(new Spot(Marker.MOUSE));
		bearList.add(new Spot(Marker.BEAR));
		fireList.add(new Spot(Marker.FIRE));
		allSpotList.addAll(mouseList);
		allSpotList.addAll(bearList);
		allSpotList.addAll(fireList);
	}
	
	public void generateNewSpot(int count) {
		if (count == 0) {
			mouseList.add(new Spot(Marker.MOUSE));			
			allSpotList.addAll(mouseList);
		}
		if (count == 1) {
			bearList.add(new Spot(Marker.BEAR));			
			allSpotList.addAll(bearList);
		}
		if (count == 2) {
			fireList.add(new Spot(Marker.FIRE));			
			allSpotList.addAll(fireList);
		}		
	}
	
	public ArrayList<Spot> getAllSpotList() {
		return allSpotList;
	}
	
	public boolean isSnakeDead() {
		boolean answer = false;
		
		if (snake.hitSelf()) {
			answer = true;
		}
		if (snake.getX() > MAX_COLS || snake.getX() < 0) {
			answer = true;
		}
		if (snake.getY() > MAX_ROWS || snake.getY() < 0) {
			answer = true;
		}
		for (int i = 0; i < allSpotList.size(); i++) {		
			if (snake.getX() == allSpotList.get(i).getPositionX() && snake.getY() == allSpotList.get(i).getPositionY()) {
				if (allSpotList.get(i).getMarker() == Marker.FIRE) {
					answer = true;
				}
				if (allSpotList.get(i).getMarker() == Marker.BEAR) {
					if (snake.getSize() < 5) {
						answer = true;
					}
				}
			}
		}
		
		return answer;
	}
	
	public Snake getSnake() {
		return snake;
	}
	
	public void setSnake(Snake snake) {
		this.snake = snake;
	}
}
