package poker;



public class Game {
	
	public static void main(String[] args) {
		Hand hand = new Hand();
		hand.takeCards(Dealer.cheatCard(11, 24, 1, 1, 45));
		hand.openHand();
		System.out.println(hand.learnHand());
	}
	
}
