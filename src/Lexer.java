import java.util.Scanner;

public class Lexer {
	private Scanner tokenizer;

	Lexer(String message){
		this.tokenizer = new Scanner(message);
	}

	public Token nextToken() {
		String token = tokenizer.next();
		if(token.matches("[0-9]+")){
			return new Token(TokenType.ID, token);
		}

		// should match any of: 'N', 'S', 'E', 'W', 'NE', 'NW', 'SE', 'SW'
		if(token.matches("^(N|S)?(E|W)?$")){
			return new Token(TokenType.DIRECTION, token);
		}

		TokenType type;
		switch(token) {
			case "hello":
				type = TokenType.HELLO;
				break;

			case "turtle":
				type = TokenType.TURTLE;
				break;

			case "quit":
				type = TokenType.QUIT;
				break;

			case "equip":
				type = TokenType.EQUIP;
				break;

			case "attack":
				type = TokenType.ATTACK;
				break;

			case "eat":
				type = TokenType.EAT;
				break;

			case "multiply":
				type = TokenType.MULTIPLY;
				break;

			case "look":
				type = TokenType.LOOK;
				break;

			case "ack":
				type = TokenType.ACK;
				break;

			default:
				type = TokenType.STRING;
				break;
		}
		return new Token(type, token);
	}

	public boolean hasNextToken() {
		return this.tokenizer.hasNext();
	}
}
