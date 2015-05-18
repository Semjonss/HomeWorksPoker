package poker;



public class Game {
	
	public static void main(String[] args) {
		Hand hand = new Hand();
		hand.TakeCards(Dealer.CheatCard(11, 24, 1, 1, 45));
		hand.OpenHand();
		System.out.println(hand.LearnHand());
	}
	
}
