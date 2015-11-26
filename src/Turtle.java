public class Turtle {
	private double food;	//!< satiation percent
	private double life;	//!< health percent
	private Position position;

	public Turtle() {
		this.food = 50;
		this.life = 100;
		this.position = new Position();
	}

	public boolean reproduce(Turtle wife) {
		if (this.food >= 85.0 && wife.food >= 85.0) {
			// reproduction state ("game engine" can create another turtle)
			return true;
		} else {
			return false;
		}
	}

	public void up() {
		int y = this.position.getY();
		position.setY(y+1);
	}

	public void down() {
		int y = this.position.getY();
		position.setY(y-1);
	}

	public void left() {
		int x = this.position.getX();
		position.setY(x-1);
	}

	public void right() {
		int x = this.position.getX();
		position.setY(x+1);
	}

	public Position getPosition() {
		return new Position(this.position); // const Position* getPosition();
	}
}
