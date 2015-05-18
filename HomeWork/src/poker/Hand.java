package poker;

public class Hand {
	
	private static final int DOWN_FLAG = 4;
	private static String[] ÑOMBINATIONS = {
		"High-card",
		"One-pair",
		"Two-pair",
		"Three of a Kind",
		"Straight",
		"Flush",
		"Full House",
		"Four of a Kind",
		"Straight Flush",
		"Royal Flush",
		};
	private Card[] _hand;	
	
	public void TakeCards(Card[] hand){
		if (hand.length == Dealer.MAX_HEND_CARD){
			_hand = hand;			
		}else{
			System.out.println("Mr dealer you make a mistake =(");
		}
	}
	
	public String LearnHand(){
		int[] helpArrOfRank = new int[Card.MAX_RANK + 1];// because ace can you begin the procedure, and to finish it.
		int flagFlush = -1;

		int StraightMaxLength = 1;
		int maxFirstRankID = 1;
		int maxSecondRankID = 0;
		int ñombinationsID;
		int felpBuff = 1;
		
		
		//preparation
		for (int i = 0; i < _hand.length; i++) {
			helpArrOfRank[_hand[i].getRank()]++;
			if (_hand[i].getRank() == 0){
				helpArrOfRank[Card.MAX_RANK]++;
			}
					
			if((flagFlush != -1) && (flagFlush != _hand[i].getSuit())){ // check Flush
				flagFlush = DOWN_FLAG;
			}else{
				flagFlush = _hand[i].getSuit();
			}
		}
		//check the same card, not necessary when  we have flush 
		// in maxSecondRankID located rank first pair or least rank of hand cards
		if(flagFlush == DOWN_FLAG)
		{
			if(helpArrOfRank[1] < helpArrOfRank[0]){
				maxFirstRankID = 0;
				maxSecondRankID = 1;
			}	
		
			for (int i = 2; i < helpArrOfRank.length - 1; i++) {
				if (helpArrOfRank[i] > helpArrOfRank[maxFirstRankID]){
					maxSecondRankID = maxFirstRankID;
					maxFirstRankID = i;
				}else if(helpArrOfRank[i] > helpArrOfRank[maxSecondRankID]){
					maxSecondRankID = i;
				}
			}			
		}
		//chekStraight not necessary when have the same card
		if(helpArrOfRank[maxFirstRankID] <= 1){
			for (int i = 1 ; i < helpArrOfRank.length; i++) {
				if((helpArrOfRank[i] == 1) && (helpArrOfRank[i - 1] == 1)){
					felpBuff++;
					StraightMaxLength = Math.max(StraightMaxLength, felpBuff);
				}else{
					felpBuff = 1;
				}
			}
		}		
		if ((StraightMaxLength == 5) && (flagFlush != DOWN_FLAG) && (helpArrOfRank[2] == 0)){
			ñombinationsID = 9;//Royal Flush
		}else if((StraightMaxLength == 5) && (flagFlush != DOWN_FLAG)){
			ñombinationsID = 8;//Straight Flush
		}else if(flagFlush != DOWN_FLAG){
			ñombinationsID = 5;//Flush
		}else if(StraightMaxLength == 5){
			ñombinationsID = 4;//Straight
		}else if(helpArrOfRank[maxFirstRankID] == 4){
			ñombinationsID = 7;//Four of a Kind
		}else if((helpArrOfRank[maxFirstRankID] == 3) && (helpArrOfRank[maxSecondRankID] == 2)){
			ñombinationsID = 6;//Full House
		}else if(helpArrOfRank[maxFirstRankID] == 3){
			ñombinationsID = 3;//Three of a Kind
		}else if((helpArrOfRank[maxFirstRankID] == 2) && (helpArrOfRank[maxSecondRankID] == 2)){
			ñombinationsID = 2;//Two-pair
		}else if(helpArrOfRank[maxFirstRankID] == 2){
			ñombinationsID = 1;//One-pair
		}else{
			ñombinationsID = 0;
		}
		return ÑOMBINATIONS[ñombinationsID];
	}
	
	public void OpenHand(){
		for (int i = 0; i < _hand.length; i++) {
			System.out.print(_hand[i].getCard());
		}
		System.out.println();
	}
			
}