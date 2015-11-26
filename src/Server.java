import org.zeromq.ZMQ;
import java.nio.charset.StandardCharsets;

public class Server {
	private ZMQ.Context context;
	private ZMQ.Socket socket;
	private Turtle turtle;
	private Lexer lexer;
	private Map map;

	public Server(int port) {
		turtle = new Turtle();
		lexer = new Lexer();
		map = new Map(10, 10);
		this.context = ZMQ.context(1);
		this.socket = context.socket(ZMQ.REP);
		System.out.println("tcp://*:"+port);
		this.socket.bind("tcp://*:"+port);
	}

	public void run() {
		String message;
		do {
			message = socket.recvStr();

			TurtleAction action = lexer.getAction(message);
			String response = action != null ? action.perform(turtle) : "unknow " + message;

			//String response = message;
			socket.send(response);
		} while (!message.equals("quit"));
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
