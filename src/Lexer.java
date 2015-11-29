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

		switch(token) {
			case "hello":
				return new Token(TokenType.HELLO, token);

			case "turtle":
				return new Token(TokenType.TURTLE, token);

			default:
				return new Token(TokenType.STRING, token);
		}
	}

	public boolean hasNextToken() {
		return this.tokenizer.hasNext();
	}
}
