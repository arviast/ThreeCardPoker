import java.util.ArrayList;
import java.util.Collections;

public class ThreeCardLogic {
	public static int evalHand(ArrayList<Card> hand) {
		
		Collections.sort(hand, (o1, o2) -> o1.getValue() - o2.getValue());
		
		// Straight Flush
		if( ((hand.get(0).getSuit() == hand.get(1).getSuit()) &&
			(hand.get(1).getSuit() == hand.get(2).getSuit()) ) &&
			( (hand.get(2).getValue() - hand.get(1).getValue() == 1) &&
			  (hand.get(1).getValue() - hand.get(0).getValue() == 1) ) )	{
			return 1;
		}
		
		// Three of a Kind
		if(hand.get(0).getValue() == hand.get(1).getValue() &&
			hand.get(1).getValue() == hand.get(2).getValue()) {
			return 2;
		}
		
		// Straight
		if( (hand.get(2).getValue() - hand.get(1).getValue() == 1) &&
			(hand.get(1).getValue() - hand.get(0).getValue() == 1) ) {
			return 3;
		}
		
		// Flush
		if( (hand.get(0).getSuit() == hand.get(1).getSuit()) &&
				(hand.get(1).getSuit() == hand.get(2).getSuit()) ){
			return 4;
		}
		
		// Pair
		if( (hand.get(0).getValue() == hand.get(1).getValue()) ||
			(hand.get(1).getValue() == hand.get(2).getValue()) ||
			(hand.get(0).getValue() == hand.get(2).getValue()) ) {
			return 5;
		}
		
		else {
			return 0;
		}
	}
	
	public static int evalPPWinnings(ArrayList<Card> hand, int bet) {
		
		// straight flush 40 to 1
		if(evalHand(hand) == 1) {
			return 40*bet;
		}
		// three of a kind 30 to 1
		else if(evalHand(hand) == 2) {
			return 30*bet;
		}
		// straight 6 to 1
		else if(evalHand(hand) == 3) {
			return 6*bet;
		}
		// flush 3 to 1
		else if(evalHand(hand) == 4) {
			return 3*bet;
		}
		// pair 1 to 1
		else if(evalHand(hand) == 5) {
			return bet;
		}
		
		else {
			return 0;
		}
	}
	
	public static int compareHands(ArrayList<Card> dealer, ArrayList<Card> player) {
		Collections.sort(dealer, (o1, o2) -> o1.getValue() - o2.getValue());
		Collections.sort(player, (o1, o2) -> o1.getValue() - o2.getValue());

//		System.out.println ("\nDealer hand");
//		for(Card x: dealer) {
//			System.out.print(x.getValue() + "" + x.getSuit());
//		}
//		System.out.println ("\nPlayer hand");
//		for(Card x: player) {
//			System.out.print(x.getValue() + "" + x.getSuit());
//		}
		
		// base case dealer has above Q
		if(dealer.get(2).getValue() < 12 && evalHand(dealer) == 0) {
			return 3;
		}
		
		// high card is 0 but straight is straight flush is 1 so cant do regular < > operations		
		int dealerStrength = evalHand(dealer);
		int playerStrength = evalHand(player);
		
		if(evalHand(dealer) == 0) {
			 dealerStrength= 6;
		}
		
		if(evalHand(player) == 0) {
			 playerStrength= 6;
		}
		// dealer wins
		if(dealerStrength < playerStrength) {
			return 1;
		}
		else if(dealerStrength > playerStrength) {
			return 2;
		}
		else {
			if (playerStrength != 5) {
				for(int i = 2; i>0; i--) {
					if (dealer.get(i).getValue() < player.get(i).getValue()) {
						return 2;
					} else if (dealer.get(i).getValue() > player.get(i).getValue()) {
						return 1;
					}
				}
				return 0;
			} else {
				int playerPair;
				int dealerPair;
				int playerKicker;
				int dealerKicker;
				if (player.get(0).getValue() == player.get(1).getValue()) {
					playerPair = player.get(0).getValue();
					playerKicker = player.get(2).getValue();
				} else {
					playerPair = player.get(2).getValue();
					if (playerPair == player.get(0).getValue()) {
						playerKicker = player.get(1).getValue();
					} else {
						playerKicker = player.get(0).getValue();
					}
				}
				
				if (dealer.get(0).getValue() == dealer.get(1).getValue()) {
					dealerPair = dealer.get(0).getValue();
					dealerKicker = dealer.get(2).getValue();
				} else {
					dealerPair = dealer.get(2).getValue();
					if (dealerPair == dealer.get(0).getValue()) {
						dealerKicker = dealer.get(1).getValue();
					} else {
						dealerKicker = dealer.get(0).getValue();
					}
				}
				
				if (dealerPair > playerPair) {
					return 1;
				} else if (playerPair > dealerPair) {
					return 2;
				} else {
					if (dealerKicker > playerKicker) {
						return 1;
					} else if (dealerKicker < playerKicker) {
						return 2;
					} else {
						return 0;
					}
				}
			}
		}
	}
}
