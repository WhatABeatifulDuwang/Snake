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
	
	// initialises first spots
	public void startSpot() {
		ArrayList<Integer[]> possibleSpots = getAllPossibleSpots();
		mouseList.add(new Spot(Marker.MOUSE, possibleSpots));
		bearList.add(new Spot(Marker.BEAR, possibleSpots));
		fireList.add(new Spot(Marker.FIRE, possibleSpots));
		allSpotList.addAll(mouseList);
		allSpotList.addAll(bearList);
		allSpotList.addAll(fireList);
	}
	
	// updates game if the dead check condition isn't met
	public void update() {
		if (!isSnakeDead()) {
			snake.move();
			checkCollision();
		}
	}
	
	// check condition if the snake is dead
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
					if ((snake.getSize() + 1) < 5) {
						answer = true;
					}
				}
			}
		}
		
		return answer;
	}
	
	// checks when snake reaches a special spot and interact with it
	private void checkCollision() {
		for (int i = 0; i < allSpotList.size(); i++) {		
			if (snake.getX() == allSpotList.get(i).getPositionX() && snake.getY() == allSpotList.get(i).getPositionY()) {
				if (allSpotList.get(i).getMarker() == Marker.BEAR) {
					if ((snake.getSize() + 1) >= 5) {						
						snake.removeBodyPart();
						removeSpot(bearList, allSpotList.get(i));
						allSpotList.remove(i);
						return;
					}
				}
				if (allSpotList.get(i).getMarker() == Marker.MOUSE) {
					int counter = 0;
					while (counter < 5) {
						counter++;
						snake.addBodyPart();
					}
					removeSpot(mouseList, allSpotList.get(i));
					allSpotList.remove(i);
					return;
				}
			}
		}
	}
	
	// creates new spots
	public void generateNewSpot(int count) {
		ArrayList<Integer[]> possibleSpots = getAllPossibleSpots();
		if (count == 0) {
			Spot spot = new Spot(Marker.MOUSE, possibleSpots);
			mouseList.add(spot);			
			allSpotList.add(spot);
		}
		if (count == 1) {
			Spot spot = new Spot(Marker.BEAR, possibleSpots);
			bearList.add(spot);			
			allSpotList.add(spot);
		}
		if (count == 2) {
			Spot spot = new Spot(Marker.FIRE, possibleSpots);
			fireList.add(spot);			
			allSpotList.add(spot);
		}		
	}
	
	// checks the placement for the spots so it wouldn't spawn on the snake or an existing spot
	private ArrayList<Integer[]> getAllPossibleSpots() {
		ArrayList<Integer[]> possibleSpots = new ArrayList<Integer[]>();
		for (int y = 0; y < 15; y++) {
			for (int x = 0; x < 19; x++) {
				if (snake.isHead(x, y)) {
					continue;
				}
				if (snake.getBodyPart(x, y) != null) {
					continue;
				}
				if (getSpot(x, y) != null) {
					continue;
				}
				
				possibleSpots.add(new Integer[] {x, y});				
			}
		}
		
		return possibleSpots;
	}

	public ArrayList<Spot> getAllSpotList() {
		return allSpotList;
	}
	
	// removes special spot from the game
	private void removeSpot(ArrayList<Spot> spots, Spot spot) {
		for (int i = 0; i < spots.size(); i++) {
			if (spots.get(i) == spot) {
				spots.remove(i);
			}
		}
	}
	
	public Spot getSpot(int x, int y) {
		for (int i = 0; i < allSpotList.size(); i++) {
			if (allSpotList.get(i).getPositionX() == x && allSpotList.get(i).getPositionY() == y) {
				return allSpotList.get(i);
			}
		}
		
		return null;
	}
	
	public Snake getSnake() {
		return snake;
	}
	
	public void setSnake(Snake snake) {
		this.snake = snake;
	}
}
