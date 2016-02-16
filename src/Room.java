import java.util.HashMap;

public class Room {
	private String name;
	private PlayerList playerList;

	public Room(String name) {
		this.name = name;
		this.playerList = new PlayerList();
	}
}
