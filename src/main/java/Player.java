import java.util.ArrayList;

public class Player {
	ArrayList<Card> hand;
	int anteBet;
	int playBet;
	int pairPlusBet;
	int totalWinnings;
	int Balance;
	
	// constructor
	Player() {
		hand = new ArrayList<Card>();
		anteBet = 0;
		playBet = 0;
		pairPlusBet = 0;
		totalWinnings = 0;
		Balance = 1000;
	}
	
	// setter
	void setPlayersHand(ArrayList<Card> x) {
		hand = x;
	}
}
