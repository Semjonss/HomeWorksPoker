package poker;


import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestGame{
	
	private int _i1;
	private int _i2;
	private int _i3;
	private int _i4;
	private int _i5;
	private String _output;

	@Parameters
	public static List<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{1, 14, 27, 40, 17, Combination.FOUR_OF_A_KIND.getName()},
				{2, 15, 28, 41, 17, Combination.FOUR_OF_A_KIND.getName()},
				{3, 16, 29, 42, 17, Combination.FOUR_OF_A_KIND.getName()},
				{4, 1, 30, 43, 17, Combination.FOUR_OF_A_KIND.getName()},
				{5, 18, 31, 44, 17, Combination.FOUR_OF_A_KIND.getName()},
				{6, 19, 32, 45, 17, Combination.FOUR_OF_A_KIND.getName()},
				{7, 20, 33, 46, 17, Combination.FOUR_OF_A_KIND.getName()},
				{8, 21, 34, 47, 17, Combination.FOUR_OF_A_KIND.getName()},
				{9, 22, 35, 48, 17, Combination.FOUR_OF_A_KIND.getName()},
				{10, 23, 36, 49, 17, Combination.FOUR_OF_A_KIND.getName()},
				{11, 24, 37, 50, 17, Combination.FOUR_OF_A_KIND.getName()},
				{12, 25, 38, 51, 17, Combination.FOUR_OF_A_KIND.getName()},
				{11, 24, 50, 37, 17, Combination.FOUR_OF_A_KIND.getName()},
				{3, 1, 33, 46, 17, Combination.ONE_PAIR.getName()},
				{7, 20, 1, 4, 17, Combination.TWO_PAIR.getName()},
				{7, 20, 35, 48, 17, Combination.TWO_PAIR.getName()},
				{7, 24, 51, 46, 17, Combination.ONE_PAIR.getName()},
				{1, 2, 3, 4, 8, Combination.FLUSH.getName()},
				{14, 2, 3, 4, 5, Combination.STRAIGHT.getName()},
				{1, 2, 3, 4, 5, Combination.STRAIGHT_FLUSH.getName()},
				{8, 9, 10, 11, 12, Combination.ROYAL_FLUSH.getName()},
				{11, 24, 50, 32, 45, Combination.FULL_HOUSE.getName()},
				{11, 24, 50, 1, 45, Combination.THREE_OF_A_KIND.getName()},
				{21, 34, 1, 24, 50, Combination.TWO_PAIR.getName()},
				{1, 3, 5, 7, 15, Combination.HIGH_CARD.getName()},
				
		}
		);
	}
	
	public TestGame(final int i1, final int i2, final int i3, 
			final int i4, final int i5, final String output) {
		_i1 = i1;
		_i2 = i2;
		_i3 = i3;
		_i4 = i4;
		_i5 = i5;
		_output = output;
	}

	@Test
	public void test() {
		Hand hand = new Hand();
		hand.takeCards(Dealer.cheatCard(_i1, _i2, _i3, _i4, _i5));
		assertEquals(_output, hand.learnHand());
	}

}