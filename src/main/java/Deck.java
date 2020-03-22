import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("serial")
public class Deck extends ArrayList<Card> {
	
	// constructor
	// create a deck with 52 cards
	// with random order
	Deck() {
		for(int i=2; i <= 14; i++) {
			this.add(new Card('C', i));
			this.add(new Card('D', i));
			this.add(new Card('S', i));
			this.add(new Card('H', i));
		}
		Collections.shuffle(this);
	}
	
	// clear the deck and initialize new one
	void newDeck() {
		this.clear();
		
		for(int i=2; i<=14;i++) {
			this.add(new Card('C', i));
			this.add(new Card('D', i));
			this.add(new Card('S', i));
			this.add(new Card('H', i));
		}
		
		Collections.shuffle(this);
	}
	
	
	// For testing
	void print() {
		for(int i = 0; i < this.size(); i++) {
			System.out.println(i + " " + this.get(i).getValue() + " " + this.get(i).getSuit()) ;
		}
	}
}
