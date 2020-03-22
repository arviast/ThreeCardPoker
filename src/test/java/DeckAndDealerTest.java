import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class DeckAndDealerTest {

	@Test
	void testIsDealer() {
		Dealer dealer = new Dealer();
		assertEquals("Dealer", dealer.getClass().getName(),"init failed on Dealer");
	}
	
	@Test
	void testIsDealerHandEmpty() {
		Dealer dealer = new Dealer();
		assertEquals(0, dealer.dealersHand.size());
	}
	
	@Test
	void testIsDeck() {
		Deck deck = new Deck();
		assertEquals("Deck", deck.getClass().getName(),"init failed on Deck");
	}
	
	@Test
	void CheckInitialSizeOfDeck() {
		Dealer dealer = new Dealer();
		assertTrue(dealer.theDeck.size() == 52);
		
	}
	
	@Test
	void CheckSizeOfDeckAfterDealing() {
		Dealer dealer = new Dealer();
		dealer.dealHand();
		assertTrue(dealer.theDeck.size() == 49);
		
	}
	
	@Test
	void CheckSizeOfDeckResets() {
		Dealer dealer = new Dealer();
		dealer.dealHand();
		dealer.dealHand();
		dealer.dealHand();
		dealer.dealHand();
		dealer.dealHand();
		dealer.dealHand();
		dealer.dealHand();
		assertEquals(49, dealer.theDeck.size());
		
	}
	
	@Test
	void CheckSizeOfDeckEdgeCase() {
		Dealer dealer = new Dealer();
		dealer.dealHand();
		dealer.dealHand();
		dealer.dealHand();
		dealer.dealHand();
		dealer.dealHand();
		dealer.dealHand();
		assertEquals(34, dealer.theDeck.size());
	}
	
	@Test
	void DealerDealsThreeDifferentCards() {
		Dealer dealer = new Dealer();
		ArrayList<Card> dealerHand = new ArrayList<Card>();
		dealerHand = dealer.dealHand();
		assertTrue(dealerHand.get(0).getValue() != dealerHand.get(1).getValue() || dealerHand.get(0).getSuit() != dealerHand.get(1).getSuit());
		assertTrue(dealerHand.get(1).getValue() != dealerHand.get(2).getValue() || dealerHand.get(1).getSuit() != dealerHand.get(2).getSuit());
		assertTrue(dealerHand.get(0).getValue() != dealerHand.get(2).getValue() || dealerHand.get(0).getSuit() != dealerHand.get(2).getSuit());
	}
	
	
	@Test
	void CheckSizeOfDeckAfterDealingTwice() {
		Dealer dealer = new Dealer();
		dealer.dealHand();
		dealer.dealHand();
		assertTrue(dealer.theDeck.size() == 46);
		
	}

	@Test
	void CheckSizeOfDeckAfterDealingThrice() {
		Dealer dealer = new Dealer();
		dealer.dealHand();
		dealer.dealHand();
		dealer.dealHand();
		assertTrue(dealer.theDeck.size() == 43);
		
	}
	
}
