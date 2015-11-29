import org.zeromq.ZMQ;
import java.nio.charset.StandardCharsets;

public class Server {
	private ZMQ.Context context;
	private ZMQ.Socket socket;
	private TurtleLexer lexer;
	private Map map;

	private PlayerList playerList;
	private int idPool;

	public Server(int port) {
		lexer = new TurtleLexer();
		map = new Map(10, 10);
		this.context = ZMQ.context(1);
		this.socket = context.socket(ZMQ.REP);
		System.out.println("tcp://*:"+port);
		this.socket.bind("tcp://*:"+port);
		this.playerList = new PlayerList();
		int idPool = 0;
	}

	public void run() {
		String message;
		boolean quit = false;
		do {
			message = socket.recvStr();
			String response = "can't parse "+message;
			Lexer l = new Lexer(message);
			Player currentPlayer = null;
			Turtle currentTurtle = null;
			while(l.hasNextToken()) {
            Token t = l.nextToken();
				switch(t.getType()) {
					case HELLO:
						playerList.add(Integer.toString(idPool), new Player(idPool));
						response = Integer.toString(idPool);
						idPool++;
						break;

					case TURTLE:
						if(currentPlayer != null) {
							currentTurtle = currentPlayer.getTurtle();
						}
						response = "using turtle "+currentTurtle.toString();
						break;

					case ID:
						currentPlayer = playerList.get(t.getValue());
						response = "using player " + currentPlayer.getId();
						break;

					case STRING:
						if(currentTurtle != null) {
							TurtleAction action = lexer.getAction(t.getValue());
							response = action != null ? action.perform(currentTurtle) : "unknow " + message;
						}
						break;

					case QUIT:
						quit = true;
                  response = "bye";
                  break;

					default:
						break;
				}
			}
			//String response = message;
			socket.send(response);
		} while (quit != true);
	}

	public static void main(String args[]) {
		int port;
		if (args.length > 0) {
			port = new Integer(args[0]);
		} else {
			port = 5555;
		}
		Server server = new Server(port);
		server.run();
	}
}
