import java.util.HashMap;

public class Lexer {
	private HashMap<String, TurtleAction> actionMap;

	public Lexer() {
		this.actionMap = new HashMap<String, TurtleAction>();
		this.actionMap.put("up", new TurtleAction() {
			public String action(Turtle turtle) {
				turtle.up();
				return "up";
			}
		});
		this.actionMap.put("down", new TurtleAction() {
			public String action(Turtle turtle) {
				turtle.down();
				return "down";
			}
		});
		this.actionMap.put("left", new TurtleAction() {
			public String action(Turtle turtle) {
				turtle.left();
				return "left";
			}
		});
		this.actionMap.put("right", new TurtleAction() {
			public String action(Turtle turtle) {
				turtle.right();
				return "right";
			}
		});
		this.actionMap.put("position", new TurtleAction() {
			public String action(Turtle turtle) {
				return turtle.getStringPosition();
			}
		});
		this.actionMap.put("quit", new TurtleAction() {
			public String action(Turtle turtle) {
				return "quit";
			}
		});
	}

	public HashMap<String, TurtleAction> getActionMap() {
		return this.actionMap;
	}
}
