package Model;

import java.util.ArrayList;

public class Snake extends BodyPart{

	private final int DEFAULT_START_X = 8;
	private final int DEFAULT_START_Y = 6;
	
	private ArrayList<BodyPart> body;
	
	private int amountOfBodyParts;
	private int speed;
	
	public Snake() {
		super();
		positionX = DEFAULT_START_X;
		positionY = DEFAULT_START_Y;
		direction = Direction.RIGHT;
		amountOfBodyParts = 4;
		body = new ArrayList<BodyPart>(); 
		
		for (int i = 1; i <= amountOfBodyParts; i++) {			
			BodyPart startPart = new BodyPart();
			startPart.setPositionX(positionX - i); 
			startPart.setPositionY(positionY);
			startPart.setDirection(Direction.RIGHT);
			body.add(startPart);
		}
	}
	
	@Override
	public void move() {
		super.move();
		moveAllBodyParts();			
	}
	
	public void moveAllBodyParts() {
		Direction nextDirection = direction;
		for (int i = body.size() - 1; i >= 0; i--) {		
			body.get(i).move();
			
			if (i != 0) {
				nextDirection = body.get(i - 1).getDirection();
			} else {
				nextDirection = direction;
			}
			body.get(i).setDirection(nextDirection);
		}
	}
	
	public void addBodyPart() {
		BodyPart tail = body.get(body.size() - 1);
		BodyPart newBodyPart = new BodyPart();
		if (tail.getDirection() == Direction.UP) {
			newBodyPart.setPositionX(tail.getPositionX());
			newBodyPart.setPositionY(tail.getPositionY() + 1);
		}
		if (tail.getDirection() == Direction.RIGHT) {
			newBodyPart.setPositionX(tail.getPositionX() - 1);
			newBodyPart.setPositionY(tail.getPositionY());
		}
		if (tail.getDirection() == Direction.DOWN) {
			newBodyPart.setPositionX(tail.getPositionX());
			newBodyPart.setPositionY(tail.getPositionY() - 1);
		}
		if (tail.getDirection() == Direction.LEFT) {
			newBodyPart.setPositionX(tail.getPositionX() + 1);
			newBodyPart.setPositionY(tail.getPositionY());
		}

		newBodyPart.setDirection(tail.getDirection());
		body.add(newBodyPart);
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
