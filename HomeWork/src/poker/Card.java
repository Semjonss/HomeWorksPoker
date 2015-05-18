package poker;


class Card {
	public static final int MAX_RANK = 13;
	// data fields for colors and suits
	 private String names[] = {"A", "2", "3", "4", "5", "6",
	 "7", "8", "9", "10", "J", "Q", "K"};
	
	// data fields
	private int rank;
	private char suitChar;
	private int suit;	
	// constructor
	
//constructor with param (rank * 13 + suit)
	Card(final int parameter) {
		if(parameter >= Dealer.MAX_CARD_COUNT){
			throw new IllegalArgumentException("can't be more 52");
		}else if(parameter < 0){
			throw new IllegalArgumentException("can't be zero");
		}
		suit = parameter / MAX_RANK;
		switch (suit) {
		case 0:
			suitChar = '♥';
			break;
		case 1:
			suitChar = '♦';
			break;
		case 2:
			suitChar = '♠';
			break;
		default:
			suitChar = '♣';
			break;
		}
		rank = parameter % MAX_RANK;
	}

	// access attributes of card
	int getRank() {
		return rank;
	}

	int getSuit() {
		return suit;
	}
	
	String getCard() {
		return (suitChar + names[rank] + " ");
	}
}