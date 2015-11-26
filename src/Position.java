public class Position{
	private int x;
	private int y;

	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}

	public Position(){
		this(0,0);
	}

	public Position(Position p){
		this(p.getX(), p.getY());
	}

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}

	public void setX(int x){
		this.x = x;
	}

	public void setY(int y){
		this.y = y;
	}

	@Override
	public String toString() {
		return String.format("(%d,%d)",getX(),getY());
	}
}
