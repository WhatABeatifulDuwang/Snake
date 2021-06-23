package Model;

public class Snake {

	private BodyPart body;
	private int[][] position;
	
	public Snake() {
		
	}
	
	public BodyPart getBody() {
		return body;
	}
	
	public void setBody(BodyPart body) {
		this.body = body;
	}
	
	public int[][] getPosition() {
		return position;
	}
	
	public void setPosition(int[][] position) {
		this.position = position;
	}
}
