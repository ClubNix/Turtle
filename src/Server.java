import org.zeromq.ZMQ;
import java.util.Map;
import java.util.HashMap;

public class Server {
	private ZMQ.Context context;
	private ZMQ.Socket socket;
	private Turtle turtle = new Turtle();

	interface ProcessingMethod {
		public String method();
	}

	private Map<String, ProcessingMethod> methodMap = new HashMap<String, ProcessingMethod>();

	public Server(int port) {
		this.context = ZMQ.context(1);
		this.socket = context.socket(ZMQ.REP);
		System.out.println("tcp://*:"+port);
		this.socket.bind("tcp://*:"+port);
		this.methodMap.put("up", new ProcessingMethod() {
			public String method() {
				turtle.up();
				return "up";
			}
		});
		this.methodMap.put("down", new ProcessingMethod() {
			public String method() {
				turtle.down();
				return "down";
			}
		});
		this.methodMap.put("left", new ProcessingMethod() {
			public String method() {
				turtle.left();
				return "left";
			}
		});
		this.methodMap.put("right", new ProcessingMethod() {
			public String method() {
				turtle.right();
				return "right";
			}
		});
		this.methodMap.put("position", new ProcessingMethod() {
			public String method() {
				return turtle.getStringPosition();
			}
		});
		this.methodMap.put("quit", new ProcessingMethod() {
			public String method() {
				return "quit";
			}
		});


	}

	private String process(String message) {
		return "Ok";
	}

	public void run() {
		String message;
		do {
			message = socket.recvStr();
			System.out.println(message);
			
			String response = this.methodMap.get(message).method();
			
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
