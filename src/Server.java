import org.zeromq.ZMQ;

public class Server {
	private ZMQ.Context context;
	private ZMQ.Socket socket;

	public Server(int port) {
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
			message = socket.recvStr();
			System.out.println(message);
			String response = process(message);
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
