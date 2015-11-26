import org.zeromq.ZMQ;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.HashMap;

public class Server {
	private ZMQ.Context context;
	private ZMQ.Socket socket;
	private Turtle turtle;
	private Lexer lexer;

	public Server(int port) {
		turtle = new Turtle();
		lexer = new Lexer();
		this.context = ZMQ.context(1);
		this.socket = context.socket(ZMQ.REP);
		System.out.println("tcp://*:"+port);
		this.socket.bind("tcp://*:"+port);
	}

	private String process(String message) {
		return "Ok";
	}

	public void run() {
		String message;
		do {
			message = socket.recvStr(StandardCharsets.UTF_8);
			System.out.println(message);

			String response = lexer.getActionMap().get(message).action(turtle);

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
