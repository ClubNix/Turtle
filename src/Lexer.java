import java.util.HashMap;

public class Lexer {
	private HashMap<String, TurtleAction> actionMap;

	public Lexer() {
		this.actionMap = new HashMap<String, TurtleAction>();
		this.actionMap.put("up", new TurtleAction() {
			public String action(Turtle turtle) {
				turtle.up();
				return turtle.getPosition().toString();
			}
		});
		this.actionMap.put("down", new TurtleAction() {
			public String action(Turtle turtle) {
				turtle.down();
				return turtle.getPosition().toString();
			}
		});
		this.actionMap.put("left", new TurtleAction() {
			public String action(Turtle turtle) {
				turtle.left();
				return turtle.getPosition().toString();
			}
		});
		this.actionMap.put("right", new TurtleAction() {
			public String action(Turtle turtle) {
				turtle.right();
				return turtle.getPosition().toString();
			}
		});
		this.actionMap.put("position", new TurtleAction() {
			public String action(Turtle turtle) {
				return turtle.getPosition().toString();
			}
		});
		this.actionMap.put("quit", new TurtleAction() {
			public String action(Turtle turtle) {
				return "bye";
			}
		});
	}

	public HashMap<String, TurtleAction> getActionMap() {
		return this.actionMap;
	}
}
