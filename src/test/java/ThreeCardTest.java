import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ThreeCardTest {

	@Test
	void StraightTest() {
		
		ArrayList<Card> DealerHand = new ArrayList<Card>();
		DealerHand.add(new Card('C',7));
		DealerHand.add(new Card('S',6));
		DealerHand.add(new Card('D',8));
		
		int result = ThreeCardLogic.evalHand(DealerHand);
		
		assertEquals(3, result);

	}
	
	@Test
	void FlushTest() {
		
		ArrayList<Card> DealerHand = new ArrayList<Card>();
		DealerHand.add(new Card('D',9));
		DealerHand.add(new Card('D',6));
		DealerHand.add(new Card('D',8));
		
		int result = ThreeCardLogic.evalHand(DealerHand);
		
		assertEquals(4, result);

	}
	
	@Test
	void PairTest() {
		
		ArrayList<Card> DealerHand = new ArrayList<Card>();
		DealerHand.add(new Card('C',7));
		DealerHand.add(new Card('S',8));
		DealerHand.add(new Card('D',8));
		
		int result = ThreeCardLogic.evalHand(DealerHand);
		
		assertEquals(5, result);

	}
	
	@Test
	void HighCardTest() {
		
		ArrayList<Card> DealerHand = new ArrayList<Card>();
		DealerHand.add(new Card('C',7));
		DealerHand.add(new Card('S',6));
		DealerHand.add(new Card('D',9));
		
		int result = ThreeCardLogic.evalHand(DealerHand);
		
		assertEquals(0, result);

	}
	
	@Test
	void StraightFlushTest() {
		
		ArrayList<Card> DealerHand = new ArrayList<Card>();
		DealerHand.add(new Card('S',7));
		DealerHand.add(new Card('S',6));
		DealerHand.add(new Card('S',8));
		
		int result = ThreeCardLogic.evalHand(DealerHand);
		
		assertEquals(1, result);

	}
	
	@Test
	void ThreeOfAKindTest() {
		
		ArrayList<Card> DealerHand = new ArrayList<Card>();
		DealerHand.add(new Card('C',7));
		DealerHand.add(new Card('S',7));
		DealerHand.add(new Card('D',7));
		
		int result = ThreeCardLogic.evalHand(DealerHand);
		
		assertEquals(2, result);

	}
	
	@Test
	void PairEvalPPWinnings() {
		
		ArrayList<Card> PlayerHand = new ArrayList<Card>();
		PlayerHand.add(new Card('S',14));
		PlayerHand.add(new Card('D',14));
		PlayerHand.add(new Card('H',7));
		
		int result = ThreeCardLogic.evalPPWinnings(PlayerHand, 20);
		assertEquals(20, result);
		
	}
	
	@Test
	void HighCardEvalPPWinnings() {
		
		ArrayList<Card> PlayerHand = new ArrayList<Card>();
		PlayerHand.add(new Card('S',12));
		PlayerHand.add(new Card('D',11));
		PlayerHand.add(new Card('H',7));
		
		int result = ThreeCardLogic.evalPPWinnings(PlayerHand, 20);
		assertEquals(0, result);
		
	}
	
	@Test
	void FlushEvalPPWinnings() {
		
		ArrayList<Card> PlayerHand = new ArrayList<Card>();
		PlayerHand.add(new Card('S',12));
		PlayerHand.add(new Card('S',11));
		PlayerHand.add(new Card('S',7));
		
		int result = ThreeCardLogic.evalPPWinnings(PlayerHand, 20);
		assertEquals(60, result);
		
	}
	
	@Test
	void StraightEvalPPWinnings() {
		
		ArrayList<Card> PlayerHand = new ArrayList<Card>();
		PlayerHand.add(new Card('S',12));
		PlayerHand.add(new Card('S',11));
		PlayerHand.add(new Card('D',10));
		
		int result = ThreeCardLogic.evalPPWinnings(PlayerHand, 10);
		assertEquals(60, result);
		
	}
	
	@Test
	void ThreeOfAKindEvalPPWinnings() {
		
		ArrayList<Card> PlayerHand = new ArrayList<Card>();
		PlayerHand.add(new Card('S',12));
		PlayerHand.add(new Card('D',12));
		PlayerHand.add(new Card('H',12));
		
		int result = ThreeCardLogic.evalPPWinnings(PlayerHand, 1);
		assertEquals(30, result);
		
	}
	
	@Test
	void StraightFlushEvalPPWinnings() {
		
		ArrayList<Card> PlayerHand = new ArrayList<Card>();
		PlayerHand.add(new Card('S',12));
		PlayerHand.add(new Card('S',11));
		PlayerHand.add(new Card('S',10));
		
		int result = ThreeCardLogic.evalPPWinnings(PlayerHand, 10);
		assertEquals(400, result);
		
	}
	
	@Test
	void DealerStraightWinsTest() {
		
		ArrayList<Card> PlayerHand = new ArrayList<Card>();
		PlayerHand.add(new Card('S',14));
		PlayerHand.add(new Card('D',14));
		PlayerHand.add(new Card('H',7));
		
		ArrayList<Card> DealerHand = new ArrayList<Card>();
		DealerHand.add(new Card('C',7));
		DealerHand.add(new Card('S',6));
		DealerHand.add(new Card('D',8));
		
		int result = ThreeCardLogic.compareHands(DealerHand, PlayerHand);
		assertEquals(1, result);
		
	}
	
	@Test
	void StraightDrawTest() {
		
		ArrayList<Card> PlayerHand = new ArrayList<Card>();
		PlayerHand.add(new Card('S',8));
		PlayerHand.add(new Card('D',9));
		PlayerHand.add(new Card('H',7));
		
		ArrayList<Card> DealerHand = new ArrayList<Card>();
		DealerHand.add(new Card('C',9));
		DealerHand.add(new Card('S',8));
		DealerHand.add(new Card('D',7));
		
		int result = ThreeCardLogic.compareHands(DealerHand, PlayerHand);
		assertEquals(0, result);
		
	}
	
	@Test
	void PlayerPairWinsTest() {
		
		ArrayList<Card> PlayerHand = new ArrayList<Card>();
		PlayerHand.add(new Card('S',8));
		PlayerHand.add(new Card('D',8));
		PlayerHand.add(new Card('H',7));
		
		ArrayList<Card> DealerHand = new ArrayList<Card>();
		DealerHand.add(new Card('C',12));
		DealerHand.add(new Card('S',8));
		DealerHand.add(new Card('D',5));
		
		int result = ThreeCardLogic.compareHands(DealerHand, PlayerHand);
		assertEquals(2, result);
		
	}
	
	@Test
	void PlayerThreeOfAKindWinsTest() {
		
		ArrayList<Card> PlayerHand = new ArrayList<Card>();
		PlayerHand.add(new Card('S',9));
		PlayerHand.add(new Card('D',9));
		PlayerHand.add(new Card('H',9));
		
		ArrayList<Card> DealerHand = new ArrayList<Card>();
		DealerHand.add(new Card('C',12));
		DealerHand.add(new Card('S',11));
		DealerHand.add(new Card('D',10));
		
		int result = ThreeCardLogic.compareHands(DealerHand, PlayerHand);
		assertEquals(2, result);
		
	}
	
	@Test
	void DealerFlushWinsTest() {
		
		ArrayList<Card> PlayerHand = new ArrayList<Card>();
		PlayerHand.add(new Card('S',9));
		PlayerHand.add(new Card('D',8));
		PlayerHand.add(new Card('H',6));
		
		ArrayList<Card> DealerHand = new ArrayList<Card>();
		DealerHand.add(new Card('D',12));
		DealerHand.add(new Card('D',11));
		DealerHand.add(new Card('D',9));
		
		int result = ThreeCardLogic.compareHands(DealerHand, PlayerHand);
		assertEquals(1, result);
		
	}
	
	@Test
	void PlayerHighCardWinsTest() {
		
		ArrayList<Card> PlayerHand = new ArrayList<Card>();
		PlayerHand.add(new Card('S',14));
		PlayerHand.add(new Card('D',8));
		PlayerHand.add(new Card('H',6));
		
		ArrayList<Card> DealerHand = new ArrayList<Card>();
		DealerHand.add(new Card('D',12));
		DealerHand.add(new Card('S',11));
		DealerHand.add(new Card('D',9));
		
		int result = ThreeCardLogic.compareHands(DealerHand, PlayerHand);
		assertEquals(2, result);
		
	}
	
	@Test
	void DealerHighCardWinsTest() {
		
		ArrayList<Card> PlayerHand = new ArrayList<Card>();
		PlayerHand.add(new Card('S',11));
		PlayerHand.add(new Card('D',8));
		PlayerHand.add(new Card('H',6));
		
		ArrayList<Card> DealerHand = new ArrayList<Card>();
		DealerHand.add(new Card('D',12));
		DealerHand.add(new Card('S',11));
		DealerHand.add(new Card('D',9));
		
		int result = ThreeCardLogic.compareHands(DealerHand, PlayerHand);
		assertEquals(1, result);
		
	}
	
	@Test
	void StraightFlushDrawTest() {
		
		ArrayList<Card> PlayerHand = new ArrayList<Card>();
		PlayerHand.add(new Card('S',8));
		PlayerHand.add(new Card('S',9));
		PlayerHand.add(new Card('S',7));
		
		ArrayList<Card> DealerHand = new ArrayList<Card>();
		DealerHand.add(new Card('D',9));
		DealerHand.add(new Card('D',8));
		DealerHand.add(new Card('D',7));
		
		int result = ThreeCardLogic.compareHands(DealerHand, PlayerHand);
		assertEquals(0, result);
		
	}
	
}


