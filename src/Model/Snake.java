package Model;

import java.util.ArrayList;

public class Snake {

	private final int DEFAULT_START_X = 8;
	private final int DEFAULT_START_Y = 6;
	
	private ArrayList<BodyPart> body;
	private Direction direction;
	
	private int amountOfBodyParts;
	private int positionX;
	private int positionY;
	private int speed;
	
	public Snake() {
		positionX = DEFAULT_START_X;
		positionY = DEFAULT_START_Y;
		direction = Direction.RIGHT;
		amountOfBodyParts = 4;
		body = new ArrayList<BodyPart>(); 
		
		for (int i = 0; i <= amountOfBodyParts; i++) {			
			BodyPart startPart = new BodyPart();
			startPart.setPositionX(positionX - i); 
			startPart.setPositionY(positionY);
			startPart.setDirection(Direction.RIGHT);
			body.add(startPart);
		}
	}
	
	public void move() {
		
		switch(direction) {
		case UP:
			positionY--;			
			moveBody(positionX, positionY + 1);
			break;
		case RIGHT:
			positionX++;
			moveBody(positionX - 1, positionY);
			break;
		case DOWN:
			positionY++;
			moveBody(positionX, positionY - 1);
			break;
		case LEFT:
			positionX--;
			moveBody(positionX + 1, positionY);
			break;
		}
	}
	
	public void moveBody(int x, int y) {
		for (int i = 0; i <= amountOfBodyParts; i++) {				
			body.get(i).setPositionX(x);
			body.get(i).setPositionY(y);
		}
	}
	
	public boolean isHead(int x, int y) {
		if (positionX == x && positionY == y) {
			return true;
		}
		
		return false;
	}
	
	public BodyPart getBodyPart(int x, int y) {
		for (int i = 0; i < body.size(); i++) {
			if (body.get(i).isPosition(x, y)) {
				return body.get(i);
			}
		}
		
		return null;
	}
	
	public boolean hitSelf() {
		boolean response = false;
		for (int i = 0; i < body.size(); i++) {
			if (positionX == body.get(i).getPositionX() && positionY == body.get(i).getPositionY()) {
				response = true;
			}
		}
		
		return response;
	}
	
	public int getSize() {
		return body.size();
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void setX(int positionX) {
		this.positionX = positionX;
	}
	
	public int getX() {
		return positionX;
	}
	
	public void setY(int positionY) {
		this.positionY = positionY;
	}
	
	public int getY() {
		return positionY;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public void setDirection(Direction direction) {
		switch(direction) {
		case UP:
			this.direction = Direction.UP;
			break;
		case RIGHT:
			this.direction = Direction.RIGHT;
			break;
		case DOWN:
			this.direction = Direction.DOWN;
			break;
		case LEFT:
			this.direction = Direction.LEFT;
			break;
		default:
			break;
		}
	}
}
