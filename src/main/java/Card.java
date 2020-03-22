public class Card {
	
	// members
	//
	private char suit;
	private int value;
	
	// constructor
	Card(char x, int y) {
		suit = x;
		value = y;
	}
	
	// setters and getters
	void setValue(int x) {
		value = x;
	}
	
	void setSuit(char x) {
		suit = x;
	}
	
	int getValue() {
		return value;
	}
	
	char getSuit() {
		return suit;
	}
}
