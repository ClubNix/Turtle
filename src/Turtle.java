public class Turtle{
	private double food;	//!< satiated percent
	private double life;	//!< healt percent

	public Turtle(){
		this.food = 50;
		this.life = 100;
	}

	public boolean reproduce(Turtle wife){
		if(this.food >= 85.0 && wife.food >= 85.0){
			// reproduction state ("game engine" can create another turtle)
			return true;
		}else{
			return false;
		}
	}
}
