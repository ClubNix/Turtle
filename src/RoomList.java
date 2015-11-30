import java.util.HashMap;

public class RoomList {
	private HashMap<String, Room> roomList;

	RoomList() {
		this.roomList = new HashMap<String, Room>();
	}

	public Room get(String name) {
		return this.roomList.get(name);
	}

	public void create(String name) {
		this.roomList.put(name, new Room(name));
	}

	public void delete(String name) {
		this.roomList.remove(name);
	}
}
