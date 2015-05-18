package poker;

import java.util.Random;

public class Dealer {

	public static final int MAX_CARD_COUNT = 52;
	public static final int MAX_HEND_CARD = 5;
	private static Random random = new Random();
	private static int numbersArray[] = new int[MAX_CARD_COUNT];// equivalently deck of card
	private static int _activeDeck;
	
	private Dealer(){}
	
	static {
		for (int i = 0; i < numbersArray.length; i++) {
			numbersArray[i] = i;
		}		
		_activeDeck = MAX_CARD_COUNT;
	}
	
	public	static Card[] GiveHand(){
		Card[] hand = new Card[MAX_HEND_CARD];
		RefreshDeck();//refresh a deck before to give a new hand
		for (int i = 0; i < hand.length; i++) {
			int j = random.nextInt(_activeDeck);
			hand[i] = new Card(numbersArray[j]);
			numbersArray[j] = numbersArray[--_activeDeck];
		}
		return hand;		
	}
	
	public static Card[] CheatCard(int a1, int a2, int a3, int a4, int a5){
		Card[] hand = new Card[MAX_HEND_CARD];
		hand[0] = new Card(a1);
		hand[1] = new Card(a2);
		hand[2] = new Card(a3);
		hand[3] = new Card(a4);
		hand[4] = new Card(a5);
		return hand;	
	}
	
	
	private static void  RefreshDeck() {
		_activeDeck = MAX_CARD_COUNT;	//it's true, because we're take random namber of card 
	}
}
