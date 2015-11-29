import java.util.HashMap;

public class TurtleLexer {
	private HashMap<String, TurtleAction> actionMap;

	public TurtleLexer() {
		this.actionMap = new HashMap<String, TurtleAction>();
		this.actionMap.put("up", new TurtleAction() {
			public String perform(Turtle turtle) {
				turtle.up();
				return turtle.getPosition().toString();
			}
		});
		this.actionMap.put("down", new TurtleAction() {
			public String perform(Turtle turtle) {
				turtle.down();
				return turtle.getPosition().toString();
			}
		});
		this.actionMap.put("left", new TurtleAction() {
			public String perform(Turtle turtle) {
				turtle.left();
				return turtle.getPosition().toString();
			}
		});
		this.actionMap.put("right", new TurtleAction() {
			public String perform(Turtle turtle) {
				turtle.right();
				return turtle.getPosition().toString();
			}
		});
		this.actionMap.put("position", new TurtleAction() {
			public String perform(Turtle turtle) {
				return turtle.getPosition().toString();
			}
		});
		this.actionMap.put("quit", new TurtleAction() {
			public String perform(Turtle turtle) {
				return "bye";
			}
		});
	}

	public TurtleAction getAction(String actionName) {
		return this.actionMap.get(actionName);
	}
}
