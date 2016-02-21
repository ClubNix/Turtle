import java.util.HashMap;

public class PlayerList {
   private HashMap<String,Player> playerList;

	PlayerList() {
		this.playerList = new HashMap<String, Player>();
	}

	public Player get(String id) {
		return this.playerList.get(id);
	}

	public void add(String id, Player player) {
		this.playerList.put(id, player);
	}

	public int size() {
		return this.playerList.size();
	}
}
