public class Player {
	private int id;
	private String key; //unused for now
	private String name;
	private Turtle turtle;

	public Player(int id, String key, String name, Turtle turtle) {
		this.id = id;
		this.key = key;
		this.name = name;
		this.turtle = turtle;
	}

	public Player(String name) {
		this((int)System.currentTimeMillis(), null, name, new Turtle());
	}

	public Player() {
		this("");
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
      this.name = name;
	}

	public Turtle getTurtle() {
		return turtle;
	}
}
