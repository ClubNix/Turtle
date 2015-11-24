public class Turtle {
	private double food;	//!< satiation percent
	private double life;	//!< health percent
	private int x;
	private int y;

	public Turtle() {
		this.food = 50;
		this.life = 100;
		this.x = 0;
		this.y = 0;
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
		this.y++;
	}

	public void down() {
		this.y--;
	}

	public void left() {
		this.x--;
	}

	public void right() {
		this.x++;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public String getStringPosition() {
		return "x:" + this.x + ",y:" + this.y;
	}
}
