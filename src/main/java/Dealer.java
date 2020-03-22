import java.util.ArrayList;

public class Dealer {
	
	// members
	public Deck theDeck;
	public ArrayList<Card> dealersHand;
	
	// constructor
	Dealer() {
		theDeck = new Deck();
		dealersHand = new ArrayList<Card>();
	}
	
	void setDealersHand(ArrayList<Card> x) {
		dealersHand = x;
	}
	
	// chooses 3 random cards
	// return to the array with size (current - 3)
	// ...
	public ArrayList<Card> dealHand() {
		isNotEnoughCards();
		ArrayList<Card> temp = new ArrayList<Card>();
	
		int x = 0;
		for(int i = 0; i < 3; i++) {
			temp.add(theDeck.get(x));
			theDeck.remove(theDeck.get(x));
		}
		return temp;
	}
	
	// checks if there enough cards
	public void isNotEnoughCards() {
		if(theDeck.size() <= 34) {
			theDeck.newDeck();
		}
	}
}
